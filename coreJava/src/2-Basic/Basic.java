public class Basic {
    int instanceVariable = 16; // instance variable - variable types

    public static int classVariable = 8; // class variable - variable types

    public void method() {
        int localVariable = 32; // local variable - variable types
    }

    // constructor
    Basic(int instanceVariable) {
        this.instanceVariable = instanceVariable;
    }

    // access modifiers
    public int visibleToEvery = 12;
    private int visibleToClassOnly = 12;
    protected int visibleToPackageAndChildren = 12;
    int visibleToPackageOnly = 12; // default

    public static void main(String[] args) {
        // whole number number data types
        byte whole8 = 100; // 8bit -2^7 -- 2^7 -1
        short whole16 = 100; // 16bit -2^15 -- 2^15 -1
        int whole32 = 100; // 32bit -2^31 -- 2^31 -1
        long whole64 = 100; // 64bit -2^63 -- 2^63 -1

        // decimal number data types
        float decimal32 = 100.32f; // 32 bit
        double decimal64 = 100.32f; // 64 bit

        // character data type
        char character8 = 'a'; // 8 bit

        // boolean data type
        boolean bool8 = true;

    }
}