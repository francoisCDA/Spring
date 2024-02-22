package org.example.exo_aop.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {

    @Pointcut("@annotation(org.example.exo_aop.annotation.LoggingAnnotation)")
    public void loggingAnnotationPointCut(){

    }

    @Around("loggingAnnotationPointCut()")
    public Object logginArroundLoggingAnnotation(ProceedingJoinPoint joinPoint) {

        try {
            Object[] args = joinPoint.getArgs();
            for (Object o :args) {
                System.out.println(o.toString());
            }
            Object retour = joinPoint.proceed();
            System.out.println(retour.toString());
            return retour;

        } catch (Exception ex) {

            System.out.println("end loggingAnnotationPointCut");

        } catch (Throwable e) {
            throw new RuntimeException(e);
        }

        return null;
    }


}
