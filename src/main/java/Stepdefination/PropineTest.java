package Stepdefination;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class PropineTest {
	static WebDriver driver;
	public String strInputDate;

	@Given("^I am a website user$")
	public void i_am_a_website_user() throws Throwable {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Shefali\\Desktop\\chromedriver_win32\\chromedriver.exe"); 
		driver =new ChromeDriver(); 
		String baseURL ="https://vast-dawn-73245.herokuapp.com/";
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get(baseURL); 
	}

	@When("^I enter \"([^\"]*)\" on the input field and click Submit button$")
	public void i_enter_on_the_input_field_and_click_Submit_button(String Date) throws Throwable {
		WebElement Datefield = driver.findElement(By.xpath("//input[@class='form-control']"));
		Datefield.sendKeys(Date);
		strInputDate=Date;
		WebElement SubmitButton = driver.findElement(By.xpath("//input[@class='btn btn-default']"));
		SubmitButton.click();


	}

	@Then("^I should see a date on the form with a \"([^\"]*)\" for the \"([^\"]*)\"$")
	public void i_should_see_a_date_on_the_form_with_a_for_the(String value,String scenario) throws Throwable {
		WebElement DateFormatValidation = driver.findElement(By.xpath("//div[@class='col-md-6']/div"));
		String strdate=DateFormatValidation.getText().trim();

		 String []arrstrDate=strdate.split(":");
		 String arroldDate=arrstrDate[0];
		 String oldDate=arroldDate.substring(4,arroldDate.length()-3).trim();


		List<SimpleDateFormat> dateFormatList = new ArrayList<SimpleDateFormat>();

		dateFormatList.add(new SimpleDateFormat("MM-dd-yyyy"));
		dateFormatList.add(new SimpleDateFormat("MM-dd-yy"));
		dateFormatList.add(new SimpleDateFormat("dd-MMMM-yyyy"));
		dateFormatList.add(new SimpleDateFormat("dd-MMMM-yy"));
		dateFormatList.add(new SimpleDateFormat("dd-MMM-yyyy"));
		dateFormatList.add(new SimpleDateFormat("dd-MMM-yy"));
		dateFormatList.add(new SimpleDateFormat("dd-MM-yyyy"));
		dateFormatList.add(new SimpleDateFormat("dd-MM-yy"));
		dateFormatList.add(new SimpleDateFormat("MMMM-dd-yyyy"));
		dateFormatList.add(new SimpleDateFormat("MMMM-dd-yy"));
		dateFormatList.add(new SimpleDateFormat("MMM-dd-yyyy"));
		dateFormatList.add(new SimpleDateFormat("MMM-dd-yy"));
		dateFormatList.add(new SimpleDateFormat("MM/dd/yyyy"));
		dateFormatList.add(new SimpleDateFormat("MM/dd/yy"));
		dateFormatList.add(new SimpleDateFormat("dd/MMMM/yyyy"));
		dateFormatList.add(new SimpleDateFormat("dd/MMMM/yy"));
		dateFormatList.add(new SimpleDateFormat("dd/MMM/yyyy"));
		dateFormatList.add(new SimpleDateFormat("dd/MMM/yy"));
		dateFormatList.add(new SimpleDateFormat("dd/MM/yyyy"));
		dateFormatList.add(new SimpleDateFormat("dd/MM/yy"));
		dateFormatList.add(new SimpleDateFormat("MMMM/dd/yyyy"));
		dateFormatList.add(new SimpleDateFormat("MMMM/dd/yy"));
		dateFormatList.add(new SimpleDateFormat("MMM/dd/yyyy"));
		dateFormatList.add(new SimpleDateFormat("MMM/dd/yy"));
		dateFormatList.add(new SimpleDateFormat("MM dd yyyy"));
		dateFormatList.add(new SimpleDateFormat("dd MM yy"));
		dateFormatList.add(new SimpleDateFormat("dd MMMM yyyy"));
		dateFormatList.add(new SimpleDateFormat("dd MMMM yy"));
		dateFormatList.add(new SimpleDateFormat("dd MMM yyyy"));
		dateFormatList.add(new SimpleDateFormat("dd MMM yy"));
		dateFormatList.add(new SimpleDateFormat("dd MM yyyy"));
		dateFormatList.add(new SimpleDateFormat("dd MM yy"));
		dateFormatList.add(new SimpleDateFormat("MMMM dd yyyy"));
		dateFormatList.add(new SimpleDateFormat("MMMM dd yy"));
		dateFormatList.add(new SimpleDateFormat("MMM dd yyyy"));
		dateFormatList.add(new SimpleDateFormat("MMM dd yy"));
		dateFormatList.add(new SimpleDateFormat("MM*dd*yyyy"));
		dateFormatList.add(new SimpleDateFormat("MM.dd.yyyy"));
	    dateFormatList.add(new SimpleDateFormat("MM&dd&yyyy"));
	    dateFormatList.add(new SimpleDateFormat("MM@dd#yyyy"));
	    dateFormatList.add(new SimpleDateFormat("MM$dd%yyyy"));
	    dateFormatList.add(new SimpleDateFormat("yyyy(dd%MM"));
	    dateFormatList.add(new SimpleDateFormat("yyyyddMM"));
	    dateFormatList.add(new SimpleDateFormat("ddMMyyyy"));
	    dateFormatList.add(new SimpleDateFormat("dd:MM:yyyy"));
		dateFormatList.add(new SimpleDateFormat("dd-yyyy-mm"));
		dateFormatList.add(new SimpleDateFormat("dd/yyyy/mm"));
		dateFormatList.add(new SimpleDateFormat("dd yyyy mm"));
		dateFormatList.add(new SimpleDateFormat("yyyy-dd-mm"));
		dateFormatList.add(new SimpleDateFormat("yyyy-dd-mm"));
		dateFormatList.add(new SimpleDateFormat("yyyy-dd-mm"));

		boolean isConverted = false;
		Date date = null;
		for(SimpleDateFormat dateFormat : dateFormatList) {
			try {
				date = dateFormat.parse(strInputDate);
				isConverted = true;
				break;
			} catch (ParseException e) {}
		}
		String newDate="";
		if(isConverted)
		{
			SimpleDateFormat dateFormat = new SimpleDateFormat("MMM dd 20yy");
			newDate=dateFormat.format(date).trim();
			date=null;

			if(scenario.equals("Positive"))
			{ 
				if(!oldDate.equals(newDate) | oldDate.equals(value))
			{
				System.out.println("It is a defect.");
			}
			else
			{
				System.out.println("The test Case is passed.");
			}

			} else if(scenario.equals("Negative"))
			{

				if(value.equals(strdate))
			{
				System.out.println("The test case is passed.");
			}
				else 
			{ 
				System.out.println("It is a defect."); 
			}

			}
		}
		else
		{
			System.out.println("The test case is passed.");

		}
		driver.close();
		driver.quit();
	}
}

