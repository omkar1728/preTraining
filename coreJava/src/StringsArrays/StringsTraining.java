package StringsArrays;

import org.apache.log4j.Logger;
public class StringsTraining {
    private static final Logger logger = Logger.getLogger(StringsTraining.class);

    public static void main(String[] args) {
        String str = "Hello world"; //definition

        //string traversal
        for (int i = 0; i < str.length(); i++) {
            logger.info(str.charAt(i));
        }

        //string concatenation
        String hello = "hello";
        String world = "world";
        String result = hello.concat(world);
        logger.info(result);


    }
}
