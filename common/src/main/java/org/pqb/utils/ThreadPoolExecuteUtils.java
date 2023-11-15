package org.pqb.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 跑数据专用线程池  IO密集型
 */
public class ThreadPoolExecuteUtils {

    public static final int CPU_COUNT = Runtime.getRuntime().availableProcessors();

    private static final Logger logger = LoggerFactory.getLogger(ThreadPoolExecuteUtils.class);

    private static final BlockingQueue<Runnable> queue = new ArrayBlockingQueue<Runnable>(10000);

    private static final ThreadPoolExecutor executor = new ThreadPoolExecutor(
            CPU_COUNT*2,
            CPU_COUNT*2,
            60L,
            TimeUnit.SECONDS,
            queue,
            (r, executor) -> {
                try {
                    executor.getQueue().put(r);
                } catch (Exception e) {
                    logger.error("线程池入队异常", e);
                }
            });


    public static ThreadPoolExecutor newExecutorInstance() {
        return executor;
    }

}

