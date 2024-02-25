package com.yourcompany.serietv.aspect;

import com.yourcompany.serietv.entity.Serial;
import com.yourcompany.serietv.service.MailService;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
@RequiredArgsConstructor
public class BroadcastMailAspect {

    private final MailService mailService;

    @Pointcut("@annotation(com.yourcompany.serietv.annotation.BroadcastMailAnnotation)")
    public void broadcastMailPointCut(){

    }

    @Around("broadcastMailPointCut()")
    public Object broadcastMailArrondNewSeason(ProceedingJoinPoint joinPoint){

        Object result = null;
        try {
            result = joinPoint.proceed();

            if (result instanceof Serial serial){
                mailService.broadcastNewSaison(serial.getName());
            }

        } catch (Throwable e) {
            throw new RuntimeException(e);
        }


        return result;

    }

}
