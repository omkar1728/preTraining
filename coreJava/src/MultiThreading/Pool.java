package MultiThreading;

import java.util.concurrent.*;
import org.apache.log4j.Logger;
//Reference - https://www.youtube.com/watch?v=ZUWs2U71vvk
public class Pool {
    static ThreadPoolExecutor executor = new ThreadPoolExecutor(3,
            4,
            10,
            TimeUnit.SECONDS,
            new ArrayBlockingQueue<>(3),
            new MyThreadFactory(),
            new MyRejectHandler());

    public static void main(String[] args) {
        //max pool size is 4 and queue has capacity of 3 hence 3 tasks will get rejected out of 10
        //lowering thread execution time will cause more tasks to be accepted
        for (int i = 0; i < 10; i++) {
            executor.submit(new MyTask(i));
        }
        executor.shutdown(); //required to complete the execution of code
    }

}
//creating a custom task to simulate a action taking some time
class MyTask implements Runnable{
    int id;
    private static final Logger logger = Logger.getLogger(Pool.class);
    MyTask(int id){
        this.id = id;
    }
    @Override
    public void run() {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        logger.info("Task running with id: " + String.valueOf(id));
    }
}
// accepts task and returns threads to pool executor.
class MyThreadFactory implements ThreadFactory{

    @Override
    public Thread newThread(Runnable r) {
        //can customize the thread here.
        return new Thread(r);
    }
}
//handles rejection policy when tasks are to be rejected.
class MyRejectHandler implements RejectedExecutionHandler{
    private static final Logger logger = Logger.getLogger(Pool.class);
    @Override
    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
        logger.error("Task was rejected " + r.toString());
    }
}