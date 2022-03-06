import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;


import static com.codeborne.selenide.Selenide.*;


public class PageHome {

    SelenideElement searchField = $("input.styles_search_input__aiQVb");
    SelenideElement searchResult = $(Selectors.byXpath("//*[@id=\"listings_container\"]/div[1]/span[1]/h3"));


    @Step("-Open Home page")
    public PageHome openHomePage() {
        open("https://www.q84sale.com/en");
        System.out.println("Navigating to https://www.q84sale.com/en");
        return this;
    }

    @Step("-search in Home page")
    public PageHome searchFor(String searchKeyword) {
        searchField.sendKeys(searchKeyword);
        searchField.pressEnter();
        return this;
    }

    @Step("-get Text")
    public String getText(SelenideElement element) {
        return element.shouldBe(Condition.visible).getText();
    }

}



