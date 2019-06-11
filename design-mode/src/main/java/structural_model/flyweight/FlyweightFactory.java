package structural_model.flyweight;

import java.util.HashMap;
/**
 * 享元工厂
 * 
 * 
 * @author smilesnake
 *
 */
public class FlyweightFactory {
	//定义一个池容器
	private static HashMap<String, Flyweight> pool = new HashMap<String,Flyweight>();
	
	//享元工厂
	public static Flyweight getFlyweight(String Extrinsic){
		Flyweight flyweight = null;
		if(pool.containsKey(Extrinsic)){
			flyweight = pool.get(Extrinsic);
		}else{
			//根据外部状态创建享元对象
			flyweight = new ConFlyWeight(Extrinsic);
			pool.put(Extrinsic, flyweight);
		}
		return flyweight;
	}
}
