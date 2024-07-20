import Base.BaseTest;
import Pages.HomePage;
import Pages.LoginPage;
import Pages.RegisterPage;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Test;

public class UserTests extends BaseTest {
    LoginPage loginPage = new LoginPage();
    HomePage homePage = new HomePage();
    RegisterPage registerPage = new RegisterPage();

    @Test(description = "Başarılı Login Kullanıcı Giriş Kontrolü")
    @Severity(SeverityLevel.CRITICAL)
    public void loginSuccesful() throws InterruptedException {
        loginPage
                .emailDoldur(email)
                .passwordDoldur(password)
                .loginTikla();
        sleep(8000);
        homePage.hesabimKontrol();
    }
    @Test(description = "Hatalı Login Kullanıcı Giriş Kontrol")
    @Severity(SeverityLevel.CRITICAL)
    public void notValidLogin() throws InterruptedException {
        loginPage
                .emailDoldur(email)
                .passwordDoldur("aaaaaaaaa")
                .loginTikla();

        sleep(3000);
        loginPage.hataMesajiPenceresiKontrolu(errorMessage);
    }
    @Test(description = "Sistemde Kayıtlı Olmayan Email ile Kullanıcı Girişi")
    @Severity(SeverityLevel.CRITICAL)
    public void notValidWithEmail() throws InterruptedException {
        loginPage.emailDoldur("aaaaaaaaaaa@mail.com")
                .passwordDoldur(password)
                .loginTikla();
        sleep(3000);
        loginPage.hataMesajiPenceresiKontrolu(errorMessage);
    }
    @Test(description = "Bos Karakter Kontrolu")
    @Severity(SeverityLevel.CRITICAL)
    public void requiredBlankControl() throws InterruptedException {
        loginPage.emailDoldur("")
                .passwordDoldur("")
                .loginTikla();
        sleep(3000);
        loginPage.hataMesajiKontrolu(errorMessage2);
        loginPage.parolaHataMesajiKontrolu(errorMessage3);
        loginPage.emailDoldur(email)
                .loginTikla();
        sleep(3000);
        loginPage
                .parolaHataMesajiKontrolu(errorMessage3)
                .passwordDoldur(password)
                .loginTikla();
        sleep(7000);
        homePage.hesabimKontrol();
    }
    @Test(description = "Minumum Karakter Kontrolü")
    @Severity(SeverityLevel.CRITICAL)
    public void minControl() throws InterruptedException {
        loginPage.emailDoldur("1")
                .passwordDoldur("2")
                .loginTikla();
        sleep(3000);
        loginPage.hataMesajiKontrolu(errorMessage2);
        loginPage.emailClear();
        loginPage.passwordClear();
        loginPage.emailDoldur(email)
                .passwordDoldur("2")
                .loginTikla();
        sleep(3000);
        loginPage.hataMesajiPenceresiKontrolu(errorMessage);
        sleep(3000);
    }
    @Test(description = "Maximum Karakter Kontrolü")
    @Severity(SeverityLevel.CRITICAL)
    public void maxControl() throws InterruptedException {
        loginPage.emailDoldur("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa")
                .passwordDoldur(password);
        sleep(3000);
        loginPage.loginTikla();
        Thread.sleep(3000);
        loginPage.hataMesajiKontrolu(errorMessage2);
        sleep(3000);
        loginPage.emailClear()
                .passwordClear()
                .emailDoldur(email)
                .loginTikla();
        sleep(3000);
        homePage.hesabimKontrol();
        sleep(3000);
    }
    @Test(description = "Facebook ile Bağlan butonu Kontrolü")
    @Severity(SeverityLevel.CRITICAL)
    public void facebookileBağlan() {
        loginPage.butonaTikla();
        homePage.facebookKontrol();
    }
    @Test(description = "Giriş Yap Sayfasından Üye Ol Sayfasına Yönlendirme Kontrolü")
    @Severity(SeverityLevel.CRITICAL)
    public void uyeOlYonlendirme() throws InterruptedException {
        loginPage.uyeOlTikla();
        sleep(3000);
        loginPage.registerPnceresiKontrolu("Üye ol");
    }
    @Test(description = "Kayıtlı kullanıcı ile Üye Olma Kontrolü")
    @Severity(SeverityLevel.CRITICAL)
    public void registerNotValid() throws InterruptedException {
        registerPage
                .registerTiklaL();
        sleep(3000);
        registerPage
                .adDoldur(name)
                .soyadDoldur(surname)
                .emailDoldurU(email)
                .sifreDoldurU(password)
                .phoneDoldur(phonenumber)
                .check()
                .registerTikla();
        sleep(3000);
        registerPage.hataMesajiPenceresiKontroluR(errorMessage4);
        sleep(3000);
    }
}
