package com.demoqa.pages.components;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class ResultsTableComponent {
    private final static String TITLE_TEXT = "Thanks for submitting the form";

    public ResultsTableComponent isVisible() {
        $(".modal-dialog").should(appear);
        $("#example-modal-sizes-title-lg").shouldHave(text(TITLE_TEXT));
        return this;
    }

    public ResultsTableComponent checkResult(String... strings) {
        for (String s : strings) {
            $(".table-responsive").shouldHave(text(s));
        }
        return this;
    }
}

