package dataObjects;

import base.CommonAPI;
import utility.DataReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class DataFileReader extends CommonAPI {

   static DataReader dtr = new DataReader();

    //Get Assert Data
    public List<String> getAssertData(String fileName) throws IOException {
        String path = "../Dice/data/" + fileName;
        List<String> output = Arrays.asList(dtr.colReader(path, 2));
        return output;
        /*List<String> output = new ArrayList<>();
        String[] outputArray = dtr.colReader(path, 2);*/
       // Collections.addAll(output,outputArray);
    }

    /*public static void main(String[] args)throws IOException {
        String path = "./Dice/data/" + "Dice.xls";
        String[]output1 = dtr.colReader(path,2);
       // List<String> output = Arrays.asList(output1);
       for (int i=0; i<output1.length; i++){
           System.out.println(output1[i]);
       }
    }*/
}
