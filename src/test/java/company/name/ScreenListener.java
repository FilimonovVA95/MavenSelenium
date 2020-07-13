package company.name;

import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

public class ScreenListener extends TestListenerAdapter {

    @Override
    public void onTestFailure(ITestResult tr) {
        screenShot();
    }

    @Attachment(value = "Screenshot exception", type = "image/png")
    private byte[] screenShot() {
        return ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.BYTES);
    }

}
