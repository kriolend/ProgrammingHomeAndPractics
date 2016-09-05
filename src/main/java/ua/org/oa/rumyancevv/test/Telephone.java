package ua.org.oa.rumyancevv.test;

/**
 * Created by u0100 on 02.07.2016.
 */
public class Telephone {
    private String number;

    public Telephone(String number) {
        this.number = number;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "Telephone{" +
                "number='" + number + '\'' +
                '}';
    }
}
