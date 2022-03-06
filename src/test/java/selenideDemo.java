import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import static com.codeborne.selenide.Selenide.*;

public class selenideDemo {
    public By searchResult = By.xpath("//*[@id=\"listings_container\"]/div[1]/span[1]/h3");
    SelenideElement searchField = $("input.styles_search_input__aiQVb");


    @BeforeAll
    public static void setup(){
        WebDriverManager.chromedriver().getDriverVersions();
        WebDriverManager.chromedriver().getDriverManagerType();
        SelenideLogger.addListener("allure", new AllureSelenide());

//        Configuration.remote = "http://localhost:4444/wd/hub";
//        DesiredCapabilities capabilities = new DesiredCapabilities();
//        capabilities.setCapability("enableVNC", true);
//        Configuration.browserCapabilities = capabilities;
    }

    @BeforeAll
    static void beforeAll() {
        Configuration.browser = "chrome";
    }

    @Test
    public void SelenideSpaghetti() {
        open("https://www.q84sale.com/en");
        searchField.sendKeys("car");
        searchField.pressEnter();

        Assertions.assertEquals($(searchResult)
                .shouldBe(Condition.visible)
                .getText(), "Result of : car");

    }

}
