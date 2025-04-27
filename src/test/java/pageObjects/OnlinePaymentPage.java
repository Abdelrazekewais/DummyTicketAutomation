package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.io.IOException;

import static utilities.Log.info;
import static utilities.readDataFromJson.readData;

public class OnlinePaymentPage extends BasePage {
    public OnlinePaymentPage(WebDriver driver) {
        super(driver);
    }
    By Logo = By.xpath("//img[@alt='dpo-logo']");
    By FName = By.xpath("//input[@id='TRANSCustFirstName']");
    By LName = By.xpath("//input[@id='TRANSCustLastName']");
    By Email = By.xpath("//input[@id='TRANSemail']");
    By City = By.xpath("//input[@id='TRANSCardHolderCity']");
    By CountyEgyptOption = By.id("TRANScoid");
    By PostalCode = By.xpath("//input[@id='TRANSCardHolderZIP']");
    By ContinueBTN = By.xpath("//button[@id='personalDetailsContinueBtn']");
    By CardHolderName = By.xpath("//input[@id='TRANScardholdername']");
    By CardNumber = By.xpath("//input[@id='TRANSCreditnum']");
    By EndMonth = By.xpath("//input[@id='TRANSexpiryM']");
    By EndYear = By.xpath("//input[@id='TRANSexpiryY']");
    By SecurityCodeCVV = By.xpath("//input[@id='TRANScvv']");
    By AgreeCheckBox = By.xpath("//div[@id='ccBtnDiv']//label[@for='terms-approval']");
    By PayNowBTN = By.xpath("//button[@id='creditCardBtn']");
    By Loader = By.id("loader");

    public OnlinePaymentPage VerifyLogoDisplayin() {
        info("Verifying logo is displayed.");
        waitForElementToBeVisible(Logo);
        Assert.assertTrue(getElement(Logo).isDisplayed(), "Logo is displayed");
        return this;
    }

    public OnlinePaymentPage fillPersonalDetails() throws IOException {
        info("Filling personal details.");
        waitForElementToBeVisible(FName);
        SendKeys(FName, readData("AdditionalDetails.FirstName"));
        SendKeys(LName, readData("AdditionalDetails.LastName"));
        SendKeys(Email, readData("AdditionalDetails.email"));
        SendKeys(City, readData("AdditionalDetails.City"));
        SendKeys(PostalCode, readData("AdditionalDetails.PostalCode"));
        Select select = new Select(getElement(CountyEgyptOption));
        select.selectByVisibleText(readData("AdditionalDetails.Nationality"));
        waitForElementToBeClickable(ContinueBTN);
        clickElement(ContinueBTN);
        return this;
    }

    public OnlinePaymentPage ChoosePaymentMethod() throws IOException {
        info("Choosing payment method.");
        waitForElementToBeVisible(CardHolderName);
       SendKeys(CardHolderName, readData("AdditionalDetails.FirstName"));
         SendKeys(CardNumber, readData("AdditionalDetails.CardNumber"));
        SendKeys(EndMonth, readData("AdditionalDetails.EndMonth"));
        SendKeys(EndYear, readData("AdditionalDetails.EndYear"));
        SendKeys(SecurityCodeCVV, readData("AdditionalDetails.SecurityCode"));
        clickElement(AgreeCheckBox);
        clickElement(PayNowBTN);
        return this;
    }
    public OnlinePaymentPage verifyLoaderAppeare(){
        info("Verifying loader appears.");
        waitForElementToBeVisible(Loader);
        Assert.assertTrue(getElement(Loader).isDisplayed(), "Loader is displayed");
        return this;
    }


}
