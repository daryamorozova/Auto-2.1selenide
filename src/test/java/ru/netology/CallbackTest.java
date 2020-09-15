package ru.netology;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selenide.*;

public class CallbackTest {

    @Test
    void shouldTestCorrectForm() {
        open("http://localhost:9999/");
        $("[data-test-id=name] input").setValue("Игорь Попов");
        $("[data-test-id='phone'] input").setValue("+79875556565");
        $("[data-test-id='agreement']").click();
        $(".button__content").click();
        $("[data-test-id=order-success]").shouldHave(exactText("Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время."));
    }

    @Test
    void shouldTestNotCorrectName() {
        open("http://localhost:9999/");
        $("[data-test-id=name] input").setValue("Igor Popov");
        $("[data-test-id='phone'] input").setValue("+79875556565");
        $("[data-test-id='agreement']").click();
        $(".button__content").click();
        $(".input__sub").shouldHave(exactText("Имя и Фамилия указаные неверно. Допустимы только русские буквы, пробелы и дефисы."));
    }

    @Test
    void shouldTestNotCorrectPhone() {
        open("http://localhost:9999/");
        $("[data-test-id=name] input").setValue("Игорь Попов");
        $("[data-test-id='phone'] input").setValue("2323535");
        $("[data-test-id='agreement']").click();
        $(".button__content").click();
        $$(".input__sub").last().shouldHave(exactText("Телефон указан неверно. Должно быть 11 цифр, например, +79012345678."));
    }
}
