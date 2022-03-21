package lesson1;

public class Dog extends Animal implements CanSwim{

    public Dog(String name, String color, int age, int run_limit, int jump_limit, int swim_limit){
        super(name, color, age, run_limit, jump_limit, swim_limit);
    }

    @Override
    public void voice(){
        System.out.println("Собака лает!");
    }

    public double swim(Pool pool){
        System.out.println("Я собака! Я плыву!");;
        return 1;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", color='" + color + '\'' +
                ", age=" + age +
                ", run_limit=" + run_limit +
                ", jump_limit=" + jump_limit +
                ", swim_limit=" + swim_limit +
                '}';
    }
}
