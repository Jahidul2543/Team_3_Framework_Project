package page_objects;

import base.CommonAPI;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PersonalPage extends CommonAPI {
    @FindBy(id = "login")
    public static WebElement loginButton;
    @FindBy(id = "find-doc")
    public static WebElement findDoctor;
    @FindBy(xpath = ".//*[@id='csng-search-header']/search-header-bar/form/cigna-typeahead/div/input")
    public static WebElement search;
    @FindBy(xpath = ".//*[@id='1386067114266']/div[4]/div/div[2]/nav/ul/li[1]/a")
    public static WebElement indFamPlan;
    @FindBy(css = ".mainNav")
    public static WebElement cMedicare;
    @FindBy(css = ".mainNav.two-lines")
    public static WebElement intIndPlan;
    @FindBy(css = ".mainNav.two-lines")
    public static WebElement offeredCigThroughW;
    @FindBy(css = ".mainNav")
    public static WebElement healthWellness;
    @FindBy(css = ".navbar-brand")
    public static WebElement logo;
    @FindBy(css = ".cigna-color-white")
    public static WebElement youSmileWeSmile;
    @FindBy(css = ".left")
    public static WebElement viewDetPlan;
    @FindBy(xpath = ".//*[@id='1387201103940']/div/div/ul/li[2]/div/div[2]/div/a/span[1]")
    public static WebElement moreInfo;
    @FindBy(xpath = ".//*[@id='1387201103940']/div/div/ul/li[3]/div/div[2]/div/a/span[1]")
    public static WebElement seeVideo;
    @FindBy(css = ".promo-cta.cigna-color-white")
    public static WebElement hearWhatYouNeedTo;
    @FindBy(xpath = ".//*[@id='1387201104356']/div/div/div/div[1]/ul/li[1]/div/div/div/div[2]/a")
    public static WebElement signUp;
    @FindBy(xpath = ".//*[@id='1387201104356']/div/div/div/div[1]/ul/li[2]/div/div/div/div[2]/a")
    public static WebElement downloadApp;
    @FindBy(xpath = ".//*[@id='1387201104356']/div/div/div/div[1]/ul/li[3]/div/div/div/div[2]/a")
    public static WebElement listenNow;
    @FindBy(xpath = ".//*[@id='paragraph-ct']/a")
    public static WebElement readMoreInTheHealth;
    @FindBy(xpath = ".//*[@id='oo_tab']")
    public static WebElement feedbackSide;
    @FindBy(xpath = ".//*[@id='1386145328993']/footer/div[1]/div/div/ul/li[1]/a")
    public static WebElement news;
    @FindBy(xpath = ".//*[@id='1386145328993']/footer/div[1]/div/div/ul/li[2]/a")
    public static WebElement investors;
    @FindBy(xpath = ".//*[@id='1386145328993']/footer/div[1]/div/div/ul/li[3]/a")
    public static WebElement coperate;
    @FindBy(xpath = ".//*[@id='1386145328993']/footer/div[1]/div/div/ul/li[4]/a")
    public static WebElement findADoctor;
    @FindBy(xpath = ".//*[@id='1386145328993']/footer/div[1]/div/div/ul/li[5]/a")
    public static WebElement informedOnReform;
    @FindBy(xpath = ".//*[@id='1386145328993']/footer/div[1]/div/div/ul/li[6]/a")
    public static WebElement mobileApp;
    @FindBy(xpath = ".//*[@id='1386145328993']/footer/div[1]/div/div/ul/li[7]/a")
    public static WebElement contactAs;
    @FindBy(xpath = ".//*[@id='fb_top']")
    public static WebElement feedback;
    @FindBy(xpath = ".//*[@id='1386145328993']/footer/div[2]/div[3]/div[2]/a[1]")
    public static WebElement linkedIn;
    @FindBy(xpath = ".//*[@id='1386145328993']/footer/div[2]/div[3]/div[2]/a[2]")
    public static WebElement facebook;
    @FindBy(xpath = ".//*[@id='1386145328993']/footer/div[2]/div[3]/div[2]/a[3]")
    public static WebElement twitter;
    @FindBy(xpath = ".//*[@id='1386145328993']/footer/div[2]/div[3]/div[2]/a[4]")
    public static WebElement youtube;
    @FindBy(xpath = ".//*[@id='1386145328993']/footer/div[2]/div[3]/div[2]/a[5]")
    public static WebElement google;
    @FindBy(xpath = ".//*[@id='1386145328993']/footer/div[2]/div[3]/div[2]/a[6]")
    public static WebElement pinintrest;
    @FindBy(xpath = ".//*[@id='1386145328993']/footer/div[2]/div[3]/div[2]/a[7]")
    public static WebElement weibo;
    @FindBy(xpath = ".//*[@id='1386145328993']/footer/div[2]/div[3]/div[2]/a[8]")
    public static WebElement instagram;
    @FindBy(xpath = ".//*[@id='1386145328993']/footer/div[2]/div[3]/div[2]/a[9]")
    public static WebElement viewAll;
    @FindBy(xpath = ".//*[@id='default-securitylogo']/ul/li[1]/a/img")
    public static WebElement norton;

    public static void clickLoginButton() {
        //click login button
        loginButton.click();
    }

    public static void clickFindDoctor() {
        //Find a Doctor
        findDoctor.click();
    }

    public static void searchBar() {
        //click and search
        search.sendKeys("location", Keys.ENTER);
    }

    public static void individualFamilyPlan() {
        boolean ind = indFamPlan.isEnabled();
        System.out.println("Individual Family Plan Link Status: " + ind);
    }

    public static void cignaMedicare() {
        boolean cMed = cMedicare.isEnabled();
        System.out.println("Cigna Medicare Link Status: " + cMed);
    }

    public static void internationalIndividualPlan() {
        boolean iip = intIndPlan.isEnabled();
        System.out.println("International Individual Plan Link Status: " + iip);
    }

    public static void offerCignaThroWork() {
        boolean octw = offeredCigThroughW.isEnabled();
        System.out.println("Offered Cigna Through Work: " + octw);
    }

    public static void healthNWellness() {
        boolean hnw = healthWellness.isEnabled();
        System.out.println("Health and Wellness: " + hnw);
    }

    public static void mLogo() {
        boolean ml = logo.isDisplayed();
        System.out.println("Cigna Logo is dislpayed: " + ml);
    }

    public static void youSmileWeSmile() {
        boolean ysws = youSmileWeSmile.isDisplayed();
        System.out.println("You Smile We Smile text is displayed: " + ysws);
    }

    public static void viewDet() {
        boolean vdp = viewDetPlan.isDisplayed();
        System.out.println("View Details Plan: " + vdp);
    }

    public static void moreI() {
        boolean mi = moreInfo.isDisplayed();
        System.out.println("More Information: " + mi);
    }

    public static void seeV() {
        boolean sv = seeVideo.isDisplayed();
        System.out.println("See Videos: " + sv);
    }

    public static void hearWhatYouNeed() {
        boolean hwynt = hearWhatYouNeedTo.isDisplayed();
        System.out.println("Here What You Need Know: " + hwynt);
    }

    public static void sign() {
        boolean su = signUp.isDisplayed();
        System.out.println("Sign Up: " + su);
    }

    public static void downloadApps() {
        boolean da = downloadApp.isDisplayed();
        System.out.println("Download App: " + da);
    }

    public static void listenN() {
        boolean ln = listenNow.isDisplayed();
        System.out.println("Listen Now: " + ln);
    }

    public static void readMore() {
        boolean rmith = readMoreInTheHealth.isDisplayed();
        System.out.println("Read More: " + rmith);
    }

    public static void newsL() {
        boolean n = news.isDisplayed();
        System.out.println("News: " + n);
    }

    public static void investorsL() {
        boolean i = investors.isDisplayed();
        System.out.println("Invertors: " + i);
    }

    public static void coperateL() {
        boolean c = coperate.isDisplayed();
        System.out.println("Coperate: " + c);
    }

    public static void findADoctorL() {
        boolean fad = findADoctor.isDisplayed();
        System.out.println("Find A Doctor: " + fad);
    }

    public static void informedOnReportL() {
        boolean ior = informedOnReform.isDisplayed();
        System.out.println("Informed On Report: " + ior);
    }

    public static void mobileApp() {
        boolean ma = mobileApp.isDisplayed();
        System.out.println("Mobile APP: " + ma);
    }

    public static void feedbackSideLink() {
        boolean fs = feedbackSide.isDisplayed();
        System.out.println("Feedback Right Side: " + fs);
    }

    public static void contactAsLink() {
        boolean ca = contactAs.isDisplayed();
        System.out.println("Contact As: " + ca);
    }

    public static void feedbackL() {
        boolean f = feedback.isDisplayed();
        System.out.println("Feedback: " + f);
    }

    public static void linkedin() {
        boolean li = linkedIn.isDisplayed();
        System.out.println("LinkedIn: " + li);
    }

    public static void facebookLink() {
        boolean fb = facebook.isDisplayed();
        System.out.println("Facebook: " + fb);
    }

    public static void twitterL() {
        boolean t = twitter.isDisplayed();
        System.out.println("Twitter: " + t);
    }

    public static void youtubeL() {
        boolean y = youtube.isDisplayed();
        System.out.println("More Information: " + y);
    }

    public static void googleLink() {
        boolean g = google.isDisplayed();
        System.out.println("More Information: " + g);
    }

    public static void pinintrestLink() {
        boolean p = pinintrest.isDisplayed();
        System.out.println("More Information: " + p);
    }

    public static void weiboLink() {
        boolean w = weibo.isDisplayed();
        System.out.println("More Information: " + w);
    }

    public static void instagramL() {
        boolean i = instagram.isDisplayed();
        System.out.println("More Information: " + i);
    }

    public static void viewAllLink() {
        boolean va = viewAll.isDisplayed();
        System.out.println("More Information: " + va);
    }

    public static void nortonLink() {
        boolean n = norton.isDisplayed();
        System.out.println("More Information: " + n);
    }
}