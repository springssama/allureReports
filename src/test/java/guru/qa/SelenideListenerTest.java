package guru.qa;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.open;

public class SelenideListenerTest extends BaseTest {

    @Test
    public void searchIssueInGithubRepositoryWithListenerTest() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        open(BASE_URL);
        $(".js-site-search-form").as("Найти окно поиска").click();
        $("[data-test-selector='nav-search-input']").as("Выполнит поиск репозитория").setValue(REPOSITORY_NAME).pressEnter();
        $$("ul.repo-list li").first().$("a").as("Выбрать нужный репозиторий").click();
        $("#issues-tab").as("Найти Issues").shouldHave(Condition.text("Issues")).shouldBe(Condition.visible);
    }
}
