package ua.org.oa.rumyancevv.task5_1;

import java.util.Comparator;

/**
 * Created by user on 06.02.2016.
 */
public class Comp implements Comparable<Comp>{
    private String name;
    private int price;

    public Comp(String name, int price) {
        setName(name);
        setPrice(price);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Comp{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }


    @Override
    public int compareTo(Comp o) {
        return getPrice() - o.getPrice();
    }
}
