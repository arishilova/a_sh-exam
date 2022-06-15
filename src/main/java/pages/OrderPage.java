package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class OrderPage {

    public SelenideElement orderItemDescription() {
        return $("#product_1_1_0_0 .product-name a").as("описание заказанного товара");
    }

}
