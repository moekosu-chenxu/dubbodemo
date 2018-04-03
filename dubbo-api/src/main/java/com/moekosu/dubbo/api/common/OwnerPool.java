package com.moekosu.dubbo.api.common;

import java.util.concurrent.*;

/**
 * @author chenxu
 * @date 2018/04
 */
public class OwnerPool {

    // 核心线程数
    private int corePoolSize;
    // 最大线程数
    private int maxPoolSize;
    // 保持时间（单位：秒）
    private long keepAliveTime;
    // 队列长度
//    private int queueSize = 0;
    // 队列
    private LinkedBlockingQueue workQueue;
    // 队列处理
    private RejectedExecutionHandler handler;
    // 线程池对象
    private ExecutorService executor;

    public OwnerPool(int core, int max, long keepAlive)
    {
        this.corePoolSize = core;
        this.maxPoolSize = max;
        this.keepAliveTime = keepAlive;
        this.workQueue = new LinkedBlockingQueue();// 无传参是无边界排队队列
        this.handler = new ThreadPoolExecutor.CallerRunsPolicy();// 队列满了后续任务还会执行

        executor = new ThreadPoolExecutor(corePoolSize, maxPoolSize, keepAliveTime,
                TimeUnit.SECONDS, workQueue, handler);
    }

    public void execute(Task task)
    {
        executor.execute(new OwnerRun(task));
    }

    public void shutdown()
    {
        executor.shutdown();
    }

    /**
     * 单个具体线程
     */
    class OwnerRun implements Runnable
    {
        private Task task;

        public OwnerRun(Task task_)
        {
            this.task = task_;
        }

        public void run()
        {
            task.doTask();
        }
    }

    /**
     * 单个任务
     */
    public interface Task
    {
        void doTask();
    }

}
