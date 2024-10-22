package org.example;
import java.io.*;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class SumFile {
    public static Double sumarFila(File f) throws FileNotFoundException {
        String line;
        double count=0;
      try (var is = new BufferedReader(new FileReader(f))) {
          while ((line=is.readLine())!=null){
              double temp= Double.parseDouble(line);
              count+=temp;
          }
      } catch (IOException e) {
          throw new RuntimeException(e);
      }

            return count;
    }

    public static void main(String[] args) throws FileNotFoundException {
        String arg = args[0];
        File f  = new File(arg);
        System.out.println(sumarFila(f));
    }

}
