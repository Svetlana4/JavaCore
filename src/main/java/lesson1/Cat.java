package lesson1;

import java.util.Objects;

public class Cat extends Animal implements CanSwim{

    public Cat(String name, String color, int age, int run_limit, int jump_limit, int swim_limit){
        super(name, color, age, run_limit, jump_limit, swim_limit);
    }

    public void voice(){
        System.out.println("Кот мяукает");
    }

    public double swim(Pool pool){
        System.out.println("Я кот! Я плыву!");
        return 1.0;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                ", color='" + color + '\'' +
                ", age=" + age +
                ", run_limit=" + run_limit +
                ", jump_limit=" + jump_limit +
                ", swim_limit=" + swim_limit +
                '}';
    }
}
