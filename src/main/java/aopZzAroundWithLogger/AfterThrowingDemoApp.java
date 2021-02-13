package aopZzAroundWithLogger;

import aopZzAroundWithLogger.dao.Account;
import aopZzAroundWithLogger.dao.AccountDAO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class AfterThrowingDemoApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
        AccountDAO accountDAO = context.getBean("accountDAO", AccountDAO.class);
        List<Account> accounts = null;
        try {
            boolean tripWire=true;
            accounts = accountDAO.findAccounts(tripWire);
        } catch (Exception e) {
            System.out.println("\n\nMain Program... caught exception: " + e);
        }
        System.out.println("\n\nMain Program: AfterThrowingDemoApp");
        System.out.println("+-+-+-+-+-+");
        System.out.println(accounts);
        System.out.println("\n\n");

        context.close();
    }
}
