package ua.org.oa.rumyancevv.practics1;

/**
 * Created by user on 19.01.2016.
 */
public class Notebook {
    private String name;
    private String descriptor;
    private int price;

    public Notebook(String name, String descriptor, int price) {
        this.name = name;
        this.descriptor = descriptor;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescriptor() {
        return descriptor;
    }

    public void setDescriptor(String descriptor) {
        this.descriptor = descriptor;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Notebook{" +
                "name='" + name + '\'' +
                ", descriptor='" + descriptor + '\'' +
                ", price=" + price +
                '}';
    }
}
