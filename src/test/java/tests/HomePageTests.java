package tests;

import org.testng.annotations.Test;
import pageObjects.FlightTicketHomePage;
import pageObjects.HomePage;
import pageObjects.HotelTicketHomePage;

import java.io.IOException;

public class HomePageTests extends BaseTest {


    @Test(enabled = true, description = "Verify the logo in home page is displayed", groups = "essentials")
    public void verifyLogoDisplaying() {
        logger.info("Starting the test...");
        new HomePage(driver).verifyLogo();
    }

    @Test(enabled = true, description = "Verify FAQ link functionality", groups = "regression")
    public void VerifyFAQLinkFunctionality() {
        logger.info("Starting the functionality of FAQ...");
        new HomePage(driver).clickFAQ()
                .verifyFAQsTitleDisplayed();
    }

    @Test(enabled = true, description = "Verify FAQ link functionality", groups = "regression")
    public void VerifyBlogLinkFunctionality() {
        logger.info("Starting the functionality of Blog...");
        new HomePage(driver).clickBlog()
                .verifyBlogImageDisplayed();
    }

    @Test(description = "Verify FAQ link functionality", groups = "regression")
    public void VerifyB2BLinkFunctionality() {
        logger.info("Starting the functionality of B2B...");
        new HomePage(driver).clickB2B()
                .verifyB2BTitleDisplayed();
    }

    @Test(description = "Verify FAQ link functionality", groups = "regression")
    public void VerifyPhoneNumberLinkFunctionality() throws InterruptedException {
        logger.info("Starting the functionality of Phone Number...");
        new HomePage(driver).clickPhoneNumber()
                .verifyPhoneNumber();
    }

    @Test(description = "Verify FLIGHT tab functionality", groups = "regression")
    public void VerifyFLIGHTTabFunctionality() throws IOException {
        logger.info("Starting the functionality of FLIGHT tab...");
        new FlightTicketHomePage(driver).verifyFlightTabFunctionality();
    }

    @Test(description = "Verify HOTEL tab functionality", groups = "regression")
    public void VerifyHotelTabFunctionality() throws IOException {
        logger.info("Starting the functionality of Hotel tab...");
        new HomePage(driver).clickHotelTab();
        new HotelTicketHomePage(driver)
                .HotelTabAssertions();
    }

    @Test(description = "Verify BOTH tab functionality", groups = "regression")
    public void VerifyBothTabFunctionality() throws IOException {
        logger.info("Starting the functionality of Both tab...");
        new HomePage(driver).verifyBothTabFunctionality();
    }

    @Test(description = "Validate 'BUY DUMMY TICKET' button functionality")
    public void ValidateBuyTicketButtonFunctionality(){
        new FlightTicketHomePage(driver).ByuTicketButtonFunctionality();
    }

    @Test(description = "Verify input validation for FROM field. There is no validation in this field so it will not throw any error")
    public void validateInputFromFieldValidation() throws IOException {
        new FlightTicketHomePage(driver).validateFromField();

    }

    @Test(description = "Verify input validation for To field. There is no validation in this field so it will not throw any error")
    public void validateInputToFieldValidation() throws IOException {
        new FlightTicketHomePage(driver).validateToField();

    }

    @Test(description = "Verify input validation for Departure field. There is no validation in this field so it will not throw any error")
    public void validateInputDepartureFieldValidation() throws IOException {
        new FlightTicketHomePage(driver).validateDepartureField();

    }



}
