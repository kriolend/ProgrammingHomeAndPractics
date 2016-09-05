package ua.org.oa.rumyancevv.homeTask1.dateNum;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Calendar;

/**
 * Created by user on 16.01.2016.
 * Задание на вложенные классы и интерфейсы
 * Создать объект класса Date, используя вложенные классы Год, Месяц, День. Методы: задать дату,
 * вывести на консоль день недели по заданной дате. День недели представить в виде перечислення.
 * Рассчитать количество дней, в заданном временном промежутке.
 * Т.е. в классе Date реализовать следующее:
 * public Date(int day, int month, int year)
 * public DayOfWeek getDayOfWeek()
 * public int getDayOfYear()
 * public int daysBetween(Date date)
 * <p/>
 * В классе Year должна осуществляться проверка на високостность (можно реализовать в конструкторе) в результате,
 * установить значение для соотв. атрибута года.
 * В классе Month можно сделать метод который позволит узнать количество дней для того или иного месяца [1-12].
 * Метод можно использовать для подсчета дней в других методах.
 * public int getDays(int monthNumber, boolean leapYear)
 * <p/>
 * Перечисление должно иметь конструктор с параметром, для того чтобы задать индексы дней недели [0-6]. 0 – Понедельник.
 * Так же можно создать статический метод
 * public static DayOfWeek valueOf (int index)
 * Для того чтобы можно было после математических расчетов использовать данный метод для преобразования индекса дня недели в соотв.
 * элемент перечисления.
 * <p/>
 * При желании можно сделать собственную архитектуру для решения поставленной задачи.
 * Главное продемонстрировать в решении использование вложенных классов и перечисления.
 */
public class Date {

    private Year Year;
    private Month Month;
    private Day Day;

    @Override
    public String toString() {
        return getDay().getDayNumber() + " " + getMonth() + " " + getYear();
    }

    public Day getDay() {
        return Day;
    }

    public Date(int year, int month, int day) {
        //конструктор
        this.Year = new Year(year);
        this.Month = new Month(month);
        this.Day = new Day(day);
    }

    public Date() {
    }

    public enum DayOfWeek {
        MON(0),
        TUE(1),
        WED(2),
        THU(3),
        FRI(4),
        SAT(5),
        SUN(6);

        int dayIndex;

        DayOfWeek(int dayIndex) {

            setDayIndex(dayIndex);
        }

        public int getDayIndex() {
            return dayIndex;
        }

        public void setDayIndex(int dayIndex) {
            this.dayIndex = dayIndex;
        }

        public static DayOfWeek valueOf(int index) {
            return DayOfWeek.values()[index];
        }
    }

    public class Day {

        private int dayNumber;

        public Day(int dayNumber) {

            int numberOfDays = java.time.Month.of(getMonth().monthNumber).length(getYear().isLeapYear());

            if (dayNumber > 0 & dayNumber <= numberOfDays) {
                this.dayNumber = dayNumber;
            } else {
                throw new IllegalArgumentException("Wrong day index. Use index from 1 to " + numberOfDays);
            }
        }

        public int getDayNumber() {
            return dayNumber;
        }

        public void setDayNumber(int dayNumber) {
            this.dayNumber = dayNumber;
        }

        @Override
        public String toString() {
            return String.valueOf(dayNumber);
        }

    }

    public class Month {

        private int monthNumber;

        public Month(int monthNumber) {
            setMonthNumber(monthNumber);
        }

        public int getMonthNumber() {
            return monthNumber;
        }

        public void setMonthNumber(int monthNumber) {
            if (monthNumber > 0 & monthNumber < 13) {
                this.monthNumber = monthNumber;
            } else {
                throw new IllegalArgumentException("Wrong number. User number from 1 to 12");
            }

        }

        public int getDays(int monthNumber, boolean leapYear) {
            return java.time.Month.of(monthNumber).length(leapYear);
        }

        @Override
        public String toString() {
            return String.valueOf(java.time.Month.of(monthNumber));
        }
    }

    public class Year {

        private int year;
        private boolean leapYear;

        public Year(int year) {
            setYear(year);
            leapYear = java.time.Year.isLeap(year);
        }

        public Year() {
        }

        public int getYear() {
            return year;
        }

        public void setYear(int year) {
            if (year > 0) {
                this.year = year;
            } else {
                throw new IllegalArgumentException("Wrong year. User number above 0");
            }
        }

        public boolean isLeapYear() {
            return leapYear;
        }

        public void setLeapYear(boolean leapYear) {
            this.leapYear = leapYear;
        }

        @Override
        public String toString() {
            if (leapYear == true) {
                return year + " (leap year)";
            } else {
                return year + " (isn't leap year)";
            }
        }
    }

    public DayOfWeek getDayOfWeek() {
        Calendar c = Calendar.getInstance();
        c.set(Year.getYear(), Month.getMonthNumber() - 1, Day.getDayNumber() - 1);
        int dayOfWeek = c.get(Calendar.DAY_OF_WEEK);
        return DayOfWeek.valueOf(dayOfWeek - 1);
    }


    public int getDayOfYear() {
        Calendar c = Calendar.getInstance();
        c.set(Year.getYear(), Month.getMonthNumber() - 1, Day.getDayNumber() - 1);
        return c.get(Calendar.DAY_OF_WEEK) - 1;

    }

    public int daysBetween(java.util.Date date) {

        Calendar c = Calendar.getInstance();
        c.set(Year.getYear(), Month.getMonthNumber() - 1, Day.getDayNumber());
        Calendar c2 = Calendar.getInstance();
        c2.setTime(date);
        c2.add(Calendar.YEAR, -1900);
        c2.add(Calendar.MONTH, -1);
        long aTime = c.getTime().getTime();
        long bTime = c2.getTime().getTime();
        long adjust = 3600000L;
        adjust = bTime > aTime ? adjust : -adjust;
        return (int) ((bTime - aTime + adjust) / 86400000L);

    }

    public Year getYear() {
        return Year;
    }

    public void setYear(int Year) {
        this.Year = new Year(Year);
    }

    public Month getMonth() {
        return Month;
    }

    public void setMonth(int Month) {
        this.Month = new Month(Month);
    }

    public void setDay(int Day) {
        this.Day = new Day(Day);
    }

    public void console() {

        BufferedReader br;

        try {
            br = new BufferedReader(new InputStreamReader(System.in));
            do {
                try {
                    System.out.println("Input year");
                    int year = Integer.parseInt(br.readLine());
                    Year = new Year(year);
                } catch (IllegalArgumentException e) {
                    System.out.println("Wrong year, use input year");
                }

            } while (Year == null);

            do {
                try {
                    System.out.println("Input month");
                    int month = Integer.parseInt(br.readLine());
                    Month = new Month(month);
                } catch (IllegalArgumentException e) {
                    System.out.println("Wrong month, use input month");
                }

            } while (Month == null);

            do {
                try {
                    System.out.println("Input day");
                    int day = Integer.parseInt(br.readLine());
                    Day = new Day(day);
                } catch (IllegalArgumentException e) {
                    System.out.println("Wrong day, use input day");
                }

            } while (Day == null);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}





