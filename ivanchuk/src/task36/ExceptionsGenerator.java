package task36;

public class ExceptionsGenerator {

    public static void generate() throws Exception {
        if ((int) (Math.random() * 2) == 0) {
            int[] array = {2};
            array[1] = 2;
        } else {
            throw new Exception("Message in exception");
        }
    }
}
