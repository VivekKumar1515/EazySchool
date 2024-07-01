package org.eazybyte.com.eazybyteschool.Aspects;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.Instant;

@Slf4j
@Aspect
@Component
public class LoggingAspect {

    @Around("execution(* org.eazybyte.com.eazybyteschool.*.*.*(..))")
    public Object log(final ProceedingJoinPoint joinPoint) throws Throwable {
        log.info(joinPoint.getSignature().toString() + "method execution started");
        Instant start = Instant.now();
        Object result = joinPoint.proceed();
        Instant end = Instant.now();
        Long duration = Duration.between(start, end).toMillis();
        log.info(joinPoint.getSignature().toString() + "method execution completed in " + duration.toString());
        log.info(joinPoint.getSignature().toString() + "method execution completed");

        return result;
    }

    @AfterThrowing(value = "execution(* org.eazybyte.com.eazybyteschool.*.*.*(..))", throwing = "e")
    public void logException(final JoinPoint joinPoint, final Throwable e) {
        log.error(joinPoint.getSignature().toString() + "exception happened due to" + e.getMessage());
    }
}
