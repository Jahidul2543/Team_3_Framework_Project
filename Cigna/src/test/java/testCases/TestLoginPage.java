package testCases;

import base.CommonAPI;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page_objects.LoginPage;
import page_objects.PersonalPage;

public class TestLoginPage extends CommonAPI{
    PersonalPage objOfPersonalPage;
    LoginPage objOfLoginPage;

    @BeforeMethod
    public void initilizationOfObject() {
        objOfPersonalPage = PageFactory.initElements(driver, PersonalPage.class);
        objOfLoginPage = PageFactory.initElements(driver, LoginPage.class);
    }

    @Test(priority = 0, enabled = true)
    public void loginButton() {
        objOfPersonalPage.clickLoginButton();
        String actualErrorMsg = objOfLoginPage.enterCredintials();
        String expectedResult = "The ID and password combination you entered does not match our records.";
        Assert.assertTrue(actualErrorMsg.contains(expectedResult));
    }

    @Test(priority = 1, enabled = true)
    public void regrister1() {
        //PersonalPage pg = PageFactory.initElements(driver, PersonalPage.class);
        objOfPersonalPage.clickLoginButton();
        //LoginPage lp = PageFactory.initElements(driver, LoginPage.class);
        objOfLoginPage.howToRegrister();
        objOfLoginPage.regristration1();
        objOfLoginPage.regristration2();
    }
}
