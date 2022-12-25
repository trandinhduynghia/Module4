package com.codegym.demospringboot.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@org.aspectj.lang.annotation.Aspect
@Component
public class Aspect {
    private Logger logger = Logger.getLogger(Aspect.class.getName());

    @After("execution(* com.codegym.demospringboot.service.BookService.increaseBookQuantity(*))")
    public void getLogAfterIncrease(JoinPoint joinPoint) throws Throwable {
        String methodName = joinPoint.getSignature().getName();
        logger.info("After: End call " + methodName);
    }

    @After("execution(* com.codegym.demospringboot.service.BookService.decreaseBookQuantity(*))")
    public void getLogAfterDecrease(JoinPoint joinPoint) throws Throwable {
        String methodName = joinPoint.getSignature().getName();
        logger.info("After: End call " + methodName);
    }

    @After("execution(* com.codegym.demospringboot.controller.BookController.*(..))")
    public void getLogAfter(JoinPoint joinPoint) throws Throwable {
        String methodName = joinPoint.getSignature().getName();
        logger.info("After: End call " + methodName);
    }
}
