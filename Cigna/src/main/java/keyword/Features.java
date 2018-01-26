package keyword;

import base.CommonAPI;
import org.openqa.selenium.InvalidArgumentException;
import org.openqa.selenium.support.PageFactory;
import page_objects.InputFromExcel;
import page_objects.LoginPage;
import page_objects.PersonalPage;
import search.IteamsToBeSearched;

import java.io.IOException;

import static javafx.beans.binding.Bindings.select;

public class Features extends CommonAPI{
    LoginPage objOfLoginPage= PageFactory.initElements(driver,LoginPage.class);
    PersonalPage objOfPersonalPage= PageFactory.initElements(driver, PersonalPage.class);
    InputFromExcel objOfinputFromExcel=PageFactory.initElements(driver, InputFromExcel.class);

    public void Login() {
        objOfLoginPage.enterCredintials();
    }

    public void Regristration(){
        objOfLoginPage.regristration1();
        objOfLoginPage.regristration2();
    }

    public void searchProduct(){
        objOfPersonalPage.searchBar();
        System.out.println("Search");
    }

    public void selectAction(String featureName) throws IOException {
        switch (featureName) {
            case "Login":
                Login();
                break;
            case "Regristration":
                Regristration();
                break;
            case "SearchProduct":
                searchProduct();
                break;
            default:
                throw new InvalidArgumentException("Invalid feature choice");
        }
    }

    public void selectFeatures() throws IOException, InterruptedException {
        String[] keyword = objOfinputFromExcel.getDataFromSignInKeyword("Key.xls");
        for (int i = 0; i < keyword.length; i++) {
            selectAction(keyword[i]);
        }
    }
}
