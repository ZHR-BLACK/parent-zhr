package behavior_pattern.reflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectServiceImpl {

    public void say() {
        System.err.println("say");
    }

    public void sayHello(String name) {
        System.err.println("Hello :" + name);
    }

    public void sayGood(String name, int isgood) {
        System.err.println(name + "is good " + isgood);
    }

    /**
     * 得到对象实例
     *
     * @return
     */
    public ReflectServiceImpl getInstance() {
        ReflectServiceImpl object = null;
        try {
            object = (ReflectServiceImpl) Class.forName("reflex.ReflectServiceImpl").newInstance();
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
            ex.printStackTrace();
        }
        return object;
    }

    /**
     * 反射带参方法
     *
     * @return
     */
    public static Object reflectMethod2() {
        Object returnObj = null;
        ReflectServiceImpl target = new ReflectServiceImpl();
        try {
            Method method = ReflectServiceImpl.class.getMethod("sayHello", String.class);
            returnObj = method.invoke(target, "大王");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return returnObj;
    }

    /**
     * 反射无参方法
     *
     * @return
     */
    public static Object reflectMethod1() {
        Object returnObj = null;
        ReflectServiceImpl target = new ReflectServiceImpl();
        try {
            Method method = ReflectServiceImpl.class.getMethod("say");
            returnObj = method.invoke(target);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return returnObj;
    }

    public static Object sayGood() {
        Object returnObj = null;
        ReflectServiceImpl target = new ReflectServiceImpl();
        try {
            Method method = ReflectServiceImpl.class.getMethod("sayGood", String.class, int.class);
            returnObj = method.invoke(target, "小三", true);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return returnObj;
    }

    /**
     * @return void
     * @Author ZHR
     * @Description 反射调用方法
     * @Date 2019/5/23 16:54
     * @param: args
     **/
    public static void main(String[] args) {
        ReflectServiceImpl target = new ReflectServiceImpl();
        try {
            Method method = target.getClass().getMethod("say");
            method.invoke(target);

            Method method2 = target.getClass().getMethod("sayHello", String.class);
            method2.invoke(target, "二逼");

            Method method3 = target.getClass().getMethod("sayGood", new Class[]{String.class, int.class});
            method3.invoke(target, new Object[]{"小三", 3});
        } catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
            e.printStackTrace();
        }

    }

}
