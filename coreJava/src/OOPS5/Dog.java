package OOPS5;


//Dog class inherits Animal class
public class Dog extends Animal{
    Dog(String name) {
        super(name);
    }
    //Run time polymorphism achieved by overriding makeNoise method
    @Override
    public void makeNoise(){
        logger.info(name + " barks");
    }
    //Compile time polymorphism achieved by overloading trick method
    public void trick(){
        logger.info("Dog woofs");
    }
    public void trick(String action){
        logger.info("Dog " + action );
    }
    public static void main(String[] args) {
        Dog dog = new Dog("doggy");
        dog.makeNoise();

        dog.trick();
        dog.trick("sit");
    }

}
