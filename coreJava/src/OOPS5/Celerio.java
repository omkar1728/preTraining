package OOPS5;

// Implementing antarctic class Car using class Celerio
public class Celerio extends Car{

    public Celerio(int cc, String fuel) {
        super(cc, fuel);
    }

    @Override
    public void start() {
        logger.info("Celerio starts");
    }

    @Override
    public void mileage() {
        logger.info("34Km per liter of " + fuel);
    }

    public static void main(String[] args) {
        Celerio celerio = new Celerio(200, "Petrol");
        celerio.start();
        celerio.mileage();

    }
}
