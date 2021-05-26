package xyz.devfo.trading;

import com.codeborne.selenide.Configuration;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;

public class RegistrationFormWithFakerTest {

    @BeforeAll
    static void setup() {
        Configuration.startMaximized = true;
    }

    Faker faker = new Faker();

    String firstname = faker.name().firstName(),
           lastname = faker.name().lastName(),
           email = faker.internet().emailAddress(),
           phone = faker.number().digits(10),
           password = faker.internet().password(9, 15);

    @Test
    void successRegistrationForm() {
        open("http://trading.devfo.xyz/register");
        $("[name=first_name]").setValue(firstname);
        $("[name=last_name]").setValue(lastname);
        $("[name=email]").setValue(email);
        $("[name=phone]").setValue(phone);
        $("[name=password]").setValue(password);
        $("[name=password_confirmation]").setValue(password);
        $("[name=terms]").setSelected(true);
        $$("button.inline-flex").first().pressEnter();
    }
}
