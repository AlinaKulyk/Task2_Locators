import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.util.List;
import static org.openqa.selenium.By.xpath;

public class Task2 {

    private WebDriver driver;

    @BeforeTest
    public void profileSetUp() {
        System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");
    }

    @BeforeMethod
    public void testsSetUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://rozetka.com.ua/");
    }

    @Test

    public void chooseLaptop() {
        driver.findElement(By.xpath("//div[@class='menu-wrapper menu-wrapper_state_static ng-star-inserted']//a[contains(text(), 'Ноутбуки и компьютеры')]")).click();

        WebElement webElementSearchField = driver.findElement(By.name("search"));
        webElementSearchField.sendKeys("ноутбуки" + Keys.ENTER);

        //Додаємо до корзини ноутбук HP Pavilion 15

        new WebDriverWait(driver, 40).until(
                webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
        WebDriverWait wait = new WebDriverWait(driver, 30);
        WebElement deviceElement = driver.findElement(By.xpath("//a[@class='checkbox-filter__link']//label[contains(text(),'HP')]"));
        wait.until(ExpectedConditions.elementToBeClickable(deviceElement));
        deviceElement.click();

        WebElement typeDeviceElement = driver.findElement(By.xpath("//a[@class='checkbox-filter__link']//label[contains(text(),'Pavilion 15')]"));
        wait.until(ExpectedConditions.visibilityOf(typeDeviceElement));
        wait.until(ExpectedConditions.elementToBeClickable(typeDeviceElement));
        typeDeviceElement.click();

        List<WebElement> optionsWebElements = driver.findElements(xpath("//select//option"));
        for (WebElement webElement : optionsWebElements) {
            if (webElement.getText().equals("От дорогих к дешевым")) {
                wait.until(ExpectedConditions.elementToBeClickable(webElement));
                webElement.click();
                break;
            }
        }

        List<WebElement> addToCartWebElement = driver.findElements(xpath("//button[@class='buy-button goods-tile__buy-button ng-star-inserted']"));
        addToCartWebElement.get(0).click();


//
//        new WebDriverWait(driver, 40).until(
//                webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
//        List<WebElement> mostExpensiveWebElement = driver.findElements(xpath("//a[@class='goods-tile__picture ng-star-inserted']"));
//        mostExpensiveWebElement.get(0).click();
//
//
//        new WebDriverWait(driver, 40).until(
//                webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
//        WebElement buttonBuy = driver.findElement(xpath("//app-product-buy-btn//button//span[contains(text(),'Купить')]"));
//        wait.until(ExpectedConditions.elementToBeClickable(buttonBuy));
//        buttonBuy.click();




    }

//        new WebDriverWait(driver, 40).until(
//                webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
//        WebElement continueShopping = driver.findElement(xpath("//a[@class='button button_size_medium button_color_gray cart-footer__continue ng-star-inserted']"));
//        wait.until(ExpectedConditions.visibilityOf(continueShopping));
//        continueShopping.click();

//     Повтор с:   webElementSearchField.sendKeys("ноутбуки" + Keys.ENTER);
//        Пример кода для сравнения стринги с интеджер, парсим в интеджер:
//
//        String sato = driver.FindElement(By.CssSelector(".user_reward_points")).Text;
//        if (Int32.Parse(sato)> 1200)
//        {
//        driver.FindElement(By.CssSelector("#free_points_rewards >
//        .effect2:nth-child(2) .large-3:nth-child(3) > .reward_link_redeem_button_style")).Click();
//        }

    @AfterMethod
    public void tearDown() {
        driver.close();
    }
}

