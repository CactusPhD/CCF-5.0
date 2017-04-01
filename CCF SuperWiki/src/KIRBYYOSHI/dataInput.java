package KIRBYYOSHI;
import java.util.*;
import java.io.*;
/**
 * Created by coola on 3/31/2017.
 */
public class dataInput {
    Scanner input = new Scanner("Lafayette_Public_Art.txt");
    publicArt art;
    ArrayList<publicArt> alist = new ArrayList<publicArt>();
    String line;
    public dataInput(){}
    public void inputDataArt(){

        //Loop for data input from lafayette public art
        while (input.hasNextLine()){
            line = input.nextLine();
            String[] lineArray = line.split("   ");
            art = new publicArt(Double.parseDouble(lineArray[0]),Double.parseDouble(lineArray[1]),
                    lineArray[3],lineArray[4],Integer.parseInt(lineArray[7]),lineArray[9],
                    lineArray[10],lineArray[11]);
            //adds the data member to an arraylist
            alist.add(art);


        }


    }
    public ArrayList<publicArt> getArrayList(){
        return alist;
    }

}
