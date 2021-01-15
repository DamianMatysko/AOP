package sk.sovy.damianmatysko;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import sk.sovy.damianmatysko.dao.Account;
import sk.sovy.damianmatysko.dao.AccountDAO;
import sk.sovy.damianmatysko.dao.MembershipDAO;

public class MainDemoApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
        AccountDAO accountDAO = context.getBean("accountDAO", AccountDAO.class);
        Account account=new Account();
        accountDAO.addAccount(account, true);
        System.out.println("\n Call it again!\n");
        accountDAO.addAccount(account, false);
        MembershipDAO membershipDAO =context.getBean("membershipDAO", MembershipDAO.class);
        membershipDAO.addAccount();
        membershipDAO.addSillyMember();
        context.close();
    }
}
