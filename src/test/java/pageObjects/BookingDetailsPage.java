package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.io.IOException;
import java.util.List;

import static utilities.Log.error;
import static utilities.Log.info;
import static utilities.readDataFromJson.readData;

public class BookingDetailsPage extends BasePage {
    //private static final Logger logger = Log.getLogger(BookingDetailsPage.class);
    Select select;
    By OrderSummary = By.xpath("//li[text()='Order Summary']");
    By BookingPageTitle = By.xpath("//div[text()=' Booking Details']");
    By CountryCodeField = By.name("country_code");
    By Nationality = By.name("nationality[]");
    By ContactNumber = By.name("contact_number");
    By EmailAddress = By.name("email");
    By PassangerTitle = By.name("passanger_title[]");
    By FirstName = By.name("first_name[]");
    By LastName = By.name("last_name[]");
    //Date Of birth selection
    By DateOfBirthField = By.name("dob[]");
    By SelectYear = By.xpath("//select[@class='ui-datepicker-year']");
    By SelectMonth = By.xpath("//select[@class='ui-datepicker-month']");
    By SelectDay = By.xpath("//table[@class='ui-datepicker-calendar']//tbody//tr//td");
    By NextButton = By.xpath("//form[@id='personalform']//input[@type='submit']"); //form[@id='personalform']/descendant::input[@type='submit']
    By ReceiveNowButton = By.xpath("//form/descendant::input[@value='receive_now']");
    By SelectPurpose = By.id("purpose");
    By WriteMessage = By.name("message");


    public BookingDetailsPage(WebDriver driver) {
        super(driver);
    }

    // Complete additional details steps:
    //1- verify we are on the booking details page
    public BookingDetailsPage VerifyTicketbooking() {
        info("Waiting to validate order summary");
        waitForElementToBeVisible(OrderSummary);

        elementIsDisplayed(OrderSummary);
        info("Verified that element is displayed");
        elementIsDisplayed(BookingPageTitle);
        info("Ticket is booked successfully");
        return this;
    }

    //2- fill contact details:
    public BookingDetailsPage setCountryCode() throws InterruptedException {
        info("setting country code.");
        ZoomOut();
        //clickElement(CountryCodeField);
        select = new Select(getElement(CountryCodeField));
        select.selectByVisibleText("Egypt - 20");
        return this;

    }

    public BookingDetailsPage setContactNumber() throws IOException {
        info("Setting contact number");
        SendKeys(ContactNumber, readData("AdditionalDetails.Contact-Number"));
        return this;
    }

    public BookingDetailsPage setEmail() throws IOException {
        info("Setting contact number");
        SendKeys(EmailAddress, readData("AdditionalDetails.email"));
        return this;
    }

    public BookingDetailsPage setPassangerTitle() throws IOException, InterruptedException {
        info("Setting passanger title");
        select = new Select(getElement(PassangerTitle));
        select.selectByVisibleText(readData("AdditionalDetails.Title"));
        return this;
    }

    public BookingDetailsPage setFirstName() throws IOException {
        info("Setting first name.");
        SendKeys(FirstName, readData("AdditionalDetails.FirstName"));
        return this;
    }

    public BookingDetailsPage setLastName() throws IOException {
        info("Setting last name.");
        SendKeys(LastName, readData("AdditionalDetails.LastName"));
        return this;
    }

    // select date of birth
    public BookingDetailsPage SelectDateOfBirth() throws IOException, InterruptedException {
        info("Setting date of birth");
        clickElement(DateOfBirthField);
        select = new Select(getElement(SelectYear));
        select.selectByVisibleText(readData("DateOfBirth.Year"));
        select = new Select(getElement(SelectMonth));
        select.selectByVisibleText(readData("DateOfBirth.Month"));
        List<WebElement> lst = getElements(SelectDay);
        for (WebElement date : lst) {
            if (date.getText().equals(readData("DateOfBirth.Date"))) {
                date.click();
            }
        }
        return this;
    }

    public BookingDetailsPage setNationality() throws IOException {
        info("Setting nationality");
        select = new Select(getElement(Nationality));
        select.selectByVisibleText(readData("AdditionalDetails.Nationality"));
        return this;
    }

    public BookingDetailsPage clickNextButton() {
        info("Clicking next button");

        try {
            ScrollToView(NextButton);
            waitForElementToBeClickable(NextButton);
            clickElement(NextButton);
        } catch (Exception e) {
            error("Repressing next button.");
            clickElement(NextButton);
        }
        return this;
    }

    public BookingDetailsPage selectReceivingTime() {
        info("Setting receiving time.");
        clickElement(ReceiveNowButton);
        return this;
    }

    public BookingDetailsPage SelectPurposeToBuyDummyTickets() throws IOException {
        info("Clicking dummy ticket button.");
        select = new Select(getElement(SelectPurpose));
        select.selectByVisibleText(readData("AdditionalDetails.PurposeToBuyDummyTicket"));
        return this;
    }

    public BookingDetailsPage LeaveMessage() throws IOException {
        info("Writing a message.");
        SendKeys(WriteMessage, readData("AdditionalDetails.Message"));
        // clickNextButton();
        try {
            waitForElementToBeClickable(By.xpath("(//input[@value='Next'])[2]"));
            driver.findElement(By.xpath("(//input[@value='Next'])[2]")).click();

        } catch (Exception e) {
            driver.findElement(By.xpath("(//input[@value='Next'])[2]")).click();

        }
        return this;
    }
}