package aopZzzAroundHandleException.aspect;

import aopZzzAroundHandleException.dao.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.logging.Logger;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {

   private Logger logger=Logger.getLogger(getClass().getName());

    @Around("execution(* aopZzAround.service.*.getFortune(..))")
    public Object aroundGetFortune(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        String method = proceedingJoinPoint.getSignature().toShortString();
        logger.info("\n=======> Executing @Around on method: " + method);
        long begin = System.currentTimeMillis();
        Object result = null;
        try {
            result = proceedingJoinPoint.proceed();
        }catch (Exception e){
            logger.warning(e.getMessage());
           throw e;
        }
        long end = System.currentTimeMillis();
        long duration = end - begin;
        logger.info("\n====> Duration: " + duration / 1000.0 + " seconds");
        return result;
    }

    @After("execution(* aopZzzAroundHandleException.dao.AccountDAO.findAccounts(..))")
    public void afterFinallyFindAccountsAdvice(JoinPoint joinPoint) {
        String method = joinPoint.getSignature().toShortString();
        logger.info("\n=======> Executing @AfterThrowing on method: " + method);
    }

    @AfterThrowing(pointcut = "execution(* aopZzzAroundHandleException.dao.AccountDAO.findAccounts(..))", throwing = "theExc")
    public void afterThrowingFindAccountsAdvice(JoinPoint joinPoint, Throwable theExc) {
        String method = joinPoint.getSignature().toShortString();
        logger.info("\n=======> Executing @After (Finally) on method: " + theExc);
    }

    @AfterReturning(pointcut = "execution(* aopZzzAroundHandleException.dao.AccountDAO.findAccounts(..))", returning = "result")
    public void afterReturningFindAccountsAdvice(JoinPoint joinPoint, List<Account> result) {
        String method = joinPoint.getSignature().toShortString();
        logger.info("\n=======> Executing @AfterReturning on method: " + method);
        logger.info("\n=======> Result is:  " + result);
        convertAccountNamesToUpperCase(result);
        logger.info("\n======> Result: " + result);
    }

    private void convertAccountNamesToUpperCase(List<Account> result) {
        for (Account a : result) {
            String upperName = a.getName().toUpperCase();
            a.setName(upperName);
        }
    }

    @Before("aopZzzAroundHandleException.aspect.AopExpressions.forDaoPackageNoGetterSetter()")
    public void beforeAddAccountAdvice(JoinPoint joinPoint) {
        logger.info("\n===>>> Executing @before advice on method");

        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        logger.info("Method: " + methodSignature);
        Object[] args = joinPoint.getArgs();
        for (Object o : args) {
            logger.info(o + ": ");
            if (o instanceof Account) {
                Account account = (Account) o;
                logger.info("Account name: " + account.getName());
                logger.info("Account level: " + account.getLevel());//todo
            }
        }


    }
}
