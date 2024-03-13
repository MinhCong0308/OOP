package ex2_2_5;
import java.util.Scanner;
public class ex2_2_5 {
	 public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);
	        System.out.print("Enter the first number: ");
	        double a = scanner.nextDouble();
	        System.out.print("Enter the second number: ");
	        double b = scanner.nextDouble();
	        double sum = a+b;
	        double difference = a-b;
	        double mul = a*b;
	        System.out.println("Sum: "+ sum);
	        System.out.println("Difference :"+difference);
	        System.out.println("Product: " + mul);

	        if (b == 0) {
	            System.out.println("The divisor is not valid");
	        }
	        else {
	            double quo = a/b;
	            System.out.println("Quotient: " + quo);
	        }
	    }
}
