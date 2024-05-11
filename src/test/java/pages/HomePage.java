package pages;

import config.CommonAppiumTest;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import pageObjectRepository.HomePageObjectRepository;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;

public class HomePage extends CommonAppiumTest {
    HomePageObjectRepository homePageObjectRepository = new HomePageObjectRepository();

    public HomePage(AppiumDriver<MobileElement> driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), homePageObjectRepository);
    }

    public void clickAkunButton() {
        MobileElement akunButton = (MobileElement) driver.findElement(MobileBy.id("edts.klik.android:id/clAccount"));
        akunButton.click();
    }

    public void clicksearchinput() {
        MobileElement searchButton = (MobileElement) driver.findElement(MobileBy.id("edts.klik.android:id/clSearch"));
        searchButton.click();
    }
    public void clickhomebar() {
        MobileElement HomeButton = (MobileElement) driver.findElement(MobileBy.id("edts.klik.android:id/clHome"));
        HomeButton.click();
    }

}
