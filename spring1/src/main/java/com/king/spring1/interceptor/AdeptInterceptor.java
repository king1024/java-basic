package com.king.spring1.interceptor;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * @author duanyong
 * 2019年4月12日 下午2:44:00
 */
public class AdeptInterceptor implements MethodInterceptor  {

	@Override
	public Object invoke(MethodInvocation methodInvocation) throws Throwable {
		System.out.println("before method invoke-----"+methodInvocation.getMethod().getName());
        Object object = methodInvocation.proceed();
        System.out.println("after method invoke-----"+methodInvocation.getMethod().getName());
        return object;
	}

}
