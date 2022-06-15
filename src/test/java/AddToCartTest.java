import com.codeborne.selenide.Condition;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.sleep;
import static io.qameta.allure.Allure.step;


@Owner("a_sh")
@Feature("Добавление товара в корзину")
public class AddToCartTest {

    @Test
    @DisplayName("Добавление товара в корзину через быструю корзину")
    public void shouldAddToCartTest() {



        step("Навести курсор на фото товара", () -> {
            open("http://automationpractice.com/index.php");
            TestPages.mainPage.itemImg()
                    .hover();
        });

        step("Кликнуть по кнопке Add to cart", () -> {
            TestPages.mainPage.addToCartButton()
                    .click();
            sleep(2000);
        });

        step("Кликнуть по кнопке Proceed to checkout", () -> {
            TestPages.mainPage.goToOrdersButton()
                    .click();
            sleep(2000);
        });

        step("Проверить, что в корзине отображается добавленный товар", () -> {
            TestPages.orderPage.orderItemDescription()
                    .shouldHave(Condition.text("Faded Short Sleeve T-shirts"));
        });

    }

}
