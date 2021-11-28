package page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class EnuygunPage {

    public EnuygunPage() {

        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "(//a[@class='nav-link'])[1]")
    public WebElement ucakBiletiButon;

    @FindBy(id = "OriginInput")
    public WebElement neredenBox;

    @FindBy(xpath = "(//div[@class='suggestion_item'])[1]")
    public WebElement istanbul;

    @FindBy(id = "DestinationInput")
    public WebElement nereyeBox;

    @FindBy(xpath = "(//div[@class='suggestion_item'])[1]")
    public WebElement paris;

    @FindBy(xpath = "//input[@class='DateInput_input DateInput_input_1 DateInput_input__readOnly DateInput_input__readOnly_2']")
    public WebElement gidisTarihi;

    @FindBy(xpath = "(//td[@class='CalendarDay CalendarDay_1 CalendarDay__default CalendarDay__default_2'])[20]")
    public WebElement seciliTarih;

    @FindBy(xpath = "//button[@class='primary-btn block']")
    public WebElement ucuzBiletBulButon;

    @FindBy(xpath = "(//button[@class='action-select-btn tr btn btn-outline-success btn-sm'])[1]")
    public WebElement biletSecButonu;

    @FindBy(id = "birthDateDay_0")
    public WebElement dogumTarihiDropDown;

    @FindBy(id = "birthDateMonth_0")
    public WebElement dogumAyiDropDown;

    @FindBy(id = "birthDateYear_0")
    public WebElement dogumYiliDropDown;

    @FindBy(xpath = "//button[@class='btn btn-warning btn-lg js-reservation-btn later']")
    public WebElement rezervasyonButonu;


}
