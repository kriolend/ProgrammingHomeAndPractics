package ua.org.oa.rumyancevv.homeTask1.innerAnanimus;

/**
 * Created by user on 16.01.2016.
 * Анонимные классы.
 * Создайте класс автомобиль. Создайте 2 объекта этого класса.
 * При создании каждого из объектов класса автомобиль переопределите методы toString() и equals() c помощью анонимных классов,
 * что б вывод toString() был различным для каждого из объектов.
 * Продемонстрируйте, работу переопределенных методов.
 */
public class App {
    public static void main(String[] args) {
        Avto avto1 = new Avto("Lada", 1000);

        Avto avto2 = new Avto("w", 4) {
            String name = "Kalina";
            int price = 2000;
            @Override
            public String toString() {
                return "$classname{" +
                        "name='" + name + '\'' +
                        ", price=" + price +
                        '}';
            }
        };
        Avto avto3 = new Avto("Q", 2) {
            String marka = "Kalina";
            int price = 4000;

            @Override
            public String toString() {
                return "$classname{" +
                        "marka='" + marka + '\'' +
                        ", price=" + price +
                        '}';
            }
        };
        System.out.println(avto1+"\n"+avto2+"\n"+avto3);

    }
}
