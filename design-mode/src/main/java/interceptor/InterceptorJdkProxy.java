package interceptor;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import structural_model.proxy.HelloWorld;
import structural_model.proxy.impl.HelloWorldImpl;
/**
 * 代理对象
 * @author smilesnake
 *
 */
public class InterceptorJdkProxy implements InvocationHandler {
	private Object target;//真实对象
	private String interceptorClass = null; //拦截器全限定名
	
	public InterceptorJdkProxy(Object target, String interceptorClass) {
		super();
		this.target = target;
		this.interceptorClass = interceptorClass;
	}
	/**
	 * 绑定委托对象并返回一个【代理占位】
	 * @param target
	 * @param interceptorClass
	 * @return
	 */
	public static Object bind(Object target,String interceptorClass){
		//取得代理对象
		return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), new InterceptorJdkProxy(target, interceptorClass));
		
	}
	
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		if(interceptorClass == null)
		//没有设置拦截器直接反射原有方法
		return method.invoke(target, args);
		
		Object result = null;
		//通过反射原有对象方法
		Interceptor interceptor = (Interceptor) Class.forName(interceptorClass).newInstance();
		if(interceptor.before(proxy, args, method, args)){
			//反射原有对象方法
			result = method.invoke(target, args);
		} else { //返回false执行around方法
			interceptor.around(proxy, args, method, args);
		}
		//调用后置方法
		interceptor.after(proxy, args, method, args);
		return result;
	}
	public static void main(String[] args) {
		HelloWorld proxy = (HelloWorld) InterceptorJdkProxy.bind(new HelloWorldImpl(), "interceptor.impl.MyInterceptor");
		proxy.sayHelloWorld();
	}
}
