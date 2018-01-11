package base;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class CommonAPI {

    public static WebDriver driver = null;
    
    private String saucelabs_username = "jahidul2543";
    private String browserstack_username = "aartipathania1";
    private String saucelabs_accesskey = "c59131c9-8821-4a81-b468-90769d7c1353";
    private String browserstack_accesskey = "XRGG5ma4V3g4QzRhpMzr";

    @Parameters({"useCloudEnv", "cloudEnvName", "os", "os_version", "browserName", "browserVersion", "url"})
    @BeforeMethod
    public void setUp(@Optional("false") boolean useCloudEnv, @Optional("false") String cloudEnvName,
                      @Optional("windows") String os, @Optional("10") String os_version, @Optional("firefox") String browserName, @Optional("34")
                              String browserVersion, @Optional("https://www.google.com") String url) throws IOException {
        if (useCloudEnv == true) {
            if (cloudEnvName.equalsIgnoreCase("browserstack")) {
                getCloudDriver(cloudEnvName, browserstack_username, browserstack_accesskey, os, os_version, browserName, browserVersion);
            } else if (cloudEnvName.equalsIgnoreCase("saucelabs")) {
                getCloudDriver(cloudEnvName, saucelabs_username, saucelabs_accesskey, os, os_version, browserName, browserVersion);
            }
        } else {
            getLocalDriver(browserName, os);
        }

        driver.get(url);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(35, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(35, TimeUnit.SECONDS);
    }

    public WebDriver getLocalDriver(String browserName, String os) {
        if (browserName.equalsIgnoreCase("chrome")) {
            if (os.equalsIgnoreCase("windows")) {
                System.setProperty("webdriver.chrome.driver", "../Generic/drivers/windows/chromedriver.exe");
                driver = new ChromeDriver();
            } else if (os.equalsIgnoreCase("mac")) {
                System.setProperty("webdriver.chrome.driver", "../Generic/drivers/mac/chromedriver");
                driver = new ChromeDriver();
            }
        } else if (browserName.equalsIgnoreCase("firefox")) {
            if (os.equalsIgnoreCase("windows")) {
                System.setProperty("webdriver.gecko.driver", "../Generic/drivers/windows/geckodriver.exe");
                driver = new ChromeDriver();
            } else if (os.equalsIgnoreCase("mac")) {
                System.setProperty("webdriver.gecko.driver", "../Generic/drivers/mac/geckodriver");
                driver = new ChromeDriver();
            }
        }
        return driver;
    }

    public WebDriver getCloudDriver(String envName, String envUsername, String envAccessKey, String os, String os_version, String browserName,
                                    String browserVersion) throws IOException {

        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("browser", "Chrome");
        caps.setCapability("browser_version", "62.0");
        caps.setCapability("os", "Windows");
        caps.setCapability("os_version", "10");

        if (envName.equalsIgnoreCase("Saucelabs")) {
            driver = new RemoteWebDriver(new URL("http://" + envUsername + ":" + envAccessKey +
                    "@ondemand.saucelabs.com:80/wd/hub"), caps);
        } else if (envName.equalsIgnoreCase("Browserstack")) {
            caps.setCapability("resolution", "1024x768");
            driver = new RemoteWebDriver(new URL("http://" + envUsername + ":" + envAccessKey +
                    "@hub-cloud.browserstack.com/wd/hub"), caps);
        }
        return driver;
    }

    @AfterMethod
    public void closeOut() {
        driver.manage().deleteAllCookies();
        driver.close();
        driver.quit();
    }

    //get title of the current page
    public static String showTitle(WebDriver driver) {
        String title = driver.getTitle();
        return title;
    }

    //return status of link if it is enabled
    public static boolean isEnableStatus(WebDriver driver, WebElement web) {
        boolean en = web.isEnabled();
        return en;
    }

    //wait time for next action
    public static void wait(WebDriver driver, int sec) throws InterruptedException {
        Thread.sleep(sec * 1000);
    }

    //(10,TimeUnit.SECONDS)
    //implicit wait
    public static void implicitWait(WebDriver driver, int sec) {
        driver.manage().timeouts().implicitlyWait(sec, TimeUnit.SECONDS);
    }
    public List<WebElement> getListOfWebElementsById(String locator) {
        List<WebElement> list = new ArrayList<WebElement>();
        list = driver.findElements(By.id(locator));
        return list;
    }
    public List<String> getTextFromWebElements(String locator){
        List<WebElement> element = new ArrayList<WebElement>();
        List<String> text = new ArrayList<String>();
        element = driver.findElements(By.cssSelector(locator));
        for(WebElement web:element){
            text.add(web.getText());
        }
        return text;
    }
    public List<WebElement> getListOfWebElementsByCss(String locator) {
        List<WebElement> list = new ArrayList<WebElement>();
        list = driver.findElements(By.cssSelector(locator));
        return list;
    }
    public List<WebElement> getListOfWebElementsByXpath(String locator) {
        List<WebElement> list = new ArrayList<WebElement>();
        list = driver.findElements(By.xpath(locator));
        return list;
    }
    public String  getCurrentPageUrl(){
        String url = driver.getCurrentUrl();
        return url;
    }
    public void navigateBack(){
        driver.navigate().back();
    }
    public void navigateForward(){
        driver.navigate().forward();
    }
    public String getTextByCss(String locator){
        String st = driver.findElement(By.cssSelector(locator)).getText();
        return st;
    }
    public String getTextByXpath(String locator){
        String st = driver.findElement(By.xpath(locator)).getText();
        return st;
    }
    public String getTextById(String locator){
        return driver.findElement(By.id(locator)).getText();
    }
    public String getTextByName(String locator){
        String st = driver.findElement(By.name(locator)).getText();
        return st;
    }

    public List<String> getListOfString(List<WebElement> list) {
        List<String> items = new ArrayList<String>();
        for (WebElement element : list) {
            items.add(element.getText());
        }
        return items;
    }

    public void selectOptionByVisibleText(WebElement element, String value) {
        Select select = new Select(element);
        select.selectByVisibleText(value);
    }
    public void sleepFor(int sec)throws InterruptedException{
        Thread.sleep(sec * 1000);
    }
    public void mouseHoverByCSS(String locator){
        try {
            WebElement element = driver.findElement(By.cssSelector(locator));
            Actions action = new Actions(driver);
            Actions hover = action.moveToElement(element);
        }catch(Exception ex){
            System.out.println("First attempt has been done, This is second try");
            WebElement element = driver.findElement(By.cssSelector(locator));
            Actions action = new Actions(driver);
            action.moveToElement(element).perform();
        }
    }
    public void mouseHoverByXpath(String locator){
        try {
            WebElement element = driver.findElement(By.xpath(locator));
            Actions action = new Actions(driver);
            Actions hover = action.moveToElement(element);
        }catch(Exception ex){
            System.out.println("First attempt has been done, This is second try");
            WebElement element = driver.findElement(By.cssSelector(locator));
            Actions action = new Actions(driver);
            action.moveToElement(element).perform();
        }
    }
    //handling Alert
    public void okAlert(){
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }
    public void cancelAlert(){
        Alert alert = driver.switchTo().alert();
        alert.dismiss();
    }

    //iFrame Handle
    public void iframeHandle(WebElement element){
        driver.switchTo().frame(element);
    }

    public void goBackToHomeWindow(){
        driver.switchTo().defaultContent();
    }

    //get Links
    public void getLinks(String locator){
        driver.findElement(By.linkText(locator)).findElement(By.tagName("a")).getText();
    }

    public static void captureScreenshot(WebDriver driver, String screenshotName){

        DateFormat df = new SimpleDateFormat("(MM.dd.yyyy-HH:mma)");
        Date date = new Date();
        df.format(date);

        File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(file, new File(System.getProperty("user.dir")+ "/screenshots/"+screenshotName+" "+df.format(date)+".png"));
            System.out.println("Screenshot captured");
        } catch (Exception e) {
            System.out.println("Exception while taking screenshot "+e.getMessage());;
        }

    }
    //Taking Screen shots
    public void takeScreenShot()throws IOException {
        File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(file,new File("screenShots.png"));
    }
    //Synchronization
    public void waitUntilClickAble(By locator){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
    }
    public void waitUntilVisible(By locator){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
    public void waitUntilSelectable(By locator){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        boolean element = wait.until(ExpectedConditions.elementToBeSelected(locator));
    }
    public void upLoadFile(String locator,String path){
        driver.findElement(By.cssSelector(locator)).sendKeys(path);
        /* path example to upload a file/image
           path= "C:\\Users\\rrt\\Pictures\\ds1.png";
         */
    }
    public void clearInput(String locator){
        driver.findElement(By.cssSelector(locator)).clear();
    }
    public void keysInput(String locator){
        driver.findElement(By.cssSelector(locator)).sendKeys(Keys.ENTER);
    }
    public String converToString(String st){
        String splitString ;
        splitString = StringUtils.join(StringUtils.splitByCharacterTypeCamelCase(st), ' ');
        return splitString;
    }
}