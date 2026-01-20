import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class HomePageTest {

    @Test
    public  void openHomePage() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://askomdch.com/");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));

        wait.until(ExpectedConditions.elementToBeClickable(By.id("menu-item-1228"))).click();

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@aria-label='Add “Basic Blue Jeans” to your cart']"))).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@title='View cart']")));

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[@title='View your shopping cart'])[1]"))).click();


        List<String> productList = driver.findElements(By.xpath("//td[@data-title='Product']"))
                .stream()
                .map(WebElement :: getText)
                .toList();
        Assert.assertEquals(productList.size(), 1);
        Assert.assertEquals(productList.get(0), "Basic Blue Jeans");

        driver.quit();

    }
}
