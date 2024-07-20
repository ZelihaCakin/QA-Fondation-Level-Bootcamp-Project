package Pages;

import Base.BaseLibrary;
import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.By;

public class HomePage extends BaseLibrary {
    @Step("Hesabım Alanı Görüntüleme Kontrolü")

    public HomePage hesabimKontrol()
    {
        String value4 = driver.findElements(By.xpath("//*[@id='navbarDropdown1']")).get(1).getText();
        screenshot();
        Assert.assertEquals("Hesabım", value4);
        return this;
    }
    public HomePage facebookKontrol()
    {
        String value4 = driver.findElement (By.cssSelector("[class='_9axz']")).getText();
        screenshot();
        Assert.assertEquals("Facebook'a Giriş Yap", value4);
        return this;
    }

}
