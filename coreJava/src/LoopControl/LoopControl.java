public class LoopControl {
    public static void main(String[] args) {
        int a = 0;

        // break statement
        for (int i = 0; i < 10; i++) {
            if (a == 10) {
                break; // break the loop when a particular statement is reached
            }
            a++;
            continue; // skips execution of the rest of the statement to the start of the loop
            // a = -10; unreachable statement as continue would take the execution to the
            // start of the loop
        }
    }
}