package TestSuites;

import org.junit.Assert;
import org.openqa.selenium.chrome.ChromeDriver;

import Helper.Config;
import Pages.HomePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class HomePageStepDef {

	@Given("admin is on home page")
	public void admin_is_on_home_page() {
		Config.confChrome();
		Config.driver = new ChromeDriver ();
		Config.maximizeWindow();
		String url = "https://mistore.com.tn/";
		Config.driver.get(url);
	}
	  


	@When("admin mouseHover on menu {string} and click on submenu {string}")
	public void admin_mouse_hover_on_menu_and_click_on_submenu(String menuName, String subMenuName) throws InterruptedException {
		 HomePage page = new HomePage ();
		   page.mouseHoverOnMenu(menuName, subMenuName);
	}
	   


	@Then("admin is directed to the page {string}")
	public void admin_is_directed_to_the_page(String expectedMessage) throws InterruptedException {
		   Thread.sleep(3000);
		   HomePage home = new HomePage ();
		   String actualMessage = home.verifyMessage ();
		   Assert.assertEquals(expectedMessage, actualMessage);
		}
}


