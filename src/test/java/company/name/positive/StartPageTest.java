package company.name.positive;

import company.name.ScreenListener;
import company.name.page.StartPage;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners({ScreenListener.class})
public class StartPageTest {

    private StartPage step = new StartPage();

    @Test(groups = "include")
    public void StartPage() {
        step.openTestStand();
        step.openAboutProductionButton();
        step.openPrice();
        step.openFAQ();
        step.openWantTestSites();
    }
}
