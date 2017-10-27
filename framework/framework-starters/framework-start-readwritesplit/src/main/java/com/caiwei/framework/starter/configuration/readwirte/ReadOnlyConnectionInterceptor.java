package com.caiwei.framework.starter.configuration.readwirte;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;

/**
 * @author longhairen
 * @create 2017/10/25 0025 下午 5:39
 */
@Aspect
@Component
public class ReadOnlyConnectionInterceptor implements Ordered {

    private static final Logger logger = LoggerFactory.getLogger(ReadOnlyConnectionInterceptor.class);

    @Around("@annotation(readOnlyConnection)")
    public Object proceed(ProceedingJoinPoint proceedingJoinPoint, ReadOnlyConnection readOnlyConnection) throws Throwable {
        try {
            logger.info("set database connection to read only");
            DatasourceContextHolder.setDatasourceType(DatasourceContextHolder.DatasourceType.SLAVE);
            Object result = proceedingJoinPoint.proceed();
            return result;
        } finally {
            DatasourceContextHolder.clearDatasourceType();
            logger.info("restore database connection");
        }
    }

    @Override
    public int getOrder() {
        return 0;
    }
}
