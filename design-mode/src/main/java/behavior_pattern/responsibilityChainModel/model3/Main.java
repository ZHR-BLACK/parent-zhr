package behavior_pattern.responsibilityChainModel.model3;

/**
 * @author ZHR
 * @version 1.0
 * @ClassName Main
 * @Date 2019-10-17 17:17
 * 纯责任链模式和不纯的责任链模式:
 * 如果一个类要么承担责任处理请求要么将请求踢给下一个皮球，则被称为纯责任链模式。
 * 如果一个类承担了一部分责任，还将请求踢给下一个皮球，则被称为不纯责任链模式。
 *
 * 一般来说，日常开发中不纯的责任链模式用的比较多一点。
 **/
public class Main {

    public static void main(String[] args) {
        StaffMember staffMember = new StaffMember();
        SectionChief sectionChief = new SectionChief();
        Director director = new Director();

        //set Handler
        staffMember.setNextHandler(sectionChief);
        sectionChief.setNextHandler(director);

        staffMember.dispose("小王", 400);
        staffMember.dispose("小混混", 800);
        staffMember.dispose("老李", 1200);
        staffMember.dispose("小明", 10000);

    }
}
