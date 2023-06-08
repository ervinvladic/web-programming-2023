import static org.junit.jupiter.api.Assertions.*;

import java.awt.Desktop.Action;
import java.time.Duration;

import org.junit.Ignore;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


class radnikba {
	private static WebDriver webDriver;
	private static String baseUrl;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		webDriver.quit();
	}

	@BeforeEach
	void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver","C:/Users/Ervin/eclipse-workspace/.metadata/Selenium-Testing/code/chromedriver/chromedriver.exe");
		webDriver= new ChromeDriver();
		baseUrl="https://lobster-app-ibqe5.ondigitalocean.app/login.html";
	}

	@AfterEach
	void tearDown() throws Exception {
		

}
	/*  Login testing on the radnikba page 
	 *    */
	@Test
	@Order(1)
	void loginTest() throws InterruptedException {
		webDriver.get(baseUrl);
		webDriver.manage().window().maximize();
		Thread.sleep(5000);
		
		WebElement email = webDriver.findElement(By.xpath("/html/body/main/div/div[1]/div/div/div/div/form/div[1]/input"));
		email.clear();
		email.sendKeys("admin@gmail.com");
		Thread.sleep(2000);
		
		WebElement password = webDriver.findElement(By.xpath("//html/body/main/div/div[1]/div/div/div/div/form/div[2]/input"));
		password.clear();
		password.sendKeys("0000");
		Thread.sleep(2000);
		
		WebElement prijaviSebutton = webDriver.findElement(By.xpath("/html/body/main/div/div[1]/div/div/div/div/form/button"));
		prijaviSebutton.click();
		Thread.sleep(5000);
		
				
}
	/*   Register testing on the radnikba page 
	 *    */
	@Test
	@Order(2)
	void registerTest() throws InterruptedException {
		webDriver.get(baseUrl);
		webDriver.manage().window().maximize();
		Thread.sleep(3000);
		
		WebElement registrujSe = webDriver.findElement(By.xpath("/html/body/main/div/div[1]/div/div/div/div/form/div[3]/a"));
		registrujSe.click();
		Thread.sleep(2000);
		
		WebElement ime = webDriver.findElement(By.xpath("/html/body/main/div/div[2]/div/div/div/div/form/div[1]/input"));
		ime.sendKeys("Test");
		Thread.sleep(2000);
		
		WebElement prezime = webDriver.findElement(By.xpath("/html/body/main/div/div[2]/div/div/div/div/form/div[2]/input"));
		prezime.sendKeys("Tester");
		Thread.sleep(2000);
		
		WebElement email = webDriver.findElement(By.xpath("/html/body/main/div/div[2]/div/div/div/div/form/div[3]/input"));
		email.sendKeys("test.tester@gmail.com");
		Thread.sleep(2000);
		
		WebElement lozinka = webDriver.findElement(By.xpath("/html/body/main/div/div[2]/div/div/div/div/form/div[4]/input"));
		lozinka.sendKeys("123456");
		Thread.sleep(2000);
		
		WebElement scroll = webDriver.findElement(By.xpath("/html/body/main/div/div[2]/div/div/div/div/form/button"));
		scroll.sendKeys(Keys.PAGE_DOWN);
		Thread.sleep(2000);
		
		WebElement grad = webDriver.findElement(By.xpath("/html/body/main/div/div[2]/div/div/div/div/form/div[5]/input"));
		grad.sendKeys("Sarajevo");
		Thread.sleep(2000);	
		
		WebElement registrujSebutton = webDriver.findElement(By.xpath("/html/body/main/div/div[2]/div/div/div/div/form/button"));
		registrujSebutton.click();
		Thread.sleep(5000);
		
				
}
	
	/*  Testing the option to see all workers, adding a comment to a worker, and deleting the comment we added 
	 *    */
	@Test
	@Order(3)
	void reviewTest() throws InterruptedException {
		webDriver.get(baseUrl);
		webDriver.manage().window().maximize();
		Thread.sleep(5000);
		
		WebElement email = webDriver.findElement(By.xpath("/html/body/main/div/div[1]/div/div/div/div/form/div[1]/input"));
		email.clear();
		email.sendKeys("admin@gmail.com");
		Thread.sleep(2000);
		
		WebElement password = webDriver.findElement(By.xpath("/html/body/main/div/div[1]/div/div/div/div/form/div[2]/input"));
		password.clear();
		password.sendKeys("0000");
		Thread.sleep(2000);
		
		WebElement prijaviSebutton = webDriver.findElement(By.xpath("/html/body/main/div/div[1]/div/div/div/div/form/button"));
		prijaviSebutton.click();
		Thread.sleep(2000);
		
		WebElement scroll = webDriver.findElement(By.xpath("/html/body/main/div[2]/div[2]/div[2]/div/div/div/button[3]"));
		scroll.sendKeys(Keys.PAGE_DOWN);
		Thread.sleep(2000);
		
		WebElement sviRadnici = webDriver.findElement(By.xpath("/html/body/main/div[2]/div[2]/div[2]/div/div/div/button[3]"));
		sviRadnici.click();
		Thread.sleep(2000);
		
		WebElement komentari = webDriver.findElement(By.xpath("/html/body/div[3]/div/div/div[2]/div/div[2]/button[2]"));
		komentari.click();
		Thread.sleep(2000);
		
		WebElement ocjena = webDriver.findElement(By.xpath("/html/body/div[4]/div/div/div[3]/form/div/div[1]/select"));
		ocjena.click();
		Thread.sleep(2000);
		
		WebElement ocjena5 = webDriver.findElement(By.xpath("/html/body/div[4]/div/div/div[3]/form/div/div[1]/select/option[2]"));
		ocjena5.click();
		Thread.sleep(1000);
		
		WebElement komentar = webDriver.findElement(By.xpath("/html/body/div[4]/div/div/div[3]/form/div/div[2]/input"));
		komentar.sendKeys("Odlican radnik");
		Thread.sleep(2000);
		
		WebElement dodajButton = webDriver.findElement(By.xpath("/html/body/div[4]/div/div/div[3]/form/div/div[3]/button"));
		dodajButton.click();
		Thread.sleep(3000);
		
		WebElement obrisiButton = webDriver.findElement(By.xpath("/html/body/div[4]/div/div/div[2]/div/div/button"));
		obrisiButton.click();
		Thread.sleep(3000);
		
		
		
				
}
	
	/*  Testing the search on the radnikba page 
	 *    */
	@Test
	@Order(4)
	void searchTest() throws InterruptedException {
		webDriver.get(baseUrl);
		webDriver.manage().window().maximize();
		Thread.sleep(5000);
		
		WebElement email = webDriver.findElement(By.xpath("/html/body/main/div/div[1]/div/div/div/div/form/div[1]/input"));
		email.clear();
		email.sendKeys("admin@gmail.com");
		Thread.sleep(2000);
		
		WebElement password = webDriver.findElement(By.xpath("/html/body/main/div/div[1]/div/div/div/div/form/div[2]/input"));
		password.clear();
		password.sendKeys("0000");
		Thread.sleep(2000);
		
		WebElement prijaviSebutton = webDriver.findElement(By.xpath("/html/body/main/div/div[1]/div/div/div/div/form/button"));
		prijaviSebutton.click();
		Thread.sleep(2000);
		
		WebElement pretragaButton = webDriver.findElement(By.xpath("/html/body/main/div[2]/div[1]/button[1]"));
		pretragaButton.click();
		Thread.sleep(3000);
		
		WebElement upisUpretragu = webDriver.findElement(By.xpath("/html/body/main/div[1]/form/input"));
		upisUpretragu.sendKeys("sarajevo");
		Thread.sleep(2000);
		
		WebElement pretraziButton = webDriver.findElement(By.xpath("/html/body/main/div[1]/form/button"));
		pretraziButton.click();
		Thread.sleep(3000);
		
		
				
}
	/*  Adding, editing and deleting job as admin
	 *    */
	@Test
	@Order(5)
	void adminTest() throws InterruptedException {
		webDriver.get(baseUrl);
		webDriver.manage().window().maximize();
		Thread.sleep(5000);
		
		WebElement email = webDriver.findElement(By.xpath("/html/body/main/div/div[1]/div/div/div/div/form/div[1]/input"));
		email.clear();
		email.sendKeys("admin@gmail.com");
		Thread.sleep(2000);
		
		WebElement password = webDriver.findElement(By.xpath("/html/body/main/div/div[1]/div/div/div/div/form/div[2]/input"));
		password.clear();
		password.sendKeys("0000");
		Thread.sleep(2000);
		
		WebElement prijaviSebutton = webDriver.findElement(By.xpath("/html/body/main/div/div[1]/div/div/div/div/form/button"));
		prijaviSebutton.click();
		Thread.sleep(2000);
		
		WebElement dodajPosao = webDriver.findElement(By.xpath("/html/body/main/div[2]/div[1]/button[2]"));
		dodajPosao.click();
		Thread.sleep(3000);
		
		WebElement imePosla = webDriver.findElement(By.xpath("/html/body/div[2]/div/div/form/div[2]/div[1]/input"));
		imePosla.sendKeys("Testni posao");
		Thread.sleep(2000);
		
		WebElement opisPosla = webDriver.findElement(By.xpath("/html/body/div[2]/div/div/form/div[2]/div[2]/input"));
		opisPosla.sendKeys("Testni posao");
		Thread.sleep(2000);
		
		WebElement potvrdi = webDriver.findElement(By.xpath("/html/body/div[2]/div/div/form/div[3]/button[2]"));
		potvrdi.click();
		Thread.sleep(3000);
		
		WebElement scroll = webDriver.findElement(By.xpath("/html/body/main/div[2]/div[2]/div[5]/div/div/div/button[1]"));
		scroll.sendKeys(Keys.PAGE_DOWN);
		Thread.sleep(2000);
		
		WebElement urediPosao = webDriver.findElement(By.xpath("/html/body/main/div[2]/div[2]/div[5]/div/div/div/button[1]"));
		urediPosao.click();
		Thread.sleep(3000);
		
		WebElement imePosla1 = webDriver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/input[2]"));
		imePosla1.clear();
		imePosla1.sendKeys("Testni posao 1");
		Thread.sleep(2000);
		
		WebElement opisPosla1 = webDriver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/input[3]"));
		opisPosla1.clear();
		opisPosla1.sendKeys("Testni posao 1");
		Thread.sleep(2000);
		
		WebElement sacuvajPromjene = webDriver.findElement(By.xpath("/html/body/div[1]/div/div/div[3]/button[2]"));
		sacuvajPromjene.click();
		Thread.sleep(3000);
		
		WebElement scroll2 = webDriver.findElement(By.xpath("/html/body/main/div[2]/div[2]/div[5]/div/div/div/button[2]"));
		scroll2.sendKeys(Keys.PAGE_DOWN);
		Thread.sleep(2000);
		
		WebElement obrisiPosao = webDriver.findElement(By.xpath("/html/body/main/div[2]/div[2]/div[5]/div/div/div/button[2]"));
		obrisiPosao.click();
		Thread.sleep(3000);
		
		
				
}
	
	/*  Adding and deleting workers as admin
	 *    */
	@Test
	@Order(6)
	void adminTest2() throws InterruptedException {
		webDriver.get(baseUrl);
		webDriver.manage().window().maximize();
		Thread.sleep(5000);
		
		WebElement email = webDriver.findElement(By.xpath("/html/body/main/div/div[1]/div/div/div/div/form/div[1]/input"));
		email.clear();
		email.sendKeys("admin@gmail.com");
		Thread.sleep(2000);
		
		WebElement password = webDriver.findElement(By.xpath("/html/body/main/div/div[1]/div/div/div/div/form/div[2]/input"));
		password.clear();
		password.sendKeys("0000");
		Thread.sleep(2000);
		
		WebElement prijaviSebutton = webDriver.findElement(By.xpath("/html/body/main/div/div[1]/div/div/div/div/form/button"));
		prijaviSebutton.click();
		Thread.sleep(2000);
		
		WebElement scroll = webDriver.findElement(By.xpath("/html/body/main/div[2]/div[2]/div[3]/div/div/div/button[3]"));
		scroll.sendKeys(Keys.PAGE_DOWN);
		Thread.sleep(2000);
		
		WebElement sviRadnici = webDriver.findElement(By.xpath("/html/body/main/div[2]/div[2]/div[3]/div/div/div/button[3]"));
		sviRadnici.click();
		Thread.sleep(3000);
		
		WebElement imeIprezime = webDriver.findElement(By.xpath("/html/body/div[3]/div/div/div[3]/form/div/div[1]/input"));
		imeIprezime.sendKeys("Test Tester");
		Thread.sleep(2000);
		
		WebElement email2= webDriver.findElement(By.xpath("/html/body/div[3]/div/div/div[3]/form/div/div[2]/input"));
		email2.sendKeys("test.tester@gmail.com");
		Thread.sleep(2000);
		
		WebElement grad= webDriver.findElement(By.xpath("/html/body/div[3]/div/div/div[3]/form/div/div[3]/input"));
		grad.sendKeys("Testni grad");
		Thread.sleep(2000);
		
		WebElement telefon= webDriver.findElement(By.xpath("/html/body/div[3]/div/div/div[3]/form/div/div[4]/input"));
		telefon.sendKeys("061111212");
		Thread.sleep(2000);
		
		WebElement adresa= webDriver.findElement(By.xpath("/html/body/div[3]/div/div/div[3]/form/div/div[5]/input"));
		adresa.sendKeys("Testna adresa");
		Thread.sleep(2000);
		
		WebElement dodaj = webDriver.findElement(By.xpath("/html/body/div[3]/div/div/div[3]/form/div/div[6]/button"));
		dodaj.click();
		Thread.sleep(3000);
		
		WebElement obrisi = webDriver.findElement(By.xpath("/html/body/div[3]/div/div/div[2]/div/div/button[1]"));
		obrisi.click();
		Thread.sleep(3000);
		
		
		
		
				
}
	
}