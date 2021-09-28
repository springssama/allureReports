package guru.qa;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.open;

public class GithubPage {
    @Step("Открыть Github")
    public GithubPage openPage(String url) {
        open(url);
        return this;
    }

    @Step("Найти окно поиска")
    public GithubPage openSearch() {
        $(".js-site-search-form").click();
        return this;
    }

    @Step("Найти репозиторий")
    public GithubPage searchRepository(String name) {
        $("[data-test-selector='nav-search-input']").setValue(name).pressEnter();
        return this;
    }

    @Step("Выбрать репозиторий")
    public GithubPage chooseRepository() {
        $$("ul.repo-list li").first().$("a").click();
        return this;
    }

    @Step("Найти Issues")
    public GithubPage verifyResults() {
        $("#issues-tab").shouldHave(Condition.text("Issues")).shouldBe(Condition.visible);
        return this;
    }
}
