package com.mono.monochrome.observer;

import java.util.concurrent.Executor;

/**
 * @author monochrome
 * @date 2022/8/12
 */
public class AsyncEventBus extends EventBus{
    public AsyncEventBus(Executor executor) {
        super(executor);
    }
}
