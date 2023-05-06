package org.brit.Brit.Lesson18_19_20_21;

public enum MyButtons {
    ALERT("Click for JS Alert"),
    CONFIRM("Click for JS Confirm"),
    PROMPT("Click for JS Prompt");

    MyButtons(String textOnButton) {
        this.textOnButton = textOnButton;
    }

    public String getTextOnButton() {
        return textOnButton;
    }

    private String textOnButton;


}
