package com.zhr;

import com.jfinal.config.*;
import com.jfinal.server.undertow.UndertowServer;
import com.jfinal.template.Engine;

/**
 * @author ZHR
 * @version 1.0
 * @ClassName DemoConfig
 * @Date 2019-11-07 13:58
 * @description todo
 **/
public class DemoConfig extends JFinalConfig {

    /**
     * 注意：用于启动的 main 方法可以在任意 java 类中创建，在此仅为方便演示
     *      才将 main 方法放在了 DemoConfig 中
     *
     *      开发项目时，建议新建一个 App.java 或者 Start.java 这样的专用
     *      启动入口类放置用于启动的 main 方法
     *
     *      打开浏览器在地址栏中输入: http://localhost/hello，输出内容为Hello JFinal World证明项目框架搭建完成
     */
    public static void main(String[] args) {
        UndertowServer.start(DemoConfig.class, 80, true);
    }

    public void configConstant(Constants me) {
        me.setDevMode(true);
    }

    public void configRoute(Routes me) {
        me.add("/hello", HelloController.class);
    }

    public void configEngine(Engine me) {}
    public void configPlugin(Plugins me) {}
    public void configInterceptor(Interceptors me) {}
    public void configHandler(Handlers me) {}
}
