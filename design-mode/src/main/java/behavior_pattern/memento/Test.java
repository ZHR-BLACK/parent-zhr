package behavior_pattern.memento;

/**
 * @author ZHR
 * @version 1.0
 * @ClassName Test
 * @Date 2019/5/23 16:56
 * @description 备忘录模式
 * <p>主要目的是保存一个对象的某个状态，以便在适当的时候恢复对象，</p>
 * <p>通俗的讲下：假设有原始类A，A中有各种属性，A可以决定需要备份的属性，</p>
 * <P>备忘录类B是用来存储A的一些内部状态，类C呢，就是一个用来存储备忘录的，且只能存储，不能修改等操作。</p>
 * @author smilesnake
 **/
public class Test {

    public static void main(String[] args) {
        // 创建原始类
        Original origi = new Original("egg");

        // 创建备忘录,存档备份
        Storage storage = new Storage(origi.createMemento());

        // 修改原始类的状态
        System.out.println("初始化状态为：" + origi.getValue());
        origi.setValue("niu");
        System.out.println("修改后的状态为：" + origi.getValue());

        // 回复原始类的状态
        origi.restoreMemento(storage.getMemento());
        System.out.println("恢复后的状态为：" + origi.getValue());
    }
}
