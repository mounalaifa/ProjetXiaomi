package TestSuites;

import org.junit.Assert;
import org.openqa.selenium.chrome.ChromeDriver;

import Helper.Config;
import Pages.ConnectedHome;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ConnectedHomeStepDef {

	@Given("the admin is on the Connected Home page")
	public void the_admin_is_on_the_connected_home_page() {
		Config.confChrome();
		Config.driver = new ChromeDriver ();
		Config.maximizeWindow();
		String url = "https://mistore.com.tn/product-category/maison-connectee/";
		Config.driver.get(url);
	}

	@When("the admin sorts the product list")
	public void the_admin_sorts_the_product_list(String sortName, String sortListName) {
	    
	}

	@When("the admin clicks on a product")
	public void the_admin_clicks_on_a_product(String productListName) {
		ConnectedHome page = new ConnectedHome ();
		page.clickProduct(productListName);
	}

	@Then("the admin verifies the selected product")
	public void the_admin_verifies_the_selected_product(String expectedMessage) throws InterruptedException {
		  Thread.sleep(3000);
		   ConnectedHome home = new ConnectedHome ();
		   String actualMessage = home.verifyMessage ();
		   Assert.assertEquals(expectedMessage, actualMessage);
		}
	


}

