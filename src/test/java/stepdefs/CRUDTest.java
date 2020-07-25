package stepdefs;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class CRUDTest {


    WebDriver driver;

    String sName = "TestComputer 10";
    String sDateIntroduced = "2018-06-11";
    String sDateDiscontinued = "2019-12-24";

    String uName = "TestComputer 20";
    String uDateIntroduced = "1986-12-06";
    String uDateDiscontinued = "2000-08-23";


    @Given("^web browser has navigated to the database app$")
    public void web_browser_has_navigated_to_the_database_app() {
        System.setProperty("webdriver.chrome.driver",ClassLoader.getSystemResource("driver/chromedriver.exe").getPath());
        ChromeOptions options = new ChromeOptions();
        options.setHeadless(false);
        options.addArguments("--disable-notifications");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-gpu");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().setSize(new Dimension(1280, 1024));
        driver.navigate().to("https://computer-database.gatling.io/computers");
    }

    @When("^add a new computer button is clicked$")
    public void add_a_new_computer_button_is_clicked() {
         WebElement addComputer = driver.findElement(By.id("add"));
         addComputer.click();
    }

    @When("^valid computer credentials are filled in$")
    public void valid_computer_credentials_are_filled_in() {
         WebElement nameBox = driver.findElement(By.id("name"));
         nameBox.click();
         nameBox.clear();
         nameBox.sendKeys(sName);
         WebElement introducedBox = driver.findElement(By.id("introduced"));
         introducedBox.click();
         introducedBox.clear();
         introducedBox.sendKeys(sDateIntroduced);
         WebElement discontinuedBox = driver.findElement(By.id("discontinued"));
         discontinuedBox.click();
         discontinuedBox.clear();
         discontinuedBox.sendKeys(sDateDiscontinued);
         WebElement dropdownCompany = driver.findElement(By.id("company"));
         dropdownCompany.click();
         WebElement selectDropdown = driver.findElement(By.cssSelector("[value=\"1\"]"));
         selectDropdown.click();
         dropdownCompany.click();
    }

    @When("^crete button is clicked$")
    public void crete_button_is_clicked() {
         WebElement createButton = driver.findElement(By.cssSelector(".btn.primary"));
         createButton.click();
    }


    @Then("^the computer is saved in the database$")
    public void the_computer_is_saved_in_the_database() {
         WebElement searchEntry = driver.findElement(By.id("searchbox"));
         searchEntry.click();
         searchEntry.clear();
         searchEntry.sendKeys(sName);
         WebElement searchSubmit = driver.findElement(By.id("searchsubmit"));
         searchSubmit.click();
         WebElement result = driver.findElement(By.xpath("//*[contains(text(),'"+sName+"')]"));
         Assert.assertTrue(result.getText().toUpperCase().contains(sName.toUpperCase()));

         driver.close();
         driver.quit();
    }

    @When("^a search by name is applied$")
    public void a_search_by_name_is_applied() {
        WebElement searchFilter = driver.findElement(By.id("searchbox"));
        searchFilter.click();
        searchFilter.clear();
        searchFilter.sendKeys(sName);
        WebElement searchButton = driver.findElement(By.id("searchsubmit"));
        searchButton.click();
    }

    @When("^the result entry is clicked$")
    public void the_result_entry_is_clicked() {
        WebElement resultClick = driver.findElement(By.xpath("//*[contains(text(),'TestComputer')]"));
        resultClick.click();
    }

    @Then("^The user is navigated to the edit page$")
    public void the_user_is_navigated_to_the_edit_page() {
        WebElement nameBox = driver.findElement(By.id("name"));
        Assert.assertTrue(nameBox.getAttribute("Value").toUpperCase().contains(sName.toUpperCase()));

        WebElement introducedBox = driver.findElement(By.id("introduced"));
        Assert.assertTrue(introducedBox.getAttribute("Value").toUpperCase().contains(sDateIntroduced.toUpperCase()));

        WebElement discontinuedBox = driver.findElement(By.id("discontinued"));
        Assert.assertTrue(discontinuedBox.getAttribute("Value").toUpperCase().contains(sDateDiscontinued.toUpperCase()));

        Select selectDropdown = new Select( driver.findElement(By.id("company")));
        Assert.assertTrue(selectDropdown.getFirstSelectedOption().getText().toUpperCase().contains("APPLE"));

        driver.close();
        driver.quit();
    }

    @When("^all fields are edited$")
    public void all_fields_are_edited() {
        WebElement nameBox = driver.findElement(By.id("name"));
        nameBox.click();
        nameBox.clear();

        nameBox.sendKeys(uName);
        WebElement introducedBox = driver.findElement(By.id("introduced"));
        introducedBox.click();
        introducedBox.clear();
        introducedBox.sendKeys(uDateIntroduced);
        WebElement discontinuedBox = driver.findElement(By.id("discontinued"));
        discontinuedBox.click();
        discontinuedBox.clear();
        discontinuedBox.sendKeys(uDateDiscontinued);
        WebElement dropdownCompany = driver.findElement(By.id("company"));
        dropdownCompany.click();
        WebElement selectDropdown = driver.findElement(By.cssSelector("[value=\"3\"]"));
        selectDropdown.click();
        dropdownCompany.click();
    }

    @When("^save button is clicked$")
    public void save_button_is_clicked() {
        WebElement saveButton = driver.findElement(By.cssSelector(".btn.primary"));
        saveButton.click();
    }

    @Then("^the entry is saved$")
    public void the_entry_is_saved() {
        WebElement searchEntry = driver.findElement(By.id("searchbox"));
        searchEntry.click();
        searchEntry.clear();
        searchEntry.sendKeys(uName);
        WebElement searchSubmit = driver.findElement(By.id("searchsubmit"));
        searchSubmit.click();
        WebElement result = driver.findElement(By.xpath("//*[contains(text(),'"+uName+"')]"));
        Assert.assertTrue(result.getText().toUpperCase().contains(uName.toUpperCase()));

        driver.close();
        driver.quit();
    }

    @When("^a search by new name is applied$")
    public void a_search_by_new_name_is_applied() {
        WebElement searchFilter = driver.findElement(By.id("searchbox"));
        searchFilter.click();
        searchFilter.clear();
        searchFilter.sendKeys(uName);
        WebElement searchButton = driver.findElement(By.id("searchsubmit"));
        searchButton.click();
    }

    @When("^delete this computer button is clicked$")
    public void delete_this_computer_button_is_clicked() {
        WebElement deleteButton = driver.findElement(By.cssSelector(".btn.danger"));
        deleteButton.click();
    }

    @Then("^the entry is removed from the list$")
    public void the_entry_is_removed_from_the_list() {
        WebElement searchEntry = driver.findElement(By.id("searchbox"));
        searchEntry.click();
        searchEntry.clear();
        searchEntry.sendKeys(uName);
        WebElement searchSubmit = driver.findElement(By.id("searchsubmit"));
        searchSubmit.click();
        List<WebElement> searchResults = driver.findElements(By.xpath("//*[contains(text(),'"+uName+"')]"));
        Assert.assertTrue(searchResults.size() == 0);

        driver.close();
        driver.quit();
    }
}
