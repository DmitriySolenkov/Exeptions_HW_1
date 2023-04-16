
import java.util.Random;
import java.util.Scanner;

public class Ex1 {

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

            int[] result = getDifArray(arr1, arr2);
            for (int number : result) {
                System.out.printf("%d  ", number);
            }
            System.out.println();
        } catch (CustomRuntimeException e) {
            System.out.println(e.getMessage());
            System.out.printf("First array's length: %d\nSecond array's length: %d\n", e.getLength1(),
                    e.getLength2());
        }

    }

    static int[] getDifArray(int[] arr1, int[] arr2) {
        if (arr1 == null || arr2 == null)
            throw new RuntimeException("Both arrays must exist!");
        if (arr1.length != arr2.length)
            throw new CustomRuntimeException("Element's amount must be equal!", arr1.length, arr2.length);

        int[] result = new int[arr1.length];
        for (int i = 0; i < arr1.length; i++)
            result[i] = arr1[i] - arr2[i];
        return result;
    }

    static int[] arrayFiller(int[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(11);
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
