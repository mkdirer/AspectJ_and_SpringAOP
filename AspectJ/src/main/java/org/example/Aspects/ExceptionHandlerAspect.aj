package org.example.Aspects;

public aspect ExceptionHandlerAspect
{
    private Integer exceptionCount = 0;

    after() throwing(Exception e) : within(org.example.ExampleService)
    {
        exceptionCount+=1;
        String err = "Aspect catched exception: " + e + " from: " + thisJoinPoint.getSignature() +
                 " \nTotal exception count: " + exceptionCount.toString();
        System.out.println(err);
        for (StackTraceElement element : e.getStackTrace())
        {
            System.out.println(element);
        }
        System.out.println("=========================");
    }
}
