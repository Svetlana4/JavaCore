package HomeWork2;

public class Main {

    public static void main(String[] args) throws MyArraySizeException {

        String[][] arr = {
                {"1", "1", "1", "1"},
                {"2", "2", "2"},
                {"3", "3", "3", "3"},
                {"4", "4", "4", "4"}};
        method(arr);
        System.out.println("Работает");
    }


    public static void method(String[][] arr) throws MyArraySizeException {
        if (arr.length != 4) {
            throw new MyArraySizeException("Количесво строк не равно 4!");
        }
        for (int i = 0; i < arr.length; i++) {

            String[] row = arr[i];
            if (row.length != 4) {
                throw new MyArraySizeException("Строка " + i + " имеет длину не 4");
            }
        }

    }

}
