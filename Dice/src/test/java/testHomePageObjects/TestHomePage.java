package testHomePageObjects;

import dataObjects.DataFileReader;
import homePageObjects.HomePage;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import java.io.IOException;
import java.util.List;

public class TestHomePage extends HomePage {

    HomePage objOfHomePage;
    DataFileReader objOfDataFileReader;

    @BeforeMethod
    public void initializationOfElements() {
        objOfHomePage = PageFactory.initElements(driver, HomePage.class);
        objOfDataFileReader = PageFactory.initElements(driver, DataFileReader.class);
    }

    //T3DIC_HP_TC01 Verify Home Page Title
   // @Test
    public void testGetTitle() {
        objOfHomePage.getPageTitle();
        System.out.println("testGetTitle Passed");
    }

    //T3DIC_HP_TC02 Verify Logo
  //  @Test
    public void testLogo() {
        objOfHomePage.verifyLogoStatus();
        objOfHomePage.veriyLogoDisplay();
    }

    //T3DIC_HP_TC04 Verify All Links In HomePage
    @Test
    public void testAllLinksInHomePage() throws IOException {
        objOfHomePage.findNumberOfLinksInHomePage();
    }

    //T3DIC_HP_TC05 Search Option
   // @Test
    public void testHomePageSearchOptions() {
        objOfHomePage.searchFromHomePage();
        System.out.println("searchFromHomePage Passed");
    }
}
