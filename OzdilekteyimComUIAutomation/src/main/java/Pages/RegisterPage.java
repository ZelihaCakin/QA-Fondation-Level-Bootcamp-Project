package Pages;

import Base.BaseLibrary;
import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.By;

public class RegisterPage extends BaseLibrary {

    @Step("Login sayfasında Üye ol butonuna tıklanır.")
    public Pages.RegisterPage registerTiklaL() {
        driver.findElement(By.cssSelector("[class='button register-button orange full login-button']")).click();
        return this;
    }

    @Step("Adınız Alanı Doldurulur")
    public Pages.RegisterPage adDoldur(String name) {
        driver.findElement(By.name("firstname")).sendKeys(name);
        return this;
    }

    @Step("Soyadınız Alanı Doldurulur")
    public Pages.RegisterPage soyadDoldur(String surname) {
        driver.findElement(By.name("lastname")).sendKeys(surname);
        return this;
    }

    @Step("E - Posta Adresiniz Alanı Doldurulur")
    public Pages.RegisterPage emailDoldurU(String email) {
        driver.findElement(By.name("email")).sendKeys(email);
        return this;
    }

    @Step("Parola Alanı Doldurulur")
    public Pages.RegisterPage sifreDoldurU(String password) {
        driver.findElement(By.name("password")).sendKeys(password);
        return this;
    }

    @Step("Cep Telefonu Alanı Doldurulur")
    public Pages.RegisterPage phoneDoldur(String phonenumber) {
        driver.findElement(By.cssSelector("[formcontrolname='phoneNumber']")).sendKeys(phonenumber);
        return this;
    }

    @Step(" Kullanım koşulları ile gizlilik ve kişisel verilerin korunması politikası onaylanır")
    public Pages.RegisterPage check() {
        driver.findElements(By.cssSelector("[class='form-check-label']")).get(1).click();
        return this;
    }
    @Step(" Üye ol butonuna tıklanır.")
    public Pages.RegisterPage registerTikla() {
        driver.findElement(By.cssSelector("[class='btn btn-block btn-primary']")).click();
        return this;
    }
    @Step("Hata Mesajı Penceresi Kontrolü: {text}")
    public RegisterPage hataMesajiPenceresiKontroluR(String text) {
        String value = driver.findElement(By.xpath("/html/body/ozd-root/cx-storefront/cx-global-message")).getText();
        screenshot();
        Assert.assertEquals(text, value);
        return this;
    }
}

