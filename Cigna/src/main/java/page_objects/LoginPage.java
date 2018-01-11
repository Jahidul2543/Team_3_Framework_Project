package page_objects;

import base.CommonAPI;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

public class LoginPage extends CommonAPI {
    @FindBy(id = "username")
    public static WebElement username;
    @FindBy(id = "password")
    public static WebElement password;
    @FindBy(xpath = ".//*[@id='userForm']/fieldset[2]/div/span/button")
    public static WebElement loginbutton;
    @FindBy(xpath = ".//*[@id='c1353257994291']/div[1]/ul/li[2]//a")
    public static WebElement how2Regrister;
    @FindBy(xpath = ".//*[@id='mycigna-learn-register']/div/a[1]")
    public static WebElement regNow;
    @FindBy(xpath = ".//*[@id='fname']")
    public static WebElement firstName;
    @FindBy(xpath = ".//*[@id='lname']")
    public static WebElement lastName;
    @FindBy(xpath = ".//*[@id='month']")
    public static WebElement month;
    @FindBy(xpath = ".//*[@id='day']")
    public static WebElement day;
    @FindBy(xpath = ".//*[@id='year']")
    public static WebElement year;
    @FindBy(xpath = ".//*[@id='address']")
    public static WebElement address;
    @FindBy(xpath = ".//*[@id='city']")
    public static WebElement city;
    @FindBy(xpath = ".//*[@id='state']")
    public static WebElement state;
    @FindBy(xpath = ".//*[@id='zip']")
    public static WebElement zip;
    @FindBy(name = "_eventId_next")
    public static WebElement button;
    @FindBy(xpath = ".//*[@id='c1289878640341']/div/p")
    public static WebElement errorMsg;
    @FindBy(xpath = ".//*[@id='regId1']")
    public static WebElement ssn;
    @FindBy(xpath = ".//*[@id='regIdZip']")
    public static WebElement zipcode;
    @FindBy(name = "_eventId_next")
    public static WebElement next;

    //to work on the newly opened page
    public String enterCredintials() {
        for (String handle : driver.getWindowHandles()) {
            driver.switchTo().window(handle);
        }
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        username.sendKeys("AlistairMendes", Keys.TAB);
        password.sendKeys("abcd1234");
        loginbutton.click();
        // boolean bl=errorMsg.isDisplayed();
        String actualErrorMsg = errorMsg.getText();
        return actualErrorMsg;
    }

    public void howToRegrister() {
        for (String handle : driver.getWindowHandles()) {
            driver.switchTo().window(handle);
        }
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        how2Regrister.click();
        regNow.click();
        Assert.assertTrue(driver.findElement(By.xpath(".//*[@id='top']")).isDisplayed(), "Registration ");
    }

    public void regristration1() {
        Select dropdownMonth = new Select(month);
        Select dropdownDay = new Select(day);
        Select dropdownYear = new Select(year);
        Select dropdownState = new Select(state);

        for (String handle : driver.getWindowHandles()) {
            driver.switchTo().window(handle);
        }
        try {
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            firstName.sendKeys("Alistair");
            lastName.sendKeys("Mendes");
            dropdownMonth.selectByIndex(4);
            dropdownDay.selectByIndex(9);
            dropdownYear.selectByIndex(16);
            address.sendKeys("2011 Hamptons Avenue");
            city.sendKeys("New York");
            dropdownState.selectByIndex(35);
            zip.sendKeys("11111");
            button.click();
        } catch (Exception e) {
            System.out.println("Not Available");
            e.printStackTrace();
        }
    }

    public void regristration2() {
        for (String handle : driver.getWindowHandles()) {
            driver.switchTo().window(handle);
        }
        try {
            ssn.sendKeys("266433665");
            zipcode.sendKeys("11111");
            next.click();
            Assert.assertTrue(driver.findElement(By.xpath(".//*[@id='main-contentWrapper']/div/div/div/section/div[1]/p")).isDisplayed(), "We're having trouble locating your information. Please recheck the info you entered. If it's correct and you are a Cigna customer with current coverage, living in the U.S., please call Customer Service at 800-853-2713 for assistance with registration. Cigna-HealthSpring customers call 855-216-4365. ");
        } catch (Exception e) {
            System.out.println("Not Available");
            e.printStackTrace();
        }
    }
}