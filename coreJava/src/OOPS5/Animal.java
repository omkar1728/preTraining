package OOPS5;

import org.apache.log4j.Logger;
public class Animal {
    public static final Logger logger = Logger.getLogger(Animal.class);
    String name;
    Animal(String name) {
        this.name = name;
    }
    public  void makeNoise(){
        logger.info(name + " makes noise");
    }
    public static void main(String[] args) {
        Animal animal = new Animal("Animal");

        animal.makeNoise();
    }
}
