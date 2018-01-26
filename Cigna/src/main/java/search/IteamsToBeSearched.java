package search;

import base.CommonAPI;
import utility.DataReader;

import java.io.IOException;

public class IteamsToBeSearched extends  CommonAPI{
        DataReader dr = new DataReader();
        //this is for searching a specific item from the excel file
        public String[] getDataFromExcelFile() throws IOException, InterruptedException {
            String path = System.getProperty("user.dir")+"C:\\Users\\Ali\\Team_3_Framework_Project\\Cigna\\data\\SearchIteams.xlsx";
            String [] data = dr.colReader(path,3);
            Thread.sleep(3000);
            return data;
        }
        public String[] getDataFromExcelFileForFeaturesChoice() throws IOException, InterruptedException {
            String path = System.getProperty("user.dir")+"C:\\Users\\Ali\\Team_3_Framework_Project\\Cigna\\data\\features.xlsx";
            String [] data = dr.colReader(path,2);
            Thread.sleep(3000);
            return data;
        }
    }

