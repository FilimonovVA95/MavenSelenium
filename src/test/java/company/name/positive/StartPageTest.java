package company.name.positive;

import company.name.page.StartPage;
import io.qameta.allure.Attachment;
import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class StartPageTest {

    private StartPage step = new StartPage();

    @Test
    public void StartPage() throws IOException {
        step.openTestStand();
        step.openAboutProductionButton();
        step.openPrice();
        step.openFAQ();
        step.openWantTestSites();
    }

}
