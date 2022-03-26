package lesson1;

public class Wolf extends Animal implements CanSwim{

    public Wolf(String name, String color, int age, int run_limit, int jump_limit, int swim_limit){
        super(name, color, age, run_limit, jump_limit, swim_limit);
    }

    @Override
    public void voice(){
        System.out.println("Волк воет!");
    }

    public double swim(Pool pool){
        System.out.println("Я волк! Я плыву!");
        return 1.0;
    }

    @Override
    public String toString() {
        return "Wolf{" +
                "name='" + name + '\'' +
                ", color='" + color + '\'' +
                ", age=" + age +
                ", run_limit=" + run_limit +
                ", jump_limit=" + jump_limit +
                ", swim_limit=" + swim_limit +
                '}';
    }
}
