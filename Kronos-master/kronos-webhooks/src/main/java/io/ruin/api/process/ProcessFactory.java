package io.ruin.api.process;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author ReverendDread on 6/14/2020
 * https://www.rune-server.ee/members/reverenddread/
 * @project Kronos
 */
public class ProcessFactory implements ThreadFactory {

    private static final Thread.UncaughtExceptionHandler EXCEPTION_HANDLER = (t, e) -> e.printStackTrace();

    private final ThreadGroup group;

    private final String namePrefix;

    private final int threadPriority;

    private final AtomicInteger threadNumber = new AtomicInteger(1);

    public ProcessFactory(String name, int threadPriority) {
        SecurityManager s = System.getSecurityManager();
        this.group = (s != null) ? s.getThreadGroup() : Thread.currentThread().getThreadGroup();
        this.namePrefix = name + " #";
        this.threadPriority = threadPriority;
        if(this.threadPriority > this.group.getMaxPriority())
            System.err.println("Thread Factory (" + name + ") priority exceeded! (" + this.threadPriority + " > " + this.group.getMaxPriority() + ")");
    }

    public Thread newThread(Runnable runnable) {
        Thread t = new Thread(group, runnable, namePrefix + threadNumber.getAndIncrement(), 0);
        if(t.isDaemon())
            t.setDaemon(false);
        if(t.getPriority() != threadPriority)
            t.setPriority(threadPriority);
        t.setUncaughtExceptionHandler(EXCEPTION_HANDLER);
        return t;
    }

    static {
        Thread.setDefaultUncaughtExceptionHandler(EXCEPTION_HANDLER);
    }

}
