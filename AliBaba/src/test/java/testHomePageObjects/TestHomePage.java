package testHomePageObjects;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import productsPageObjects.ProductsPage;
import signInPageObjects.SignInPage;

import java.io.IOException;

public class TestHomePage extends HomePage {
    HomePage objOfHomePage;
    SignInPage objOfSignInPage;
    ProductsPage objOfProductsPage;

    @BeforeMethod
    public void initializationOfElements() {
        objOfHomePage = PageFactory.initElements(driver, HomePage.class);
        objOfSignInPage = PageFactory.initElements(driver, SignInPage.class);
        objOfProductsPage = PageFactory.initElements(driver, ProductsPage.class);
    }
    // T3ALI_HP_TC01 Verify Home Page URL
    @Test(priority = 1, enabled = true)
    public void testProductSearch() {
        String actual = objOfHomePage.searchProduct();
        String expected = "I Phone";
        Assert.assertTrue(actual.contains(expected));
    }

    //T3ALI_HP_TC02 Verify Search Options
    @Test(priority = 2, enabled = true)
    public void testSupplierSearch() {
        String actual = objOfHomePage.searchSuppliers();
        String expected = "Laptop";
        Assert.assertTrue(actual.contains(expected));
    }

    //T3ALI_HP_TC03 Verify Search by Quote Option
    @Test(priority = 3, enabled = true)
    public void testQuotesSearch() {
        String actual = objOfHomePage.quotesSearchOption();
        String expected = "Manufacturers";
        Assert.assertTrue(actual.contains(expected));
    }

    //T3ALI_HP_TC04 Verify by Sourcing Solutions
    @Test(priority = 4, enabled = true)
    public void testSourcingSolutions() {
        String actual = objOfHomePage.sourcingSolutions();
        String expected = "Alibaba selection";
        Assert.assertTrue(expected.contains(expected));

    }

    //T3ALI_HP_TC05 Verify by Home Page Links Status
    @Test(priority = 5, enabled = true)
    public void testHompageButtonStatus() {
        boolean bl = objOfHomePage.homePageButtonStatus();
        Assert.assertTrue(bl);
    }

    ////T3ALI_HP_TC06 Verify Options Of Categories
    @Test(priority = 6, enabled = true)
    public void testOptionsOfCategories() {
        String actual = objOfHomePage.categories();
        String expected = "Hand-Tools";
        Assert.assertTrue(actual.contains(expected));
    }

    @Test (priority = 7, enabled = true)
    public void testCategories() throws InterruptedException {
        HomePage sr = PageFactory.initElements(driver, HomePage.class);
        sr.categories();
    }

    // T3ALI_HP_TC07 verify logo displayed on homepage or not
    @Test(priority = 8, enabled = true)
    public void checkLogoVisibility() {
        boolean enabled = objOfHomePage.clickLogo();
        Assert.assertEquals(enabled, true);
    }

    // T3ALI_HP_TC08 Verify Order Protection Link
    @Test(priority = 9, enabled = true)
    public void testOrderProtectionButtonStatus() {
        boolean enabled = objOfHomePage.orderProtectionButtonStatus();
        Assert.assertEquals(enabled, true);
    }

    // T3ALI_HP_TC09
    @Test(priority = 10, enabled = true)
    public void categoriesList() {
        objOfHomePage.categoriesList();
    }

    //T3ALI_HP_TC10 Verify Trade Alert Subscription is functional
    @Test(priority = 11, enabled = true)
    public void testTradeAlertSubscriptionFunction() throws InterruptedException {
        String actual = objOfHomePage.tradeAlertSubscription();
        String expected = "https://login.alibaba.com";
        Assert.assertTrue(actual.contains(expected));
    }

    //T3ALI_HP_TC11 Help Center Link Status
    @Test(priority = 12, enabled = true)
    public void testHelpCenterLinkStatus() throws InterruptedException {
        String actual = objOfHomePage.helpCenterLinkStatus();
        String expected = "Help Center";
        Assert.assertTrue(actual.contains(expected));
    }

    //T3ALI_HP_TC12 About Alibaba Link Status
    @Test(priority = 13, enabled = true)
    public void testAboutAlibabaLinkStatus() throws InterruptedException {
        String actual = objOfHomePage.aboutAlibabaLinkStatus();
        String expected = "About Alibaba.com";
        Assert.assertTrue(actual.contains(expected));
    }
    //T3ALI_HP_TC13 About Wholesale Market Link Status
    @Test(priority = 14 , enabled = true)
    public void testWholesaleMarketLinkStatus() throws InterruptedException {
        String actual = objOfHomePage.wholesaleMarketLinkStatus();
        String expected = "Wholesaler Market";
        Assert.assertTrue(actual.contains(expected));
    }
    //T3ALI_HP_TC14 Move to top button functionality check
    @Test (priority = 15, enabled = true)
    public void testTopButtonVerification() throws InterruptedException {
        String actual = objOfHomePage.topButtonVerification();
        String expected = "(1299, 542)";
       // Assert.assertTrue(actual.contains(expected));
    }
    ////T3ALI_HP_TC14 Quotes request
    @Test(priority = 16, enabled = true)
    public void testQuotesRequestForm() throws InterruptedException {
      objOfHomePage.quotesRequestForm();
      objOfHomePage.quotesRequestFormDetails();
      objOfHomePage.popUpSignIn();
      switchWindow(driver);
      String actual = objOfSignInPage.sendGoogleIdAndPassword();
      sleepFor(40);
      String expected = "Wrong password";
      //Assert.assertTrue(actual.contains(expected));

    }
    @Test
    public void testNumberOfLinksInHomePage() throws IOException {
        objOfHomePage.findNumberOfLinksInHomePage();
    }
}