package lesson4.hw4;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<String> products = Arrays.asList("Potatoes", "Carrots", "Butter", "Apples", "Banana", "Lemon",
                "Butter", "Kefir", "Carrots", "Milk", "Cheese");
        System.out.println(products);

        HashMap<String, Integer> uniqueProducts = new HashMap<>();

        for (int i = 0; i < products.size(); i++) {
//        for (String products : Arrays.asList(args)) {
            if (uniqueProducts.containsKey(products.get(i))){
                uniqueProducts.put(products.get(i), uniqueProducts.get(products.get(i)) + 1);
            } else {
                uniqueProducts.put(products.get(i), 1);
            }

        }
        System.out.println(uniqueProducts);




    }



}
