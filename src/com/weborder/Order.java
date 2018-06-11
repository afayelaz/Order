package com.weborder;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/*
 * Test Case: Order
Open browser
Go to url http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx (Links to an external site.)Links to an external site.
Login using username Tester and password test
Click on Order link
Enter a random quantity between 1 and 100
Enter Customer Name: John <middle_name> Smith. Instead of <middle_name> your code should enter a random string every time.
Enter street: 123 Any st
Enter City: Anytown
Enter State: Virginia
Enter a random 5 digit number to the zip code field
Select any card type. Every time your code should select a different type.
Enter any card number. If you selected Visa, card number should start with 4. If you selected Master, card number should start with 5. If you selected American Express, card number should start with 3. New card number should be auto generated every time you run the test. Card numbers should be 16 digits for Visa and Master, 15 for American Express.
Enter any valid expiration date 
Click on Process
Verify than the page contains text New order has been successfully added.
 */

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.ClickAction;
import org.openqa.selenium.support.ui.Select;

public class Order {

	public static void main(String[] args) throws InterruptedException {
		
		Random rn = new Random();
		int random = rn.nextInt(100);
		int random2 = rn.nextInt(9);
		//System.out.println(random);
		String run_num = Integer.toString(random);
		
		int card = getRandomInteger(1,3);
		
		
		

		
		System.setProperty("webdriver.chrome.driver", 
"/Users/alacaf/Documents/selenium dependencies/drivers/chromedriver");
		WebDriver driver = new ChromeDriver();
driver.get("http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx");
		
	Thread.sleep(1000);
	driver.findElement(By.id("ctl00_MainContent_username")).sendKeys("Tester");
	//driver.findElement(By.name("ctl00$MainContent$username")).sendKeys("Tester");
	driver.findElement(By.id("ctl00_MainContent_password")).sendKeys("test");
	driver.findElement(By.id("ctl00_MainContent_login_button")).click();
	
	driver.findElement(By.linkText("Order")).click();
	
//	Select dropdown = new Select (driver.findElement(By.name("ctl00$MainContent$fmwOrder$ddlProduct")));
//	dropdown.selectByVisibleText("MyMoney");
	
	driver.findElement(By.name("ctl00$MainContent$fmwOrder$txtQuantity")).
	sendKeys(Keys.HOME,Keys.chord(Keys.SHIFT,Keys.END),run_num);

	//driver.findElement(By.cssSelector("input[type = 'submit']")).click();
	
	driver.findElement(By.name("ctl00$MainContent$fmwOrder$txtName")).sendKeys("John " + randomIdentifier() + " Smith" );
	Thread.sleep(1000);
	
	driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox2")).sendKeys("123 Any st");
	driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox3")).sendKeys("Anytown");
	driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox4")).sendKeys("Virginia");
	driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox5")).sendKeys(zipCode());
	
	driver.findElement(By.xpath("(//input[@name='ctl00$MainContent$fmwOrder$cardList'])["+ card +"]")).click();
	
		if (card == 1) {
			driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox6")).sendKeys( 4  + creditCardNumber(15) );
		} else if (card == 2) {
			driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox6")).sendKeys( 5 + creditCardNumber(15) );
		} else if (card == 3) {
			driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox6")).sendKeys( 3 + creditCardNumber(14) );
		}
		
//		switch(card) {
//		case 1: driver.findElement(By.name("ctl00$MainContent$fmwOrder$TextBox6")).sendKeys("4"+randomCard(16) ); break; 
//		case 2: driver.findElement(By.name("ctl00$MainContent$fmwOrder$TextBox6")).sendKeys("5"+randomCard(16)  ); break;
//		case 3: driver.findElement(By.name("ctl00$MainContent$fmwOrder$TextBox6")).sendKeys("3"+randomCard(15)  ); break;
//		}
	
		driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox1")).sendKeys("10/22");
		
		driver.findElement(By.linkText("Process")).click();
		 
		if( driver.findElement(By.cssSelector("#ctl00_MainContent_fmwOrder > tbody > tr > td > div > strong")).isDisplayed()){
			System.out.println("Verified");
	}else{
			System.out.println("unVerified");
	}
		
		
		
		
	}
	
	public static String creditCardNumber(int numbers)
	 {
	 String CreditCardNumber ="";
	 int nums = numbers;
	 Random num = new Random();
	 for (int i = 0; i < nums; i++)
	 {
	 CreditCardNumber = num.nextInt(9) + CreditCardNumber;
	 }

	return CreditCardNumber;
	 }
	
	public static String randomCard(int num) {
		
		Random rn = new Random();
		String card=""; 
		for (int i = 0; i < num-1; i++) {
			int random = rn.nextInt(10); 
		    card=card+random;  
			
		}
		
		return  card; 
		
	
		
	}
	
	
	public static int getRandomInteger(int min, int max){
	    return ThreadLocalRandom.current().nextInt(min, max+1);
	}
	
	public static String randomIdentifier() {
		
		final String lexicon = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		Random rn = new Random();
		int random1 = rn.nextInt(24);
		int random2 = rn.nextInt(24);
		
	    
	    return lexicon.charAt(random1)+""+lexicon.charAt(random2);
	}
	
	public static String zipCode() {
		
		Random rn = new Random();
		int random = rn.nextInt(10);
		int randomfirst=rn.nextInt(9)+1; 
		String zipcode=""+randomfirst+random+random+random+random; 
		return  zipcode; 
		
	
		
	}
	
	
		
	
		
	}


