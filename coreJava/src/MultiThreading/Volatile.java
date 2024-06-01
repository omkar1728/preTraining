package MultiThreading;

import org.apache.log4j.Logger;
public class Volatile {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            Task task = new Task();
            Thread thread = new Thread(task);
            thread.start();
        }
    }
}
class Task implements Runnable{

    @Override
    public void run() {
        Singelton.getInstance();
        try {
            Thread.sleep(10000);
        } catch (InterruptedException ignored) {

        }
    }
}

class Singelton{
    private static Singelton instance = null;
    private static final Logger logger = Logger.getLogger(Volatile.class);
    private Singelton(){
    }

    public static Singelton getInstance(){
        if(instance == null){
            instance = new Singelton();
        }
        logger.info("Object has the hashcode of " + instance.hashCode());
        return instance;
    }

}
