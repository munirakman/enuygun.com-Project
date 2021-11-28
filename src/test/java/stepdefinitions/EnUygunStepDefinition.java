package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import page.EnuygunPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;


public class EnUygunStepDefinition {

    EnuygunPage enuygun = new EnuygunPage();
    Actions actions = new Actions(Driver.getDriver());


    @Given("kullanici {string} sayfasina gider")
    public void kullanici_sayfasina_gider(String String) {
        Driver.getDriver().get(ConfigReader.getProperty("enuygunUrl"));
    }

    @When("ucak bileti bolumune tiklar")
    public void ucak_bileti_bolumune_tiklar() {
        enuygun.ucakBiletiButon.click();
    }

    @And("nereden box'inda istanbul'a tiklar")
    public void nereden_box_inda_istanbul_a_tiklar() throws InterruptedException {

        Thread.sleep(2000);
        enuygun.neredenBox.click();
        Thread.sleep(2000);
        enuygun.neredenBox.sendKeys("istanbul");
        Thread.sleep(2000);
        enuygun.istanbul.click();

    }

    @And("nereye box'inda Paris'e tiklar")
    public void nereye_box_inda_paris_e_tiklar() throws InterruptedException {
        enuygun.nereyeBox.sendKeys("paris");
        Thread.sleep(2000);
        enuygun.paris.click();

    }

    @And("gidis tarihine gecerli tarihi girer")
    public void gidis_tarihine_gecerli_tarihi_girer() throws InterruptedException {
        Thread.sleep(2000);
        enuygun.gidisTarihi.click();
        Thread.sleep(1000);
        enuygun.seciliTarih.click();
    }

    @And("ucuz bilet bul butonuna tiklar")
    public void ucuz_bilet_bul_butonuna_tiklar() {
        enuygun.ucuzBiletBulButon.click();
    }

    @And("listelenen ucuslardan birinde sec butonuna tiklar")
    public void listelenenUcuslardanBirindeSecButonunaTiklar() {
        ReusableMethods.waitFor(5);
        // ReusableMethods.waitForPageToLoad(3);
        enuygun.biletSecButonu.click();

    }

    @And("ilgili kutulara {string} {string} {string} {string} bilgileri girer")
    public void ilgili_kutulara_bilgileri_girer(String eposta, String ceptelefonu, String ad, String soyad) {

        ReusableMethods.waitForVisibility(enuygun.dogumTarihiDropDown,3);
        actions.
                sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(eposta)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(ceptelefonu)
                .sendKeys(Keys.TAB)
                .sendKeys(ad)
                .sendKeys(Keys.TAB)
                .sendKeys(soyad)
                .perform();
    }

    @And("dogum tarihi dropdown menusunden girer")
    public void dogum_tarihi_dropdown_menusunden_girer() {
        enuygun.dogumTarihiDropDown.click();
        Select select = new Select(enuygun.dogumTarihiDropDown);
        select.selectByVisibleText("04");
        Select select1 = new Select(enuygun.dogumAyiDropDown);
        select1.selectByValue("01");
        Select select2 = new Select(enuygun.dogumYiliDropDown);
        select2.selectByValue("1998");
        ReusableMethods.waitFor(2);


    }


    @And("bu bileti sonrasi icin ayir butonuna basar")
    public void bu_bileti_sonrasi_icin_ayir_butonuna_basar() {

        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript ("window.scrollBy (0,1100)");
        ReusableMethods.waitForVisibility(enuygun.rezervasyonButonu,3);
        ReusableMethods.waitFor(2);
        enuygun.rezervasyonButonu.click(); // site otomatik olarak hemen rezervasyon yaptığından, bu locate'i test sürecim boyunca çalıştırmadım. "//" içerisinde yer aldı. Ancak doğru locate alındı.
    }


    @And("sayfa kapanir")
    public void sayfaKapanir() {
        Driver.closeDriver();
    }
}
