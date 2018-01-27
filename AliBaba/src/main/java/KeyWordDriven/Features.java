package KeyWordDriven;

import base.CommonAPI;
import org.openqa.selenium.InvalidArgumentException;
import org.openqa.selenium.support.PageFactory;
import signInPageObjects.ByInputFromExls;
import signInPageObjects.SignInPage;
import testHomePageObjects.HomePage;

import java.io.IOException;

public class Features extends CommonAPI {
    HomePage objOfHomePage = PageFactory.initElements(driver, HomePage.class);
    SignInPage objOfSignInPage = PageFactory.initElements(driver, SignInPage.class);
    ByInputFromExls objOfByInputFromExls = PageFactory.initElements(driver, ByInputFromExls.class);

    //KeyWord ClickSigIn
    public void clickSignIn() throws InterruptedException {
        objOfHomePage.clikSignIn();
    }

    //KeyWord SwitchToSignForm
    public void switchToSignInForm() {
        objOfSignInPage.switchToSignInForm();
    }

    //KeyWord SignIn
    public void signIn() throws InterruptedException {
        objOfSignInPage.signIn();
    }
    public void searchProduct(){
        objOfHomePage.searchProduct();
        System.out.println("Search for Jahid");
    }

    public void selectAction(String featureName) throws IOException, InterruptedException {
        switch (featureName) {
            case "ClickSignIn":
                clickSignIn();
                break;
            case "SwitchToSignInForm":
                switchToSignInForm();
                break;
            case "SignIn":
                signIn();
                break;
            default:
                throw new InvalidArgumentException("Invalid feature choice");
        }
    }

    public void selectFeature() throws IOException, InterruptedException {
        String[] keyword = objOfByInputFromExls.getDataFromSignInKeyword("Key.xls");
        for (int i = 0; i < keyword.length; i++) {
            selectAction(keyword[i]);
        }
    }
}

