package company.name.page;

import company.name.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import static io.qameta.allure.Allure.step;

/**
 * Асбтрактный класс страницы. Загружает ссылку на тест-стенд из файла конфигурации и подгружает указанные веб-элементы
 */
public abstract class AbstractPage {

    /**
     * Поле страницы тест-стенда, загруженного с файла конфигурации
     */
    private static String testStand;

    /**
     * Конструктор. Загружает ссылку на тест-стенд из файла конфигурации и подгружает указанные веб-элементы
     * @param driver вебдрайвер с которым мы работаем
     */
    public AbstractPage(WebDriver driver) {
        PageFactory.initElements(driver, this);

        InputStream inputStream = DriverManager.class.getClassLoader().getResourceAsStream("config.properties");
        Properties properties = new Properties();
        try {
            properties.load(inputStream);
        } catch (IOException e) {
            throw new RuntimeException((e));
        }
        testStand = properties.getProperty("test.stand");
    }

    public static String getStand() {
        return testStand;
    }

    protected void checkStep (String nameStep, boolean check, String message) {
        step(nameStep, () -> {
            Assert.assertTrue(check, message);
        });
    }
}
