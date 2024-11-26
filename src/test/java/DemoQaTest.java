import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class DemoQaTest {
    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1928x1980";
        Configuration.pageLoadStrategy = "eager";

    }
    @Test
    void practiceFormTest() {
        open("https://demoqa.com/automation-practice-form");
        $("#firstName").setValue("Maria");
        $("#lastName").setValue("Ivanova");
        $("#userEmail").setValue("maria@yandex.ru");
        $("#genterWrapper").$(byText("Female")).click();
        $("#userNumber").setValue("1234567891");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("February");
        $(".react-datepicker__year-select").selectOption("1995");
        $(".react-datepicker__day.react-datepicker__day--007").click();
        $("#subjectsInput").setValue("English").pressEnter();
        $("#hobbiesWrapper").$(byText("Sports")).click();
        $("#uploadPicture").uploadFromClasspath("picture.jpg");
        $("#currentAddress").setValue("Russia");
        $("#react-select-3-input").setValue("NCR").pressEnter();
        $("#react-select-4-input").setValue("Delhi").pressEnter();
        $("#submit").click();

        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $(".table").shouldHave(text("Student Name")).shouldHave(text("Maria Ivanova"));
        $(".table").shouldHave(text("Student Email")).shouldHave(text("maria@yandex.ru"));
        $(".table").shouldHave(text("Gender")).shouldHave(text("Female"));
        $(".table").shouldHave(text("Mobile")).shouldHave(text("1234567891"));
        $(".table").shouldHave(text("Date of Birth")).shouldHave(text("07 February,1995"));
        $(".table").shouldHave(text("Subjects")).shouldHave(text("English"));
        $(".table").shouldHave(text("Hobbies")).shouldHave(text("Sports"));
        $(".table").shouldHave(text("Picture")).shouldHave(text("picture.jpg"));
        $(".table").shouldHave(text("Address")).shouldHave(text("Russia"));
        $(".table").shouldHave(text("State and City")).shouldHave(text("NCR Delhi"));
    }
}