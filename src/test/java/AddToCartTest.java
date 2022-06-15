import com.codeborne.selenide.Condition;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;


@Owner("a_sh")
@Feature("Добавление товара в корзину")
public class AddToCartTest {

    @Test
    @DisplayName("Добавление товара в корзину через быструю корзину")
    public void shouldAddToCartTest() {

        open("http://automationpractice.com/index.php");

        step("Навести курсор на фото товара", () -> {
            TestPages.mainPage.itemImg()
                    .hover();
        });

        step("Кликнуть по кнопке Add to cart", () -> {
            TestPages.mainPage.addToCartButton()
                    .click();
        });

        step("Кликнуть по кнопке Proceed to checkout", () -> {
            TestPages.mainPage.goToOrdersButton()
                    .click();
        });

        step("Проверить, что в корзине отображается добавленный товар", () -> {
            TestPages.orderPage.orderItemDescription()
                    .shouldHave(Condition.text("Faded Short Sleeve T-shirts"));
        });

    }

}
