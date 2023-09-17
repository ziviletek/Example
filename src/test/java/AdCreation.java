import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class AdCreation {

    public static WebDriver driver;

    @Test
    public void createAdPositiveTest() throws InterruptedException {
    driver.get("https://elenta.lt/patalpinti/ivesti-informacija?categoryId=NT_Butai&actionId=Siulo&returnurl=%2F");
    driver.findElement(By.id("title")).sendKeys("abcdefg");
    driver.findElement(By.id("text")).sendKeys("description");
    driver.findElement(By.id("price")).sendKeys("1234");
    driver.findElement(By.id("location-search-box")).sendKeys("city");
    driver.findElement(By.id("phone")).sendKeys("+37060000001");
    driver.findElement(By.id("email")).sendKeys("gms@gia.com");
    driver.findElement(By.id("submit-button")).click();
    WebElement uploadFile = driver.findElement(By.id("inputfile"));
    uploadFile.sendKeys(System.getProperty("user.dir") + "/src/main/resources/house.jpeg");
    Thread.sleep(2000);
    driver.findElement(By.id("forward-button")).click();
    }

@BeforeClass
    public void before() {
    driver = new ChromeDriver();
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
    acceptCookies();
}

public void acceptCookies() {
    driver.get("https://elenta.lt/");
    driver.findElement(By.className("fc-button-label")).click();
}

}
