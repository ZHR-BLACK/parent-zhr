package structural_model.flyweight.concrete;

import java.util.HashMap;
/**
 * 学生工厂 
 * @author smilesnake
 *
 */
public class StudentFactory {
	// 定义一个池容器
	private static HashMap<String, Academy> pool = new HashMap<String, Academy>();

	// 工厂方法，创建一个学生对象
	public static StudentFlyWeight getStudent(String name, int age, Academy academy) {
		return new StudentFlyWeight(name, age, academy);
	}
	
	// 工厂方法，创建一个学生对象,如果计算机学院需要实例化1万个学生，那么学院类只需要实例化一个就够了
	public static StudentFlyWeight getStudentInstance(String name, int age, String academyName, String president,
			String presidentSex, String academyInfo) {
		Academy academy = null;
		if (pool.containsKey(academyName)) {
			academy = pool.get(academyName);
		} else {
			academy = new Academy(academyName, president, presidentSex, academyInfo);
			// 把学院对象实例放到池子里
			pool.put(academyName, academy);
		}
		return new StudentFlyWeight(academyName, age, academy);
	}
}
