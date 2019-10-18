package creation_pattern.builder;

/**
 * 建造者模式
 *
 * @author smilesnake
 */
public class TicketHelper {

    public void buildAdult(String info) {
        System.err.println("构建成年人票逻辑" + info);
    }

    public void buildChildrenForSeat(String info) {
        System.err.println("构建有座儿童票逻辑" + info);
    }

    public void buildChildrenNoSeat(String info) {
        System.err.println("构建无座儿童逻辑" + info);
    }

    public void buildElderly(String info) {
        System.err.println("构建有老年人票逻辑" + info);
    }

    public void buildSoldier(String info) {
        System.err.println("构建军人及其家属逻辑" + info);
    }
}