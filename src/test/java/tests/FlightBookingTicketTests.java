package tests;

import org.testng.annotations.Test;
import pageObjects.*;

import java.io.IOException;

public class FlightBookingTicketTests extends BaseTest {

    @Test(description = "Validate buying ticket from FLIGHT tab with round trip", groups = "regression")
    public void VerifyBookingFromFlightTab() throws InterruptedException, IOException {

        new FlightTicketHomePage(driver).
                setFromDate()
                .setToDate()
                .setDepartureDate()
                .clickBuyDummyTicketButton();

        new BookingDetailsPage(driver).VerifyTicketbooking()
                .setCountryCode()
                .setContactNumber()
                .setEmail()
                .setPassengerTitle()
                .setFirstName()
                .setLastName()
                .setNationality()
                .SelectDateOfBirth()
                .clickNextButton()
                .selectReceivingTime()
                .SelectPurposeToBuyDummyTickets()
                .LeaveMessage();
        new SelectPaymentMethodPage(driver).ChangeCurrency()
                .MakePayment();
        new OnlinePaymentPage(driver).VerifyLogoDisplayin()
                .fillPersonalDetails()
                .ChoosePaymentMethod()
                .verifyLoaderAppeare();

    }

    @Test(description = "Validate buying ticket from FLIGHT tab with round trip", groups = "regression")
    public void VerifyBookingFromFlightTabRoundTrip() throws InterruptedException, IOException {

        new FlightTicketHomePage(driver)
                .SelectRoundTripRadioBTN()
                .setRoundTripFromDate()
                .setRoundTripToDate()
                .setRoundTripDepartureDate()
                .setRoundTripReturnDate()
                .clickRoundTripBuyDummyTicketButton();

        new BookingDetailsPage(driver).VerifyTicketbooking()
                .setCountryCode()
                .setContactNumber()
                .setEmail()
                .setPassengerTitle()
                .setFirstName()
                .setLastName()
                .setNationality()
                .SelectDateOfBirth()
                .clickNextButton()
                .selectReceivingTime()
                .SelectPurposeToBuyDummyTickets()
                .LeaveMessage();
        new SelectPaymentMethodPage(driver).ChangeCurrency()
                .MakePayment();
        new OnlinePaymentPage(driver).VerifyLogoDisplayin()
                .fillPersonalDetails()
                .ChoosePaymentMethod()
                .verifyLoaderAppeare();

    }

    @Test(description = "Validate buying ticket from FLIGHT tab with MultiTrip", groups = "regression")
    public void VerifyBookingFromFlightTabMultiTrip() throws IOException, InterruptedException {
        new FlightTicketHomePage(driver)
                .SelectMultiTripRadioBTN()
                .setMultiTripFromDate()
                .setMultiTripToDate()
                .setMultiTripDepartureDate()
                .clickMultiTripBuyDummyTicketButton();
        new BookingDetailsPage(driver).VerifyTicketbooking()
                .setCountryCode()
                .setContactNumber()
                .setEmail()
                .setPassengerTitle()
                .setFirstName()
                .setLastName()
                .setNationality()
                .SelectDateOfBirth()
                .clickNextButton()
                .selectReceivingTime()
                .SelectPurposeToBuyDummyTickets()
                .LeaveMessage();
        new SelectPaymentMethodPage(driver).ChangeCurrency()
                .MakePayment();
        new OnlinePaymentPage(driver).VerifyLogoDisplayin()
                .fillPersonalDetails()
                .ChoosePaymentMethod()
                .verifyLoaderAppeare();

    }



}
