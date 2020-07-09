package company.name.positive;

import company.name.page.StartPage;
import org.testng.annotations.Test;

public class StartPageTest {

    private StartPage step = new StartPage();

    @Test
    public void StartPage() {
        step.openTestStand();
        step.openAboutProductionButton();
        step.openPrice();
        step.openFAQ();
        step.openWantTestSites();
    }
}
