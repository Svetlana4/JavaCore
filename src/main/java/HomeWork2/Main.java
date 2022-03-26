package HomeWork2;

public class Main {

    public static void main(String[] args) throws MyArraySizeException {

        String[][] arr = {
                {"1", "1", "1", "1"},
                {"2", "2", "2", "2"},
                {"3", "3", "3", "3"},
                {"4", "4", "4", "4"}};
        method(arr);
        System.out.println("Работает");
    }


    public static void method(String[][] arr) throws MyArraySizeException {
        if (arr.length != 4) {
            throw new MyArraySizeException();
        }
        for (String[] row : arr) {
            if (row.length != 4) {
                throw new MyArraySizeException();
            }
        }

    }

}
