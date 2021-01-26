package aopPointcutDeclarations.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import sk.sovy.damianmatysko.dao.Account;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {

    @Before("aopPointcutDeclarations.aspect.AopExpressions.forDaoPackageNoGetterSetter()")
    public void beforeAddAccountAdvice(JoinPoint joinPoint) {
        System.out.println("\n===>>> Executing @before advice on method");

        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        System.out.println("Method: " + methodSignature);
        Object[] args=joinPoint.getArgs();
        for (Object o: args){
            System.out.println(o+"aksdjhfbvdskhjf");
            if (o instanceof Account){
                Account account= (Account) o;
                System.out.println("Account name: "+account.getName());
                System.out.println("Account level: "+account.getLevel());
            }
        }

    }
}
