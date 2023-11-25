package Pages;

import java.time.Duration;
import java.util.List;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Helper.Config;

public class HomePage {
	
	@FindBy(xpath= "/html/body/div[2]/header/div[1]/div/section/div/div[2]/div/div/div/div/nav/ul/li/a")
	List<WebElement> menus;
	
	@FindBy(xpath= "/html/body/div[2]/header/div[1]/div/section/div/div[2]/div/div/div/div/nav/ul/li[3]/div/div/div/div/section/div/div/div")
	List<WebElement> submenus;
	
	@FindBy(xpath = "/html/body/div[2]/div[5]/div/div/div[1]/div/header/h1")
	WebElement connectedHome;

	public HomePage() {
		PageFactory.initElements(Config.driver, this);
	}

	public void mouseHoverOnMenu(String menuName, String subMenuName) throws InterruptedException {
		for (WebElement menu : menus) {
			Config.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			try {
				if (menu.getText().contains(menuName)) {
					System.out.println(menuName);
					System.out.println(menu.getText());
					Config.actions = new Actions(Config.driver);
					Config.actions.moveToElement(menu).perform();

					for (WebElement submenu : submenus) {
						Config.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
						try {
							if (submenu.getText().contains(subMenuName)) {
								Config.actions.moveToElement(submenu).perform();
							}
						} catch (Exception e) {
							
						}
					}
				}
			} catch (Exception e) {
				
			}
		}
	}

	public void clickProduct(String ConnectedHome) {
	    try {
	        if (connectedHome.getText().contains(ConnectedHome)) {
	        	connectedHome.click();
	        }
			} catch (Exception e) {
		
			}
		}
	    public String verifyMessage() {
	    	String actualMessage = connectedHome.getText();
	    	return actualMessage;
	}
}