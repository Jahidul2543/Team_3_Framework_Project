package testHomePageObjects;

import homePageObjects.HomePage;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestHomePage extends HomePage{
    HomePage objHomePage;

    @BeforeMethod
    public void initializePageObjects() {
        objHomePage = PageFactory.initElements(driver, HomePage.class);
    }

    //T3TWI_HP_TC01 go to About page and get HeroImage text
   @Test
    public void testHeroImage(){
        String actual = objHomePage.goToAboutPageGetHeroImageText();
        String expected = "what’s happening";
        Assert.assertTrue(actual.contains(expected));
        System.out.println("testHeroImage test passed");
    }
    //T3TWI_HP_TC02 Get list of links in Home page(anchor tags)
   @Test
    public void verifyTotalLinksHomePage(){
        int actual = objHomePage.findNumberOfLinks();
        String actualLinks = String.valueOf(actual); //convert int to String for assertion
        String expectedLinks = "45";
        Assert.assertEquals(actualLinks,expectedLinks);
        System.out.println("verifyTotalLinksHomePage test passed");
    }
    //T3TWI_HP_TC03 verify 'Help Center' link
    @Test
    public void testHelpCenterLink(){
       boolean actual = objHomePage.verifyHelpCenterLink();
       Assert.assertTrue(actual);
        System.out.println("testHelpCenterLink test passed");
    }
    //T3TWI_HP_TC04 verify Blog link
    @Test
    public void testBlogLink(){
        boolean actual = objHomePage.verifyBlogLink();
        Assert.assertTrue(actual);
        System.out.println("testBlogLink test passed");
    }
    //T3TWI_HP_TC05 Get items from Sortby drop box
    @Test
    public void testListSortBy(){
        objHomePage.getDropBoxList();
        System.out.println("testListSortBy test passed");
    }
    //T3TWI_HP_TC06 verify HomePage text
    @Test
    public void testHomePageText(){
        String actual = objHomePage.verifyHomePageText();
        String expected = "the world right";
       // Assert.assertTrue(actual.contains(expected));
        System.out.println("testHomePageText test passed");
    }
}
