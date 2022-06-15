import com.codeborne.selenide.Condition;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static org.junit.jupiter.params.provider.Arguments.arguments;

@Owner("a_sh")
@Feature("Поле ввода e-mail")
public class EmailEnterTest {

    @MethodSource("addEmail")
    @ParameterizedTest(name = "{displayName} {0}")
    @DisplayName("Негативные кейсы для поля ввода e-mail. Ввод ")

    public void shouldntAcceptEmail(String type, String value) {

        open("http://automationpractice.com/index.php");

        step("Ввести в поле ввода email невалидный адрес", () -> {
            TestPages.mainPage.emailInput()
                    .sendKeys(value);
        });

        step("Кликнуть по кнопке подтверждения", () -> {
            TestPages.mainPage.submitButton()
                    .click();
        });

        step("Проверить, что в инпуте появилось сообщение об ошибке", () -> {
            TestPages.mainPage.errorMessage()
                    .shouldBe(Condition.visible);
        });
    }

    static Stream<Arguments> addEmail() {
        return Stream.of(
                arguments(
                        "пустого значения",
                        ""
                ),
                arguments(
                        "адреса без символа @",
                        "testmail.ru"
                ),
                arguments(
                        "адреса без домена",
                        "test@mail"
                )
        );
    }

}
