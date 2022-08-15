package com.mono.monochrome.observer;

import com.google.common.util.concurrent.MoreExecutors;

import java.util.List;
import java.util.concurrent.Executor;

/**
 * @author monochrome
 * @date 2022/8/12
 */
public class EventBus {
    private Executor executor;
    private ObserverRegistry registry = new ObserverRegistry();

    //为了复用代码，MoreExecutors.directExecutor()实际上是Google Guava提供的工具类，实际不是多线程，而是单线程
    public EventBus() {
        this(MoreExecutors.directExecutor());
    }

    public EventBus(Executor executor) {
        this.executor = executor;
    }

    public void register(Object object) {
        registry.register(object);
    }

    public void post(Object event) {
        List<ObserverAction> matchedObserverActions = registry.getMatchedObserverActions(event);
        for (ObserverAction observerAction : matchedObserverActions) {
            executor.execute(() -> {
                observerAction.execute(event);
            });
        }
    }

}
