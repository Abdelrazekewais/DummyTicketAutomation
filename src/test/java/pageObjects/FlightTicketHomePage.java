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

public class FlightTicketHomePage extends BasePage {
    // Locate elements for Round trip in Flight tab
    private final By FlightRoundTripFromInput = By.xpath("//form[@id='flight_round']//input[@name='source[]']");
    private final By FlightRoundTripToInput = By.xpath("//form[@id='flight_round']//input[@name='destination[]']");
    private final By FlightRoundTripDeparture = By.xpath("//form[@id='flight_round']//input[@name='departure[]']");
    private final By FlightRoundTripReturn = By.xpath("//form[@id='flight_round']//input[@name='return[]']");
    private final By FlightRoundTripBuyTicketBTN = By.xpath("//form[@id='flight_round']//input[@type='submit']");
    private final By FlightRoundTripCurrentYear = By.xpath("//span[@class='ui-datepicker-year']");
    private final By previousButton = By.xpath("//a[@title='Prev']");
    private final By nextButton = By.xpath("//a[@title='Next']");
    // Locate elements for Multi trip in Flight tab
    private final By MultiTripRadioBtn = By.xpath("//input[@value='multicitymain']");
    private final By FlightMultiTripFromInput = By.xpath("//form[@id='flight_multitrip']//input[@name='source[]']");
    private final By FlightMultiTripToInput = By.xpath("//form[@id='flight_multitrip']//input[@name='destination[]']");
    private final By FlightMultiTripDeparture = By.xpath("//form[@id='flight_multitrip']//input[@name='departure[]']");
    private final By FlightMultiTripBuyTicketBTN = By.xpath("//form[@id='flight_multitrip']//input[@type='submit']");
    // Locate elements in Flight Tab Functionality
    By OneWayRadioBtn = By.xpath("//input[@value='onewaymain']");
    By FromInputField = By.xpath("(//input[@name='source[]'])[1]"); //label[text()= 'From']/following-sibling::input
    By ToInputField = By.xpath("(//input[@name='destination[]'])[1]");
    By DepartureInputField = By.xpath("(//input[@name='departure[]'])[1]");
    By SelectYear = By.cssSelector("select[aria-label='Select year']");
    By SelectMonth = By.cssSelector("select[aria-label='Select month']");
    By SelectDate = By.xpath("//tbody/tr/td");
    By ValidationErrorMessage = By.xpath("//small[@class='error text-danger']");
    By FlightTab = By.xpath("//a[normalize-space()='Flight']");
    By BuyTicketBTN = By.id("flight_oneway_btn");
    By RoundTripRadioBtn = By.xpath("//input[@type='radio' and @value='roundtripmain']");
    List<WebElement> lst = getElements(SelectDate);
    private By FlightMultiTripSelectYear = By.cssSelector("select[class ='ui-datepicker-year']");
    private By FlightMultiTripSelectMonth = By.cssSelector("select[class ='ui-datepicker-month']");
    private final By FlightMultiTripSelectDate = By.xpath("//div[@id='ui-datepicker-div']//a[@class='ui-state-default']");


    public FlightTicketHomePage(WebDriver driver) {
        super(driver);
    }

    public FlightTicketHomePage clickOneWayRadioBTN() {
        clickElement(OneWayRadioBtn);
        return this;
    }

    public FlightTicketHomePage setFromDate() throws IOException {
        info("Setting from date.");
        ZoomOut();
        SendKeys(FromInputField, readData("OneWayFlight.Flight-OneWayFrom"));
        return this;
    }

    public FlightTicketHomePage SelectRoundTripRadioBTN() {

        clickElement(RoundTripRadioBtn);
        return this;
    }

    public void SelectDataFromCalender() throws IOException, InterruptedException {
        info("Selecting date from calendar.");
        select = new Select(getElement(SelectYear));
        select.selectByVisibleText(readData("OneWayFlight.Flight-OneWayYear"));
        select = new Select(getElement(SelectMonth));
        select.selectByVisibleText(readData("OneWayFlight.Flight-OneWayMonth"));
        List<WebElement> lst = getElements(SelectDate);
        for (WebElement date : lst) {
            if (date.getText().equals(readData("OneWayFlight.Flight-OneWayDate"))) {
                date.click();
            }
        }
    }

    public FlightTicketHomePage setToDate() throws IOException {
        info("Setting trip destination.");
        SendKeys(ToInputField, readData("OneWayFlight.Flight-OneWayTo"));
        return this;
    }

    public FlightTicketHomePage setDepartureDate() throws IOException, InterruptedException {
        info("Setting departure date.");
        clickElement(DepartureInputField);
        SelectDataFromCalender();
        // SendKeys(InputDepartureValue, readData("OneWayFlight.Flight-OneWayDeparture"));
        return this;
    }

    public FlightTicketHomePage verifyFlightTabFunctionality() {
        info("Clicking Flight tab.");
        waitForElementToBeClickable(FlightTab);
        clickElement(FlightTab);
        Assert.assertTrue(getElement(FromInputField).isDisplayed());
        Assert.assertTrue(getElement(ToInputField).isDisplayed());
        Assert.assertTrue(getElement(DepartureInputField).isDisplayed());
        return this;
    }

    public void validateFromField() throws IOException {
        info("Setting source.");
        SendKeys(FromInputField, readData("OneWayFlight.Flight-OneWayFrom") + readData("AdditionalDetails.FirstName"));
        ElementIsNotDisplayed(ValidationErrorMessage);
    }

    public void validateToField() throws IOException {
        info("Setting destination.");
        SendKeys(ToInputField, readData("OneWayFlight.Flight-OneWayFrom") + readData("AdditionalDetails.FirstName"));
        ElementIsNotDisplayed(ValidationErrorMessage);
    }

    public void clickBuyDummyTicketButton() {
        info("Clicking dummy ticket button.");
        clickElement(BuyTicketBTN);
    }

    public void validateDepartureField() throws IOException {
        info("Selecting departure.");
        SendKeys(DepartureInputField, readData("AdditionalDetails.FirstName"));
        clickBuyDummyTicketButton();
        Assert.assertTrue(getElement(ValidationErrorMessage).isDisplayed(), "Validation message is displayed");
    }

    public void ByuTicketButtonFunctionality() {
        info("Clicking buy ticket button.");
        waitForElementToBeClickable(BuyTicketBTN);
        clickElement(BuyTicketBTN);
        waitForElementToBeVisible(ValidationErrorMessage);
        Assert.assertTrue(getElement(ValidationErrorMessage).isDisplayed(), "Validation message is displayed");
    }

    public FlightTicketHomePage setRoundTripFromDate() throws IOException {
        info("Setting source.");
        SendKeys(FlightRoundTripFromInput, readData("OneWayFlight.Flight-OneWayFrom"));
        return this;
    }

    public FlightTicketHomePage setRoundTripToDate() throws IOException {
        info("Setting destination.");
        SendKeys(FlightRoundTripToInput, readData("OneWayFlight.Flight-OneWayTo"));
        return this;
    }

    public FlightTicketHomePage setRoundTripDepartureDate() throws IOException {
        info("Setting departure.");
        clickElement(FlightRoundTripDeparture);
        // check the year firstly to know if the same or greater or less than the current year
        int CurrentYear = Integer.parseInt(getElement(FlightRoundTripCurrentYear).getText());
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
            CurrentYear = Integer.parseInt(getElement(FlightRoundTripCurrentYear).getText());
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

    public FlightTicketHomePage setRoundTripReturnDate() throws IOException {
        info("Selecting return date.");
        clickElement(FlightRoundTripReturn);
        // check the year firstly to know if the same or greater or less than the current year
        int CurrentYear = Integer.parseInt(getElement(FlightRoundTripCurrentYear).getText());
        int expectedYear = Integer.parseInt(readData("BuyTicketHotel.EndYear"));
        // check if the year is greater than the current year
        while (CurrentYear != expectedYear) {
            if (CurrentYear > expectedYear) {
                waitForElementToBeClickable(previousButton);
                clickElement(previousButton);
            } else if (CurrentYear < expectedYear) {
                waitForElementToBeClickable(nextButton);
                clickElement(nextButton);
            }
            CurrentYear = Integer.parseInt(getElement(FlightRoundTripCurrentYear).getText());
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

    public void clickRoundTripBuyDummyTicketButton() {

        clickElement(FlightRoundTripBuyTicketBTN);
    }

    // Locate elements for Multi trip in Flight tab
    public FlightTicketHomePage SelectMultiTripRadioBTN() {
        info("Selecting Multi trip ticket type.");
        clickElement(MultiTripRadioBtn);
        return this;

    }

    public FlightTicketHomePage setMultiTripFromDate() throws IOException {
        info("Setting source.");
        SendKeys(FlightMultiTripFromInput, readData("OneWayFlight.Flight-OneWayFrom"));
        return this;
    }

    public FlightTicketHomePage setMultiTripToDate() throws IOException {
        info("Setting destination.");
        SendKeys(FlightMultiTripToInput, readData("OneWayFlight.Flight-OneWayTo"));
        return this;
    }

    public FlightTicketHomePage setMultiTripDepartureDate() throws IOException {
        info("Selecting departure date.");
        clickElement(FlightMultiTripDeparture);
        // check the year firstly to know if the same or greater or less than the current year
        select = new Select(getElement(FlightMultiTripSelectYear));
        select.selectByVisibleText(readData("BuyTicketHotel.EndYear"));

        select = new Select(getElement(FlightMultiTripSelectMonth));
        select.selectByVisibleText(readData("BuyTicketHotel.StartMonth"));
        List<WebElement> lst = getElements(FlightMultiTripSelectDate);
        for (int i = 0; i < lst.size(); i++) {
            System.out.println("The size is: " + lst.size());
            WebElement freshDate = driver.findElements(By.xpath("//div[@id='ui-datepicker-div']//a[@class='ui-state-default']")).get(i);
            if (freshDate.getText().equals(readData("OneWayFlight.Flight-OneWayDate"))) {
                freshDate.click();
                break;  // Break after clicking
            }
        }
        return this;
    }

    public FlightTicketHomePage clickMultiTripBuyDummyTicketButton() {
        info("clicking buy ticket button.");
        clickElement(FlightMultiTripBuyTicketBTN);
        return this;
    }


}