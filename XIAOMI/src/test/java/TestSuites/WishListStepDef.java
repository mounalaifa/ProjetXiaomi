package TestSuites;

import org.junit.Assert;
import org.openqa.selenium.chrome.ChromeDriver;
import Helper.Config;
import Pages.WishList;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class WishListStepDef {

	@Given("admin is product page")
	public void admin_is_product_page() {
		Config.confChrome();
		Config.driver = new ChromeDriver();
		Config.maximizeWindow();
		String url = "https://mistore.com.tn/product/mi-portable-bluetooth-speaker/";
		Config.driver.get(url);
	}

	@When("admin adds product to the wish list {string}")
	public void admin_adds_product_to_the_wish_list(String productTitle) {
		WishList wishListPage = new WishList(Config.driver);
		wishListPage.addProduct(productTitle);
	}

	@When("admin access the wish list page")
	public void admin_access_the_wish_list_page() {
		Config.confChrome();
		Config.driver = new ChromeDriver();
		String url = "https://mistore.com.tn/listedesouhaits/";
		Config.driver.get(url);
	}

	@Then("admin verifies that the product is added")
	public void admin_verifies_that_the_product_is_added(String expectedMessage) throws InterruptedException {
		Thread.sleep(3000);
		WishList home = new WishList(Config.driver);
		String actualMessage = home.verifyProduct();
		Assert.assertEquals(expectedMessage, actualMessage);
	}

}
