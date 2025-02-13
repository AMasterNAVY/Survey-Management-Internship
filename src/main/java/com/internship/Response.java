package com.internship;

class Response {
    Candidate candidate;
    Question question;
    String answer;

    public Response(Candidate candidate, Question question, String answer) {
        if (candidate == null || question == null) {
            throw new IllegalArgumentException("Candidate and question cannot be null.");
        }
        if (!question.isValidAnswer(answer)) {
            throw new IllegalArgumentException("Invalid answer: " + answer);
        }
        this.candidate = candidate;
        this.question = question;
        this.answer = answer;
    }

    public Candidate getCandidate() {
        return candidate;
    }

    public Question getQuestion() {
        return question;
    }

    public String getAnswer() {
        return answer;
    }
}
