package ua.org.oa.rumyancevv.practics5;

import java.io.Serializable;

/**
 * Created by vr on 19.02.16.
 */
public class Studet implements Serializable{
    private static final long serialVersionUID = 1L;
    private String name;
    private int age;

    public Studet(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Studet{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
