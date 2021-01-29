package aopPointcutDeclarations;

import aopPointcutDeclarations.dao.Account;
import aopPointcutDeclarations.dao.AccountDAO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class AfterReturnigDemoApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
        AccountDAO accountDAO = context.getBean("accountDAO", AccountDAO.class);
        List<Account> accounts = accountDAO.findAccounts();
        System.out.println("\n\nMain Program: AfterReturningDemoApp");
        System.out.println("+-+-+-+-+-+");
        System.out.println(accounts);
        System.out.println("\n\n");

        context.close();
    }
}
