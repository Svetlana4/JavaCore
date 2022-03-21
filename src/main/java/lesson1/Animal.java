package lesson1;

import java.util.Objects;

public abstract class Animal {

    protected String name;
    protected String color;
    protected int age;
    protected int run_limit;
    protected int jump_limit;
    protected int swim_limit;

    public Animal(String name, String color, int age, int run_limit, int jump_limit, int swim_limit){
        this.name = name;
        this.color = color;
        this.setAge(age);
        this.run_limit = run_limit;
        this.jump_limit = jump_limit;
        this.swim_limit = swim_limit;

    }

    public boolean run(int length) {
        return run_limit >= length;
    }

    public boolean jump(int height) {
        return jump_limit >= height;
    }

    public boolean swim(int length) {
        return swim_limit >= length;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Animal cat = (Animal) o;
        return age == cat.getAge() && Objects.equals(name, cat.getName()) && Objects.equals(color, cat.getColor());
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, color);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age >= 0) this.age = age;
    }

    public int getRun_limit() {
        return run_limit;
    }

    public void setRun_limit(int run_limit) {
        this.run_limit = run_limit;
    }

    public int getJump_limit() {
        return jump_limit;
    }

    public void setJump_limit(int jump_limit) {
        this.jump_limit = jump_limit;
    }

    public int getSwim_limit() {
        return swim_limit;
    }

    public void setSwim_limit(int swim_limit) {
        this.swim_limit = swim_limit;
    }

    public abstract void voice();

}
