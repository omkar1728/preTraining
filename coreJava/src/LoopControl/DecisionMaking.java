package LoopControl;

import org.apache.log4j.Logger;
import java.util.Scanner;

public class DecisionMaking {
    public static final Logger logger = Logger.getLogger(DecisionMaking.class);
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();

        //if condition
        if(num%2 == 0){
            logger.info("Number is even");
        }
        // if-else condition
        if(num%2 == 0){
            logger.info("Number is even");
        } else {
            logger.info("Number is odd");
        }
    }
}
