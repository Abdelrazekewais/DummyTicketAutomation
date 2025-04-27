package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.io.IOException;
import java.util.List;

import static utilities.Log.info;
import static utilities.readDataFromJson.readData;

public class HotelTicketHomePage extends BasePage {
    //Locators in Home Page Tab Hotel
    private final By hotelTab = By.xpath("//a[@href='/hotel']");
    private final By cityField = By.xpath("//input[@placeholder='City']");
    private final By checkInDate = By.xpath("//input[@placeholder='Check-in']");
    private final By checkOutDate = By.xpath("//input[@placeholder='Check-out']");
    private final By buyDummyTicketButton = By.xpath("//form[@id='hotel_form']//input[@value='Buy Dummy Ticket']");
    private final By hotelTabTitle = By.xpath("//h1[contains(text(),'Hotel')]");
    private final By hotelTabLogo = By.xpath("//img[@alt='logo']");
    private final By HotelTabCheckInCurrentYear = By.xpath("//span[@class='ui-datepicker-year']");
    private final By HotelTabCheckInCurrentMonth = By.xpath("//span[@class='ui-datepicker-month']");
    private final By previousButton = By.xpath("//a[@title='Prev']");
    private final By nextButton = By.xpath("//a[@title='Next']");
    private final By CairoSuggestedOption = By.xpath("//ul[@class='suggestions-cities-list']//li//p[text()='Cairo']");
    private final By HotelTabCityField = By.name("city[]");
    private final By HotelTabCheckInField = By.name("checkin[]");
    private final By HotelTabCheckoutField = By.name("checkout[]");
    private final By SelectMonth = By.cssSelector("select[aria-label='Select month']");
    private final By SelectDate = By.xpath("//tbody/tr/td/a");

    public HotelTicketHomePage(WebDriver driver) {
        super(driver);
    }
    Select select;
    public HotelTicketHomePage setHotelTabCityField() throws IOException {
        info("Providing city.");
        try {
            SendKeys(HotelTabCityField, "Cai");
            waitForElementToBeVisible(CairoSuggestedOption);
            clickElement(CairoSuggestedOption);
        } catch (Exception e) {
            getElement(HotelTabCityField).clear();
            SendKeys(HotelTabCityField, "Cai");
            waitForElementToBeVisible(CairoSuggestedOption);
            clickElement(CairoSuggestedOption);
        }
        return this;
    }


    public HotelTicketHomePage clickHotelTab() {
        info("Clicking hotel tab.");
        clickElement(hotelTab);
        return this;
    }

    private void clickCheckInDate() {
        info("Setting check in date.");
        clickElement(HotelTabCheckInField);
    }


    public HotelTicketHomePage setCheckInDate() throws IOException {
        info("Setting check in date.");
        clickCheckInDate();
        // check the year firstly to know if the same or greater or less than the current year
        int CurrentYear = Integer.parseInt(getElement(HotelTabCheckInCurrentYear).getText());
        int expectedYear = Integer.parseInt(readData("BuyTicketHotel.StartYear"));
// check if the year is greater than the current year
        while (CurrentYear != expectedYear) {
            if (CurrentYear > expectedYear) {
                waitForElementToBeClickable(previousButton);
                clickElement(previousButton);
            } else if (CurrentYear < expectedYear) {
                waitForElementToBeClickable(nextButton);
                clickElement(nextButton);
            }
            CurrentYear = Integer.parseInt(getElement(HotelTabCheckInCurrentYear).getText());
        }
        select = new Select(getElement(SelectMonth));
        select.selectByVisibleText(readData("BuyTicketHotel.StartMonth"));
        List<WebElement> lst = getElements(SelectDate);
        for (int i = 0; i < lst.size(); i++) {
            WebElement freshDate = driver.findElements(By.xpath("//tbody/tr/td/a")).get(i);
            if (freshDate.getText().equals(readData("BuyTicketHotel.StartDate"))) {
                freshDate.click();
                break;  // Break after clicking
            }
        }
        return this;
    }
    private void clickCheckOutDate() {
        info("Setting check out date.");
        clickElement(HotelTabCheckoutField);
    }
    public HotelTicketHomePage setCheckOutDate() throws IOException {
        info("Setting check out date.");
        clickCheckOutDate();
        // check the year firstly to know if the same or greater or less than the current year
        int CurrentYear = Integer.parseInt(getElement(HotelTabCheckInCurrentYear).getText());
        int expectedYear = Integer.parseInt(readData("BothOneWayFlight.CheckOutYear"));
// check if the year is greater than the current year
        while (CurrentYear != expectedYear) {
            if (CurrentYear > expectedYear) {
                waitForElementToBeClickable(previousButton);
                clickElement(previousButton);
            } else if (CurrentYear < expectedYear) {
                waitForElementToBeClickable(nextButton);
                clickElement(nextButton);
            }
            CurrentYear = Integer.parseInt(getElement(HotelTabCheckInCurrentYear).getText());
        }
        select = new Select(getElement(SelectMonth));
        select.selectByVisibleText(readData("BuyTicketHotel.StartMonth"));
        List<WebElement> lst = getElements(SelectDate);
        for (int i = 0; i < lst.size(); i++) {
            WebElement freshDate = driver.findElements(By.xpath("//tbody/tr/td/a")).get(i);
            if (freshDate.getText().equals(readData("BuyTicketHotel.EndDate"))) {
                freshDate.click();
                break;  // Break after clicking
            }
        }

        return this;
    }

    public HotelTicketHomePage clickHotelBuyDummyTicketButton(){
        info("Clicking buy ticket button.");
        clickElement(buyDummyTicketButton);
        return this;
    }

    public HotelTicketHomePage HotelTabAssertions() {
        info("Validating hotel tab.");
        Assert.assertTrue(getElement(HotelTabCityField).isDisplayed());
        Assert.assertTrue(getElement(HotelTabCheckInField).isDisplayed());
        Assert.assertTrue(getElement(HotelTabCheckoutField).isDisplayed());
        return this;
    }
    public void verifyHotelTabTitleDisplayed() {
        info("Validating hotel tab title is displayed.");
        Assert.assertTrue(elementIsDisplayed(hotelTabTitle), "Hotel tab title is not displayed");
    }

    public void verifyHotelTabLogoDisplayed() {
        info("Validating Logo is displayed.");
        Assert.assertTrue(elementIsDisplayed(hotelTabLogo), "Hotel tab logo is not displayed");
    }
}
