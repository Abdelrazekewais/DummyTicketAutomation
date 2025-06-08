package tests;

import org.testng.annotations.Test;
import pageObjects.*;

import java.io.IOException;

public class HotelBookingTicketTests extends BaseTest{

    @Test(description = "Validate buying ticket from Hotel tab with round trip", groups = "regression")
    public void VerifyBookingFromHotelTab() throws InterruptedException, IOException {

        new HomePage(driver).
                clickHotelTab();

        new HotelTicketHomePage(driver)
                .setHotelTabCityField()
                .setCheckInDate()
                .setCheckOutDate()
                .clickHotelBuyDummyTicketButton();

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
