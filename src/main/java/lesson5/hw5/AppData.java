package lesson5.hw5;

import lesson5.Student;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class AppData {
    private String [] header;
    private Integer[][] data;

    public AppData() {

    }

    public String[] getHeader() {
        return header;
    }

    public void setHeader(String[] header) {
        this.header = header;
    }

    public Integer[][] getData() {
        return data;
    }

    public void setData(Integer[][] data) {
        this.data = data;
    }

//    @Override
//    public String toString() {
//        return "AppData{" +
//                "header=" + Arrays.toString(header) +
//                ", data=" + Arrays.toString(data) +
//                '}';
//    }

    public void save(String fileName) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {

            printRow(writer, header);
            for (Integer[] row : data){
                printRow(writer, row);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private <T> void printRow(BufferedWriter writer, T[] row) throws IOException {
        for (int i = 0; i < row.length; i++) {
            T h = row[i];
            if (i != row.length - 1){
                writer.write(h + ";");
            }else {
                writer.write(h + "\n");
            }
        }
    }

    private Integer[] convertStrings(String[] strings) {
        Integer[] result = new Integer[strings.length];
        for (int i = 0; i < strings.length; i++) {
            result[i] = Integer.parseInt(strings[i]);
        }
        return result;
    }

    public void load(String fileName) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            header = bufferedReader.readLine().split(";");

            ArrayList<Integer[]> dataList = new ArrayList<>();

            String s;
            while ((s = bufferedReader.readLine()) != null){
                String[] strings = s.split(";");
                dataList.add(convertStrings(strings));
            }

            data = dataList.toArray(new Integer[dataList.size()][]);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

