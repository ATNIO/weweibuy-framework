package com.weweibuy.framework.compensate.core;

import com.weweibuy.framework.compensate.support.RecoverMethodArgsResolverComposite;
import lombok.Builder;
import lombok.Data;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author durenhao
 * @date 2020/2/14 19:56
 **/
@Data
@Builder
public class CompensateHandlerMethod {

    private Object bean;

    private Method method;

    private Object recoverBean;

    private Method recoverMethod;

    private RecoverMethodArgsResolverComposite composite;


    public Object invoke(Object[] args) throws InvocationTargetException {
        ReflectionUtils.makeAccessible(method);
        try {
            return method.invoke(bean, args);
        } catch (IllegalAccessException e) {
            throw new IllegalStateException(e);
        }
    }

    public Object invokeRecover(Object[] args) throws InvocationTargetException {
        ReflectionUtils.makeAccessible(recoverMethod);
        try {
            return recoverMethod.invoke(recoverBean, args);
        } catch (IllegalAccessException e) {
            throw new IllegalStateException(e);
        }
    }

    public boolean hasRecoverMethod() {
        return recoverBean != null && recoverMethod != null;
    }

}
