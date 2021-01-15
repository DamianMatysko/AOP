package aopPointcutDeclarations;

import aopPointcutDeclarations.dao.Account;
import aopPointcutDeclarations.dao.AccountDAO;
import aopPointcutDeclarations.dao.MembershipDAO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

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
