package Pages;

import Base.BaseLibrary;
import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.By;

public class LoginPage extends BaseLibrary {
    @Step("Email Alanı Doldurulur")
    public LoginPage emailDoldur(String email) {
        driver.findElement(By.cssSelector("[formcontrolname='userId']")).sendKeys(email);
        return this;
    }
    @Step("Parola Alanı Doldurulur")
    public LoginPage passwordDoldur(String password) {
        driver.findElement(By.cssSelector("[formcontrolname='password']")).sendKeys(password);
        screenshot();
        return this;
    }
    @Step("Login Butonuna Tıklanır")
    public LoginPage loginTikla() {
        driver.findElement(By.xpath("//*[contains(text(),'GİRİŞ YAP')]")).click();
        return this;
    }
    @Step("Hata Mesajı Penceresi Kontrolü: {text}")
    public LoginPage hataMesajiPenceresiKontrolu(String text) {
        String value = driver.findElement(By.xpath("/html/body/ozd-root/cx-storefront/cx-global-message")).getText();
        screenshot();
        Assert.assertEquals(text, value);
        return this;
    }
    @Step("Hata Mesajı Kontrolü: {text}")
    public LoginPage hataMesajiKontrolu(String text) {
        String value = driver.findElement(By.cssSelector("[class='invalid-feedback'] span")).getText();
        screenshot();
        Assert.assertEquals(text, value);
        return this;
    }
    @Step("Parola Hata Mesajı Kontrolu: {text}")
    public LoginPage parolaHataMesajiKontrolu(String text) {
        String value = driver.findElement(By.xpath("/html/body/ozd-root/cx-storefront/main/cx-page-layout/cx-page-slot[1]/ozd-custom-login/div/div[2]/form/div[2]/label/span")).getText();
        screenshot();
        Assert.assertEquals(text, value);
        return this;
    }
    @Step("Email Alanı İçeriği Temizlenir")
    public LoginPage emailClear() {
        driver.findElement(By.cssSelector("[formcontrolname='userId']")).clear();
        return this;
    }
    @Step("Password İçeriği Temizlenir")
    public LoginPage passwordClear() {
        driver.findElement(By.cssSelector("[formcontrolname='password']")).clear();
        return this;
    }
    @Step("Facebook ile Bağlan butonuna tıklanır.")
    public LoginPage butonaTikla() {
        driver.findElement(By.cssSelector("[class=\"button full login-facebook\"]")).click();
        return this;
    }
    @Step("Üye ol butonuna kontrolü.")
    public LoginPage uyeOlTikla() {
        driver.findElement(By.cssSelector("[class='button register-button orange full login-button']")).click();
        return this;
    }
    @Step("Register Penceresi Kontrolü: {text}")
    public LoginPage registerPnceresiKontrolu(String text) {
        String value = driver.findElement(By.cssSelector("[class='title']")).getText();
        screenshot();
        Assert.assertEquals("Üye Ol", value);
        return this;
    }
}
