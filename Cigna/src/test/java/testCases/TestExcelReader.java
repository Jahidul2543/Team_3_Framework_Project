package testCases;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page_objects.InputFromExcel;
import page_objects.PersonalPage;

import java.io.IOException;

public class TestExcelReader extends InputFromExcel{
    PersonalPage objOfPersonalPage;
    InputFromExcel objExcelFile;

    @BeforeMethod
    public void initialization(){
        //    objOfHomePage = PageFactory.initElements(driver, HomePage.class);
        objExcelFile = PageFactory.initElements(driver, InputFromExcel.class);
    }

    @Test
    public void searchProductUsingExcel() throws IOException, InterruptedException {
        String[] expectedItems = objExcelFile.getAssertData("Data.xls");
        String[] actualItems = objExcelFile.searchProduct("Data.xls");
        for (int i = 0; i < actualItems.length; i++) {
            Assert.assertTrue(actualItems[i].contains(expectedItems[i]));
            System.out.println(expectedItems[i] + ": Test - Passed"+actualItems[i]);
        }
        System.out.println("searchProductUsingExcel test pass");
        implicitWait(driver, 20);
    }
}
