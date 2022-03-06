import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class selenidePOMDemo {
    PageHome home;

   // browser configuration is found in build.gradle line 34

    @Test
    public void SelenidePOM() {
        home = new PageHome();

        home.openHomePage()
                .searchFor("car");

        Assertions.assertEquals("Result of : car", home.getText(home.searchResult), "search result doesn't contain 'car'");
    }
}
