package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class MainPage {

    public SelenideElement addToCartButton() {
        return $("#homefeatured .ajax_block_product:nth-child(1) .product-container .right-block .button-container .ajax_add_to_cart_button").as("кнопка добавления товара через быструю корзину");
    }

    public SelenideElement goToOrdersButton() {
        return $(".layer_cart_cart a").as("кнопка перехода к списку заказов");
    }

    public SelenideElement itemDescription() {
        return $("#homefeatured .right-block h5 a.product-name[title=\"Faded Short Sleeve T-shirts\"]").as("описание товара");
    }

    public SelenideElement itemImg() {
        return $("#homefeatured li .product_img_link[href=\"http://automationpractice.com/index.php?id_product=1&controller=product\"]").as("изображение товара");
    }

}
