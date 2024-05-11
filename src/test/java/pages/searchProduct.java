package pages;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;

import static pages.BasePage.driver;

public class searchProduct {
    public void clickinputsearch() {
        MobileElement textsearchButton = driver.findElement(MobileBy.id("edts.klik.android:id/text_input_start_icon"));
        textsearchButton.click();
    }
    public void setInputFieldsearch(String keyword){
        MobileElement inputFieldsearch = driver.findElement(MobileBy.className("android.widget.EditText"));
        inputFieldsearch.sendKeys(keyword);
    }
    public void clicksuggestkeyword() {
        MobileElement kopiBubukElement = driver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().text(\"Kopi bubuk\")"));
        kopiBubukElement.click();
    }
    public void verifyresult() {
        MobileElement VerifyKopiExist = driver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().text(\"Kopi\")"));
        VerifyKopiExist.isDisplayed();
    }
    public void clickFirstresult(){
        MobileElement searchElement = driver.findElement(MobileBy.id("edts.klik.android:id/tvTitle"));
        searchElement.click();
    }
}

