package org.example.Aspects;

public aspect MeasureExecutionTimeAspect
{
    pointcut beanAnnotatedWithMonitor() : within(@com.example.Monitor *);
    pointcut publicMethod() : execution(public * *(..));
    pointcut publicMethodInsideAClassMarkedWithAtMonitor() : publicMethod() && beanAnnotatedWithMonitor();

    pointcut longMethod() : @annotation(org.example.MonitorPerformance) && call(* *(..));
    void around() : longMethod()
    {
        long start = System.currentTimeMillis();
        proceed();
        long executionTime = System.currentTimeMillis() - start;

        System.out.println("Time of executing of" + thisJoinPoint.getSignature().toString() + " was " + executionTime + "ms");
    }
}
