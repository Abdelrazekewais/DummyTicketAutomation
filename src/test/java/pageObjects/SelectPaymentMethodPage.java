package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static utilities.Log.info;

public class SelectPaymentMethodPage extends BasePage {
    By CurrencyButton = By.xpath("//*[@id=\"content\"]/section/div[1]/div/div[2]/div/div/div[2]/div/div[1]/table/tbody/tr/td[2]/label[2]");
    By PayWithDebitCardBTN = By.xpath("//*[@id=\"content\"]/section/div[1]/div/div[2]/div/div/div[2]/div/div[3]/div[2]/div/div[1]/input");
    By MakePaymentBTN = By.xpath("/html/body/div[1]/div[1]/div[2]/section/div[1]/div/div[2]/div/div/div[2]/div/div[3]/form[2]/div/button"); //form[@id='dbs']//button

    public SelectPaymentMethodPage(WebDriver driver) {
        super(driver);
    }

    public SelectPaymentMethodPage ChangeCurrency() throws InterruptedException {
        info("Changing currency.");
        //ZoomOut();
        wait.until(ExpectedConditions.visibilityOf(getElement(CurrencyButton))).click();
        return this;
    }

    public SelectPaymentMethodPage MakePayment() {
        info("Making the payment.");
        clickElement(PayWithDebitCardBTN);
        clickElementUsingJS(MakePaymentBTN);
        return this;
    }


}
