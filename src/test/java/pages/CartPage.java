package pages;

import config.CommonAppiumTest;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import pageObjectRepository.CartPageObjectRepository;

public class CartPage extends CommonAppiumTest {
    CartPageObjectRepository cartPageObjectRepository = new CartPageObjectRepository();

    public CartPage(AppiumDriver<MobileElement> driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), cartPageObjectRepository);
    }

    public CartPage assertDefaultCartUI() {
        System.out.println("Asserting default UI on Cart Page");
        Assert.assertEquals(cartPageObjectRepository.title.getText(), cartPageObjectRepository.getTitleText(),
                "Title text is incorrect!");
        Assert.assertEquals(cartPageObjectRepository.description.getText(), cartPageObjectRepository.getDescriptionText(),
                "Description text is incorrect!");
        return this;
    }
}
