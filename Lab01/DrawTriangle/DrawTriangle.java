package DrawTriangle;

import java.util.Scanner;

public class DrawTriangle {
    public static void DrawTriangle(int num) {
        for(int i = 1; i <= num; i++) {
            for(int j = 1; j <= num-i; j++) {
                System.out.print(" ");
            }
            for(int j =1; j<= 2*i -1; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        int num = keyboard.nextInt();
        DrawTriangle(num);
    }
}

