package Days_Month_Years;

import java.util.Scanner;

public class Days_Month_Years {
    static boolean LeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

    static int checkValid(String month) {
        int position = -1;
        String[] months = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
        String[] months3k = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
        String[] monthsabb = {"Jan.", "Feb.", "Mar.", "Apr.", "May", "June", "July", "Aug.", "Sep.", "Oct.", "Nov.", "Dec."};
        String[] monthint = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"};
        for (int i = 0; i < months.length; i++) {
            if (month.equals(months[i]) || month.equals(months3k[i]) || month.equals(monthsabb[i]) || month.equals(monthint[i])) {
                position = i;
                break;
            }
        }
        return position;
    }

    public static void main(String[] args) {
        int[] days = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        System.out.print("Please enter the month you want to check the number of days: ");
        Scanner scanner = new Scanner(System.in);
        String month = scanner.nextLine();
        System.out.print("Please enter the year: ");
        int year = scanner.nextInt();
        if (checkValid(month) == 1 && LeapYear(year))
            System.out.println("The month " + month + " year " + year + " has " + "29 days");
        else {
            int res = checkValid(month);
            if (res == -1)
                System.out.println("Please re-enter the month.");
            else {
                int day = days[res];
                System.out.println("The month " + month + " year " + year + " has " + day + " days");
            }
        }
    }
}


