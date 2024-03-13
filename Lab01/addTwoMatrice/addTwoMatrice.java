package addTwoMatrice;
import java.util.Scanner;
public class addTwoMatrice {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
        System.out.print("Please enter the number of rows: ");
        int row = input.nextInt();
        System.out.print("Please enter the number of columns: ");
        int col = input.nextInt();
        int[][] matrice1 = new int[row][col];
        System.out.println("Please enter the value of first matrice: ");
        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                matrice1[i][j] = input.nextInt();
            }
        }
        int [][] matrice2 = new int[row][col];
        System.out.println("Please enter the value of second matrice: ");
        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                matrice2[i][j] = input.nextInt();
            }
        }
        int [][] resmatrix = new int[row][col];
        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                resmatrix[i][j] = matrice1[i][j] + matrice2[i][j];
            }
        }
        System.out.println("The result matrix is: ");
        for(int i = 0; i < row; i++) {
            System.out.println();
            for(int j = 0; j < col; j++) {
                System.out.print(resmatrix[i][j] + " ");
            }
        }
	}

}
