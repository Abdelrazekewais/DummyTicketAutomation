package tests;

import org.testng.annotations.Test;
import pageObjects.*;

import java.io.IOException;

public class BothBookingTicketTests extends BaseTest {

    @Test
    public void TestBookingTicketFromBothTabOneWay() throws IOException, InterruptedException {
        new HomePage(driver)
                .clickBothTab();
        new BothTicketHomePage(driver)
                .clickBothTabRadioBTN()
                .setBothOneWayFrom()
                .setBothOneWayTo()
                .setBothDepartureDate()
                .setBothOneWayCityField()
                .setCheckInDate()
                .setCheckOutDate()
                .clickBuyDummyTicketButton();
        new BookingDetailsPage(driver).VerifyTicketbooking()
                .setCountryCode()
                .setContactNumber()
                .setEmail()
                .setPassangerTitle()
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

    @Test
    public void TestBookingTicketFromBothTabRoundTrip() throws IOException, InterruptedException {
        new HomePage(driver)
                .clickBothTab();
        new BothTicketHomePage(driver)
                .clickBothRoundTripRadioBTN()
                .setBothRoundTripFrom()
                .setBothRoundTripTo()
                .setBothRoundTripDepartureDate()
                .setBothRoundTripReturnDate()
                .setBothRoundTripCityField()
                .setBothRoundTripCheckInDate()
                .setBothRoundTripCheckOutDate()
                .clickBothRoundTripBuyDummyTicketButton();
        new BookingDetailsPage(driver)
                .VerifyTicketbooking()
                .setCountryCode()
                .setContactNumber()
                .setEmail()
                .setPassangerTitle()
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

    @Test
    public void TestBookingTicketFromBothTabMultiTrip() throws IOException, InterruptedException {
        new HomePage(driver)
                .clickBothTab();
        new BothTicketHomePage(driver)
                .clickBothMultiTripRadioBTN()
                .setBothMultiTripFrom()
                .setBothMultiTripTo()
                .setBothMultiTripDepartureDate()
                .setBothMultiTripCityField()
                .setBothMultiTripCheckInDate()
                .setBothMultiTripCheckOutDate()
                .clickBothMultiTripBuyDummyTicketButton();
        new BookingDetailsPage(driver)
                .VerifyTicketbooking()
                .setCountryCode()
                .setContactNumber()
                .setEmail()
                .setPassangerTitle()
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
