package HomeWork2;

public class MyArrayDataException extends Exception{
    MyArrayDataException (int i, int j){
        super("Неверные данные в строке " + i + " столбце "+ j);
    }
}
