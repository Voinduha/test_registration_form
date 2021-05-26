package xyz.devfo.trading;

import com.github.javafaker.Faker;

import static com.codeborne.selenide.Selenide.*;

public class RegistrationFormPage {

    Faker faker = new Faker();
    String firstname = faker.name().firstName(),
            lastname = faker.name().lastName(),
            email = faker.internet().emailAddress(),
            phone = faker.number().digits(10),
            password = faker.internet().password(9, 15);

    public void openPage() {
        open("http://trading.devfo.xyz/register");
    }

    public void fillFormName() {
        $("[name=first_name]").setValue(firstname);
        $("[name=last_name]").setValue(lastname);
        $("[name=email]").setValue(email);
        $("[name=phone]").setValue(phone);
        $("[name=password]").setValue(password);
        $("[name=password_confirmation]").setValue(password);
    }

    public void setCheckBox() {
        $("[name=terms]").setSelected(true);
    }

    public void pressRegistrationButton() {
        $$("button.inline-flex").first().pressEnter();
    }
}
