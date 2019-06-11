package structural_model.flyweight;
/**
 * 具体的享元类 
 * @author smilesnake
 *
 */
public class ConFlyWeight extends Flyweight {

	public ConFlyWeight(String _Extrinsic) {
		super(_Extrinsic);
	}

	@Override
	public void operate() {
		System.out.println("业务逻辑处理");
	}

}
