package guru.qa;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;


import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.linkText;
import static org.openqa.selenium.By.partialLinkText;

public class AdditionalLambdaTest extends BaseTest {

    @Test
    public void githubSearchIssueTest() {
        step("Открыть GitHub", () -> open(BASE_URL));
        step("Найти репозиторий " + ADDITIONAL_REPO_NAME, () -> {
            $(".header-search-input").setValue(ADDITIONAL_REPO_NAME).submit();

        });
        step("Перейти в репозиторий " + ADDITIONAL_REPO_NAME, () -> {
            $(linkText(ADDITIONAL_REPO_NAME)).click();
        });
        step("Открыть раздел Issues ", () -> {
            $(partialLinkText("Issues")).click();
        });
        step("Проверить наличие issue с номером " + ISSUE_NUMBER, () -> {
            $(withText(ISSUE_NUMBER)).should(Condition.exist);
        });


    }
}