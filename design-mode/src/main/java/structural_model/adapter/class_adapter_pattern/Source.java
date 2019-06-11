package structural_model.adapter.class_adapter_pattern;
/**
 * <p>适配器模式将某个类的接口转换成客户端期望的另一个接口表示，
 * <p>目的是消除由于接口不匹配所造成的类的兼容性问题
 * @author smilesnake
 *
 */
public class Source {
	public void method1(){
		System.out.println("this is original method!");
	}
}
