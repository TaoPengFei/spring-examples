package cn.lee.jason.util.comparator;

import java.util.Comparator;

/**
 * Created by jason on 17/2/13.
 */
public class Dog implements Comparator<Dog>, Comparable<Dog> {

    private String name;
    private int age;

    public Dog() {
    }

    public Dog(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public String getDogName() {
        return name;
    }

    ;

    public void setName(String name) {
        this.name = name;
    }

    public int getDogAge() {
        return age;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int compare(Dog o1, Dog o2) {
        return o1.getAge() - o2.getAge();
    }

    public int compareTo(Dog o) {
        return this.name.compareTo(o.getName());
    }
}
