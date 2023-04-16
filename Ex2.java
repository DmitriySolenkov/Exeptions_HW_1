
import java.util.Random;
import java.util.Scanner;

public class Ex2 {

    static Scanner scanner = new Scanner(System.in);
    static Random random = new Random();

    public static void main(String[] args) {
        task();
    }

    static void task() {

            try {
                int[] arr1 = new int[random.nextInt(2) + 4];
                int[] arr2 = new int[5];
                arr1 = arrayFiller(arr1);
                arr2 = arrayFiller(arr2);
                if (random.nextInt(5) == 0) {
                    arr1 = null;
                }

                float[] result = getDivArray(arr1, arr2);
                for (float number : result) {
                    System.out.printf("%.2f  ",number);
                }
                System.out.println();
            } catch (CustomRuntimeException e) {
                System.out.println(e.getMessage());
                System.out.printf("First array's length: %d\nSecond array's length: %d\n", e.getLength1(),
                        e.getLength2());
            }

    }

    static float[] getDivArray(int[] arr1, int[] arr2) {
        if (arr1 == null || arr2 == null)
            throw new RuntimeException("Both arrays must exist!");
        if (arr1.length != arr2.length)
            throw new CustomRuntimeException("Element's amount must be equal!", arr1.length, arr2.length);

        float[] result = new float[arr1.length];
        for (int i = 0; i < arr1.length; i++){
            if (arr2[i]==0)
                throw new RuntimeException("Can't be divided by zero!");
            result[i] = (float)arr1[i] / arr2[i];
            
        }
        return result;
    }

    static int[] arrayFiller(int[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(21);
            System.out.printf("%d  ", array[i]);
        }
        System.out.println();
        return array;
    }

}

class CustomRuntimeException extends RuntimeException {

    private int length1;
    private int length2;

    public int getLength1() {
        return length1;
    }

    public int getLength2() {
        return length2;
    }

    public CustomRuntimeException(String message, int length1, int length2) {
        super(message);
        this.length1 = length1;
        this.length2 = length2;
    }
}
