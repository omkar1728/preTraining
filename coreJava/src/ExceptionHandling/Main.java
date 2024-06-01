package ExceptionHandling;

import org.apache.log4j.Logger;
public class Main {
    public static Logger logger = Logger.getLogger(DivideByZeroException.class);
    public static void divide(int a, int b) throws DivideByZeroException {
        if(b == 0){
            throw new DivideByZeroException();
        }
    }

    public static void main(String[] args) {
        int a = 32;
        int b = 0;
        try{
            divide(a,b);
        }
        catch (Exception e){
            logger.error("An error occurred.");
        }
    }
}


class DivideByZeroException extends Exception{
    DivideByZeroException(){
        Logger logger = Logger.getLogger(DivideByZeroException.class);
        logger.error("Division by zero is not possible.");
    }
}