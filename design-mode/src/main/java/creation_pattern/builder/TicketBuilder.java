package creation_pattern.builder;

/**
 * @Date 2020-09-23 14:59
 * ZHR
 * 通过调整调用方法的顺序构建不同的结果
 **/
public class TicketBuilder {

    public static Object build(TicketHelper helper) {
        System.out.println("通过TicketHelper 构建套票信息");
        return null;
    }

    public static void main(String[] args) {
        TicketHelper helper = new TicketHelper();
        helper.buildAdult("成人票");
        helper.buildChildrenForSeat("有座儿童");
        helper.buildChildrenNoSeat("无座儿童");
        helper.buildElderly("老人票");
        helper.buildSoldier("军人票");
        TicketBuilder.build(helper);
    }
}
