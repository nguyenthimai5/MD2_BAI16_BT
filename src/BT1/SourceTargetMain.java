package BT1;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SourceTargetMain {
    static List<String> stringList=new ArrayList<>();
    static List<String> stringList1=new ArrayList<>();
    public static void main(String[] args) {
       SourceTargetMain sourceTargetMain=new SourceTargetMain();
    Scanner scanner=new Scanner(System.in);
       sourceTargetMain.readFile("D:\\MD2\\MD2_BAI19_BAITAP\\src\\BT1\\source");
       sourceTargetMain.writeFile(scanner,"D:\\MD2\\MD2_BAI19_BAITAP\\src\\BT1\\target",sokytu());
    }
    public void readFile(String filePath){
        try {
            File file=new File(filePath);
            if (!file.exists()){
                throw new FileNotFoundException();
            }
            BufferedReader bufferedReader=new BufferedReader(new FileReader(file));
            String line = "";
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
                stringList.add(line);
            }
            bufferedReader.close();
        } catch ( Exception e) {
            System.err.println("file khong co du lieu hoac khong ton tai");
        }
    }
    public void writeFile(Scanner scanner, String path,String soKyTu){
      File file=new File(path);
      FileOutputStream fileOutputStream=null;
      try {
          fileOutputStream=new FileOutputStream(file);
      } catch (FileNotFoundException e) {
          throw new RuntimeException(e);
      }
      OutputStreamWriter outputStreamWriter=new OutputStreamWriter(fileOutputStream);
      BufferedWriter bufferedWriter=new BufferedWriter(outputStreamWriter);

          try {
              bufferedWriter.write(stringList.toString());
              bufferedWriter.flush();
              bufferedWriter.newLine();
              SourceTargetMain.stringList1.add(String.valueOf(stringList.toString().split("")));

              bufferedWriter.write(soKyTu);
              bufferedWriter.flush();
          } catch (IOException e) {
              throw new RuntimeException(e);
          }
      try {
          bufferedWriter.close();
          outputStreamWriter.close();
          fileOutputStream.close();
      } catch (IOException e) {
          throw new RuntimeException(e);
      }
    }
    public static String sokytu(){
        int cnt=0;
        for (String stringCharAt:stringList1) {
            cnt+=stringCharAt.length();
        }
        return "So ky tu la: "+cnt;
    }
}
