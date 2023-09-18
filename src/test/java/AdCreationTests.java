import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class AdCreationTests {

    public static WebDriver driver;
    public static WebDriverWait wait;

    @Test
    public void createAdPositiveTest() throws InterruptedException {
        driver.get("https://elenta.lt/patalpinti/ivesti-informacija?categoryId=NT_Butai&actionId=Siulo&returnurl=%2F");
        driver.findElement(By.id("title")).sendKeys("Abcdefg1234!?/");
        driver.findElement(By.id("text")).sendKeys("Description1234!?/");
        driver.findElement(By.id("price")).sendKeys("1234");
        driver.findElement(By.id("location-search-box")).sendKeys("Vilnius");
        driver.findElement(By.id("phone")).sendKeys("+37060000001");
        driver.findElement(By.id("email")).sendKeys("gms@gia.com");
        driver.findElement(By.id("submit-button")).click();
        WebElement uploadFile = driver.findElement(By.id("inputfile"));
        uploadFile.sendKeys(System.getProperty("user.dir") + "/src/main/resources/house.jpeg");
        Thread.sleep(2000);
        driver.findElement(By.id("forward-button")).click();
    }

    @Test
    public void createAd2CharsTest() {
        //according to imaginary documentation it is indicated that the title should be longer than 3 symbols
        driver.get("https://elenta.lt/patalpinti/ivesti-informacija?categoryId=NT_Butai&actionId=Siulo&returnurl=%2F");
        driver.findElement(By.id("title")).sendKeys("Ab");
        driver.findElement(By.id("text")).sendKeys("description1234!?/");
        driver.findElement(By.id("price")).sendKeys("1234");
        driver.findElement(By.id("location-search-box")).sendKeys("Vilnius");
        driver.findElement(By.id("phone")).sendKeys("+37060000001");
        driver.findElement(By.id("email")).sendKeys("gms@gia.com");
        driver.findElement(By.id("submit-button")).click();
        driver.findElement(By.id("forward-button")).click();

        String txt = "";
        try {
            txt = driver.findElement(By.id("te")).getText();
        } catch (Exception e) {
        }
        Assert.assertEquals(txt, "Pavadinime turi būti bent 3 simboliai");
    }

    @Test
    public void createAd3CharsTest() {
        //according to imaginary documentation it is indicated that the title should be longer than 3 symbols
        driver.get("https://elenta.lt/patalpinti/ivesti-informacija?categoryId=NT_Butai&actionId=Siulo&returnurl=%2F");
        driver.findElement(By.id("title")).sendKeys("Abc");
        driver.findElement(By.id("text")).sendKeys("description1234!?/");
        driver.findElement(By.id("price")).sendKeys("1234");
        driver.findElement(By.id("location-search-box")).sendKeys("Vilnius");
        driver.findElement(By.id("phone")).sendKeys("+37060000001");
        driver.findElement(By.id("email")).sendKeys("gms@gia.com");
        driver.findElement(By.id("submit-button")).click();
        driver.findElement(By.id("forward-button")).click();
    }

    @Test
    public void createAdTitle150CharsTest() {
        //according to imaginary documentation it is indicated that the title should not be longer than 150 symbols
        driver.get("https://elenta.lt/patalpinti/ivesti-informacija?categoryId=NT_Butai&actionId=Siulo&returnurl=%2F");
        driver.findElement(By.id("title")).sendKeys("Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis p");
        driver.findElement(By.id("text")).sendKeys("description1234!?/");
        driver.findElement(By.id("price")).sendKeys("1234");
        driver.findElement(By.id("location-search-box")).sendKeys("Vilnius");
        driver.findElement(By.id("phone")).sendKeys("+37060000001");
        driver.findElement(By.id("email")).sendKeys("gms@gia.com");
        driver.findElement(By.id("submit-button")).click();
        driver.findElement(By.id("forward-button")).click();
    }

    @Test
    public void createAdTitle151CharsTest() {
        //according to imaginary documentation it is indicated that the title should not be longer than 150 symbols
        driver.get("https://elenta.lt/patalpinti/ivesti-informacija?categoryId=NT_Butai&actionId=Siulo&returnurl=%2F");
        driver.findElement(By.id("title")).sendKeys("Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis pa");
        driver.findElement(By.id("text")).sendKeys("description1234!?/");
        driver.findElement(By.id("price")).sendKeys("1234");
        driver.findElement(By.id("location-search-box")).sendKeys("Vilnius");
        driver.findElement(By.id("phone")).sendKeys("+37060000001");
        driver.findElement(By.id("email")).sendKeys("gms@gia.com");
        driver.findElement(By.id("submit-button")).click();
        driver.findElement(By.id("forward-button")).click();

        String txt = "";
        try {
            txt = driver.findElement(By.id("te")).getText();
        } catch (Exception e) {
        }
        Assert.assertEquals(txt, "Pavadinime turi būti iki 150 simbolių");
    }

    @Test
    public void createAdSymbolsInTitlePositiveTest() {
        driver.get("https://elenta.lt/patalpinti/ivesti-informacija?categoryId=NT_Butai&actionId=Siulo&returnurl=%2F");
        driver.findElement(By.id("title")).sendKeys("!@#$%^&*()_+-=[{]}|;\":");
        driver.findElement(By.id("text")).sendKeys("description1234!?/");
        driver.findElement(By.id("price")).sendKeys("1234");
        driver.findElement(By.id("location-search-box")).sendKeys("Vilnius");
        driver.findElement(By.id("phone")).sendKeys("+37060000001");
        driver.findElement(By.id("email")).sendKeys("gms@gia.com");
        driver.findElement(By.id("submit-button")).click();
        driver.findElement(By.id("forward-button")).click();
    }

    @Test
    public void createAdNoTitleTest() {
        driver.get("https://elenta.lt/patalpinti/ivesti-informacija?categoryId=NT_Butai&actionId=Siulo&returnurl=%2F");
        driver.findElement(By.id("title")).sendKeys("");
        driver.findElement(By.id("text")).sendKeys("description1234!?/");
        driver.findElement(By.id("price")).sendKeys("1234");
        driver.findElement(By.id("location-search-box")).sendKeys("Vilnius");
        driver.findElement(By.id("phone")).sendKeys("+37060000001");
        driver.findElement(By.id("email")).sendKeys("gms@gia.com");
        driver.findElement(By.id("submit-button")).click();
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.id("te"), "Įveskite skelbimo pavadinimą"));

        String txt = "";
        try {
            txt = driver.findElement(By.id("te")).getText();
            System.out.println(txt);
        } catch (Exception e) {
        }
        Assert.assertEquals(txt, "Įveskite skelbimo pavadinimą");
    }

    @Test
    public void createAdDescription4CharsTest() {
        //according to imaginary documentation it is indicated that the description should be longer than 5 symbols
        driver.get("https://elenta.lt/patalpinti/ivesti-informacija?categoryId=NT_Butai&actionId=Siulo&returnurl=%2F");
        driver.findElement(By.id("title")).sendKeys("Abcd");
        driver.findElement(By.id("text")).sendKeys("description1234!?/");
        driver.findElement(By.id("price")).sendKeys("1234");
        driver.findElement(By.id("location-search-box")).sendKeys("Vilnius");
        driver.findElement(By.id("phone")).sendKeys("+37060000001");
        driver.findElement(By.id("email")).sendKeys("gms@gia.com");
        driver.findElement(By.id("submit-button")).click();
        driver.findElement(By.id("forward-button")).click();

        String txt = "";
        try {
            txt = driver.findElement(By.id("te")).getText();
        } catch (Exception e) {
        }
        Assert.assertEquals(txt, "Aprašyme turi būti bent 5 simboliai");
    }

    @Test
    public void createAdDescription5CharsTest() {
        //according to imaginary documentation it is indicated that the description should be longer than 5 symbols
        driver.get("https://elenta.lt/patalpinti/ivesti-informacija?categoryId=NT_Butai&actionId=Siulo&returnurl=%2F");
        driver.findElement(By.id("title")).sendKeys("Abcde");
        driver.findElement(By.id("text")).sendKeys("description1234!?/");
        driver.findElement(By.id("price")).sendKeys("1234");
        driver.findElement(By.id("location-search-box")).sendKeys("Vilnius");
        driver.findElement(By.id("phone")).sendKeys("+37060000001");
        driver.findElement(By.id("email")).sendKeys("gms@gia.com");
        driver.findElement(By.id("submit-button")).click();
        driver.findElement(By.id("forward-button")).click();
    }

    @Test
    public void createAdDescription200CharsTest() {
        //according to imaginary documentation it is indicated that the description should not be longer than 200 symbols
        driver.get("https://elenta.lt/patalpinti/ivesti-informacija?categoryId=NT_Butai&actionId=Siulo&returnurl=%2F");
        driver.findElement(By.id("title")).sendKeys("Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Donec qu");
        driver.findElement(By.id("text")).sendKeys("description1234!?/");
        driver.findElement(By.id("price")).sendKeys("1234");
        driver.findElement(By.id("location-search-box")).sendKeys("Vilnius");
        driver.findElement(By.id("phone")).sendKeys("+37060000001");
        driver.findElement(By.id("email")).sendKeys("gms@gia.com");
        driver.findElement(By.id("submit-button")).click();
        driver.findElement(By.id("forward-button")).click();
    }

    @Test
    public void createAdDescription201CharsTest() {
        //according to imaginary documentation it is indicated that the description should not be longer than 200 symbols
        driver.get("https://elenta.lt/patalpinti/ivesti-informacija?categoryId=NT_Butai&actionId=Siulo&returnurl=%2F");
        driver.findElement(By.id("title")).sendKeys("Abcd");
        driver.findElement(By.id("text")).sendKeys("Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Donec qua");
        driver.findElement(By.id("price")).sendKeys("1234");
        driver.findElement(By.id("location-search-box")).sendKeys("Vilnius");
        driver.findElement(By.id("phone")).sendKeys("+37060000001");
        driver.findElement(By.id("email")).sendKeys("gms@gia.com");
        driver.findElement(By.id("submit-button")).click();
        driver.findElement(By.id("forward-button")).click();

        String txt = "";
        try {
            txt = driver.findElement(By.id("te")).getText();
        } catch (Exception e) {
        }
        Assert.assertEquals(txt, "Skelbimo aprašymas viršija 200 simbolių");
    }

    @Test
    public void createAdDescriptionNumbersOnlyPositiveTest() {
        driver.get("https://elenta.lt/patalpinti/ivesti-informacija?categoryId=NT_Butai&actionId=Siulo&returnurl=%2F");
        driver.findElement(By.id("title")).sendKeys("Abc");
        driver.findElement(By.id("text")).sendKeys("1234567890");
        driver.findElement(By.id("price")).sendKeys("1234");
        driver.findElement(By.id("location-search-box")).sendKeys("Vilnius");
        driver.findElement(By.id("phone")).sendKeys("+37060000001");
        driver.findElement(By.id("email")).sendKeys("gms@gia.com");
        driver.findElement(By.id("submit-button")).click();
        driver.findElement(By.id("forward-button")).click();
    }

    @Test
    public void createAdDescriptionSymbolsOnlyPositiveTest() {
        driver.get("https://elenta.lt/patalpinti/ivesti-informacija?categoryId=NT_Butai&actionId=Siulo&returnurl=%2F");
        driver.findElement(By.id("title")).sendKeys("Abc");
        driver.findElement(By.id("text")).sendKeys("!@#$%^&*)(-_=+?';:");
        driver.findElement(By.id("price")).sendKeys("1234");
        driver.findElement(By.id("location-search-box")).sendKeys("Vilnius");
        driver.findElement(By.id("phone")).sendKeys("+37060000001");
        driver.findElement(By.id("email")).sendKeys("gms@gia.com");
        driver.findElement(By.id("submit-button")).click();
        driver.findElement(By.id("forward-button")).click();
    }

    @Test
    public void createAdNoPriceTest() {
        //according to imaginary documentation it is indicated that the ad must have a price
        driver.get("https://elenta.lt/patalpinti/ivesti-informacija?categoryId=NT_Butai&actionId=Siulo&returnurl=%2F");
        driver.findElement(By.id("title")).sendKeys("Abcde");
        driver.findElement(By.id("text")).sendKeys("description1234!?/");
        driver.findElement(By.id("price")).sendKeys("");
        driver.findElement(By.id("location-search-box")).sendKeys("Vilnius");
        driver.findElement(By.id("phone")).sendKeys("+37060000001");
        driver.findElement(By.id("email")).sendKeys("gms@gia.com");
        driver.findElement(By.id("submit-button")).click();

        String txt = "";
        try {
            txt = driver.findElement(By.id("te")).getText();
        } catch (Exception e) {
        }
        Assert.assertEquals(txt, "Įveskite kainą");
    }

    @Test
    public void createAdPrice10NumbersTest() {
        //according to imaginary documentation it is indicated that the ad's price can have only 10 numbers
        driver.get("https://elenta.lt/patalpinti/ivesti-informacija?categoryId=NT_Butai&actionId=Siulo&returnurl=%2F");
        driver.findElement(By.id("title")).sendKeys("Abcde");
        driver.findElement(By.id("text")).sendKeys("description1234!?/");
        driver.findElement(By.id("price")).sendKeys("01234567891");
        driver.findElement(By.id("location-search-box")).sendKeys("Vilnius");
        driver.findElement(By.id("phone")).sendKeys("+37060000001");
        driver.findElement(By.id("email")).sendKeys("gms@gia.com");
        driver.findElement(By.id("submit-button")).click();
        driver.findElement(By.id("forward-button")).click();
    }

    @Test
    public void createAdPrice11NumbersTest() {
        //according to imaginary documentation it is indicated that the ad's price can have only 10 numbers
        driver.get("https://elenta.lt/patalpinti/ivesti-informacija?categoryId=NT_Butai&actionId=Siulo&returnurl=%2F");
        driver.findElement(By.id("title")).sendKeys("Abcde");
        driver.findElement(By.id("text")).sendKeys("description1234!?/");
        driver.findElement(By.id("price")).sendKeys("01234567891");
        driver.findElement(By.id("location-search-box")).sendKeys("Vilnius");
        driver.findElement(By.id("phone")).sendKeys("+37060000001");
        driver.findElement(By.id("email")).sendKeys("gms@gia.com");
        driver.findElement(By.id("submit-button")).click();

        String txt = "";
        try {
            txt = driver.findElement(By.id("te")).getText();
        } catch (Exception e) {
        }
        Assert.assertEquals(txt, "Kaina yra per didelė");
    }

    @Test
    public void createAdPriceOnlyCharsTest() {
        //according to imaginary documentation it is indicated that the ad's price must contain only numbers
        driver.get("https://elenta.lt/patalpinti/ivesti-informacija?categoryId=NT_Butai&actionId=Siulo&returnurl=%2F");
        driver.findElement(By.id("title")).sendKeys("Abcde");
        driver.findElement(By.id("text")).sendKeys("description1234!?/");
        driver.findElement(By.id("price")).sendKeys("abcde");
        driver.findElement(By.id("location-search-box")).sendKeys("Vilnius");
        driver.findElement(By.id("phone")).sendKeys("+37060000001");
        driver.findElement(By.id("email")).sendKeys("gms@gia.com");
        driver.findElement(By.id("submit-button")).click();

        String txt = "";
        try {
            txt = driver.findElement(By.id("te")).getText();
        } catch (Exception e) {
        }
        Assert.assertEquals(txt, "Kainoje turi būti tik skaičiai");
    }

    @Test
    public void createAdPriceOnlySymbolsTest() {
        //according to imaginary documentation it is indicated that the ad's price must contain only numbers
        driver.get("https://elenta.lt/patalpinti/ivesti-informacija?categoryId=NT_Butai&actionId=Siulo&returnurl=%2F");
        driver.findElement(By.id("title")).sendKeys("Abcde");
        driver.findElement(By.id("text")).sendKeys("description1234!?/");
        driver.findElement(By.id("price")).sendKeys("!@#$%^&*)(");
        driver.findElement(By.id("location-search-box")).sendKeys("Vilnius");
        driver.findElement(By.id("phone")).sendKeys("+37060000001");
        driver.findElement(By.id("email")).sendKeys("gms@gia.com");
        driver.findElement(By.id("submit-button")).click();

        String txt = "";
        try {
            txt = driver.findElement(By.id("te")).getText();
        } catch (Exception e) {
        }
        Assert.assertEquals(txt, "Kainoje turi būti tik skaičiai");
    }

    @Test
    public void createAdNoLocationPositiveTest() {
        driver.get("https://elenta.lt/patalpinti/ivesti-informacija?categoryId=NT_Butai&actionId=Siulo&returnurl=%2F");
        driver.findElement(By.id("title")).sendKeys("Abcde");
        driver.findElement(By.id("text")).sendKeys("description1234!?/");
        driver.findElement(By.id("price")).sendKeys("123");
        driver.findElement(By.id("location-search-box")).sendKeys("");
        driver.findElement(By.id("phone")).sendKeys("+37060000001");
        driver.findElement(By.id("email")).sendKeys("gms@gia.com");
        driver.findElement(By.id("submit-button")).click();
        driver.findElement(By.id("forward-button")).click();
    }

    @Test
    public void createAdNoPhoneNumberTest() {
        driver.get("https://elenta.lt/patalpinti/ivesti-informacija?categoryId=NT_Butai&actionId=Siulo&returnurl=%2F");
        driver.findElement(By.id("title")).sendKeys("Abcde");
        driver.findElement(By.id("text")).sendKeys("description1234!?/");
        driver.findElement(By.id("price")).sendKeys("123");
        driver.findElement(By.id("location-search-box")).sendKeys("Vilnius");
        driver.findElement(By.id("phone")).sendKeys("");
        driver.findElement(By.id("email")).sendKeys("gms@gia.com");
        driver.findElement(By.id("submit-button")).click();
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.id("ce"), "Įveskite telefono numerį"));

        String txt = "";
        try {
            txt = driver.findElement(By.id("ce")).getText();
            System.out.println(txt);
        } catch (Exception e) {
        }
        Assert.assertEquals(txt, "Įveskite telefono numerį");
    }

    @Test
    public void createAdLettersPhoneTest() {
        driver.get("https://elenta.lt/patalpinti/ivesti-informacija?categoryId=NT_Butai&actionId=Siulo&returnurl=%2F");
        driver.findElement(By.id("title")).sendKeys("Abcde");
        driver.findElement(By.id("text")).sendKeys("description1234!?/");
        driver.findElement(By.id("price")).sendKeys("123");
        driver.findElement(By.id("location-search-box")).sendKeys("Vilnius");
        driver.findElement(By.id("phone")).sendKeys("grtggte");
        driver.findElement(By.id("email")).sendKeys("gms@gia.com");
        driver.findElement(By.id("submit-button")).click();
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.id("pe"), "Blogas tel. numeris"));

        String txt = "";
        try {
            txt = driver.findElement(By.id("pe")).getText();
            System.out.println(txt);
        } catch (Exception e) {
        }
        Assert.assertEquals(txt, "Blogas tel. numeris");
    }

    @Test
    public void createAdWrongNumberTest() {
        driver.get("https://elenta.lt/patalpinti/ivesti-informacija?categoryId=NT_Butai&actionId=Siulo&returnurl=%2F");
        driver.findElement(By.id("title")).sendKeys("Abcde");
        driver.findElement(By.id("text")).sendKeys("description1234!?/");
        driver.findElement(By.id("price")).sendKeys("123");
        driver.findElement(By.id("location-search-box")).sendKeys("Vilnius");
        driver.findElement(By.id("phone")).sendKeys("+1234567");
        driver.findElement(By.id("email")).sendKeys("gms@gia.com");
        driver.findElement(By.id("submit-button")).click();
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.id("pe"), "Blogas tel. numeris"));

        String txt = "";
        try {
            txt = driver.findElement(By.id("pe")).getText();
            System.out.println(txt);
        } catch (Exception e) {
        }
        Assert.assertEquals(txt, "Blogas tel. numeris");
    }

    @Test
    public void createAdPhone12NumbersTest() {
        driver.get("https://elenta.lt/patalpinti/ivesti-informacija?categoryId=NT_Butai&actionId=Siulo&returnurl=%2F");
        driver.findElement(By.id("title")).sendKeys("Abcde");
        driver.findElement(By.id("text")).sendKeys("description1234!?/");
        driver.findElement(By.id("price")).sendKeys("123");
        driver.findElement(By.id("location-search-box")).sendKeys("Vilnius");
        driver.findElement(By.id("phone")).sendKeys("+370600000012");
        driver.findElement(By.id("email")).sendKeys("gms@gia.com");
        driver.findElement(By.id("submit-button")).click();
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.id("pe"), "Blogas tel. numeris"));

        String txt = "";
        try {
            txt = driver.findElement(By.id("pe")).getText();
            System.out.println(txt);
        } catch (Exception e) {
        }
        Assert.assertEquals(txt, "Blogas tel. numeris");
    }

    @Test
    public void createAdNoEmailPositiveTest() {
        driver.get("https://elenta.lt/patalpinti/ivesti-informacija?categoryId=NT_Butai&actionId=Siulo&returnurl=%2F");
        driver.findElement(By.id("title")).sendKeys("Abcde");
        driver.findElement(By.id("text")).sendKeys("description1234!?/");
        driver.findElement(By.id("price")).sendKeys("123");
        driver.findElement(By.id("location-search-box")).sendKeys("Vilnius");
        driver.findElement(By.id("phone")).sendKeys("+37060000001");
        driver.findElement(By.id("email")).sendKeys("");
        driver.findElement(By.id("submit-button")).click();
        driver.findElement(By.id("forward-button")).click();
    }

    @Test
    public void createAdNoSymbolEmailTest() {
        driver.get("https://elenta.lt/patalpinti/ivesti-informacija?categoryId=NT_Butai&actionId=Siulo&returnurl=%2F");
        driver.findElement(By.id("title")).sendKeys("Abcde");
        driver.findElement(By.id("text")).sendKeys("description1234!?/");
        driver.findElement(By.id("price")).sendKeys("123");
        driver.findElement(By.id("location-search-box")).sendKeys("Vilnius");
        driver.findElement(By.id("phone")).sendKeys("+37060000001");
        driver.findElement(By.id("email")).sendKeys("fffgia.com");
        driver.findElement(By.id("submit-button")).click();
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.id("ee"), "Blogas el. pašto adresas"));

        String txt = "";
        try {
            txt = driver.findElement(By.id("ee")).getText();
            System.out.println(txt);
        } catch (Exception e) {
        }
        Assert.assertEquals(txt, "Blogas el. pašto adresas");
    }

    @Test
    public void createAdServerEmailTest() {
        driver.get("https://elenta.lt/patalpinti/ivesti-informacija?categoryId=NT_Butai&actionId=Siulo&returnurl=%2F");
        driver.findElement(By.id("title")).sendKeys("Abcde");
        driver.findElement(By.id("text")).sendKeys("description1234!?/");
        driver.findElement(By.id("price")).sendKeys("123");
        driver.findElement(By.id("location-search-box")).sendKeys("Vilnius");
        driver.findElement(By.id("phone")).sendKeys("+37060000001");
        driver.findElement(By.id("email")).sendKeys("sfl@.com");
        driver.findElement(By.id("submit-button")).click();
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.id("ee"), "Blogas el. pašto adresas"));

        String txt = "";
        try {
            txt = driver.findElement(By.id("ee")).getText();
            System.out.println(txt);
        } catch (Exception e) {
        }
        Assert.assertEquals(txt, "Blogas el. pašto adresas");
    }

    @Test
    public void createAdNoUsernameEmailTest() {
        driver.get("https://elenta.lt/patalpinti/ivesti-informacija?categoryId=NT_Butai&actionId=Siulo&returnurl=%2F");
        driver.findElement(By.id("title")).sendKeys("Abcde");
        driver.findElement(By.id("text")).sendKeys("description1234!?/");
        driver.findElement(By.id("price")).sendKeys("123");
        driver.findElement(By.id("location-search-box")).sendKeys("Vilnius");
        driver.findElement(By.id("phone")).sendKeys("+37060000001");
        driver.findElement(By.id("email")).sendKeys("@gia.com");
        driver.findElement(By.id("submit-button")).click();
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.id("ee"), "Blogas el. pašto adresas"));

        String txt = "";
        try {
            txt = driver.findElement(By.id("ee")).getText();
            System.out.println(txt);
        } catch (Exception e) {
        }
        Assert.assertEquals(txt, "Blogas el. pašto adresas");
    }

    @Test
    public void createAdNoDomainEmailTest() {
        driver.get("https://elenta.lt/patalpinti/ivesti-informacija?categoryId=NT_Butai&actionId=Siulo&returnurl=%2F");
        driver.findElement(By.id("title")).sendKeys("Abcde");
        driver.findElement(By.id("text")).sendKeys("description1234!?/");
        driver.findElement(By.id("price")).sendKeys("123");
        driver.findElement(By.id("location-search-box")).sendKeys("Vilnius");
        driver.findElement(By.id("phone")).sendKeys("+37060000001");
        driver.findElement(By.id("email")).sendKeys("vvgb@gia");
        driver.findElement(By.id("submit-button")).click();
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.id("ee"), "Blogas el. pašto adresas"));

        String txt = "";
        try {
            txt = driver.findElement(By.id("ee")).getText();
            System.out.println(txt);
        } catch (Exception e) {
        }
        Assert.assertEquals(txt, "Blogas el. pašto adresas");
    }


    @BeforeClass
    public void before() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        acceptCookies();
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    public void acceptCookies() {
        driver.get("https://elenta.lt/");
        driver.findElement(By.className("fc-button-label")).click();
    }

}
