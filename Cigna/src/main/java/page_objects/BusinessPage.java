package page_objects;

import base.CommonAPI;
import org.apache.bcel.generic.Select;
import org.apache.bcel.generic.Visitor;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

import static sun.plugin.cache.FileVersion.convertToString;

public class BusinessPage extends CommonAPI {

    @FindBy(css = ".business>a>span")
    public static WebElement businesstab;
    @FindBy(xpath = ".//*[@id='login']")
    public static WebElement login1;


    public static void business() {
        businesstab.g
    }


}