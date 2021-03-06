package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class MainPage {

    public SelenideElement addToCartButton() {
        return $("#homefeatured .ajax_block_product:nth-child(1)  .ajax_add_to_cart_button").as("кнопка добавления товара через быструю корзину");
    }

    public SelenideElement goToOrdersButton() {
        return $(".layer_cart_cart a").as("кнопка перехода к списку заказов");
    }

    public SelenideElement itemDescription() {
        return $("#homefeatured .right-block [title='Faded Short Sleeve T-shirts']").as("описание товара");
    }

    public SelenideElement itemImg() {
        return $("#homefeatured .product_img_link[href='http://automationpractice.com/index.php?id_product=1&controller=product']").as("изображение товара");
    }

    public SelenideElement emailInput() {
        return $("#newsletter-input").as("поле ввода email");
    }

    public SelenideElement submitButton() {
        return $("[name='submitNewsletter']").as("кнопка подтверждения отправки email");
    }

    public SelenideElement errorMessage() {
        return $("[value='Invalid email address.']").as("сообщение об ошибке в поле ввода email");
    }

    public SelenideElement errorBanner() {
        return $(".alert-danger").as("сообщение об ошибке наверху страницы");
    }

}
