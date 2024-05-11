package testSuite;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BasePage;
import pages.HomePage;
import pages.Login;
import pages.searchProduct;
import pages.ProductDetail;
import pages.Checkout;

import java.util.concurrent.TimeUnit;

public class HomePageTest extends BasePage {
    private final Login loginPage = new Login();
    private final searchProduct searchProduct = new searchProduct();
    private final ProductDetail ProductDetail = new ProductDetail();
    private final Checkout Checkout = new Checkout();

    @Test
    public void testPurchaseFlow() {
        HomePage HomePage = new HomePage(new BasePage().getMobileDriver());
        HomePage.clickAkunButton();

        // LOGIN
        loginPage.clickMasukButton();
        loginPage.clickGabungPopup();
        loginPage.User("081382631822");
        loginPage.Lanjutkan();
        loginPage.Password("123ABC");
        loginPage.Lanjutkan();

        // SEARCH step
        HomePage.clickhomebar();
        HomePage.clicksearchinput();
        searchProduct.clickinputsearch();
        searchProduct.setInputFieldsearch("Kopi");
        searchProduct.clicksuggestkeyword();
        searchProduct.verifyresult();

        // Open product detail page
        searchProduct.clickFirstresult();
        // Add to cart
        ProductDetail.addCart();
        ProductDetail.verifySubtotal();
        ProductDetail.clickCartDetail();

        // Verify product price
        String expectedProductPrice = "Rp 6.600";
        String actualProductPrice = Checkout.getProductPrice();

        System.out.println("Actual product price: " + actualProductPrice);
        Assert.assertEquals(actualProductPrice.trim(), expectedProductPrice.trim(), "Product price is not as expected");

        Checkout.PilihPengiriman();
        Checkout.ClickPengirimanReguler();
        Checkout.ClickKonfirmasi();
        Checkout.OpenTotalHarga();
        // Verify shipping fee
        String expectedShippingFee = "Rp 5.000";
        String actualShippingFee = Checkout.getShippingFee();
        Assert.assertEquals(actualShippingFee, expectedShippingFee, "Shipping fee is not as expected");

        // Calculate and verify total price
        int productPrice = extractPriceValue(actualProductPrice);
        int shippingFee = extractPriceValue(actualShippingFee);
        int expectedTotalPrice = productPrice + shippingFee;
        String actualTotalPrice = Checkout.getTotalPrice();
        // Remove non-numeric characters from expected and actual total prices
        String expectedTotalPriceStr = String.valueOf(expectedTotalPrice);
        String expectedTotalPriceStripped = expectedTotalPriceStr.replaceAll("[^\\d]", "");
        String actualTotalPriceStripped = actualTotalPrice.replaceAll("[^\\d]", "");

        // Assert that the stripped total prices match
        Assert.assertEquals(actualTotalPriceStripped, expectedTotalPriceStripped, "Total price is not as expected");

        try {
            TimeUnit.SECONDS.sleep(5); // Sleep for 3 seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String pageSource = driver.getPageSource();
        System.out.println("Page Source:");
        System.out.println(pageSource);


    }
    // Helper method to extract price value from string
    private int extractPriceValue(String priceString) {
        return Integer.parseInt(priceString.replaceAll("[^\\d]", ""));
    }

    // Helper method to format integer price value to string format
    private String formatPrice(int price) {
        return "Rp " + price;
    }
}
