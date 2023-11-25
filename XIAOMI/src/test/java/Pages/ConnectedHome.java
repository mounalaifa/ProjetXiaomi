package Pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Helper.Config;

public class ConnectedHome {

	@FindBy(xpath = "/html/body/div[2]/div[5]/div/div/div[1]/div/div[2]/div[4]/form/div/p/span")
	WebElement sorts;

	@FindBy(xpath = "/html/body/div[2]/div[5]/div/div/div[1]/div/div[2]/div[4]/form/div/div/ul/li/label")
	List<WebElement> sortLists;

	@FindBy(xpath = "/html/body/div[2]/div[5]/div/div/div[1]/div/div[3]/div/div/div/div[2]/div[2]/h3/a")
	List<WebElement> productLists;

	@FindBy(xpath = "/html/body/div[2]/div[4]/div/div/div/div/div[3]/div[1]/div/div[1]/div/div[1]/h1")
	WebElement products;

	public ConnectedHome() {
		PageFactory.initElements(Config.driver, this);
	}

	public void mouseHoverOnSort(String sortName, String sortListName) throws InterruptedException {
		Config.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		try {
			if (sorts.getText().contains(sortName)) {
				System.out.println(sortName);
				System.out.println(sorts.getText());
				Config.actions = new Actions(Config.driver);
				Config.actions.moveToElement(sorts).perform();

				for (WebElement sortList : sortLists) {
					Config.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
					try {
						if (sortList.getText().contains(sortListName)) {
							Config.actions.moveToElement(sortList).perform();
						}
					} catch (Exception e) {

					}
				}
			}
		} catch (Exception e) {

		}
	}

	public void clickProduct(String productListName) {
	    for (WebElement productList : productLists) {
	        Config.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	        try {
	            if (productList.getText().contains(productListName)) {
	                Config.actions.moveToElement(productList).perform();
	            }
	        } catch (Exception e) {
	            
	        }
	    }
	}

	public void verifyProduct(String productName) {
	    try {
	        if (products.getText().contains(productName)) {
	            products.click();
	        }
	    } catch (Exception e) {
	       
	    }
	}

	 public String verifyMessage() {
	    	String actualMessage = products.getText();
	    	return actualMessage;
	}
	
}
