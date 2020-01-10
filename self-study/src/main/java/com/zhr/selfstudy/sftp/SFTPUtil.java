package com.zhr.selfstudy.sftp;

import com.jcraft.jsch.*;
import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Vector;


public class SFTPUtil {

    private static Logger log = LoggerFactory.getLogger(SFTPUtil.class);

    private ChannelSftp sftp;

    private Session session;
    /**
     * SFTP 登录用户名
     */
    private String username;
    /**
     * SFTP 登录密码
     */
    private String password;
    /**
     * 私钥
     */
    private String privateKey;
    /**
     * SFTP 服务器地址IP地址
     */
    private String host;
    /**
     * SFTP 端口
     */
    private int port;

    /**
     * 构造基于密码认证的sftp对象
     */
    public SFTPUtil(String username, String password, String host, int port) {
        this.username = username;
        this.password = password;
        this.host = host;
        this.port = port;
    }
    /**
     * 构造基于秘钥认证的sftp对象
     */
    public SFTPUtil(String username, String host, int port, String privateKey) {
        this.username = username;
        this.host = host;
        this.port = port;
        this.privateKey = privateKey;
    }

    /**
     * 连接sftp服务器
     */
    public void login() throws JSchException {
        log.debug("enter into login()");
        JSch jsch = new JSch();
        if (privateKey != null) {
            jsch.addIdentity(privateKey);// 设置私钥
        }

        session = jsch.getSession(username, host, port);

        if (password != null) {
            session.setPassword(password);
        }
        Properties config = new Properties();
        config.put("StrictHostKeyChecking", "no");
        config.put("userauth.gssapi-with-mic", "no");

        session.setConfig(config);
        session.connect();

        Channel channel = session.openChannel("sftp");
        channel.connect();

        sftp = (ChannelSftp) channel;
    }

    /**
     * 关闭连接 server
     */
    public void logout() {
        if (sftp != null) {
            if (sftp.isConnected()) {
                sftp.disconnect();
            }
        }
        if (session != null) {
            if (session.isConnected()) {
                session.disconnect();
            }
        }
    }

    /**
     * 将输入流的数据上传到sftp作为文件。文件完整路径=basePath+directory
     *
     * @param basePath     服务器的基础路径
     * @param directory    上传到该目录
     * @param sftpFileName sftp端文件名
     * @param input        输入流
     */
    public void upload(String basePath, String directory, String sftpFileName, InputStream input) throws SftpException {
        try {
            sftp.cd(basePath);
            sftp.cd(directory);
        } catch (SftpException e) {
            //目录不存在，则创建文件夹
            String[] dirs = directory.split("/");
            String tempPath = basePath;
            for (String dir : dirs) {
                if (null == dir || "".equals(dir)) continue;
                tempPath += "/" + dir;
                try {
                    sftp.cd(tempPath);
                } catch (SftpException ex) {
                    sftp.mkdir(tempPath);
                    sftp.cd(tempPath);
                }
            }
        }
        sftp.put(input, sftpFileName);  //上传文件
    }

    /**
     * 下载文件。
     *
     * @param directory    下载目录
     * @param downloadFile 下载的文件
     * @param saveFile     存在本地的路径
     */
    public byte[] download(String directory, String downloadFile, String saveFile) throws SftpException,
            FileNotFoundException, IOException {
        log.debug("enter into download(String directory, String downloadFile, String saveFile)");
        changeDir(directory);
        File file = new File(saveFile);
        //sftp.get(downloadFile, new FileOutputStream(file));
        log.debug("local file is:" + file.getAbsolutePath());
        InputStream is = sftp.get(downloadFile);
        byte[] fileData = IOUtils.toByteArray(is);
        FileOutputStream outputStream = new FileOutputStream(file);
        outputStream.write(fileData);
        outputStream.flush();
        outputStream.close();
        return fileData;

    }

    /**
     * 下载文件
     *
     * @param directory    下载目录
     * @param downloadFile 下载的文件名
     * @return 字节数组
     */
    public byte[] download(String directory, String downloadFile) throws SftpException, IOException {
        InputStream is = getInputStrem(directory, downloadFile);
        byte[] fileData = IOUtils.toByteArray(is);
        return fileData;
    }

    public InputStream getInputStrem(String directory, String downloadFile) throws SftpException {
        log.debug("enter into download(String directory, String downloadFile)");
        changeDir(directory);
        return sftp.get(downloadFile);
    }

    private void changeDir(String directory) throws SftpException {
        log.debug("enter into changeDir({})", directory);
        if (directory != null && !"".equals(directory)) {
            if (!directory.startsWith("/")) {
                directory = "/" + directory;
            }
            if (!sftp.pwd().equals(directory)) {
                log.debug("change dir");
                sftp.cd(directory);
            } else {
                log.debug("no change dir");
            }
        }
        log.debug("level changeDir({})", directory);
    }

    /**
     * 删除文件
     *
     * @param directory  要删除文件所在目录
     * @param deleteFile 要删除的文件
     */
    public void delete(String directory, String deleteFile) throws SftpException {
        sftp.cd(directory);
        sftp.rm(deleteFile);
    }

    /**
     * 列出目录下的文件
     *
     * @param directory 要列出的目录
     */
    public Vector<?> listFiles(String directory) throws SftpException {
        return sftp.ls(directory);
    }

    /**
     * 路径下是否存在此文件
     *
     * @param directory
     * @param filename
     * @return
     * @throws SftpException
     */
    public boolean exist(String directory, final String filename) throws SftpException {
        final List<Boolean> allFile = new ArrayList<>();
        sftp.ls(directory, new ChannelSftp.LsEntrySelector() {

            @Override
            public int select(ChannelSftp.LsEntry lsEntry) {
                if (!lsEntry.getAttrs().isDir() && lsEntry.getFilename().equalsIgnoreCase(filename)) {
                    allFile.add(true);
                } else {
                    allFile.add(false);
                }
                return 0;
            }
        });
        return allFile.contains(true);
    }
}
