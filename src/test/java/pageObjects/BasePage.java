package pageObjects;


import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected Select select;
    JavascriptExecutor executor;
    // class constructor
    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        executor = (JavascriptExecutor) driver;
    }
    //Method to get the element from a By variable
    public WebElement getElement(By element){
        return driver.findElement(element);
    }

    public List<WebElement> getElements(By element){
        return driver.findElements(element);
    }
    //Method to take By variable element and click it
    public void clickElement(By element){
        getElement(element).click();
    }
    //Method to take By variable element and fill it with data
    public void SendKeys(By element, String input){
        getElement(element).sendKeys(input);
    }

    public boolean elementIsDisplayed (By element){
        return getElement(element).isDisplayed();
    }

    //wait for element to be clickable
    public void waitForElementToBeClickable(By Element){
        wait.until(ExpectedConditions.elementToBeClickable(getElement(Element)));
    }
    //wait for element to be visible
    public void waitForElementToBeVisible(By Element){
        wait.until(ExpectedConditions.visibilityOf(getElement(Element)));
    }

    //Make sure element is not displayed:
    public void ElementIsNotDisplayed(By element) {
        try {
            Assert.assertFalse(getElement(element).isDisplayed());
        } catch (NoSuchElementException e) {
            // Element is not found, so it is not displayed
            Assert.assertTrue(true);
        }
    }

    //wait for element to be displayed
   public void ScrollToView(By element){
       executor.executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", getElement(element));
   }

   public void ZoomOut(){
       executor.executeScript("document.body.style.zoom='80%'");
   }
    public void clickElementUsingJS(By Element){
        executor.executeScript("arguments[0].click();", getElement(Element));
    }

}
