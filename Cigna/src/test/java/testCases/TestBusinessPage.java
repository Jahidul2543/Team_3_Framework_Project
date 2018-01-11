package testCases;

import base.CommonAPI;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page_objects.BusinessPage;
import page_objects.LoginPage;
import page_objects.PersonalPage;

import java.util.List;

public class TestBusinessPage extends CommonAPI{

    PersonalPage objOfPersonalPage;
    BusinessPage objOfBusinessPage;

    @BeforeMethod
    public void initilizationOfObject() {
        objOfPersonalPage = PageFactory.initElements(driver, PersonalPage.class);
        objOfBusinessPage = PageFactory.initElements(driver, BusinessPage.class);
    }

    @Test
    public void businessPageFunctions(){
            TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object(){}.getClass().getEnclosingMethod().getName()));
            List<String> expectedMenu = getMenus();
            List<String> listOfMenu = getMenus();
            Assert.assertEquals(listOfMenu, "text");
        }
    }


}
