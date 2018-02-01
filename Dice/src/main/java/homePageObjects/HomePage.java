package homePageObjects;

import base.CommonAPI;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class HomePage extends CommonAPI {
    @FindBy(partialLinkText = "Dice")
    public WebElement logo;
    @FindBy(tagName = "a")
    public List<WebElement> anchorTag = new ArrayList<>();
    @FindBy(id = "search-field-keyword")
    public WebElement keywordField;
    @FindBy(id = "search-field-location")
    public WebElement locationField;
    @FindBy(xpath = "//div[@id='resultSec']//div[1]/h1")
    public WebElement searchVerificationPoint;

    public void getPageTitle() {
        String title = driver.getTitle();
        String expectedTitle = "Dice.com";
        Assert.assertTrue(title.contains(expectedTitle));
    }

    public void verifyLogoStatus() {
        boolean logoIcon = logo.isEnabled();
        Assert.assertTrue(logoIcon);
    }

    public void veriyLogoDisplay() {
        boolean logoIcon = logo.isDisplayed();
        Assert.assertTrue(logoIcon);
    }

    //Verify all available links in HomePage
    public void findNumberOfLinksInHomePage() throws IOException {
        List<String> actualLinkList = findNumberOfLink(anchorTag);
        List<String> expectedLinkList = getAssertData("../Dice/data/DataFile.xls",2);
        assertData(actualLinkList,expectedLinkList);
    }
    //Verify all the available links are Visible
    public void verifyAllLinkesAreVisible(){
         waitUntilVisibleElements(anchorTag);
    }

    public void searchFromHomePage() {
        keywordField.sendKeys("QA Analyst Selenium");
        locationField.sendKeys("Florida", Keys.ENTER);
        implicitWait(driver, 10);
        String actual = searchVerificationPoint.getText();
        String expected = "QA Analyst Selenium";
        Assert.assertTrue(actual.contains(expected));
    }

}


