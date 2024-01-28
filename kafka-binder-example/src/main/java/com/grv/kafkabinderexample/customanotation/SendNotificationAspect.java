package com.grv.kafkabinderexample.customanotation;

import com.grv.kafkabinderexample.KafkaProducer;
import com.grv.kafkabinderexample.dto.NotificationProduceDto;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Aspect
@Component
public class SendNotificationAspect {

    @Autowired
    KafkaProducer kafkaProducer;

    @Around("@annotation(SendNotification)")
    public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {

        long initTime = System.currentTimeMillis();
        Object proceed = joinPoint.proceed();
        long executionTime = System.currentTimeMillis() - initTime;
        System.out.println("============================================================================================================");
        System.out.println("Method Signature is : "+joinPoint.getSignature());
        System.out.println("Method Signature is : "+resolveEvent(joinPoint));
        System.out.println("Method executed in : " + executionTime + "ms");
//        System.out.println("Input Request: " + joinPoint.getArgs()[0]);
        System.out.println("Output Response : " + proceed);

        NotificationProduceDto notificationProduceDto = NotificationProduceDto.builder().build();

        notificationProduceDto.setEventName(resolveEvent(joinPoint));
        notificationProduceDto.setEventValue(proceed.toString());
        kafkaProducer.sendMessage(notificationProduceDto.toString());
        return proceed;
    }


    private static String resolveEvent(ProceedingJoinPoint joinPoint){
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        SendNotification annotation = method.getAnnotation(SendNotification.class);
        return annotation.eventName();
    }

}
