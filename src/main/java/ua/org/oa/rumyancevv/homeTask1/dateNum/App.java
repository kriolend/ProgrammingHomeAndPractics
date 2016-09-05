package ua.org.oa.rumyancevv.homeTask1.dateNum;


public class App {
    public static void main(String[] args) {

        Date Date = new Date();

        Date.console();

        System.out.println(Date);

        System.out.println("Number of days: " + Date.getMonth().getDays(Date.getMonth().getMonthNumber(), Date.getYear().isLeapYear()));

        System.out.println("Day of week: " + Date.getDayOfWeek());

        System.out.println("Day index: " + Date.getDayOfYear());

        java.util.Date date = new java.util.Date(2016, 10, 10);
        System.out.println("Days between: " + Date.daysBetween(date));

        System.out.println("Value of index: " + ua.org.oa.rumyancevv.homeTask1.dateNum.Date.DayOfWeek.valueOf(Date.getDayOfYear()));
    }
}