package behavior_pattern.responsibilityChainModel;

import java.lang.reflect.Method;

import interceptor.Interceptor;

public class Interceptor2 implements Interceptor{

	@Override
	public boolean before(Object proxy, Object target, Method method, Object[] args) {
		System.out.println("【拦截器2】的before方法");
		return true;
	}

	@Override
	public void around(Object proxy, Object target, Method method, Object[] args) {}

	@Override
	public void after(Object proxy, Object target, Method method, Object[] args) {
		System.out.println("【拦截器2】的after方法");
	}
}
