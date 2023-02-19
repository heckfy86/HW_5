package qaguru;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class HomeWork {

        SelenideElement solutions = $(".header-menu-wrapper").$(byText("Solutions"));
        SelenideElement enterprise = $(byText("Enterprise"));
        SelenideElement tagline = $(".h1-mktg.mb-3");

        @BeforeAll
        static void beforeAll() {
            Configuration.holdBrowserOpen = true;
        }

        @Test
        void buildLikeTheBest() {
            open("https://github.com/");
            solutions.hover();
            enterprise.click();
            tagline.shouldHave(text("Build like the best"));
        }

        @Test
        void dragAndDrop() {
            open("https://the-internet.herokuapp.com/drag_and_drop");
            $("#column-a").dragAndDropTo($("#column-b"));
            $("#column-a header").shouldHave(text("B"));
            $("#column-b header").shouldHave(text("A"));
        }
    }

