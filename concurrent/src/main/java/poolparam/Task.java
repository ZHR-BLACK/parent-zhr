package poolparam;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

/**
 * @创建人 zhangjing710
 * @创建时间 2021/2/8 15:04
 * @描述 任务
 */
public class Task implements Callable<List<String>> {

    // 模拟传入参数i
    private int i;

    public Task(int i){
        this.i = i;
    }

    @Override
    public List<String> call() {
        String a = "queue" + i;
        System.out.println(a);
        List<String> list = new ArrayList<>();
        list.add(a);
        list.add(a + i);
        return list;
    }
}
