import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestShoppingCart extends ShoppingCart {
    ShoppingCart objShoppinCart;
    @BeforeTest
    public void initialization(){
        objShoppinCart = PageFactory.initElements(driver, ShoppingCart.class);
    }
    @Test
    public void testShoppingCart(){
        System.out.println("This is a test");

        objShoppinCart.shoppingCart();
    }
}
