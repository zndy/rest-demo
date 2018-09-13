package com.johnny.restdemo.service;

import com.johnny.restdemo.entity.MemoryInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.lang.management.ManagementFactory;
import java.lang.management.MemoryMXBean;
import java.lang.management.MemoryUsage;

@Service
public class MemoryObserverJob {

    @Autowired
    public ApplicationEventPublisher eventPublisher;

    @Scheduled(fixedRate = 1000)
    public void doSomething() {
        MemoryMXBean memBean = ManagementFactory.getMemoryMXBean();
        MemoryUsage heap = memBean.getHeapMemoryUsage();
        MemoryUsage nonHeap = memBean.getNonHeapMemoryUsage();
        MemoryInfo mi = new MemoryInfo(heap.getUsed(), nonHeap.getUsed());
        this.eventPublisher.publishEvent(mi);
    }
}
