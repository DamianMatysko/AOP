package aopZzAround.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class AopExpressions {

    @Pointcut("execution(* aopPointcutDeclarations.dao.*.*(..))")
    public void forDaoPackage() {
    }


    @Pointcut("execution(* aopPointcutDeclarations.dao.*.get*(..))")
    public void getter() {
    }

    @Pointcut("execution(* aopPointcutDeclarations.dao.*.set*(..))")
    public void setter() {
    }

    @Pointcut("forDaoPackage() && !(getter() || setter())")
    public void forDaoPackageNoGetterSetter() {
    }

}
