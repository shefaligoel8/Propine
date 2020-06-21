package Stepdefination;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.text.SimpleDateFormat;
import java.util.*;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LoginTest {

	static WebDriver driver;
	public String strInputDate;

	@Given("^I am a website user$")
	public void i_am_a_website_user() throws Throwable {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Sourav\\Desktop\\chromedriver_win32\\chromedriver.exe"); 
		driver =new ChromeDriver(); 
		String baseURL ="https://vast-dawn-73245.herokuapp.com/";
		System.out.println("Login Successfully");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get(baseURL); 
	}

	@When("^I enter \"([^\"]*)\" on the input field and click Submit button$")
	public void i_enter_on_the_input_field_and_click_Submit_button(String Date) throws Throwable {
		WebElement Datefield = driver.findElement(By.xpath("//input[@class='form-control']"));
		Datefield.sendKeys(Date);
		strInputDate=Date;
		System.out.println("Date Format is:"+ Date);
		System.out.println("Date entered successfully");
		WebElement SubmitButton = driver.findElement(By.xpath("//input[@class='btn btn-default']"));
		SubmitButton.click();
		System.out.println("Submit button clicked successfully");
	}

	@Then("^I should see a date on the form with a \"([^\"]*)\" for the \"([^\"]*)\"$")
	public void i_should_see_a_date_on_the_form_with_a_for_the(String value,String scenario) throws Throwable {
		WebElement DateFormatValidation = driver.findElement(By.xpath("//div[@class='col-md-6']/div"));
		String strdate=DateFormatValidation.getText();
		DateFormatValidation.getAttribute("innerText");
    	System.out.println("strdate Format is:"+DateFormatValidation.getAttribute("innerText"));
     	
    	SimpleDateFormat dt = new SimpleDateFormat("dd-MMM-yyyy"); 
    	Date date = dt.parse(strInputDate); 
    	String strnewdate = new SimpleDateFormat("E MMM dd yyyy 00:00:00 'GMT'+0000").format(date);
    	System.out.println(strnewdate);
		
		if(scenario.equals("Positive"))
		{
			if(strdate.equals(strnewdate))
			{
				System.out.println("The test case is passed.");
			}
			else
			{
				System.out.println("It is a defect.");
			}
		}
		else if(scenario.equals("Negative"))
		{

			if(strdate.equals(value))
			{
				System.out.println("The test case is passed.");
			}
			else
			{
				System.out.println("It is a defect.");
			}

		}
		driver.close();
		driver.quit();
	}
}
