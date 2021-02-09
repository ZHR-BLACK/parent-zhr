package poolparam;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @创建人 zhangjing710
 * @创建时间 2020/12/30 16:50
 * @描述 自定义线程池拒绝策略
 */
@Slf4j
public class CustomRejectedPolicy implements RejectedExecutionHandler {
    @Override
    public void rejectedExecution(Runnable r, ThreadPoolExecutor e) {
        doLog(r, e);
    }

    private void doLog(Runnable r, ThreadPoolExecutor e) {
        log.info(r.toString() + " is-rejected");
        // 重新执行，不丢弃任务
        e.submit(r);
    }
}
