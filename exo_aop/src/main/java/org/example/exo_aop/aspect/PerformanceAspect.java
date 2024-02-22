package org.example.exo_aop.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class PerformanceAspect {

    @Pointcut("@annotation(org.example.exo_aop.annotation.PerformanceAnnotation)")
    public void performanceAnnotationPointCut(){

    }

    @Around("performanceAnnotationPointCut()")
    public Object performanceAroundAnnotation(ProceedingJoinPoint joinPoint){

        try{
            long t0 =System.currentTimeMillis();

            Object retour = joinPoint.proceed();

            long dt = System.currentTimeMillis() - t0;

            System.out.println("temps d'execution de la méthode : " + dt + " ms");

            return retour;
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }

    }

}
