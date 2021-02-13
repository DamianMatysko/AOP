package aopZzAround;



import aopZzAround.dao.Account;
import aopZzAround.dao.AccountDAO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class AfterReturningDemoApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
        AccountDAO accountDAO = context.getBean("accountDAO", AccountDAO.class);
        List<Account> accounts = accountDAO.findAccounts(false);
        System.out.println("\n\nMain Program: AfterReturningDemoApp");
        System.out.println("+-+-+-+-+-+");
        System.out.println(accounts);
        System.out.println("\n\n");

        context.close();
    }
}