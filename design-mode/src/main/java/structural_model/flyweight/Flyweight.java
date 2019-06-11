package structural_model.flyweight;

/**
 * Flyweight: 抽象出来的享元类
 * 
 * @author
 */
public abstract class Flyweight {
	// 不共享的状态
	private String intrinsic;
	// 可以共享的状态
	protected final String Extrinsic;

	// 要求享元角色必须接受外部状态
	public Flyweight(String _Extrinsic) {
		this.Extrinsic = _Extrinsic;
	}

	// 定义业务操作
	public abstract void operate();

	// 内部状态的getter/setter
	public String getIntrinsic() {
		return intrinsic;
	}

	public void setIntrinsic(String intrinsic) {
		this.intrinsic = intrinsic;
	}

}
