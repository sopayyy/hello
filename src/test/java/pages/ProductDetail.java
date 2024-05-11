package pages;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;

import static pages.BasePage.driver;
public class ProductDetail {
    public void addCart (){
        MobileElement pluscartElement = driver.findElement(MobileBy.id("edts.klik.android:id/bvCart"));
        pluscartElement.click();
    }
    public void verifySubtotal () {
        MobileElement subtotalItemElement = driver.findElement(MobileBy.id("edts.klik.android:id/lbPrice"));
        subtotalItemElement.click();
    }
    public void clickCartDetail () {
        MobileElement flCartInfo = driver.findElement(MobileBy.id("edts.klik.android:id/flCart"));
        flCartInfo.click();
    }
}
