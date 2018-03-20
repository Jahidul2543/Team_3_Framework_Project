package testSignInPageObjects;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import testHomePageObjects.HomePage;
import productsPageObjects.ProductsPage;
import signInPageObjects.SignInPage;
import reporting.TestLogger;

public class TestSignInPage extends SignInPage {
    HomePage objOfHomePage;
    SignInPage objOfSignInPage;
    ProductsPage objOfProductsPage;

    @BeforeMethod
    public void initializationOfElements() {
        objOfHomePage = PageFactory.initElements(driver, HomePage.class);
        objOfSignInPage = PageFactory.initElements(driver, SignInPage.class);
        objOfProductsPage = PageFactory.initElements(driver, ProductsPage.class);
    }

    // T3ALI_SI_TC01 Sign in with invalid id and invalid password
    @Test(priority = 1, enabled = true)
    public void signInWithInvalidIdTest() throws InterruptedException {
        objOfHomePage.clikSignIn();
        objOfSignInPage.switchToSignInForm();
        String actual = objOfSignInPage.signIn();
        System.out.println("Actual Error Message: " + actual);
        String expected = "Your account name or password is incorrect.";
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(actual.contains(expected));
        //System.out.println("Test Case signInWithInvalidIdTest Passed");
        // TestLogger.log(getClass().getSimpleName() + ": " + converToString(new Object(){}.getClass().getEnclosingMethod().getName()));
    }

    //T3ALI_SI_TC02 Sign In By Mobile Link Status
    @Test(priority = 2, enabled = true)
    public void signInByMobileLinkStatusTest() throws InterruptedException {
        // TestLogger.log(getClass().getSimpleName() + ": " + converToString(new Object() {
        //}.getClass().getEnclosingMethod().getName()));
        objOfHomePage.clikSignIn();
        SignInPage sign = PageFactory.initElements(driver, SignInPage.class);
        objOfSignInPage.switchToSignInForm();
        boolean bl = objOfSignInPage.signInByMobileNumberLink();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(bl, true);
        // Assert.assertEquals(bl, true);
        System.out.println("Test Case signInByMobileLinkStatusTest Passed");
        TestLogger.log(getClass().getSimpleName() + ": " + converToString(new Object() {
        }.getClass().getEnclosingMethod().getName()));
    }

    //T3ALI_SI_TC03 Join Free Link status
   /* @Test(priority = 3, enabled = true)
    public void joinFreeLinkStatusTest() throws InterruptedException {
        // HomePage sr = PageFactory.initElements(driver, HomePage.class);
        try {
            objOfHomePage.clikSignIn();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // T3ALI_SI_TC04 SignInPage sign = PageFactory.initElements(driver, SignInPage.class);
        objOfSignInPage.switchToSignInForm();
        boolean bl = objOfSignInPage.joinFreeLinkStatus();
        Assert.assertEquals(bl, true);
        System.out.println("Test Case joinFreeLinkStatusTest Passed");
    }

    // T3ALI_SI_TC05 Sign in By invalid mobile number and password
    @Test(priority = 4, enabled = false)
    public void signInByMobileNumberTest() throws InterruptedException {
        try {
            objOfHomePage.clikSignIn();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        objOfSignInPage.switchToSignInForm();
        String actualErrorMessage = objOfSignInPage.signInByMobileNumber();
        String expectdErrorMessage = "Your account name or password is incorrect.";
        Assert.assertEquals(actualErrorMessage, expectdErrorMessage);
        System.out.println("Test Case signInByMobileNumberTest Passed");
    }

    // T3ALI_SI_TC06 Sign In By Facebook Link status
    @Test(priority = 5, enabled = true)
    public void facebookLinkStatusTest() throws InterruptedException {
        HomePage sr = PageFactory.initElements(driver, HomePage.class);
        try {
            sr.clikSignIn();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        SignInPage sign = PageFactory.initElements(driver, SignInPage.class);
        sign.switchToSignInForm();
        boolean bl = sign.signInByFacebookIconStatus();
        Assert.assertEquals(bl, true);
        System.out.println("Test Case facebookLinkStatusTest Passed");
    }

    // T3ALI_SI_TC07 Sign In By Google Link status
    @Test(priority = 6, enabled = true)
    public void googleLinkStatusTest() throws InterruptedException {
        HomePage sr = PageFactory.initElements(driver, HomePage.class);
        try {
            sr.clikSignIn();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        SignInPage sign = PageFactory.initElements(driver, SignInPage.class);
        sign.switchToSignInForm();
        boolean bl = sign.signInByGoogleIconStatus();
        Assert.assertEquals(bl, true);
        System.out.println("Test Case googleLinkStatusTest Passed");
    }

    //T3ALI_SI_TC08 Sign In By LinkedIn Link status
    @Test(priority = 7, enabled = true)
    public void linkedInLinkStatusTest() throws InterruptedException {
        HomePage sr = PageFactory.initElements(driver, HomePage.class);
        try {
            sr.clikSignIn();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        SignInPage sign = PageFactory.initElements(driver, SignInPage.class);
        sign.switchToSignInForm();
        boolean bl = sign.signInByLinkInIconStatus();
        Assert.assertEquals(bl, true);
        System.out.println("Test Case linkedInLinkStatusTest Passed");
    }

    //T3ALI_SI_TC09 Sign In By Twitter Link status
    @Test(priority = 8, enabled = true)
    public void twitterLinkStatusTest() throws InterruptedException {
        HomePage sr = PageFactory.initElements(driver, HomePage.class);
        try {
            sr.clikSignIn();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        SignInPage sign = PageFactory.initElements(driver, SignInPage.class);
        sign.switchToSignInForm();
        boolean bl = sign.signInByTwiterIconStatus();
        Assert.assertEquals(bl, true);
        System.out.println("Test Case twitterLinkStatusTest Passed");
    }

    //T3ALI_SI_TC10 Sign in by invalid(email & password) Twitter account
    @Test(priority = 9, enabled = true)
    public void signInByInvalidTwitterAccountTest() {
        HomePage sr = PageFactory.initElements(driver, HomePage.class);
        try {
            sr.clikSignIn();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        SignInPage sign = PageFactory.initElements(driver, SignInPage.class);
        sign.switchToSignInForm();
        String actualErrorMessage = sign.signInByInvalidTwitterAccount();
        String expectedErroMessage = "The email and password you entered did not match our records. Please double-check and try again.";
        Assert.assertEquals(expectedErroMessage, actualErrorMessage);
        System.out.println("Test Case signInByInvalidTwitterAccountTest Passed");
    }

    // T3ALI_SI_TC11 Sign in by valid Twitter account
    @Test(priority = 10, enabled = true)
    public void signInByValidTwitterAccountTest() {
        HomePage sr = PageFactory.initElements(driver, HomePage.class);
        try {
            sr.clikSignIn();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        SignInPage sign = PageFactory.initElements(driver, SignInPage.class);
        sign.switchToSignInForm();
        String actuaMessage = sign.signInByValidTwitterAccount();
        String expectedMessage = "Please enter the following details to complete your registration.";
        Assert.assertTrue(actuaMessage.contains(expectedMessage));
        System.out.println("Test Case signInByValidTwitterAccountTest Passed");
    }

    // T3ALI_SI_TC12 Sign in by invalid facebook account
    @Test(priority = 11, enabled = true)
    public void signInByInvalidFacebookAccountTest() {
        HomePage sr = PageFactory.initElements(driver, HomePage.class);
        try {
            sr.clikSignIn();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        SignInPage sign = PageFactory.initElements(driver, SignInPage.class);
        sign.switchToSignInForm();
        String actualErrorMessage = sign.signInByInvalidFacebookAccount();
        String expectedErroMessage = "Incorrect Email";
        Assert.assertEquals(expectedErroMessage, actualErrorMessage);
        System.out.println("Test Case signInByInvalidFacebookAccountTest Passed");
    }

    // T3ALI_SI_TC13 Sign in by valid Twitter account
    @Test(groups = {"smokeTest"},priority = 12, enabled = true)
    public void signInByValidGoogleAccountTest() {
        String winHandleBefore = driver.getWindowHandle();
        try {
            objOfHomePage.clikSignIn();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        objOfSignInPage.switchToSignInForm();
        objOfSignInPage.signInByValidGooleAcount();
        driver.switchTo().window(winHandleBefore);
        String actuaMessage = objOfHomePage.hoverOverMyAccount();
        String expectedMessage = "Hi J";
        Assert.assertEquals(expectedMessage, actuaMessage);
        System.out.println("Test Case signInByValidGoogleAccountTest Passed");
    }

    //T3ALI_SI_TC14 Verify "Get Help Here" option
    @Test(priority = 13, enabled = true)
    public void getHelpHere() {
        try {
            objOfHomePage.clikSignIn();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        objOfSignInPage.getHlepHere();
    }*/
}
