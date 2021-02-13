package aopZzAround;

import aopZzAround.dao.Account;
import aopZzAround.dao.AccountDAO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class AfterFinallyDemoApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
        AccountDAO accountDAO = context.getBean("accountDAO", AccountDAO.class);
        List<Account> accounts = null;
        try {
            boolean tripWire=true;
            accounts = accountDAO.findAccounts(false);
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
