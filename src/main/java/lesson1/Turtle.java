package lesson1;

public class Turtle extends Animal implements CanSwim{

    public Turtle(String name, String color, int age, int run_limit, int jump_limit, int swim_limit){
        super(name, color, age, run_limit, jump_limit, swim_limit);
    }

    public void voice(){
        System.out.println("Черепаха издает звук");
    }

    public double swim(Pool pool){
        System.out.println("Я черепаха! Я плыву!");
        return 1;
    }

    @Override
    public String toString() {
        return "Turtle{" +
                "name='" + name + '\'' +
                ", color='" + color + '\'' +
                ", age=" + age +
                ", run_limit=" + run_limit +
                ", jump_limit=" + jump_limit +
                ", swim_limit=" + swim_limit +
                '}';
    }
}
