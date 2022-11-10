package com.demoqa.pages;

import com.codeborne.selenide.SelenideElement;
import com.demoqa.pages.components.UploadFileComponent;
import com.demoqa.pages.components.CalendarComponent;
import com.demoqa.pages.components.ResultsTableComponent;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class RegistrationFormPage {
        private static final String TEXT = "Student Registration Form";
        private final CalendarComponent calendarComponent = new CalendarComponent();
        private final ResultsTableComponent resultTableComponent = new ResultsTableComponent();
        private final UploadFileComponent uploadFileComponent = new UploadFileComponent();

        private final SelenideElement firstNameInput = $("#firstName"),
                lastNameInput = $("#lastName"),
                emailInput = $("#userEmail"),
                numberInput = $("#userNumber"),
                genderInput = $("#genterWrapper"),
                dateOfBirthInput = $("#dateOfBirthInput"),
                subjectInput = $("#subjectsInput"),
                hobbiesInput = $("#hobbiesWrapper"),
                currentAddressInput = $("#currentAddress"),
                stateInput = $("#react-select-3-input"),
                cityInput = $("#react-select-4-input"),
                submitButton = $("#submit");

        public RegistrationFormPage openPage() {
            open("/automation-practice-form");
            $(".practice-form-wrapper").shouldHave(text(TEXT));
            executeJavaScript("$('footer').remove()");
            executeJavaScript("$('#fixedban').remove()");
            return this;
        }

        public RegistrationFormPage setFirstName(String value) {
            firstNameInput.setValue(value);
            return this;
        }

        public RegistrationFormPage clearFirstName() {
            firstNameInput.clear();
            return this;
        }

        public RegistrationFormPage setLastName(String value) {
            lastNameInput.setValue(value);
            return this;
        }

        public RegistrationFormPage setEmail(String value) {
            emailInput.setValue(value);
            return this;
        }

        public RegistrationFormPage setGender(String value) {
            genderInput.$(byText(value)).click();
            return this;
        }

        public RegistrationFormPage setNumber(String value) {
            numberInput.setValue(value);
            return this;
        }

        public RegistrationFormPage setBirthDate(String day, String month, String year) {
            dateOfBirthInput.click();
            calendarComponent.setDate(day, month, year);
            return this;
        }

        public RegistrationFormPage setSubject(String value) {
            subjectInput.setValue(value).pressEnter();
            return this;
        }

        public RegistrationFormPage setHobby(String value) {
            hobbiesInput.$(byText(value)).click();
            return this;
        }

        public RegistrationFormPage uploadFile(String path) {
            uploadFileComponent.uploadFile(path);
            return this;
        }

        public RegistrationFormPage setAddress(String value) {
            currentAddressInput.setValue(value);
            return this;
        }

        public RegistrationFormPage setStateAndCity(String state, String city) {
            stateInput.setValue(state).pressEnter();
            cityInput.setValue(city).pressEnter();

            return this;
        }

        public RegistrationFormPage submit() {
            submitButton.scrollTo().click();
            return this;
        }

        public RegistrationFormPage checkResultTableVisibility() {
            resultTableComponent.isVisible();
            return this;
        }

        public RegistrationFormPage checkResultTableData(String... strings) {
            resultTableComponent.checkResult(strings);
            return this;
        }
    }
