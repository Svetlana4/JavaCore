package lesson3.hw3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Box<T extends Fruit> {
    ArrayList<T> fruits;

    public Box(List<T> fruits) {
        this.fruits = new ArrayList<>(fruits);
    }

    public ArrayList<T> getFruits() {
        return fruits;
    }

    public void setFruits(List<T> fruits) {
        this.fruits = new ArrayList<>(fruits);
    }

    public float getWeight(){
       float weight = 0.0f;
        if (fruits.get(0) instanceof Apple) {
            weight = 1.0f;
        } else
            if(fruits.get(0) instanceof Orange) {
            weight = 1.5f;
        }else
            throw new RuntimeException("Относится к другому типу фруктов");
        return weight * fruits.size();
    }

    @Override
    public String toString() {
        if (fruits.size() == 0) {
            return "пустая коробка";
        } else
        if (fruits.get(0) instanceof Apple){
            return "коробка с яблоками( " + fruits.size() + " шт)";
        }else {
            return "коробка с апельсинами( " + fruits.size() + " шт)";
        }
    }

    public boolean compare(Box<?> box) {
        return getWeight() == box.getWeight();
    }

    public void sprinkle(Box<T> anotherBox){
        anotherBox.fruits.addAll(this.fruits);
        this.fruits.clear();
    }


    public static void main(String[] args) {

        Box<Apple> appleBox = new Box<Apple>( Arrays.asList(new Apple(), new Apple()));
        System.out.println("Вес " + appleBox + " " + appleBox.getWeight());

        Box<Orange> orangeBox = new Box<Orange>(Arrays.asList(new Orange(), new Orange(), new Orange()));
        System.out.println("Вес " + orangeBox + " " + orangeBox.getWeight());


        System.out.println(appleBox.compare(orangeBox));

        // как создать переменную:
        // ТИП название ( = )

        Box<Apple> anotherBox = new Box<>(Arrays.asList(new Apple(), new Apple()));
        System.out.println(appleBox + ", " + anotherBox);
        appleBox.sprinkle(anotherBox);
        System.out.println(appleBox + ", " + anotherBox);
//        Box box = new Box(Arrays.asList());
//        System.out.println(box.количествоФруктов);
//        box.добавитьФруктов(5);
//        System.out.println(box.количествоФруктов);
    }



}
