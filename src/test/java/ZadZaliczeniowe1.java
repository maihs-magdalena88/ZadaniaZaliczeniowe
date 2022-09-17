import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.internal.WebElementToJsonConverter;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;


public class ZadZaliczeniowe1 {
    WebDriver driver;

    @Given("Jestem na stronie addresses")
    public void ZalogujIPrzejdzDoAddresses() throws InterruptedException {
        System.setProperty("webdriver.edge.driver", "C:\\Intel\\msedgedriver.exe");
        driver = new EdgeDriver();
        driver.get("https://mystore-testlab.coderslab.pl/");
        driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);

        WebElement zalogujSie = driver.findElement(By.cssSelector("[title=\"Log in to your customer account\"]"));
        zalogujSie.click();

        WebElement email = driver.findElement(By.className("form-control"));
        email.sendKeys("nataszakowalczyk@jourrapide.com");

        WebElement password = driver.findElement(By.name("password"));
        password.sendKeys("Natasza11!");

        WebElement singIn = driver.findElement(By.cssSelector("[id=\"submit-login\"]"));
        singIn.click();

        WebElement addresses = driver.findElement(By.cssSelector("[title=\"Addresses\"]"));
        addresses.click();

        WebElement newAddress = driver.findElement(By.cssSelector("[data-link-action=\"add-address\"]"));
        newAddress.click();


        WebElement alias = driver.findElement(By.cssSelector("input[name=alias]"));
        alias.sendKeys("NataszaDom");
        alias.click();

        WebElement address = driver.findElement(By.cssSelector("input[name=address1]"));
        address.sendKeys("Słoneczna 32");
        address.click();

        WebElement city = driver.findElement(By.cssSelector("input[name=city]"));
        city.sendKeys("Ptaszków");
        city.click();

        WebElement zip = driver.findElement(By.cssSelector("input[name=postcode]"));
        zip.sendKeys("58-100");
        zip.click();

        WebElement country = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/form/section/div[10]/div[1]/select"));
        country.sendKeys("United Kingdom");
        country.click();

        WebElement phone = driver.findElement(By.cssSelector("input[name=phone]"));
        phone.sendKeys("523325564");
        phone.click();

        WebElement save = driver.findElement(By.xpath("/html/body/main/section/div/div/section/section/div/div/form/footer/button"));
        save.click();


        System.out.println("Gotowe!");
        WebElement wynik = driver.findElement(By.xpath("/html/body/main/section/div/div/section/section/aside/div/article/ul/li"));
        System.out.println(wynik.getText());

        Assertions.assertEquals(wynik.getText(), "Address successfully added!");
    }
}


