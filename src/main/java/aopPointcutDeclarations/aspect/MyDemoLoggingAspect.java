package aopPointcutDeclarations.aspect;

import aopPointcutDeclarations.dao.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;


import java.util.List;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {

    @AfterReturning(pointcut = "execution(* aopPointcutDeclarations.dao.AccountDAO.findAccounts(..))", returning = "result")
    public void afterReturningFindAccountsAdvice(JoinPoint joinPoint, List<Account> result) {
        String method = joinPoint.getSignature().toShortString();
        System.out.println("\n=======> Executing @AfterReturning on method: " + method);
        System.out.println("\n=======> Result is:  " + result);
        convertAccountNamesToUpperCase(result);
        System.out.println("\n======> Result: "+result);
    }

    private void convertAccountNamesToUpperCase(List<Account> result) {
        for (Account a:result){
            String upperName=a.getName().toUpperCase();
            a.setName(upperName);
        }
    }

    @Before("aopPointcutDeclarations.aspect.AopExpressions.forDaoPackageNoGetterSetter()")
    public void beforeAddAccountAdvice(JoinPoint joinPoint) {
        System.out.println("\n===>>> Executing @before advice on method");

        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        System.out.println("Method: " + methodSignature);
        Object[] args = joinPoint.getArgs();
        for (Object o : args) {
            System.out.println(o + ": ");
            if (o instanceof Account) {
                Account account = (Account) o;
                System.out.println("Account name: " + account.getName());
                System.out.println("Account level: " + account.getLevel());//todo not working
            }
        }


    }
}
