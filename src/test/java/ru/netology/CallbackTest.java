package ru.netology;

import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class CallbackTest {

    @Test
    void shouldTestForm() {
        open("http://localhost:9999/");
        SelenideElement form = $("[action='/']");
        form.$("[data-test-id='name']").setValue("Игорь Попов");
        form.$("[data-test-id='phone']").setValue("+79875556565");
        form.$("[data-test-id='agreement']").click();
        form.$(".button__content").click();
        form.$("[data-test-id='order-success']").shouldHave(exactText("Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время."));


    }

}
