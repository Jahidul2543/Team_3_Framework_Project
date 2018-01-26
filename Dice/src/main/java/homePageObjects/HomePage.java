package homePageObjects;

import base.CommonAPI;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

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

    public List<String> findNumberOfLink() {
        System.out.println(anchorTag.size());
        implicitWait(driver, 5);
        List<String> actualLinks = new ArrayList<>();
        for (int i = 0; i < anchorTag.size(); i = i + 1) {
            implicitWait(driver, 5);
            //System.out.println(anchorTag.get(i).getText());
            if (anchorTag.get(i).getText() != null && anchorTag.get(i).getText().length() > 0) {
                actualLinks.add(anchorTag.get(i).getText());
            }
        }
        for (String link : actualLinks) {
            System.out.println(link);
        }
        return actualLinks;
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


