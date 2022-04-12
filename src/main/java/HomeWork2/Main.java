package HomeWork2;

public class Main {

    public static void main(String[] args) {

        String[][] arr = {
                {"1", "1", "1", "1"},
                {"2", "2", "2", "2"},
                {"3", "3", "3", "3"},
                {"4", "4", "4", "4"}};
        try {
            int sum = method(arr);
            System.out.println("Сумма массива = " + sum);
        } catch (MyArraySizeException e) {
            e.printStackTrace();
        } catch (MyArrayDataException e) {
            e.printStackTrace();
        }


    }


    public static int method(String[][] arr) throws MyArraySizeException, MyArrayDataException {
        if (arr.length != 4) {
            throw new MyArraySizeException("Количесво строк не равно 4!");
        }
        for (int i = 0; i < arr.length; i++) {

            String[] row = arr[i];
            if (row.length != 4) {
                throw new MyArraySizeException("Строка " + (i + 1) + " имеет длину не 4");
            }
        }

        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            String[] row = arr[i];
            for (int j = 0; j < row.length; j++){
                String el = row[j];

                try {
                    int number = Integer.parseInt(el);
                    sum = sum + number;
                }
                catch (NumberFormatException e){
                    throw new MyArrayDataException(i + 1, j + 1);
                }

            }

        }
      return sum;



    }

}
