package poolparam;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ThreadFactory;

/**
 * @创建人 zhangjing710
 * @创建时间 2020/12/30 16:54
 * @描述 自定义线程工厂
 */
@Slf4j
public class CustomTreadFactory implements ThreadFactory {

    private String threadName;

    public CustomTreadFactory(String threadName){
        this.threadName = threadName;
    }
    @Override
    public Thread newThread(Runnable r) {
        Thread t = new Thread(r, threadName);
        log.info(t.getName() + " has been created");
        return t;
    }

}
