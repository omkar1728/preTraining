package OOPS5;

import org.apache.log4j.Logger ;

//Defining actract class Car
public abstract class Car {
    int cc;
    String fuel;
    public final Logger logger = Logger.getLogger(Car.class);
    public Car(int cc, String fuel) {
        this.cc = cc;
        this.fuel = fuel;
    }
    public abstract void start();
    public abstract void mileage();

//    public abstract void

}
