package lesson3.hw3;

import java.util.Arrays;

public class Main{

//    @Override
//    public String toString() {
//        return "NumbersBox{" +
//                "array=" + Arrays.toString(array) +
//                '}';
//    }

    public static void main(String[] args) {

        String[] arr = {"ghj", "jhg"};
        System.out.println(Arrays.toString(arr));
        changeArrayElements(arr, 0, 1);
        System.out.println(Arrays.toString(arr));

    }

    public static <T> void changeArrayElements(T[]array, int firstElement, int secondElement){

        T temp = array[firstElement];
        array[firstElement] = array[secondElement];
        array[secondElement] = temp;

    }


}
