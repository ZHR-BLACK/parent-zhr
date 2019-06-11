package structural_model.adapter.adapter_pattern_for_objects;

import structural_model.adapter.class_adapter_pattern.Source;
import structural_model.adapter.class_adapter_pattern.Targetable;

/**
 * 对象的适配器模式
 * <p>只是将Adapter类作修改，这次不继承Source类，而是持有Source类的实例，以达到解决兼容性的问题。</p>
 * @author smilesnake
 *
 */
public class Wrapper implements Targetable {

	private Source source;

	public Wrapper(Source source) {
		super();
		this.source = source;
	}

	@Override
	public void method1() {
		source.method1();
	}

	@Override
	public void method2() {
		System.out.println("this is the targetable method!");
	}
	
	public static void main(String[] args) {
			Source source = new Source();
			Targetable target = new Wrapper(source);
			target.method1();
			target.method2();
	}

}
