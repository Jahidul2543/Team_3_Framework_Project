package page_objects;

import base.CommonAPI;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utility.DataReader;

import java.io.IOException;

import static org.openqa.selenium.support.How.ID;
import static org.openqa.selenium.support.How.XPATH;

public class InputFromExcel extends CommonAPI{
    @FindBy(xpath = ".//*[@id='csng-search-header']/search-header-bar/form/cigna-typeahead/div/input")
    public static WebElement searchBox;
    @FindBy(css = ".csng-search-key>strong")
    public static WebElement resultText;

    DataReader dtr = new DataReader();
    //T3ALI_BE _TC01
    public String[] getActual(String fileName) throws IOException {
        String path = "../Cigna/data/" + fileName;
        String[] output = dtr.colReader(path, 2);
        return output;
    }

    //T3ALI_BE _TC01
    public String[] getAssertData(String fileName) throws IOException {
        String path = "../Cigna/data/" + fileName;
        String[] output = dtr.colReader(path, 4);
        return output;
    }

    //T3ALI_BE _TC01 LogIn by using excel sheet data
    public String[] searchProduct(String fileName) throws IOException, InterruptedException {
        String[] searchItem = getActual(fileName);
        String[] actual = new String[searchItem.length];
        for (int i = 0; i < searchItem.length; i++) {
            sleepFor(1);
            inputValueInTextBoxByWebElement(searchBox, searchItem[i]);
            sleepFor(2);
            actual[i] = driver.getTitle();
            //actual[i] = getTextByWebElement(resultText);
            clearInputBox(searchBox);
            sleepFor(1);
        }
        return actual;
    }
    public String[] getDataFromSignInKeyword(String fileName) throws IOException {
        String path = "../Cigna/data/" + fileName;
        String[] output = dtr.colReader(path, 2); //col 2 = email
        return output;
    }
}
