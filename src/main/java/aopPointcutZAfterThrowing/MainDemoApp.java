package aopPointcutZAfterThrowing;

import aopPointcutZAfterThrowing.dao.Account;
import aopPointcutZAfterThrowing.dao.AccountDAO;
import aopPointcutZAfterThrowing.dao.MembershipDAO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainDemoApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
        AccountDAO accountDAO = context.getBean("accountDAO", AccountDAO.class);
        Account account=new Account();
        account.setName("Jano");
        account.setLevel("Gold");
        accountDAO.addAccount(account, true);
        System.out.println("\n Call it again!\n");
        accountDAO.addAccount(account, false);
        MembershipDAO membershipDAO =context.getBean("membershipDAO", MembershipDAO.class);
        membershipDAO.addAccount();


        accountDAO.setName("foobar");
        accountDAO.setServiceCode("silver");
        String name = accountDAO.getName();
        String code = accountDAO.getServiceCode();

        membershipDAO.addSillyMember();
        context.close();
    }
}
