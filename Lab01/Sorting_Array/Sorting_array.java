package Sorting_Array;
import java.util.Scanner;
import java.util.Arrays;
public class Sorting_array {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please enter the length of array: ");
        int num = scanner.nextInt();
        int sum = 0;
        int[] array = new int[num];
        System.out.print("Enter the element of array: ");
        for(int i = 0; i < num; i++) {
            array[i] = scanner.nextInt();
            sum += array[i];
        }
        double avg = (double) sum / num;
        Arrays.sort(array);
        System.out.print("The new array after sorted: ");
        for (int i = 0; i < num; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
        System.out.println("Sum: " + sum);
        System.out.println("Average: " + avg);
    }
}