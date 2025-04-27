package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.io.IOException;
import java.util.List;

import static utilities.Log.info;
import static utilities.readDataFromJson.readData;

public class BothTicketHomePage extends BasePage {
    By BothTabRadioBTN = By.xpath("//input[@value='onewayfh']");
    By BothOneWayFrom = By.xpath("//form[@id='both_oneway']//input[@name='source[]']");
    By BothOneWayTo = By.xpath("//form[@id='both_oneway']//input[@name='destination[]']");
    By BothDepartureDate = By.xpath("//form[@id='both_oneway']//input[@name='departure[]']");
    By SelectYear = By.xpath("//select[@aria-label='Select year']");
    By SelectMonth = By.xpath("//select[@aria-label='Select month']");
    By SelectDate = By.xpath("//table[@class='ui-datepicker-calendar']//a[@class='ui-state-default']");
    By BothOneWayCityField = By.xpath("//form[@id='both_oneway']//input[@name='city[]']");
    By BothOneWayCityFieldList = By.xpath("//form[@id='both_oneway']//li//p[text()='Cairo']");
    By BothOneWayCheckIn = By.xpath("//form[@id='both_oneway']//input[@name='checkin[]']");
    By BothOneWayHotelCheckInCurrentYear = By.xpath("//div[@id='ui-datepicker-div']//span[@class='ui-datepicker-year']");
    By BothOneWayHotelCheckInSelectMonth = By.xpath("//select[@aria-label='Select month']");
    By BothOneWayHotelCheckInSelectDate = By.xpath("//table[@class='ui-datepicker-calendar']//a[@class='ui-state-default']");
    By BothOneWayCheckOut = By.xpath("//form[@id='both_oneway']//input[@name='checkout[]']");
    By BothOneWayHotelCheckOutCurrentYear = By.xpath("//div[@id='ui-datepicker-div']//span[@class='ui-datepicker-year']");
    By BothOneWayHotelCheckOutSelectMonth = By.xpath("//select[@aria-label='Select month']");
    By BothOneWayHotelCheckOutSelectDate = By.xpath("//table[@class='ui-datepicker-calendar']//a[@class='ui-state-default']");
    By BothBuyDummyTicketButton = By.xpath("//form[@id='both_oneway']//input[@value='Buy Dummy Ticket']");
    By BothCheckInnextButton = By.xpath("//div[@id='ui-datepicker-div']//a[@title='Next']");
    By BothCheckInpreviousButton = By.xpath("//div[@id='ui-datepicker-div']//a[@title='Prev']");

    // Locate elements in Both tab Round Trip
    By BothRoundTripRadioBTN = By.xpath("//div[@id='twotabtabtthree']//input[@value='roundtripfh']");
    By BothRoundTripFrom = By.xpath("//form[@id='both_round']//input[@name='source[]']");
    By BothRoundTripTo = By.xpath("//form[@id='both_round']//input[@name='destination[]']");
    By BothRoundTripDepartureDate = By.xpath("//form[@id='both_round']//input[@name='departure[]']");
    By BothRoundTripReturnDate = By.xpath("//form[@id='both_round']//input[@name='return[]']");
    By RoundTripSelectYear = By.xpath("//select[@aria-label='Select year']");
    By RoundTripSelectMonth = By.xpath("//select[@aria-label='Select month']");
    By CurrentYear = By.xpath("//div[@id='ui-datepicker-div']//span[@class='ui-datepicker-year']");
    By RoundTripSelectDate = By.xpath("//table[@class='ui-datepicker-calendar']//a[@class='ui-state-default']");
    By BothRoundTripCityField = By.xpath("//form[@id='both_round']//input[@name='city[]']");
    By BothRoundTripCityFieldList = By.xpath("//form[@id='both_round']//li//p[text()='Cairo']");
    By BothRoundTripCheckIn = By.xpath("//form[@id='both_round']//input[@name='checkin[]']");
    By BothRoundTripHotelCheckInCurrentYear = By.xpath("//div[@id='ui-datepicker-div']//span[@class='ui-datepicker-year']");
    By BothRoundTripHotelCheckInSelectMonth = By.xpath("//select[@aria-label='Select month']");
    By BothRoundTripHotelCheckInSelectDate = By.xpath("//table[@class='ui-datepicker-calendar']//a[@class='ui-state-default']");
    By BothRoundTripCheckOut = By.xpath("//form[@id='both_round']//input[@name='checkout[]']");
    By BothRoundTripHotelCheckOutCurrentYear = By.xpath("//div[@id='ui-datepicker-div']//span[@class='ui-datepicker-year']");
    By BothRoundTripHotelCheckOutSelectMonth = By.xpath("//select[@aria-label='Select month']");
    By BothRoundTripHotelCheckOutSelectDate = By.xpath("//table[@class='ui-datepicker-calendar']//a[@class='ui-state-default']");
    By BothRoundTripBuyDummyTicketButton = By.xpath("//form[@id='both_round']//input[@value='Buy Dummy Ticket']");
    By BothRoundTripCheckInNextButton = By.xpath("//div[@id='ui-datepicker-div']//a[@title='Next']");
    By BothRoundTripCheckInPreviousButton = By.xpath("//div[@id='ui-datepicker-div']//a[@title='Prev']");

    // Locate elements for Both tickets Multi trip
    By BothMultiTripRadioBTN = By.xpath("//div[@id='twotabtabtthree']//input[@value='multicityfh']");
    By BothMultiTripFrom = By.xpath("//form[@id='both_multycity']//input[@name='source[]']");
    By BothMultiTripTo = By.xpath("//form[@id='both_multycity']//input[@name='destination[]']");
    By BothMultiTripDepartureDate = By.xpath("//form[@id='both_multycity']//input[@name='departure[]']");
    By SelectMultiTripYear = By.xpath("//select[@aria-label='Select year']");
    By SelectMultiTripMonth = By.xpath("//select[@aria-label='Select month']");
    By BothMultiTripCityField = By.xpath("//form[@id='both_multycity']//input[@name='city[]']");
    By BothMultiTripCityFieldList = By.xpath("//form[@id='both_multycity']//li//p[text()='Cairo']");
    By BothMultiTripCheckIn = By.xpath("//form[@id='both_multycity']//input[@name='checkin[]']");
    By BothMultiTripHotelCheckInCurrentYear = By.xpath("//div[@class='ui-datepicker-title']//span[@class='ui-datepicker-year']");
    By BothMultiTripHotelCheckInSelectMonth = By.xpath("//select[@aria-label='Select month']");
    By BothMultiTripHotelCheckInSelectDate = By.xpath("//table[@class='ui-datepicker-calendar']//a[@class='ui-state-default']");
    By BothMultiTripCheckOut = By.xpath("//form[@id='both_multycity']//input[@name='checkout[]']");
    By BothMultiTripHotelCheckOutCurrentYear = By.xpath("//div[@class='ui-datepicker-title']//span[@class='ui-datepicker-year']");
    By BothMultiTripHotelCheckOutSelectMonth = By.xpath("//select[@aria-label='Select month']");
    By BothMultiTripHotelCheckOutSelectDate = By.xpath("//table[@class='ui-datepicker-calendar']//a[@class='ui-state-default']");
    By BothMultiTripBuyDummyTicketButton = By.xpath("//form[@id='both_multycity']//input[@value='Buy Dummy Ticket']");
    By BothMultiTripCheckInNextButton = By.xpath("//div[@id='ui-datepicker-div']//a[@title='Next']");
    By BothMultiTripCheckInPreviousButton = By.xpath("//div[@id='ui-datepicker-div']//a[@title='Prev']");

    public BothTicketHomePage(WebDriver driver) {
        super(driver);
    }

    // Methods for Both tab One Way
    public BothTicketHomePage clickBothTabRadioBTN() throws IOException {
        clickElement(BothTabRadioBTN);
        return this;
    }

    public BothTicketHomePage setBothOneWayFrom() throws IOException {
        SendKeys(BothOneWayFrom, readData("BothOneWayFlight.From"));
        return this;
    }

    public BothTicketHomePage setBothOneWayTo() throws IOException {
        SendKeys(BothOneWayTo, readData("BothOneWayFlight.To"));
        return this;
    }

    public BothTicketHomePage setBothDepartureDate() throws IOException {
        clickElement(BothDepartureDate);
        select = new Select(getElement(SelectYear));
        select.selectByVisibleText(readData("BothOneWayFlight.DepartureYear"));
        select = new Select(getElement(SelectMonth));
        select.selectByVisibleText(readData("BothOneWayFlight.DepartureMonth"));

        List<WebElement> dates = getElements(SelectDate);
        for (int i = 0; i < dates.size(); i++) {
            WebElement freshDate = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//a[@class='ui-state-default']")).get(i);
            if (freshDate.getText().equals(readData("BothOneWayFlight.DepartureDate"))) {
                freshDate.click();
                break;
            }
        }
        return this;
    }

    public BothTicketHomePage setBothOneWayCityField() throws IOException {
        SendKeys(BothOneWayCityField, readData("BothOneWayFlight.City"));
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//form[@id='both_oneway']//ul[@class='suggestions-cities-list']")));
        waitForElementToBeClickable(BothOneWayCityFieldList);

        List<WebElement> suggestions = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//form[@id='both_oneway']//ul[@class='suggestions-cities-list']//li//div//p")));
        for (WebElement suggestion : suggestions) {
            if (suggestion.getText().equalsIgnoreCase("Cairo")) {
                Actions action = new Actions(driver);
                action.moveToElement(suggestion).click().perform();
                // suggestion.click();
                break;
            }

        }


        // clickElement(BothOneWayCityFieldList);
        return this;
    }

    public BothTicketHomePage setCheckInDate() throws IOException {
        clickElement(BothOneWayCheckIn);
        // check the year firstly to know if the same or greater or less than the current year
        int CurrentYear = Integer.parseInt(getElement(BothOneWayHotelCheckInCurrentYear).getText());
        int expectedYear = Integer.parseInt(readData("BothOneWayFlight.CheckInYear"));
        // check if the year is greater than the current year
        while (CurrentYear != expectedYear) {
            if (CurrentYear > expectedYear) {
                waitForElementToBeClickable(BothCheckInpreviousButton);
                clickElement(BothCheckInpreviousButton);
            } else if (CurrentYear < expectedYear) {
                waitForElementToBeClickable(BothCheckInnextButton);
                clickElement(BothCheckInnextButton);
            }
            CurrentYear = Integer.parseInt(getElement(BothOneWayHotelCheckInCurrentYear).getText());
        }
        select = new Select(getElement(BothOneWayHotelCheckInSelectMonth));
        select.selectByVisibleText(readData("BothOneWayFlight.CheckInMonth"));
        List<WebElement> lst = getElements(BothOneWayHotelCheckInSelectDate);
        for (int i = 0; i < lst.size(); i++) {
            WebElement freshDate = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//a[@class='ui-state-default']")).get(i);
            if (freshDate.getText().equals(readData("BothOneWayFlight.CheckInDate"))) {
                freshDate.click();
                break;  // Break after clicking
            }
        }
        return this;

    }

    public BothTicketHomePage setCheckOutDate() throws IOException {
        clickElement(BothOneWayCheckOut);
        // check the year firstly to know if the same or greater or less than the current year
        int CurrentYear = Integer.parseInt(getElement(BothOneWayHotelCheckOutCurrentYear).getText());
        int expectedYear = Integer.parseInt(readData("BothOneWayFlight.CheckOutYear"));
        // check if the year is greater than the current year
        while (CurrentYear != expectedYear) {
            if (CurrentYear > expectedYear) {
                waitForElementToBeClickable(BothCheckInpreviousButton);
                clickElement(BothCheckInpreviousButton);
            } else if (CurrentYear < expectedYear) {
                waitForElementToBeClickable(BothCheckInnextButton);
                clickElement(BothCheckInnextButton);
            }
            CurrentYear = Integer.parseInt(getElement(BothOneWayHotelCheckInCurrentYear).getText());
        }
        select = new Select(getElement(BothOneWayHotelCheckOutSelectMonth));
        select.selectByVisibleText(readData("BothOneWayFlight.CheckOutMonth"));
        List<WebElement> lst = getElements(BothOneWayHotelCheckOutSelectDate);
        for (int i = 0; i < lst.size(); i++) {
            WebElement freshDate = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//a[@class='ui-state-default']")).get(i);
            if (freshDate.getText().equals(readData("BothOneWayFlight.CheckOutDate"))) {
                freshDate.click();
                break;  // Break after clicking
            }
        }
        return this;
    }

    public BothTicketHomePage clickBuyDummyTicketButton() throws IOException {
        ScrollToView(BothBuyDummyTicketButton);
        new Actions(driver).moveToElement(getElement(BothBuyDummyTicketButton)).click().perform();
        // clickElement(BothBuyDummyTicketButton);
        return this;
    }

    // Methods for Both tab One Way
    public BothTicketHomePage clickBothRoundTripRadioBTN() throws IOException {
        info("Starting booking ticket with Round trip type...");
        clickElement(BothRoundTripRadioBTN);
        return this;
    }

    public BothTicketHomePage setBothRoundTripFrom() throws IOException {
        info("Setting trip source");
        ZoomOut();
        SendKeys(BothRoundTripFrom, readData("BothOneWayFlight.From"));
        return this;
    }

    public BothTicketHomePage setBothRoundTripTo() throws IOException {
        info("Setting trip destination");
        SendKeys(BothRoundTripTo, readData("BothOneWayFlight.To"));
        return this;
    }

    public BothTicketHomePage setBothRoundTripDepartureDate() throws IOException {
        info("Providing departure date.");
        clickElement(BothRoundTripDepartureDate);
        CompareAndSelectYear(CurrentYear, BothRoundTripCheckInPreviousButton, BothRoundTripCheckInNextButton, "BothOneWayFlight.DepartureYear");
        select = new Select(getElement(SelectMonth));
        select.selectByVisibleText(readData("BothOneWayFlight.DepartureMonth"));

        List<WebElement> dates = getElements(SelectDate);
        for (int i = 0; i < dates.size(); i++) {
            WebElement freshDate = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//a[@class='ui-state-default']")).get(i);
            if (freshDate.getText().equals(readData("BothOneWayFlight.DepartureDate"))) {
                freshDate.click();
                break;
            }
        }
        return this;
    }

    public BothTicketHomePage setBothRoundTripCityField() throws IOException {
        info("Providing City.");
        SendKeys(BothRoundTripCityField, readData("BothOneWayFlight.City"));
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//form[@id='both_round']//ul[@class='suggestions-cities-list']")));
        waitForElementToBeClickable(BothRoundTripCityFieldList);

        List<WebElement> suggestions = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//form[@id='both_round']//ul[@class='suggestions-cities-list']//li//div//p")));
        for (WebElement suggestion : suggestions) {
            if (suggestion.getText().equalsIgnoreCase("Cairo")) {
                Actions action = new Actions(driver);
                action.moveToElement(suggestion).click().perform();
                break;
            }
        }
        return this;
    }

    public BothTicketHomePage setBothRoundTripReturnDate() throws IOException {
        info("Providing return date.");
        //ScrollToView(BothRoundTripCheckIn);

        clickElement(BothRoundTripReturnDate);
        CompareAndSelectYear(CurrentYear, BothRoundTripCheckInPreviousButton, BothRoundTripCheckInNextButton, "BothOneWayFlight.DepartureYear");

        select = new Select(getElement(RoundTripSelectMonth));
        select.selectByVisibleText(readData("BothOneWayFlight.CheckOutMonth"));


        List<WebElement> dates = getElements(RoundTripSelectDate);
        for (int i = 0; i < dates.size(); i++) {
            WebElement freshDate = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//a[@class='ui-state-default']")).get(i);
            if (freshDate.getText().equals(readData("BothOneWayFlight.CheckOutDate"))) {
                freshDate.click();
                break;
            }
        }
        return this;
    }

    public BothTicketHomePage setBothRoundTripCheckInDate() throws IOException {
        info("Providing check in date.");
        clickElement(BothRoundTripCheckIn);
        // check the year firstly to know if the same or greater or less than the current year
        CompareAndSelectYear(BothRoundTripHotelCheckInCurrentYear, BothRoundTripCheckInPreviousButton, BothRoundTripCheckInNextButton, "BothOneWayFlight.CheckInYear");

        select = new Select(getElement(BothRoundTripHotelCheckInSelectMonth));
        select.selectByVisibleText(readData("BothOneWayFlight.CheckInMonth"));
        List<WebElement> lst = getElements(BothRoundTripHotelCheckInSelectDate);
        for (int i = 0; i < lst.size(); i++) {
            WebElement freshDate = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//a[@class='ui-state-default']")).get(i);
            if (freshDate.getText().equals(readData("BothOneWayFlight.CheckInDate"))) {
                Actions actions = new Actions(driver);
                actions.moveToElement(freshDate).click().perform();
                break;  // Break after clicking
            }
        }
        return this;

    }

    public BothTicketHomePage setBothRoundTripCheckOutDate() throws IOException {
        info("Providing check out date.");
        clickElement(BothRoundTripCheckOut);
        // check the year firstly to know if the same or greater or less than the current year
        int CurrentYear = Integer.parseInt(getElement(BothRoundTripHotelCheckOutCurrentYear).getText());
        int expectedYear = Integer.parseInt(readData("BothOneWayFlight.CheckOutYear"));
        // check if the year is greater than the current year
        while (CurrentYear != expectedYear) {
            if (CurrentYear > expectedYear) {
                waitForElementToBeClickable(BothRoundTripCheckInPreviousButton);
                clickElement(BothRoundTripCheckInPreviousButton);
            } else if (CurrentYear < expectedYear) {
                waitForElementToBeClickable(BothRoundTripCheckInNextButton);
                clickElement(BothRoundTripCheckInNextButton);
            }
            CurrentYear = Integer.parseInt(getElement(BothRoundTripHotelCheckInCurrentYear).getText());
        }
        select = new Select(getElement(BothRoundTripHotelCheckOutSelectMonth));
        select.selectByVisibleText(readData("BothOneWayFlight.CheckOutMonth"));
        List<WebElement> lst = getElements(BothRoundTripHotelCheckOutSelectDate);
        for (int i = 0; i < lst.size(); i++) {
            WebElement freshDate = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//a[@class='ui-state-default']")).get(i);
            if (freshDate.getText().equals(readData("BothOneWayFlight.CheckOutDate"))) {
                freshDate.click();
                break;  // Break after clicking
            }
        }
        return this;
    }

    public BothTicketHomePage clickBothRoundTripBuyDummyTicketButton() throws IOException {
        info("pressing dummy ticket to book ticket.");
        ScrollToView(BothRoundTripBuyDummyTicketButton);
        new Actions(driver).moveToElement(getElement(BothRoundTripBuyDummyTicketButton)).click().perform();
        // clickElement(BothRoundTripBuyDummyTicketButton);
        return this;
    }


    // Methods for Both tab Multi Trip
    public BothTicketHomePage clickBothMultiTripRadioBTN() throws IOException {
        info("Selecting Multi trip ticket type.");
        clickElement(BothMultiTripRadioBTN);
        return this;
    }

    public BothTicketHomePage setBothMultiTripFrom() throws IOException {
        info("Providing Source.");
        ZoomOut();
        SendKeys(BothMultiTripFrom, readData("BothOneWayFlight.From"));
        return this;
    }

    public BothTicketHomePage setBothMultiTripTo() throws IOException {
        info("Providing destination.");
        SendKeys(BothMultiTripTo, readData("BothOneWayFlight.To"));
        return this;
    }

    public BothTicketHomePage setBothMultiTripDepartureDate() throws IOException {
        info("providing departure date.");
        clickElement(BothMultiTripDepartureDate);
        SelectYearBySelectTag(SelectMultiTripYear, "BothOneWayFlight.DepartureYear");
        select = new Select(getElement(SelectMultiTripMonth));
        select.selectByVisibleText(readData("BothOneWayFlight.DepartureMonth"));

        List<WebElement> dates = getElements(SelectDate);
        for (int i = 0; i < dates.size(); i++) {
            WebElement freshDate = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//a[@class='ui-state-default']")).get(i);
            if (freshDate.getText().equals(readData("BothOneWayFlight.DepartureDate"))) {
                freshDate.click();
                break;
            }
        }
        return this;
    }

    public BothTicketHomePage setBothMultiTripCityField() throws IOException {
        info("providing city.");
        ScrollToView(BothMultiTripBuyDummyTicketButton);
        SendKeys(BothMultiTripCityField, readData("BothOneWayFlight.City2"));
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//form[@id='both_multycity']//ul[@class='suggestions-cities-list']")));
        waitForElementToBeClickable(BothMultiTripCityFieldList);

        List<WebElement> suggestions = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//form[@id='both_multycity']//ul[@class='suggestions-cities-list']//li//div//p")));
        for (WebElement suggestion : suggestions) {
            if (suggestion.getText().equalsIgnoreCase("Cairo")) {
                Actions action = new Actions(driver);
                action.moveToElement(suggestion).click().perform();
                // suggestion.click();
                break;
            }


        }


        // clickElement(BothOneWayCityFieldList);
        return this;
    }

    public BothTicketHomePage setBothMultiTripCheckInDate() throws IOException {
        info("providing check in date.");
        clickElement(BothMultiTripCheckIn);
        // check the year firstly to know if the same or greater or less than the current year
        CompareAndSelectYear(BothMultiTripHotelCheckInCurrentYear, BothMultiTripCheckInPreviousButton, BothMultiTripCheckInNextButton, "BothOneWayFlight.CheckInYear");

        select = new Select(getElement(BothMultiTripHotelCheckInSelectMonth));
        select.selectByVisibleText(readData("BothOneWayFlight.CheckInMonth"));
        List<WebElement> lst = getElements(BothMultiTripHotelCheckInSelectDate);
        for (int i = 0; i < lst.size(); i++) {
            WebElement freshDate = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//a[@class='ui-state-default']")).get(i);
            if (freshDate.getText().equals(readData("BothOneWayFlight.CheckInDate"))) {
                Actions actions = new Actions(driver);
                actions.moveToElement(freshDate).click().perform();
                break;  // Break after clicking
            }
        }
        return this;

    }

    public BothTicketHomePage setBothMultiTripCheckOutDate() throws IOException {
        info("providing check out date.");
        clickElement(BothMultiTripCheckOut);
        // check the year firstly to know if the same or greater or less than the current year
        CompareAndSelectYear(BothMultiTripHotelCheckOutCurrentYear, BothMultiTripCheckInPreviousButton, BothMultiTripCheckInNextButton, "BothOneWayFlight.CheckOutYear");
        select = new Select(getElement(BothRoundTripHotelCheckOutSelectMonth));
        select.selectByVisibleText(readData("BothOneWayFlight.CheckOutMonth"));
        List<WebElement> lst = getElements(BothRoundTripHotelCheckOutSelectDate);
        for (int i = 0; i < lst.size(); i++) {
            WebElement freshDate = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//a[@class='ui-state-default']")).get(i);
            if (freshDate.getText().equals(readData("BothOneWayFlight.CheckOutDate"))) {
                freshDate.click();
                break;  // Break after clicking
            }
        }
        return this;
    }

    public BothTicketHomePage clickBothMultiTripBuyDummyTicketButton() throws IOException {
        info("pressing dummy ticket button to reserve the ticket.");
        ScrollToView(BothMultiTripBuyDummyTicketButton);
        new Actions(driver).moveToElement(getElement(BothMultiTripBuyDummyTicketButton)).click().perform();
        // clickElement(BothMultiTripBuyDummyTicketButton);
        return this;
    }


    public void SelectYearBySelectTag(By element, String YearToSelect) throws IOException {
        select = new Select(getElement(SelectYear));
        select.selectByVisibleText(readData(YearToSelect));
    }

    public void CompareAndSelectYear(By CurrentElement, By PreviousButton, By NextButton, String YearToSelect) throws IOException {
        int CurrentYear = Integer.parseInt(getElement(CurrentElement).getText());
        System.out.println("Current Year is: " + CurrentYear);
        int expectedYear = Integer.parseInt(readData(YearToSelect));
        System.out.println("Expected Year is: " + expectedYear);
        // check if the year is greater than the current year
        while (CurrentYear != expectedYear) {
            if (CurrentYear > expectedYear) {
                waitForElementToBeClickable(PreviousButton);
                clickElement(PreviousButton);
            } else if (CurrentYear < expectedYear) {
                waitForElementToBeClickable(NextButton);
                clickElement(NextButton);
            }
            CurrentYear = Integer.parseInt(getElement(CurrentElement).getText());
        }
    }
}
