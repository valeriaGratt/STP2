package org.donstu.domain;

public class Human {
    private String name;
    private int age;
    private String qualification;
    private Dog dog;

    public Human(String name, int age, String qualification, Dog dog) {
        this.name = name;
        this.age = age;
        this.qualification = qualification;
        this.dog = dog;
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

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public Dog getDog() {
        return dog;
    }

    public void setDog(Dog dog) {
        this.dog = dog;
    }
}
