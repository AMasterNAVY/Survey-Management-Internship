package com.internship;

import java.util.List;
import java.util.Arrays;

public class Question {
    private String text;
    static final List<String> ALTERNATIVES = Arrays.asList("Agree", "Slightly Agree", "Slightly Disagree", "Disagree");

    public Question(String text){
        if (text == null || text.trim().isEmpty()) {
            throw new IllegalArgumentException("Question text cannot be empty or null.");
        }
        this.text = text;
    }

    public String getText() {
        return this.text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public boolean isValidAnswer(String answer) {
        return ALTERNATIVES.contains(answer);
    }
}
