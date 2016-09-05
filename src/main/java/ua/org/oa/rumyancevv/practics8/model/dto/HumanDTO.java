package ua.org.oa.rumyancevv.practics8.model.dto;

/**
 * Created by dmitr on 01.03.2016.
 */
public class HumanDTO {
    private int id;
    private String name;
    private int age;
    public HumanDTO(){

    }

    public HumanDTO(String name, int age) {
     setName(name);
        setAge(age);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
        return "HumanDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
