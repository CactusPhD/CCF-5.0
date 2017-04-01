import com.sun.corba.se.spi.orbutil.fsm.Input;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
        List<Double> crawfish = new ArrayList<>();
        List<String> holder = new ArrayList<>();
        File file = new File("crawfishPrice.txt");
        String tempo = "";
        try (Scanner input = new Scanner(file)) {
            //System.out.print(input.hasNext());
            while (input.hasNext()) {
                if(input.hasNextDouble()){
                    crawfish.add(input.nextDouble());}
                else{
                    holder.add(input.next());
                }

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
       // for (int i = 0; i < holder.size(); i++){
         //  System.out.println(holder.get(i));
        //}
        //for (int j = 0; j < crawfish.size(); j++){
          // System.out.println(crawfish.get(j));
        //}

        Double[] total = new Double[40];
        Integer[] count = new Integer[40];

        for (int k = 0; k < crawfish.size(); k++){
            total[k%40] = (total[k%40] + crawfish.get(k));
            if (crawfish.get(k) != 0){
                count[k%40] += 1;
            }

        }
        }
}

