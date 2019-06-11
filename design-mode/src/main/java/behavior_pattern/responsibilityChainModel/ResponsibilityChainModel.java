package behavior_pattern.responsibilityChainModel;

import interceptor.InterceptorJdkProxy;
import structural_model.proxy.HelloWorld;
import structural_model.proxy.impl.HelloWorldImpl;

/**
 * 责任链模式
 *
 * @author smilesnake
 */
public class ResponsibilityChainModel {

    public static void main(String[] args) {
        HelloWorld proxy1 = (HelloWorld) InterceptorJdkProxy.bind(new HelloWorldImpl(), "behavior_pattern.responsibilityChainModel.Interceptor1");
        HelloWorld proxy2 = (HelloWorld) InterceptorJdkProxy.bind(proxy1, "behavior_pattern.responsibilityChainModel.Interceptor2");
        HelloWorld proxy3 = (HelloWorld) InterceptorJdkProxy.bind(proxy2, "behavior_pattern.responsibilityChainModel.Interceptor3");
        proxy3.sayHelloWorld();
    }
}
