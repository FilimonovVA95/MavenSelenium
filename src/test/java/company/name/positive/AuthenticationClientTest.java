package company.name.positive;

import company.name.ScreenListener;
import company.name.page.AuthenticationPage;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

/**
 * Тест проверяет возможность войти с заданными логином и паролем
 * @see AuthenticationPage
 */
@Listeners({ScreenListener.class})
public class AuthenticationClientTest {

    private String email = "kicoti9729@kartk5.com";  // Почта заранее зарагестрированного пользователя
    private String password = "QlwS1Z";  // Пароль от личного кабинета клиента

    private AuthenticationPage step = new AuthenticationPage();

    @Test(groups = "exclude")
    public void authenticationClient() {
        step.openTestStand();
        step.openPopUp();
        step.inputEmail(email);
        step.inputPassword(password);
        step.clickAuthentication();
        step.logOut();
    }
}
