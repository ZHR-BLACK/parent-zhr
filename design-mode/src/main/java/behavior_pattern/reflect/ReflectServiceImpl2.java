package behavior_pattern.reflect;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReflectServiceImpl2 {

    private String name;

    public void sayHello() {
        System.err.println("Hello :" + this.name);
    }

//	public ReflectServiceImpl2 getInstance() {
//		ReflectServiceImpl2 object = null;
//		try {
//			object = (ReflectServiceImpl2) Class.forName("reflex.ReflectServiceImpl2").getConstructor(String.class).newInstance("张三");
//		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException | SecurityException ex) {
//			ex.printStackTrace();
//		}
//		return object;
//	}

    /**
     * @return void
     * @Author ZHR
     * @Description 反射创建对象实例并调用其方法
     * @Date 2019/5/23 16:50
     * @param: args
     **/
    public static void main(String[] args) {
        ReflectServiceImpl2 object = null;
        try {
            object = (ReflectServiceImpl2) Class.forName("reflex.ReflectServiceImpl2").getConstructor(String.class).newInstance("张三");
            object.sayHello();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
