import base.CommonAPI;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ShoppingCart extends CommonAPI {
    @FindBy(xpath = "//button[@type='button' and @class='close']")
    WebElement popUpCloseBtn;
    public void shoppingCart() {
        System.out.println("Helper Method");
        WebDriverWait wait = new WebDriverWait(driver, 35);

        wait.until(ExpectedConditions.elementToBeClickable(popUpCloseBtn));
        popUpCloseBtn.click();


    }
}
