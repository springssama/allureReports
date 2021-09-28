package guru.qa;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class SelenideLambdaTest extends BaseTest {

    @Test
    public void searchIssueInGithubRepositoryWithLambdaTest() {
        step("Открыть GitHub", () -> open(BASE_URL));
        step("Найти окно поиска", () -> $(".js-site-search-form").click());
        step("Выполнить поиск репозитория", () -> $("[data-test-selector='nav-search-input']").setValue(REPOSITORY_NAME).pressEnter());
        step("Выбрать нужный репозиторий", () -> $$("ul.repo-list li").first().$("a").click());
        step("Найти Issues", () -> $("#issues-tab").shouldHave(Condition.text("Issues")).shouldBe(Condition.visible));
    }
}
