package interceptor;

import java.lang.reflect.Method;
/**
 * 拦截器模式
 * @author smilesnake
 *
 */
public interface Interceptor {
	/**
	 * 它在真实对象前调用，当返回为true时，则反射真实对象，返回false时，则调用around方法
	 * @param proxy	代理对象
	 * @param target 真实对象
	 * @param method method方法
	 * @param args	运行方法参数
	 * @return boolean
	 */
	public boolean before(Object proxy, Object target, Method method, Object[] args);
	/**
	 * 在before方法返回false时，调用此方法
	 * @param proxy	代理对象
	 * @param target 真实对象
	 * @param method method方法
	 * @param args	运行方法参数
	 */
	public void around(Object proxy, Object target, Method method, Object[] args);
	/**
	 * 在反射真实对象或around方法执行后，调用after方法
	 * @param proxy	代理对象
	 * @param target 真实对象
	 * @param method method方法
	 * @param args	运行方法参数
	 */
	public void after(Object proxy, Object target, Method method, Object[] args);

}
