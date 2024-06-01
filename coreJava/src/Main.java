import org.apache.log4j.Logger;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    private static final Logger logger = Logger.getLogger(Main.class);
    public static void main(String[] args) {

        System.out.println("Hello and welcome!");
        for(int i = 0; i < 10; i++){
            logger.info(i);
        }


    }   
}
