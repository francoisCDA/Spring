package org.example.demo_aop.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class DemoAspect {


    //@Before("execution(* org.example.demo_aop.service.*.*())")  // cible toutes les méthodes des classes du service avec (0 / TOUS / un type particulier) argument
//    @Before("execution(* org.example.demo_aop.service.*.*(..))")
//    public void addActionBefore() {
//        System.out.println("Action executed by Aspect");
//
//    }
//
//    @After("execution(* org.example.demo_aop.service.*.*(..))")
//    public void addActionAfter() {
//        System.out.println("Action executed after by Aspect");
//
//    }
//
//    @AfterReturning("execution(* org.example.demo_aop.service.*.*(..))")
//    public void addActionAfterReturning() {
//        System.out.println("Action executed afterReturning by Aspect");
//
//    }
//
//
//    @AfterThrowing("execution(* org.example.demo_aop.service.*.*(..))")
//    public void addActionAfterThrowing() {
//        System.out.println("Action executed afterthrowing exception by Aspect");
//
//    }


//    @Around("execution(* org.example.demo_aop.service.*.*(..))")
//    public void addActionAround(ProceedingJoinPoint joinPoint) {
//
//        try {
//            //avant
//            System.out.println("start around");
//
//            //execute
//            //récupérer les arguments
//            Object[] args = jointPoint.getArgs();
//            //utiliser la méthode
//            joinPoint.proceed();
//            System.out.println("la méthode interceptée à été executé");
//        } catch (Exception ex) {
//            //Après
//            System.out.println("end around");
//        } catch (Throwable e) {
//            System.out.println("throw exception");
//            throw new RuntimeException(e);
//        }
//    }

    @Pointcut("@annotation(org.example.demo_aop.annotation.CustomAnnotation)")
    public void customAnnotationPointCut(){

    }

    @Before("customAnnotationPointCut()")
    public void methodeAspectWithAnnotation(){
        System.out.println("Aspect with methode annotation");

    }

}
