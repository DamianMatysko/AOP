package aopZzAround.dao;

import org.springframework.stereotype.Component;

@Component
public class MembershipDAO {
 public void addAccount(){
     System.out.println(getClass()+ ": DOING STUFF: ADDING A MEMBERSHIP ACCOUNT");
 }
    public boolean addSillyMember(){
        System.out.println(getClass()+ ": DOING STUFF: ADDING A SILLYMEMBERSHIP ACCOUNT");
        return true;
    }
}