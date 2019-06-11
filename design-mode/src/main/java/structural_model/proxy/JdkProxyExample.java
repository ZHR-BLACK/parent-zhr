package structural_model.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import structural_model.proxy.impl.HelloWorldImpl;
/**
 * 动态代理
 * @author smilesnake
 *
 */
public class JdkProxyExample implements InvocationHandler {
	//真实对象
	private Object target = null;
	/**
	 * 建立代理对象和真实对象的代理关系，并返回代理对象
	 * @param target 真实对象
	 * @return 代理对象
	 */
	public Object bind(Object target){
		this.target = target;
		return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(),this);
	}
	
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("进入代理逻辑方法之前");
		System.out.println("在调度真实方法对象之前的服务");
		
		Object obj = method.invoke(target, args);  //相当于调用SayHelloWorld();
		
		System.out.println("在调度真实对象之后的服务");

		return obj;
	}
	/**
	 * <p>代理模式的应用场景：
	 * <p>如果已有的方法在使用的时候需要对原有的方法进行改进，此时有两种办法：
	 * <p>1、修改原有的方法来适应。这样违反了“对扩展开放，对修改关闭”的原则。
	 * <p>2、就是采用一个代理类调用原有的方法，且对产生的结果进行控制。这种方法就是代理模式。
	 * <p>使用代理模式，可以将功能划分的更加清晰，有助于后期维护！
	 * @param args
	 */
	public static void main (String[] args) {
		JdkProxyExample jdk = new JdkProxyExample();
		HelloWorld proxy = (HelloWorld) jdk.bind(new HelloWorldImpl());
		proxy.sayHelloWorld("小三");
	}
	
}
