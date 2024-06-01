package MultiThreading;
import org.apache.log4j.Logger;
public class Synchronization implements Runnable {
    private final static Logger logger = Logger.getLogger(Synchronization.class);
    public int count;
    public int synCount;
    public void increment(){
        count++;
    }
    //example of method synchronization
    public synchronized void synchronizedIncrement(){
        synCount++;
    }
    public  void synchronizedIncrement2(){
        synchronized (this){
            synCount++;

        }
    }
    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            increment();
            synchronizedIncrement();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Synchronization obj = new Synchronization();
        Thread thread1 = new Thread(obj);
        Thread thread2 = new Thread(obj);

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        logger.info("With synchronization :" + String.valueOf(obj.synCount));
        logger.info("Without synchronization :" + String.valueOf(obj.count));

    }

}


