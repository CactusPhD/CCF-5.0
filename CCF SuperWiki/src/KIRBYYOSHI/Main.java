package KIRBYYOSHI;
import java.util.*;
import java.io.*;
/**
 * Created by coola on 3/31/2017.
 */
public class Main {
    public static void main(String[] args){
        dataInput d = new dataInput();
        d.inputDataArt();
        ArrayList<publicArt> alist = d.getArrayList();
        System.out.println(alist.get(0).zipCode);

    }
}
