package testHomePageObjects;

import base.CommonAPI;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class HomePage extends CommonAPI {
    @FindBy(name = "SearchText")
    public static WebElement searchBox;
    @FindBy(xpath = "//div[@id=\"J_SC_header\"]//form/div[1]/div/div/span[1]")
    public static WebElement productSearchOption;
    @FindBy(xpath = "//div[@id=\"J_SC_header\"]//form/div[1]/div/div/span[1]")
    public static WebElement suppliersSearchOption;
    @FindBy(xpath = "//div[@id=\"J_SC_header\"]//form/div[1]/div/div/span[2]")
    public static WebElement quotesSearchOptin;
    @FindBy(xpath = "//*[@id=\"J_SC_header\"]//input[4]")
    public static WebElement searchButton;
    @FindBy(xpath = "//*[@id=\"J_SC_header\"]/header/div[1]/div[3]/ul/li[1]/span")
    public static WebElement sourcingSolutions;
    @FindBy(partialLinkText = "Top Selected")
    public static WebElement topSelectedSuppliers;
    @FindBy(partialLinkText = "Sign In")
    public static WebElement signInButton;
    @FindBy(partialLinkText = "Get the App")
    public static WebElement getTheAppLink;
    @FindBy(partialLinkText = "One Request")
    public static WebElement oneRequestButton;
    @FindBy(partialLinkText = "Favorites")
    public static WebElement favoriteLink;
    @FindBy(xpath = "//div[@id=\"J_SC_header\"]/header/div[2]/div[1]/div/div/h3")
    public static WebElement categories;
    @FindBy(partialLinkText = "Machinery")
    private WebElement machinery;
    @FindBy(partialLinkText = "Hand Tools")
    private WebElement handTools;
    @FindBy(xpath = "//a[@class='more' and @href='javascript:;']")
    private WebElement seeMore;
    @FindBy(xpath = "//div/a[text()='Alibaba.com']")
    private WebElement logo;
    @FindBy(xpath = "//a[@data-val='ordericon']")
    private WebElement orderProtectionButton;
    //After sign under MyAccount this location shall be available
    @FindBy(css = ".sc-hd-ms-name")
    public static WebElement greetingsToAccountHolder;
    @FindBy(partialLinkText = "My Alibaba")
    public static WebElement myAlibaba;
    @FindBy(css = ".J-search-text")
    public static WebElement emailBoxToSubscribeForTradeAlert;
    @FindBy(css = ".J-btn-search")
    public static WebElement tradeAlertSubscriptionButton;
    //Footer
    @FindBy(xpath = "//*[@id=\"ui-footer\"]//div[1]/dl/dd[1]/a")
    public static WebElement helpCenterLink;
    @FindBy(xpath = "//*[@id=\"J_SC_header\"]/header/div[2]/div[1]/div[1]/a")
    public static WebElement verificationPointHelpCenter;
    @FindBy(xpath = "//dd/a[contains (text(), 'About Alibaba.com')]")
    public static WebElement aboutAlibabaLink;
    @FindBy(xpath = "//h2[contains (text(), 'About Alibaba.com')]")
    public static WebElement verificationPointAboutAlibaba;
    @FindBy(xpath = "//dd/a[contains (text(),'Wholesaler Market')]")
    public static WebElement wholesalerMarket;
    @FindBy(linkText = "Wholesaler Market")
    public static WebElement vaerificationPointAWholesaleMarket;
    @FindBy(xpath = "/html/body/div[5]/div/div/i")
    public static WebElement moveToTopButton;
    @FindBy(xpath = "//input[@name='rfqName']")
    public static WebElement productNameForQuotes;
    @FindBy(xpath = "//input[@name='quantity']")
    public static WebElement quantity;
    @FindBy(xpath = "//form/div[3]/div")
    public static WebElement clickUnit;
    @FindBy(xpath = "/html/body/div[7]/ul/li[6]/a")
    public static WebElement selectUnit;
    @FindBy(css = ".ui2-tag-body")
    public static WebElement requestPrice;
    @FindBy(css = ".rfq-submit")
    public static WebElement requestForQuotation;
    @FindBy(css = ".control-detail")
    public static WebElement productDetailedSpecifications;
    @FindBy(xpath = "//div[@id='post-wrap']//form//button")
    public static WebElement submitRFQ;
    @FindBy(css = "#xjoinFirstName")
    public static WebElement fNamePoPUpSignInWindow;
    @FindBy(xpath = "//div[@id='thirdPartLogin']/a[2]")
    public static WebElement googleIconOnPoPUpSignInWindow;
    @FindBy(tagName = "a")
    public List<WebElement> anchorTag = new ArrayList<>();

    //T3ALI_HP_TC01 Verify Home Page URL
    public String searchProduct() {
        String url = driver.getCurrentUrl();
        System.out.println("Home Page title: " + driver.getTitle());
        searchBox.sendKeys("I phone", Keys.ENTER);
        String title = driver.getTitle();
        System.out.println("Get Product Search Page Title: " + title);
        return title;
    }

    //T3ALI_HP_TC02
    public String searchSuppliers() {
        productSearchOption.click();
        suppliersSearchOption.click();
        searchBox.sendKeys("laptop i7");
        searchButton.click();
        switchWindow(driver);
        String title = driver.getTitle();
        System.out.println("Suppliers Search Page Titel: " + title);
        return title;
    }

    //T3ALI_HP_TC03
    public String quotesSearchOption() {
        productSearchOption.click();
        quotesSearchOptin.click();
        searchBox.sendKeys("laptop bag");
        switchWindow(driver);
        String title = driver.getTitle();
        System.out.println("Quotes page Title: " + title);
        return title;
    }

    //T3ALI_HP_TC04 Verify by Sourcing Solutions
    public String sourcingSolutions() {
        //hover Sourcing Solutions
        Actions act = new Actions(driver);
        act.moveToElement(sourcingSolutions).build().perform();
        // clcik top selected suppliers
        boolean bl = topSelectedSuppliers.isEnabled();
        // boolean bl = isEnableStatus(driver,topSelectedSuppliers);
        System.out.println("Top Selected Suppliers link status: " + bl);
        System.out.println(topSelectedSuppliers.getText());
        topSelectedSuppliers.click();
        switchWindow(driver);
        String title = driver.getTitle();
        System.out.println("Page titel for Sourcing Solutions: " + title);
        return title;
    }

    //T3ALI_SI_TC02, T3ALI_SI_TC01
    public void clikSignIn() throws InterruptedException {
        sleepFor(4);
        signInButton.click();
    }

    //T3ALI_SI_TC13, Get Account Holder Name from My Alibaba
    public String hoverOverMyAccount() {
        driver.navigate();
        Actions act = new Actions(driver);
        act.moveToElement(myAlibaba).build().perform();
        String actuaMessage = greetingsToAccountHolder.getText();
        return actuaMessage;
    }

    //T3ALI_HP_TC05
    public boolean homePageButtonStatus() {
        System.out.println("Get The App link status: " + getTheAppLink.isEnabled());
        System.out.println("'One Request' link status: " + oneRequestButton.isEnabled());
        boolean bl = favoriteLink.isEnabled();
        return bl;
    }

    //T3ALI_HP_TC06
    public String categories() {
        //hover over Categories. Hover in multiple windows.
        Actions act = new Actions(driver);
        act.moveToElement(categories).moveToElement(machinery).build().perform();
        handTools.click();
        switchWindow(driver);
        String url = driver.getCurrentUrl();
        return url;
    }

    // T3ALI_HP_TC07 verify logo displayed on homepage or not
    public boolean clickLogo() {
        boolean displayed = logo.isDisplayed();
        boolean enabled = logo.isEnabled();
        return enabled;

    }

    // T3ALI_HP_TC08 Verify Order Protection Link
    public boolean orderProtectionButtonStatus() {
        boolean displayed = orderProtectionButton.isDisplayed();
        boolean enabled = orderProtectionButton.isEnabled();
        return enabled;
    }

    public void categoriesList() {
        //getTextFromWebElements("//div[class=\"component-list\"]");
        List<String> sortByOptions = new ArrayList<>();
        List<WebElement> option = driver.findElements(By.xpath("//ul[@class='component-list']"));
        for (WebElement we : option) {
            sortByOptions.add(we.getText());
        }
        for (String st : sortByOptions) {
            System.out.println(st);
        }

    }

    //T3ALI_HP_TC10 Trade Alert Subscription
    public String tradeAlertSubscription() throws InterruptedException {
        emailBoxToSubscribeForTradeAlert.sendKeys("testdata.islam@gmail.com");
        tradeAlertSubscriptionButton.click();
        sleepFor(5);
        String currentUrl = driver.getCurrentUrl();
        return currentUrl;
    }

    //T3ALI_HP_TC11 Help Center Link Status
    public String helpCenterLinkStatus() throws InterruptedException {
        helpCenterLink.click();
        for (String handle : driver.getWindowHandles()) {
            driver.switchTo().window(handle);
        }
        sleepFor(5);

        String text = verificationPointHelpCenter.getText();
        return text;
    }

    //T3ALI_HP_TC12 About ALibaba.com Link Status
    public String aboutAlibabaLinkStatus() throws InterruptedException {
        aboutAlibabaLink.click();
        switchWindow(driver);
        sleepFor(5);
        String text = verificationPointAboutAlibaba.getText();
        return text;
    }

    //T3ALI_HP_TC13 About Wholesale Market Link Status
    public String wholesaleMarketLinkStatus() throws InterruptedException {
        wholesalerMarket.click();
        sleepFor(5);
        switchWindow(driver);
        sleepFor(5);
        String text = vaerificationPointAWholesaleMarket.getText();

        return text;
    }

    //T3ALI_HP_TC14 Move to top button functionality check
    public String topButtonVerification() throws InterruptedException {
        System.out.println("My Alibab Display Status: " + myAlibaba.isDisplayed());
        sleepFor(10);
        System.out.println("Initial location of top button" + moveToTopButton.getLocation());
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("scroll(0, 1000);");
        System.out.println("My Alibab Display Status: " + myAlibaba.isDisplayed());
        System.out.println("Location after scroll: " + moveToTopButton.getLocation());
        moveToTopButton.click();
        System.out.println("My Alibab Display Status: " + myAlibaba.isDisplayed());
        System.out.println(moveToTopButton.getLocation());
        sleepFor(10);
        String location = "Location after clik to Top Button: " + moveToTopButton.getLocation();
        return location;
    }

    //T3ALI_HP_TC14 Quotes request
    public void quotesRequestForm() {
        productNameForQuotes.sendKeys("Laptop");
        quantity.sendKeys("100");
        clickUnit.click();
        selectUnit.click();
        requestPrice.click();
        requestForQuotation.click();
        switchWindow(driver);
        System.out.println("Page Title: " + driver.getTitle());
    }

    //RFQ Details
    public void quotesRequestFormDetails() {
        implicitWait(driver, 10);
        productDetailedSpecifications.sendKeys("30 Days");
        submitRFQ.click();
    }

    //PoP Up Sign In
    public void popUpSignIn() {
        implicitWait(driver, 15);
        fNamePoPUpSignInWindow.sendKeys("J Islam");
        googleIconOnPoPUpSignInWindow.click();
    }
    //Verify all available links in HomePage
    public void findNumberOfLinksInHomePage() throws IOException {
        List<String> actualLinkList = findNumberOfLink(anchorTag);
        List<String> expectedLinkList = getAssertData("../AliBaba/data/HomePageLinkData.xls",2);
        assertData(actualLinkList,expectedLinkList);
    }
}
