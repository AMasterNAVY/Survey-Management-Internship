package com.internship;

import java.util.ArrayList;
import java.util.List;

public class Survey {
    private String title;
    private String topic;
    private String description;
    protected List<Question> questions;
    protected List<Candidate> candidates;
    protected List<Response> responses;

    public Survey(String title, String topic, String description) {
        this.title = title;
        this.topic = topic;
        this.description = description;
        this.questions = new ArrayList<>();
        this.candidates = new ArrayList<>();
        this.responses = new ArrayList<>();
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTopic() {
        return this.topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void addQuestion(Question question) {
        if (questions.size() >= 40) {
            System.out.println("Survey: " + this.title + ", cannot have any more questions!");
        } else {
            boolean exists = false;
            for (Question q : questions) {
                if (q.getText().equals(question.getText())) {
                    exists = true;
                    break;
                }
            }
            if (!exists) {
                questions.add(question);
            } else {
                System.out.println("This survey already has this question");
            }
        }
    }

    public void removeQuestion(String text) {
        for (Question question : questions) {
            if (question.getText().equals(text)) {
                questions.remove(question);
            }
        }
    }

    public void removeQuestion(int index) {
        questions.remove(index);
    }

    public boolean validateSurvey() {
        return questions.size() >= 10 && questions.size() <= 40;
    }

    public void recordResponse(Candidate candidate, Question question, String answer) {
        if (!candidates.contains(candidate)) {
            candidates.add(candidate);
        }
        responses.add(new Response(candidate, question, answer));
    }

    public void printResults() {
        for (Question q : questions) {
            System.out.println("Question: " + q.getText());
            int[] counts = new int[5];
            for (Response r : responses) {
                if (r.question.equals(q)) {
                    int index = Question.ALTERNATIVES.indexOf(r.answer);
                    if (index != -1) counts[index]++;
                }
            }
            for (int i = 0; i < Question.ALTERNATIVES.size(); i++) {
                System.out.println(Question.ALTERNATIVES.get(i) + ": " + counts[i]);
            }
        }
    }

    public String mostCommonAnswer() {
        int[] counts = new int[4];
        for (Response r : responses) {
            int index = Question.ALTERNATIVES.indexOf(r.answer);
            if (index != -1) counts[index]++;
        }
        int maxIndex = 0;
        for (int i = 1; i < counts.length; i++) {
            if (counts[i] > counts[maxIndex]) maxIndex = i;
        }
        return Question.ALTERNATIVES.get(maxIndex);
    }

    public void getCandidateResponses(Candidate candidate) {
        if (candidate == null || !candidates.contains(candidate)) {
            throw new IllegalArgumentException("Candidate didn't participate in this survey or is null.");
        }
        for (Question q : questions) {
            System.out.println("Question: " + q.getText());
            boolean answered = false;
            for (Response r : responses) {
                if (r.candidate.equals(candidate) && r.question.equals(q)) {
                    System.out.println("Answer: " + r.answer);
                    answered = true;
                } 
            }
            if (!answered) {
                System.out.println("No Answer");
            }
        }
    }

    public void removeLowResponseQuestions() {
        List<Question> toRemove = new ArrayList<>();
        for (Question q : questions) {
            int count = 0;
            for (Response r : responses) {
                if (r.question.equals(q)) count++;
            }
            if (count < candidates.size() / 2) {
                toRemove.add(q);
            }
        }
        questions.removeAll(toRemove);
    }
}
