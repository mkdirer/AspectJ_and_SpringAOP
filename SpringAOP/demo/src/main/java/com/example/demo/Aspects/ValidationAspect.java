package com.example.demo.Aspects;


import com.example.demo.UserValidator;
import com.example.demo.model.User;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ValidationAspect
{
    @Autowired
    private UserValidator userValidator;

    @Around("execution(* com.example.demo.service.UserService.saveUser(com.example.demo.model.User)) && args(user)")
    public void validateUser(ProceedingJoinPoint pjp, User user) throws Throwable
    {
        Boolean isUserDataCorrect = userValidator.validate(user);
        if(isUserDataCorrect)
        {
            Object result = pjp.proceed();
        }
        else
        {
            System.out.println( pjp.getSignature() + " doesn't saved user due to invalid user data");
        }
    }
}

