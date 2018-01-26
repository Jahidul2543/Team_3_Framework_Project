package search;
import base.CommonAPI;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import reporting.TestLogger;

import java.io.IOException;

public class SearchClass extends CommonAPI{

        @FindBy(id = ".//*[@id='csng-search-header']/search-header-bar/form/cigna-typeahead/div/input")
        WebElement searchBar;

        @FindBy(id = ".//*[@id='csng-search-results']/search-bar/form/button")
        WebElement clicksearch;

        public void searchFor(String value){
            TestLogger.log(getClass().getSimpleName() + ": " + converToString(new Object(){}.getClass().getEnclosingMethod().getName())+" "+ value);
            searchBar.sendKeys(value);
        }
        public void submitSearch(){
            clicksearch.click();
        }

    public void searching() throws InterruptedException, IOException {
        TestLogger.log(getClass().getSimpleName() + ": " + converToString(new Object(){}.getClass().getEnclosingMethod().getName()));
        IteamsToBeSearched itemsToBeSearched = new IteamsToBeSearched();
        String [] value = itemsToBeSearched.getDataFromExcelFile();
        for(int i=0; i<value.length; i++) {
            sleepFor(1);
            searchFor(value[i]);
            Thread.sleep(2000);
            submitSearch();
            Thread.sleep(2000);
            }
        }
    }

