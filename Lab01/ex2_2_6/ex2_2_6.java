package ex2_2_6;
import java.util.Scanner;
public class ex2_2_6 {
	public static void main(String[] args) {
        System.out.println("1. Solve the first degree equation");
        System.out.println("2. Solve systems of first degree equation");
        System.out.println("3. Solve the second degree equation");
        System.out.print("Please choose the option above: ");
        Scanner scanner = new Scanner(System.in);
        int res = scanner.nextInt();
        switch (res) {
            case 1:
                System.out.print("Enter the first number: ");
                double num1 = scanner.nextDouble();
                System.out.print("Enter the second number: ");
                double num2 = scanner.nextDouble();
                if (num1 == 0) {
                    if (num2 == 0) {
                        System.out.println("This equation has infinite solutions");
                    }
                    else {
                        System.out.println("This equation has no solutions");
                    }
                }
                else {
                    double result1 = -num2/num1;
                    System.out.println("The equation has 1 solution is: " + result1);
                }
                break;
            case 2:
                System.out.print("Enter the first number of first equation: ");
                double num3 = scanner.nextDouble();
                System.out.print("Enter the second number of first equation: ");
                double num4 = scanner.nextDouble();
                System.out.print("Enter the result of first equation: ");
				double b1 = scanner.nextDouble();
                System.out.print("Enter the first number of second equation: ");
                double num5 = scanner.nextDouble();
                System.out.print("Enter the second number of second equation: ");
                double num6 = scanner.nextDouble();
                System.out.print("Enter the result of second equation: ");
                double b2 = scanner.nextDouble();
                double det = Math.abs(num3*num6 - num4*num5);
                if(det == 0) {
                    if (num3/num5 == b1/b2) {
                        System.out.println("This system has infinite solutions");
                    }
                    else {
                        System.out.println("This system has no solutions");
                    }
                }
                else {
                    double detx = b1*num6 - b2*num4;
                    double dety = num3*b2 -  num5*b1;
                    double ketqua = -detx/det;
                    double ketqua2 = -dety/det;
                    System.out.println("The value of x is: " + ketqua);
                    System.out.println("The value of y is: " + ketqua2);
                }
                break;
            case 3:
                System.out.print("Enter the first number: ");
                double a = scanner.nextDouble();
                System.out.print("Enter the second number: ");
                double b = scanner.nextDouble();
                System.out.print("Enter the third number: ");
                double c = scanner.nextDouble();
                if(a == 0) {
                    if(b == 0) {
                        if(c == 0) {
                            System.out.println("This equation has infinite solution");
                        }
                        else {
                            System.out.println("This equation has no solution");
                        }
                    }
                    else {
                        double res0 = -c/b;
                        System.out.println("This equation has only 1 solution is " + res0);
                    }
                }
                else {
                    double delta = b*b - 4*a*c;
                    if (delta < 0) {
                        System.out.println("This equation has no solution");
                    }
                    else if (delta == 0) {
                        double res2 = -b/(2*a);
                        System.out.println("This equation has 1 solution is: " + res2);
                    }
                    else {
                        double res3 = (-b + Math.sqrt(delta))/ 2*a;
                        double res4 = (-b - Math.sqrt(delta))/2*a;
                        System.out.println("This equation has 2 solutions is x1 = " + res3 + " and " + "x2 = " + res4);
                    }
                }
                break;
            default:
                System.out.println("Your option is not valid!!");
                break;
        }

    }

}
