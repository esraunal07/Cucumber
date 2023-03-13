package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.WebUniversityPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class WebUniversityStepdefinitions {

    WebUniversityPage webUniversityPage=new WebUniversityPage();
    String ilkSayfaWHD ;
    String ikinciSayfaWHD;

    @Then("Login Portal gorununcuye kadar asagi iner")
    public void login_portal_gorununcuye_kadar_asagi_iner() {

    }
    @Then("Login Portal butonuna tiklar")
    public void login_portal_butonuna_tiklar() {
        ilkSayfaWHD= Driver.getDriver().getWindowHandle();
        webUniversityPage.loginPortalElement.click();

    }
    @Then("acilan ikinci window'a gecer")
    public void acilan_ikinci_window_a_gecer() {
        ReusableMethods.switchToWindow("WebDriver | Login Portal");
        ikinciSayfaWHD=Driver.getDriver().getWindowHandle();

    }
    @Then("Username kutusuna deger yazdirir")
    public void username_kutusuna_deger_yazdirir() {
        webUniversityPage.usernameBox.sendKeys(ConfigReader.getProperty("webUniname"));

    }
    @Then("Passsword kutusune deger yazdirir")
    public void passsword_kutusune_deger_yazdirir() {
        webUniversityPage.passwordBox.sendKeys(ConfigReader.getProperty("webUnipassword"));

    }
    @Then("webUniversity login butonuna basar")
    public void web_university_login_butonuna_basar() {
        webUniversityPage.loginButton.click();

    }
    @Then("Popup'ta cikan yazinin {string} oldugunu test eder")
    public void popup_ta_cikan_yazinin_oldugunu_test_eder(String string) {
        String expectedAlertYazi = "validation failed";
        String actualAlertYazi = Driver.getDriver().switchTo().alert().getText();
        Assert.assertEquals(expectedAlertYazi,actualAlertYazi);
    }
    @Then("Ok diyerek Popup'i kapatir")
    public void ok_diyerek_popup_i_kapatir() {
        Driver.getDriver().switchTo().alert().accept();

    }
    @Then("Ilk sayfaya geri doner")
    public void ılk_sayfaya_geri_doner() {
        Driver.getDriver().switchTo().window(ilkSayfaWHD);

    }
    @Then("Ilk sayfaya donuldugunu test eder")
    public void ılk_sayfaya_donuldugunu_test_eder() {
        Assert.assertTrue(webUniversityPage.loginPortalElement.isDisplayed());


    }

    @And("tum sayfalari kapatir")
    public void tumSayfalariKapatir() {
        Driver.quitDriver();
    }
}
