package company.name.page;

import company.name.DriverManager;
import io.qameta.allure.Step;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;


/**
 * класс для авторизации
 */
public class AuthenticationPage extends AbstractPage {

    @FindBy(id = "header-lk-button")                    //кнопка открытия окна авторизации
    private WebElement loginButton;

    @FindBy(id = "login")
    private WebElement loginFiled;                      //поле для ввода логина при входе

    @FindBy(css = "[type=password]")
    private WebElement passwordField;                   //поле для ввода пароля

    @FindBy(css = "[ng-tr=\"WHE1.WHE4\"]")              // Кнопка войти в аккаунт
    private WebElement clickLogIn;

    @FindBy(id = "logout")                              // Кнопка выйти
    private WebElement clickLogOut;

    @FindBy(className = "error-block")                  // Поле ошибки при неверном указании email или пароля
    private WebElement InCorrectEmailOrPasswordError;

    @FindBy(css = ".validation-invalid")                // Поле ошибки при пустом email или пароле
    private WebElement InCorrectEmailOrPasswordNull;


    /**
     * Конструктор. Загружает ссылку на тест-стенд из файла конфигурации и подгружает указанные веб-элементы
     */
    public AuthenticationPage() {
        super(DriverManager.getDriver());
    }

    @Step("Открыть тестовый стенд")
    public void openTestStand(){
        DriverManager.getDriver().get(getStand());
        checkAndScreenShotStep("Проверяем активность кнопки 'Войти'", checkLoginButton(), "Open test stand exception");
    }

    @Step("Открываем PopUp")
    public void openPopUp() {
        loginButton.click();
        checkAndScreenShotStep("Проверяем открытие окна авторизации", checkClickLogIn(), "Open popUp exception");
    }

    @Step("Ввести e-mail")
    public void inputEmail (String email){
        loginFiled.sendKeys(email);
        checkAndScreenShotStep("Проверяем правильность ввода email",checkLoginFiled(email),"Input email authorization exception");
    }

    @Step("Ввести пароль")
    public void inputPassword(String password){
        passwordField.sendKeys(password);
        checkAndScreenShotStep("Проверяем правильность ввода пароля", checkPasswordField(password), "Input password authorization exception");
    }

    @Step("Нажать кнопку войти")
    public void clickAuthentication(){
        clickLogIn.click();
        checkAndScreenShotStep("Проверяем активность кнопки 'Выйти'", checkClickLogOut(), "Client login exception");
    }

    @Step("Нажать кнопку войти с пустым паролем")
    public void clickAuthenticationPasswordNull(){
        clickLogIn.click();
        checkAndScreenShotStep("Проверяем наличие ошибки о некорректности введенных данных. Пустой пароль",
                checkInCorrectEmailOrPasswordNull("Введите пароль"), "Error expected null password");
    }

    @Step("Нажать кнопку войти с пустым email")
    public void clickAuthenticationEmailNull(){
        clickLogIn.click();
        checkAndScreenShotStep("Проверяем наличие ошибки о некорректности введенных данных. Пустой email",
                checkInCorrectEmailOrPasswordNull("Введите почту"), "Error expected null email");
    }

    @Step("Нажать кнопку войти при некорректном пароле или email")
    public void clickAuthenticationError(){
        clickLogIn.click();
        checkAndScreenShotStep("Проверяем наличие ошибки о некорректности введенных данных",
                checkInCorrectEmailOrPasswordError(), "Error expected no correct password or email");
    }

    @Step("Очистить поле email")
    public void clearEmail() {
        String del = Keys.chord(Keys.CONTROL, "a") + Keys.DELETE;
        loginFiled.sendKeys(del);
    }

    @Step("Очистить поле пароля")
    public void clearPassword() {
        String del = Keys.chord(Keys.CONTROL, "a") + Keys.DELETE;
        passwordField.sendKeys(del);
    }

    @Step("Нажать кнопку выйти")
    public void logOut(){
        clickLogOut.click();
        checkAndScreenShotStep("Проверяем активность кнопки 'Войти'", checkLoginButton(), "Client LogOut exception");
    }

    /**
     * проверка кнопки открытия PopUp
     * @return возвращает true если найден объект
     */
    public boolean checkLoginButton() {
        return loginButton.isEnabled();
    }

    /**
     * проверка поля email
     * @param email корректный email который ввели на предыдущем шаге
     * @return возвращает true если совпадает email
     */
    public boolean checkLoginFiled(String email) {
        return loginFiled.getAttribute("value").equals(email);
    }

    /**
     * проверка поля пароля
     * @param password корректный пароль который ввели на предыдущем шаге
     * @return возвращает true если совпадает пароль
     */
    public boolean checkPasswordField(String password) {
        return passwordField.getAttribute("value").equals(password);
    }

    /**
     * проверка кнопки входа
     * @return возвращает true если найден объект
     */
    public boolean checkClickLogIn() {
        return clickLogIn.isEnabled();
    }

    /**
     * проверка кнопки выхода из личного кабинета
     * @return возвращает true если найден объект
     */
    public boolean checkClickLogOut() {
        return clickLogOut.isEnabled();
    }

    /**
     * проверка поля сообщения об ошибке входа
     * @return возвращает true если найден объект
     */
    public boolean checkInCorrectEmailOrPasswordError() {
        new WebDriverWait(DriverManager.getDriver(), 5).until((d) -> InCorrectEmailOrPasswordError.isDisplayed());
        return InCorrectEmailOrPasswordError.getText().equals("Неверная почта или пароль");
    }

    /**
     * проверка поля сообщения если пароль или email пустой
     * @param message сообщение, о неверности введенных данных
     * @return возвращает true если совпадает сообщение
     */
    public boolean checkInCorrectEmailOrPasswordNull(String message) {
        return InCorrectEmailOrPasswordNull.getText().equals(message);
    }

}
