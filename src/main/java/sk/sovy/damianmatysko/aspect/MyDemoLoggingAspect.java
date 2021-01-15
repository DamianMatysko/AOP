package sk.sovy.damianmatysko.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {
    //@Before("execution(public void sk.sovy.damianmatysko.dao.AccountDAO.addAccount())")
    //@Before("execution(public void add*())")
    //@Before("execution(* add*())")
    //@Before("execution(public void updateAccount())")
    //@Before("execution(* add*(sk.sovy.damianmatysko.dao.Account))")
    //@Before("execution(* add*(Account))")
    @Before("execution(* add*(sk.sovy.damianmatysko.dao.Account, ..))")
    public void beforeAddAccountAdvice() {
        System.out.println("\n===>>> Executing @before advice on method");
    }
}
