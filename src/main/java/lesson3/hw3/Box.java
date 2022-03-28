package lesson3.hw3;

import java.util.Arrays;

public class Box<T extends Fruit> {
    T[] fruits;

    public Box(T[] items) {
        this.fruits = items;
    }

    public T[] getFruits() {
        return fruits;
    }

    public void setFruits(T[] fruits) {
        this.fruits = fruits;
    }

    public double getWeight(){
       double weight;
        if (fruits[0] instanceof Apple) {
            weight = 1.0f;
        } else
            if(fruits[0] instanceof Orange) {
            weight = 1.5f;
        }else
            throw new RuntimeException("Относится к другому типу фруктов");
        return weight * fruits.length;
    }

    @Override
    public String toString() {
        if (fruits[0] instanceof Apple){
            return "Коробка с яблоками";
        }else {
            return "Коробка с апельсинами";
        }
    }

    public static void main(String[] args) {

       Box<Apple> appleBox = new Box<>(new Apple[] {new Apple(), new Apple()});

       System.out.println("Вес " + appleBox + " " + appleBox.getWeight());


        Box<Orange> orangeBox = new Box<>(new Orange[]{new Orange(), new Orange(), new Orange()});
        System.out.println("Вес " + orangeBox + " " + orangeBox.getWeight());


    }
}
