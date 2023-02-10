import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.Keys;
import java.time.Duration;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Test1 {
    WebDriver driver;
    @BeforeTest
    public void browserSet(){
        System.setProperty("webdriver.chrome.driver", "D:\\chromedriver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://testpages.herokuapp.com/");
    }
    @Test
    public void testAlert() {
        driver.findElement(By.xpath("//h3[@class='LC20lb MBeuO DKV0Md']")).click();
        driver.findElement(By.id("alerttest")).click();
        driver.findElement(By.xpath("//input[@value='Show confirm box']")).click();
        driver.switchTo().alert().accept();
        WebElement result = driver.findElement(By.xpath("//p[@id='confirmreturn']"));
        Assertions.assertEquals("true",result.getText());
    }
	
	//@Test
	//public void testTable() {
		//driver.findElement(By.xpath("//a[@id='tablestest']")).click();
	//}
