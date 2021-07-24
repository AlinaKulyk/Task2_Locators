import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

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
        driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);

    }

    @Test

    public void chooseLaptop() {


        driver.findElement(By.xpath("//div[@class='menu-wrapper menu-wrapper_state_static ng-star-inserted']//a[contains(text(), 'Ноутбуки и компьютеры')]")).click();
        WebElement webElementSearchField = driver.findElement(By.name("search"));
        webElementSearchField.sendKeys("ноутбуки" + Keys.ENTER);

        //Додаємо до корзини ноутбук HP Pavilion 15

        WebDriverWait wait = new WebDriverWait(driver, 50);

        wait.until(
                webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));

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

        wait.until(
                webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
        List<WebElement> mostExpensiveWebElement = driver.findElements(xpath("//a[@class='goods-tile__picture ng-star-inserted']"));
        mostExpensiveWebElement.get(0).click();

        wait.until(
                webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
        WebElement buttonBuy = driver.findElement(xpath("//app-product-buy-btn/app-buy-button/button[@class='buy-button button button_with_icon button_color_green button_size_large ng-star-inserted']"));
        wait.until(ExpectedConditions.elementToBeClickable(buttonBuy));
        buttonBuy.click();

        WebElement continueShopping = driver.findElement(xpath("//a[@class='button button_size_medium button_color_gray cart-footer__continue ng-star-inserted']"));
        driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
        wait.until(ExpectedConditions.elementToBeClickable(continueShopping));
        continueShopping.click();

        WebElement webElementSearchField2 = driver.findElement(By.name("search"));
        webElementSearchField2.sendKeys("ноутбуки" + Keys.ENTER);

        // Додаємо до корзини ноутбук Acer Aspire 3

        WebElement deviceElement2 = driver.findElement(By.xpath("//a[@class='checkbox-filter__link']//label[contains(text(),'Acer')]"));
        wait.until(ExpectedConditions.elementToBeClickable(deviceElement2));
        deviceElement2.click();

        WebElement typeDeviceElement2 = driver.findElement(By.xpath("//a[@class='checkbox-filter__link']//label[contains(text(),'Aspire 3')]"));
        wait.until(ExpectedConditions.visibilityOf(typeDeviceElement2));
        wait.until(ExpectedConditions.elementToBeClickable(typeDeviceElement2));
        typeDeviceElement2.click();

        List<WebElement> optionsWebElements2 = driver.findElements(xpath("//select//option"));
        for (WebElement webElement : optionsWebElements2) {
            if (webElement.getText().equals("От дорогих к дешевым")) {
                wait.until(ExpectedConditions.elementToBeClickable(webElement));
                webElement.click();
                break;
            }
        }


        wait.until(
                webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
        List<WebElement> mostExpensiveWebElement2 = driver.findElements(xpath("//a[@class='goods-tile__picture ng-star-inserted']"));
        mostExpensiveWebElement2.get(0).click();

        wait.until(
                webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
        WebElement buttonBuy2 = driver.findElement(xpath("//app-product-buy-btn/app-buy-button/button[@class='buy-button button button_with_icon button_color_green button_size_large ng-star-inserted']"));
        wait.until(ExpectedConditions.visibilityOf(buttonBuy2));
        wait.until(ExpectedConditions.elementToBeClickable(buttonBuy2));
        buttonBuy2.click();


        wait.until(
                webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
        WebElement continueShopping2 = driver.findElement(xpath("//a[@class='button button_size_medium button_color_gray cart-footer__continue ng-star-inserted']"));
        wait.until(ExpectedConditions.visibilityOf(continueShopping2));
        wait.until(ExpectedConditions.elementToBeClickable(continueShopping2));
        continueShopping2.click();

        WebElement webElementSearchField3 = driver.findElement(By.name("search"));
        webElementSearchField3.sendKeys("ноутбуки" + Keys.ENTER);

//         Додаємо до корзини ноутбук Apple Apple M

        WebElement deviceElement3 = driver.findElement(By.xpath("//a[@class='checkbox-filter__link']//label[contains(text(),'Apple')]"));
        wait.until(ExpectedConditions.elementToBeClickable(deviceElement3));
        deviceElement3.click();

        WebElement typeDeviceElement3 = driver.findElement(By.xpath("//a[@class='checkbox-filter__link']//label[contains(text(),'MacBook Air 2020')]"));
        wait.until(ExpectedConditions.visibilityOf(typeDeviceElement3));
        wait.until(ExpectedConditions.elementToBeClickable(typeDeviceElement3));
        typeDeviceElement3.click();

        List<WebElement> optionsWebElements3 = driver.findElements(xpath("//select//option"));
        for (WebElement webElement : optionsWebElements3) {
            if (webElement.getText().equals("От дорогих к дешевым")) {
                wait.until(ExpectedConditions.elementToBeClickable(webElement));
                webElement.click();
                break;
            }
        }


        wait.until(
                webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
        List<WebElement> mostExpensiveWebElement3 = driver.findElements(xpath("//a[@class='goods-tile__picture ng-star-inserted']"));
        mostExpensiveWebElement3.get(0).click();

        wait.until(
                webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
        WebElement buttonBuy3 = driver.findElement(xpath("//app-product-buy-btn/app-buy-button/button[@class='buy-button button button_with_icon button_color_green button_size_large ng-star-inserted']"));
        wait.until(ExpectedConditions.visibilityOf(buttonBuy3));
        wait.until(ExpectedConditions.elementToBeClickable(buttonBuy3));
        buttonBuy3.click();


        WebElement price = driver.findElement(xpath(("//div[@class='cart-receipt__sum-price']")));

        int sum;
        String strPrice = price.getText();
        strPrice = strPrice.substring(0, strPrice.length() - 2);
        sum = Integer.parseInt(strPrice);

        if (sum < 136000) {
            System.out.println("Sum Of Products < 136 000");
        } else
            System.out.println("Sum Of Products > 136 000");

        int i = driver.findElements(xpath(("//p[@class='cart-product__price']"))).size();
        System.out.println("Elements quantity: " + i);

    }

    @AfterMethod
    public void tearDown() {
        driver.close();
    }

}










