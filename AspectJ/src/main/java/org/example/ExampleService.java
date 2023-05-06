package org.example;

import org.example.MonitorPerformance;

// ExampleService.java
public class ExampleService
{
    public void shortRunningMethod() throws InterruptedException
    {
    }
    @MonitorPerformance
    public void longRunningMethod() throws InterruptedException {
        Thread.sleep(1000);
    }

    @MonitorPerformance
    public void anotherLongRunningMethod() throws InterruptedException {
        Thread.sleep(2000);
    }

    public void throwingMethod() throws Exception
    {
        throw new Exception();
    }
}