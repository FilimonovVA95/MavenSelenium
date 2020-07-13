package company.name.page;

import company.name.DriverManager;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Класс страницы для проверки меню главной страницы
 * @author Филимонов Виктор
 */
public class StartPage extends AbstractPage {


    @FindBy(css = "#header-lk-button")
    private WebElement loginButton;                                     // кнопка открытия окна авторизации

    @FindBy(css = ".nl-header-link[ng-tr=\"NLHEA.NLHEA1\"]")
    private WebElement aboutProductionButton;                           // кнопка перейти на страницу "О продукте"

    @FindBy(css = ".nl-header-link[ng-tr=\"NLHEA.NLHEA2\"]")
    private WebElement priceButton;                                     // кнопка перейти на страницу "Цены"

    @FindBy(css = ".nl-header-link[ng-tr=\"NLHEA.NLHEA3\"]")
    private WebElement faqButton;                                       // кнопка перейти на страницу "FAQ"

    @FindBy(css = ".nl-header-link[ng-tr=\"NLHEA.NLHEA4\"]")
    private WebElement wantTestSitesButton;                             // кнопка перейти на страницу "Хочу тестировать сайты"

    @FindBy(css = "[ng-tr=\"NLABO.NLABO1\"]")
    private WebElement checkAboutProduction;                            // проверка наличия элемента на странице "О продукте"

    @FindBy(css = "[ng-tr=\"NLPRC.NLPRC1\"]")
    private WebElement checkPrice;                                      // проверка наличия элемента на странице "Цены"

    @FindBy(css = ".nl-faq-header")
    private WebElement checkFAQ;                                        // проверка наличия элемента на странице "FAQ"

    @FindBy(css = "[ng-tr=\"NLTES.NLTES6\"]")
    private WebElement checkWantTestSite;                               // проверка наличия элемента на странице "Хочу стать тестировщиком"


    /**
     * Конструктор. Загружает ссылку на тест-стенд из файла конфигурации и подгружает указанные веб-элементы
     */
    public StartPage() {
        super(DriverManager.getDriver());
    }

    @Step("Открыть тестовый стенд")
    public void openTestStand() {
        DriverManager.getDriver().get(getStand());;
        checkAndScreenShotStep("Проверяем активность кнопки 'Войти'",
                checkLoginButton(), "Open test stand exception");
    }

    @Step("Нажать кнопку 'О продукте'")
    public void openAboutProductionButton() {
        aboutProductionButton.click();
        checkAndScreenShotStep("Проверяем открытие страницы 'О продукте'",
                checkAboutProduction(), "Open about production page exception");
    }

    @Step("Нажать кнопку 'Цены'")
    public void openPrice() {
        priceButton.click();
        checkAndScreenShotStep("Проверяем открытие страницы 'Цены'",
                checkPrice(), "Open price page exception");
    }

    @Step("Нажать кнопку 'FAQ'")
    public void openFAQ() {
        faqButton.click();
        checkAndScreenShotStep("Проверяем открытие страницы 'FAQ'",
                checkFAQ(), "Open FAQ page exception");
    }

    @Step("Нажать кнопку 'Хочу стать тестировщиком'")
    public void openWantTestSites() {
        wantTestSitesButton.click();
        checkAndScreenShotStep("Проверяем открытие страницы 'Хочу стать тестировщиком'",
                checkWantTestSite(), "Open want test sites page exception");
    }

    /**
     * проверка активности кнопки "Войти"
     * @return true, если элемент найден
     */
    private boolean checkLoginButton() {
        return loginButton.isEnabled();
    }

    /**
     * проверка наличия элемента на странице "О продукте"
     * @return true, если элемент найден
     */
    private boolean checkAboutProduction() {
        return checkAboutProduction.isEnabled();
    }

    /**
     * проверка наличия элемента на странице "Цены"
     * @return true, если элемент найден
     */
    private boolean checkPrice() {
        return checkPrice.isEnabled();
    }

    /**
     * проверка наличия элемента на странице "FAQ"
     * @return true, если элемент найден
     */
    private boolean checkFAQ() {
        return checkFAQ.isEnabled();
    }

    /**
     * проверка наличия элемента на странице "Хочу стать тестировщиком"
     * @return true, если элемент найден
     */
    private boolean checkWantTestSite() {
        return checkWantTestSite.isEnabled();
    }

}
