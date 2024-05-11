package pages;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;

import static pages.BasePage.driver;

public class Checkout {
    public void PilihPengiriman (){
        MobileElement PilihPengiriman = driver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().text(\"Pilih Pengiriman\")"));
        PilihPengiriman.click();
    }
    public void ClickLengkapiAlamatButton (){
        MobileElement LengkapiAlamat = driver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().text(\"Lengkapi Alamat\")"));
        LengkapiAlamat.click();
    }
    public void TambahkanAlamatPopup(){
        MobileElement TambahkanAlamatPopup = driver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().text(\"Tambahkan Alamat\")"));
        TambahkanAlamatPopup.click();
    }
    public void GunakanLokasiSaatIni(){
        MobileElement GunakanLokasiSaatIni = driver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().text(\"Gunakan lokasi saat ini\")"));
        GunakanLokasiSaatIni.click();
    }
    public void PilihTitikLokasi(){
        MobileElement PilihTitikLokasi = driver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().text(\"Pilih Titik Lokasi\")"));
        PilihTitikLokasi.click();
    }

    public void ClickPengirimanReguler(){
        MobileElement ClickPengirimanReguler = driver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().text(\"Regular (Rp 9.000) Rp 5.000\")"));
        ClickPengirimanReguler.click();
    }
    public void ClickKonfirmasi(){
        MobileElement ClickKonfirmasi = driver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().text(\"Konfirmasi\")"));
        ClickKonfirmasi.click();
    }
    public void OpenTotalHarga(){
        MobileElement tvTotal = driver.findElement(MobileBy.id("edts.klik.android:id/tvTotal"));
        tvTotal.click();
    }
    public String getShippingFee() {
        MobileElement shippingFeeElement = driver.findElement(MobileBy.id("edts.klik.android:id/tvDeliveryFee"));
        return shippingFeeElement.getText();
    }
    public String getProductPrice() {
        MobileElement productPriceElement = driver.findElement(MobileBy.id("edts.klik.android:id/tvPrice"));
        return productPriceElement.getText();
    }
    public String getTotalPrice() {
        MobileElement totalPriceElement = driver.findElement(MobileBy.id("edts.klik.android:id/tvPay"));
        return totalPriceElement.getText();
    }

}
