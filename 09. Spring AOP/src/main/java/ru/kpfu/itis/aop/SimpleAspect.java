package ru.kpfu.itis.aop;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.reflect.MethodSignature;
import ru.kpfu.itis.util.annotation.RetryIfException;

import java.lang.reflect.Method;
import java.util.Arrays;

public class SimpleAspect {

    public Object log(ProceedingJoinPoint joinPoint) {
        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!" + joinPoint.getTarget().getClass().getSimpleName() +
                " " + joinPoint.getSignature().getName() +
                " " + Arrays.toString(joinPoint.getArgs()));
        try {
            Object result = joinPoint.proceed();
            System.out.println("?????????????????????????");
            return result;
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        return null;
    }

    public Object retry(ProceedingJoinPoint joinPoint) throws NoSuchMethodException {
        final Class clazz = joinPoint.getTarget().getClass();
        final Method method = clazz.getMethod(joinPoint.getSignature().getName());
        final RetryIfException annotation = method.getAnnotation(RetryIfException.class);
        if (annotation == null) {
            try {
                return joinPoint.proceed();
            } catch (Throwable throwable) {
                throwable.printStackTrace();
            }
        }
        int count = annotation.value();
        System.out.println("ОК босс, у нас есть " + count + " попыток!");
        while (count > 0) {
            try {
                Object result = joinPoint.proceed();
                return result;
            } catch (Throwable throwable) {
                System.out.println("Не получилось:(");
                count--;
                System.out.println("Осталось " + count);
            }
        }
        return null;
    }

}
