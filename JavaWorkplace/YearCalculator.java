
public class YearCalculator {
   public static void main(String[] args) {
        // Display the number of days for each year from 2000 to 2020
        for (int year = 2000; year <= 2020; year++) {
            System.out.println("Year " + year + " has " + numberOfDaysInAYear(year) + " days.");
        }
   }


// Return the number of days in a year
public static int numberOfDaysInAYear(int year) {
    // Check if the year is a leap year
    return (isLeapYear(year)) ? 366 : 365;
}

/** 检查给定年份是否是闰年 */
private static boolean isLeapYear(int year) {
    return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
}

}


