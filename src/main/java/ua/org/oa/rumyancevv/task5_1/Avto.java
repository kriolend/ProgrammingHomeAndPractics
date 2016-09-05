package ua.org.oa.rumyancevv.task5_1;

/**
 * Created by user on 06.02.2016.
 */
public class Avto {
    private String name;
    private int price;

    public Avto(String name, int price) {
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
        return "Avto{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
