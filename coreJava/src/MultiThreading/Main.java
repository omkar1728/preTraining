package MultiThreading;
import org.apache.log4j.Logger;
public class Main {
    public static void main(String[] args) {
        Thread hello = new Hello();
        Runnable world = new World();
        Thread worldRunner = new Thread(world);

        hello.start();
        worldRunner.start();
    }
}
//implementing thread by extending thread class : method 1
class Hello extends Thread {
    public final static Logger logger = Logger.getLogger(Main.class);

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            logger.info("Hello");
            try {
                Thread.sleep(20);
            } catch (Exception ignored) {
            }
        }

    }
}

//implementing thread using Runnable interface : method 2
class World implements Runnable {
    public final static Logger logger = Logger.getLogger(Main.class);

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            logger.info("World");
        }
    }
}

