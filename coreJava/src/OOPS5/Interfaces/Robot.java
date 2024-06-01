package OOPS5.Interfaces;
import org.apache.log4j.Logger;
public class Robot implements Software, Hardware{
    public final Logger logger = Logger.getLogger(Robot.class);
    @Override
    public void legs() {
        logger.info("These are robot legs");
    }

    @Override
    public void walkingAlgo() {
        logger.info("This is robot walking algo");
    }

    public void walk(){
        legs();
        walkingAlgo();
        logger.info("Robot is walking using legs and walking algo");
    }

    public static void main(String[] args) {
        Robot robot = new Robot();
        robot.walk();
    }
}
