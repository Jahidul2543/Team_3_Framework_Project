package testCases;

import base.CommonAPI;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import page_objects.HomePage;
import page_objects.ProductsPage;
import page_objects.SignInPage;


import java.util.concurrent.TimeUnit;


public class TestHomePage extends CommonAPI {

    /* @Test (priority = 2, )
     public void testProductSearch(){
         HomePage sr = PageFactory.initElements(driver, HomePage.class);
         sr.searchProduct();
     }

     @Test (priority = 1)
     public void testSupplierSearch(){
         HomePage sr = PageFactory.initElements(driver, HomePage.class);
         sr.searchSuppliers();
     }
     @Test (priority = 3)
     public void  testQuotesSearch(){
         HomePage sr = PageFactory.initElements(driver, HomePage.class);
         sr.quotesSearchOption();
     }
     @Test (priority = 4)
     public void sourcingSolutions(){
         HomePage sr = PageFactory.initElements(driver, HomePage.class);
         sr.sourcingSolutions();
     }*/
    @Test(priority = 1, enabled = false)
    public void signIn() {
        HomePage sr = PageFactory.initElements(driver, HomePage.class);
        sr.clikSignIn();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        SignInPage sign = PageFactory.initElements(driver, SignInPage.class);
        sign.signIn();
    }

    @Test (enabled = false)
    public void testHompageButtonStatus() {
        HomePage sr = PageFactory.initElements(driver, HomePage.class);
        sr.homePageButtonStatus();

    }

    @Test
    public void testCategories() throws InterruptedException {
        HomePage sr = PageFactory.initElements(driver, HomePage.class);
        sr.categories();

        ProductsPage productsPage = PageFactory.initElements(driver, ProductsPage.class);
        productsPage.toolsSearch();
    }

}
