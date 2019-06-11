package interceptor.impl;

import interceptor.Interceptor;

import java.lang.reflect.Method;

public class MyInterceptor implements Interceptor{

	@Override
	public boolean before(Object proxy, Object target, Method method, Object[] args) {
		System.out.println("反射方法前逻辑:");
		return false;//不反射被代理对象原有方法
	}

	@Override
	public void around(Object proxy, Object target, Method method, Object[] args) {
		System.out.println("反射方法逻辑");
	}

	@Override
	public void after(Object proxy, Object target, Method method, Object[] args) {
		System.out.println("取代被代理对象的方法");
	}

}
