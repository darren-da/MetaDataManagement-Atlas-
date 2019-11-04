package com.limp.framework.utils;






import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Auther: zhangbo
 * @Date: 2018/10/22 13:54
 * @Description:线程池工具类
 */
public class ThreadPoolUtils {

    private static final AtomicInteger poolNumber = new AtomicInteger(1);

    private static final int CPU_NUM = Runtime.getRuntime().availableProcessors();

    //核心线程数 = CPU核心数 + 1
    private static final int CORE_POOL_SIZE = CPU_NUM + 1;

    //线程池最大线程数 = CPU核心数 * 2 + 1
    private static final int MAXIMUM_POOL_SIZE = CPU_NUM * 2 + 1;

    public static ThreadPool instance = null;
    /** 耗时比较长的线程池   用来请求网络 **/
    private ThreadPoolExecutor longExecutor;
    /** 比较短的线程池    用来加载本地数据 **/
    private ThreadPoolExecutor shortExecutor;

    public static ThreadPool getInstance(){
        if(instance == null){
            synchronized (ThreadPoolUtils.class){
                if(instance == null){
                    // 获取处理器数量
                    // 根据cpu数量,计算出合理的线程并发数

                    instance = new ThreadPool(CORE_POOL_SIZE, MAXIMUM_POOL_SIZE, 1);
                }
            }
        }
        return instance;
    }

    public static class ThreadPool {
        private ThreadPoolExecutor mExecutor;
        private int corePoolSize;
        private int maximumPoolSize;
        private long keepAliveTime;

        private ThreadPool(int corePoolSize, int maximumPoolSize, long keepAliveTime) {
            this.corePoolSize = corePoolSize;
            this.maximumPoolSize = maximumPoolSize;
            this.keepAliveTime = keepAliveTime;
        }

        public void execute(Runnable runnable) {
            if (runnable == null) {
                return;
            }
            if (mExecutor == null) {
                mExecutor = new ThreadPoolExecutor(
                        // 核心线程数
                        corePoolSize,
                        // 最大线程数
                        maximumPoolSize,
                        // 闲置线程存活时间
                        keepAliveTime,
                        // 时间单位
                        TimeUnit.MILLISECONDS,
                        // 线程队列
                        new ArrayBlockingQueue<Runnable>(20),
                        Executors.defaultThreadFactory(),
                        // 队列已满,而且当前线程数已经超过最大线程数时的异常处理策略
                        new ThreadPoolExecutor.AbortPolicy() {
                            @Override
                            public void rejectedExecution(Runnable r, ThreadPoolExecutor e) {
                                super.rejectedExecution(r, e);
                            }
                        }
                );
            }
            try{
                mExecutor.execute(runnable);
            }catch (Exception e){
                System.err.println(e.getMessage());

            }

        }

        public ThreadPoolExecutor createExecutor(){
            if (mExecutor == null) {
                mExecutor = new ThreadPoolExecutor(
                        // 核心线程数
                        corePoolSize,
                        // 最大线程数
                        maximumPoolSize,
                        // 闲置线程存活时间
                        keepAliveTime,
                        // 时间单位
                        TimeUnit.MILLISECONDS,
                        // 线程队列
                        new ArrayBlockingQueue<Runnable>(20),
                        Executors.defaultThreadFactory(),
                        // 队列已满,而且当前线程数已经超过最大线程数时的异常处理策略
                        new ThreadPoolExecutor.AbortPolicy() {
                            @Override
                            public void rejectedExecution(Runnable r, ThreadPoolExecutor e) {
                                super.rejectedExecution(r, e);
                            }
                        }
                );
            }
            return mExecutor;
        }

        public void cancel(Runnable runnable) {
            if (mExecutor != null) {
                mExecutor.getQueue().remove(runnable);
            }
        }
    }




}
