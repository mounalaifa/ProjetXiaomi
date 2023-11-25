package Pages;

import java.time.Duration;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Helper.Config;

public class WishList {
	
    @FindBy(xpath = "/html/body/div[2]/div[4]/div/div/div/div/div[3]/div[1]/div/div[3]/div/form/div/div[2]/div/div/div/div/a")
    WebElement addProducts;	

    @FindBy(xpath = "/html/body/div[2]/header/div[1]/div/section/div/div[4]/div/section/div/div[1]/div/div")
    WebElement wishLists;

    @FindBy(xpath = "/html/body/div[1]/div[5]/section/div/div/div/form/table/tbody/tr/td[2]/a")
    WebElement verifyProduct;

    public WishList(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void addProduct(String productTitle) {
        try {
            if (addProducts.getText().contains(productTitle)) {
                Config.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
                addProducts.click();
                Config.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

                WebDriverWait wait = new WebDriverWait(Config.driver, Duration.ofSeconds(10));
                wait.until(ExpectedConditions.elementToBeClickable(wishLists));
                wishLists.click();

                Config.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
                Assert.assertTrue(verifyProduct.getText().contains(productTitle));
            }
        } catch (Exception e) {
           
        }
        
      
    }
    
    public String verifyProduct() {
    	String actualMessage = verifyProduct.getText();
    	return actualMessage;
}
}

