package guru.qa;

import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class SelenideAnnotationTest extends BaseTest {

    @Test
    @Feature("Страницы Github")
    @Story("Поиск Issue в репозитории")
    @DisplayName("В репозитории есть раздел Issue")
    public void searchIssueInGithubRepositoryWithAnnotationTest() {
        GithubPage githubPage = new GithubPage();

        githubPage.openPage(BASE_URL);
        githubPage.openSearch();
        githubPage.searchRepository(REPOSITORY_NAME);
        githubPage.chooseRepository();
        githubPage.verifyResults();
    }
}
