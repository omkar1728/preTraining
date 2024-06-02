package FileHandling;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import org.apache.log4j.Logger;
public class TextFileWriter {
    private  static final Logger logger = Logger.getLogger(TextFileWriter.class);
    public static void main(String[] args) throws IOException {
        //creating new file object
        File file = new File("./output.txt");

        //creating new file
        try {
            file.createNewFile();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        //creating file writer object
        FileWriter writer = new FileWriter("./output.txt");
        for (int i = 0; i < 10; i++) {
            //write 10 lines to file
            writer.write("This is something written in file \n");

        }
        writer.close();
        //reading the file
        Scanner scanner = new Scanner(file);
        while (scanner.hasNextLine()){
            logger.info(scanner.nextLine());
        }


    }
}
