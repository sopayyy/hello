package pages;

import config.CommonAppiumTest;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import pageObjectRepository.LoginPageObjectRepository;

import static pages.BasePage.driver;

public class Login{
    LoginPageObjectRepository loginPageObjectRepo = new LoginPageObjectRepository();

    public void clickMasukButton() {
        MobileElement masukButton = (MobileElement) driver.findElement(MobileBy.id("edts.klik.android:id/bvSubmit"));
        masukButton.click();
    }
    public void clickGabungPopup() {
        MobileElement gabungButton = (MobileElement) driver.findElement(MobileBy.id("edts.klik.android:id/tvJoin"));
        gabungButton.click();
    }
    public void Lanjutkan() {
        MobileElement LanjutkanButton = driver.findElement(MobileBy.id("edts.klik.android:id/bvLogin"));
        LanjutkanButton.click();
    }
    public void User(String phoneNumber) {
        MobileElement inputField = driver.findElement(MobileBy.className("android.widget.EditText"));
        inputField.sendKeys(phoneNumber);
    }
    public void Password(String pass) {
        MobileElement passField = driver.findElement(MobileBy.className("android.widget.EditText"));
        passField.sendKeys(pass);
    }
    public void VerifySuccessLogin() {
        MobileElement VerifySuccessLogin = driver.findElement(MobileBy.id("edts.klik.android:id/tvName"));
        VerifySuccessLogin.isDisplayed();
    }





}
