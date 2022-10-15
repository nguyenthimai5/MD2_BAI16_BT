package BT2;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static List<String> stringList = new ArrayList<>();

    public static void main(String[] args) {
        readFileCountry("D:\\MD2\\MD2_BAI19_BAITAP\\src\\BT2\\Country");
        printCountry(stringList);

    }

    public static void readFileCountry(String path) {
        try {
            File file = new File(path);
            if (!file.exists()) {
                throw new FileNotFoundException();
            }
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            String line = "";
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
                stringList.add(line);
            }
            bufferedReader.close();


        } catch (Exception e) {
            System.err.println("File nay khong co du lieu hoac khong ton tai!");
        }
    }

    private static void printCountry(List<String> country) {

        for (int i = 0; i < stringList.size(); i++) {
            System.out.println(
                    "Country [id= "
                            + country.get(i)
                            + ", code= " + country.get(i+1)
                            + " , name=" + country.get(i+2)
                            + "]");
        }
    }
}