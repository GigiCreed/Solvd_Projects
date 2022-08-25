package solvd.projects.multithread.threadpool;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;

public class Reject implements RejectedExecutionHandler {
    private static final Logger LOGGER = LogManager.getLogger(Reject.class);
    @Override
    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
      LOGGER.error("Rejected Thread");
    }
}
