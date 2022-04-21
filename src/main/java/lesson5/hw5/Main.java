package lesson5.hw5;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {

        AppData appData = new AppData();

        //appData.setHeader(new String[]{"Value 1", "Value 2", "Value 3"});
        //appData.setData(new Integer[][]{
        //        new Integer[] { 1, 2, 3},
        //        new Integer[] { 4, 5, 6}
        //});


        appData.load("home_work_5.csv");
//
        //appData.save("home_work_5.csv");

        System.out.println(Arrays.toString(appData.getHeader()));
        System.out.println(Arrays.deepToString(appData.getData()));


    }
}
