package xyz.devfo.trading;

import org.junit.jupiter.api.Test;

public class RegistrationFormWithFakerTest extends TestBase {
    RegistrationFormPage registrationFormPage;

    @Test
    void successRegistrationForm() {
        registrationFormPage = new RegistrationFormPage();

        registrationFormPage.openPage();
        registrationFormPage.fillFormName();
        registrationFormPage.setCheckBox();
        registrationFormPage.pressRegistrationButton();
    }
}
