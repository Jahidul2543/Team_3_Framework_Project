package testCases;

import base.CommonAPI;
import com.gargoylesoftware.htmlunit.Page;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page_objects.LoginPage;
import page_objects.PersonalPage;

public class TestPersonalPage extends CommonAPI {
    PersonalPage objOfPersonalPage;
    LoginPage objOfLoginPage;

    @BeforeMethod
    public void initilizationOfObject() {
        objOfPersonalPage = PageFactory.initElements(driver, PersonalPage.class);
        objOfLoginPage = PageFactory.initElements(driver, LoginPage.class);
    }

    @Test(priority = 0, enabled = false)
    public void personalPageFunctions() {
        objOfPersonalPage.clickFindDoctor();
        objOfPersonalPage.navigateBack();
        objOfPersonalPage.individualFamilyPlan();
        objOfPersonalPage.searchBar();
        objOfPersonalPage.navigateBack();
        objOfPersonalPage.cignaMedicare();
        objOfPersonalPage.internationalIndividualPlan();
        objOfPersonalPage.offerCignaThroWork();
        objOfPersonalPage.healthNWellness();
        objOfPersonalPage.mLogo();
        objOfPersonalPage.moreI();
        objOfPersonalPage.viewDet();
        objOfPersonalPage.seeV();
        objOfPersonalPage.hearWhatYouNeed();
        objOfPersonalPage.downloadApps();
        objOfPersonalPage.listenN();
        objOfPersonalPage.readMore();
        objOfPersonalPage.newsL();
        objOfPersonalPage.investorsL();
        objOfPersonalPage.coperateL();
        objOfPersonalPage.findADoctorL();
        objOfPersonalPage.informedOnRepormL();
        objOfPersonalPage.mobileApp();
        objOfPersonalPage.contactAsLink();
        objOfPersonalPage.feedbackL();
        objOfPersonalPage.linkedin();
        objOfPersonalPage.facebookLink();
        objOfPersonalPage.twitterL();
        objOfPersonalPage.youtubeL();
        objOfPersonalPage.googleLink();
        objOfPersonalPage.pinintrestLink();
        objOfPersonalPage.weiboLink();
        objOfPersonalPage.instagramL();
        objOfPersonalPage.viewAllLink();
        objOfPersonalPage.nortonLink();
        objOfPersonalPage.feedbackSideLink();
        objOfPersonalPage.goBackToHomeWindow();
        objOfPersonalPage.sign();
        objOfPersonalPage.goBackToHomeWindow();
    }
}