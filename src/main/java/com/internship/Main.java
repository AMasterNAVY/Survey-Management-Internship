package com.internship;

import java.util.ArrayList;
import java.util.List;

class SurveyList {
    List<Survey> surveys = new ArrayList<>();
    List<Candidate> candidates = new ArrayList<>();

    public void addSurvey(Survey survey) {
        if (survey == null) {
            throw new IllegalArgumentException("Survey cannot be null.");
        }
        surveys.add(survey);
    }

    public void addCandidate(Candidate candidate) {
        candidates.add(candidate);
    }

    public Candidate findMostActiveCandidate() {
        if (surveys.isEmpty()) {
            throw new IllegalStateException("No surveys available to determine the most active candidate.");
        }
        Candidate mostActive = null;
        int maxSurveys = 0;
        for (Candidate c : candidates) {
            int count = 0;
            for (Survey s : surveys) {
                if (s.candidates.contains(c)) {
                    count++;
                    break;
                }
            }
            if (count > maxSurveys) {
                maxSurveys = count;
                mostActive = c;
            }
        }
        return mostActive;
    }
}

public class Main {
    public static void main(String[] args) {
        try {
            SurveyList manager = new SurveyList();
            Survey survey = new Survey("Customer Feedback", "Service Quality", "Survey on customer experience");

            Survey survey1 = new Survey("Customer Feedback1", "Service Quality1", "Survey on customer experience1");

            Question q1 = new Question("Are you satisfied with our service?");
            Question q2 = new Question("Would you recommend us to others?");
            Question q3 = new Question("Was our staff helpful?");
            Question q4 = new Question("Would you use our service again?");
            Question q5 = new Question("Did our service meet your expectations?");
            Question q6 = new Question("Was our facility clean and well-maintained?");
            Question q7 = new Question("Did you receive enough information about our services?");
            Question q8 = new Question("Would you use our service again in the future?");
            Question q9 = new Question("Did you find the pricing reasonable?");
            Question q10 = new Question("Would you rate your overall experience as positive?");
            Question q11 = new Question("Would you rate your overall experience as positive?");
            
            survey.addQuestion(q1);
            survey.addQuestion(q2);
            survey.addQuestion(q3);
            survey.addQuestion(q4);
            survey.addQuestion(q5);
            survey.addQuestion(q6);
            survey.addQuestion(q7);
            survey.addQuestion(q8);
            survey.addQuestion(q9);
            survey.addQuestion(q10);
            survey.addQuestion(q11);

            survey1.addQuestion(q1);
            survey1.addQuestion(q2);
            survey1.addQuestion(q3);
            survey1.addQuestion(q4);
            survey1.addQuestion(q5);
            survey1.addQuestion(q6);
            survey1.addQuestion(q7);
            survey1.addQuestion(q8);
            survey1.addQuestion(q9);
            survey1.addQuestion(q10);
            survey1.addQuestion(q11);
            
            System.out.println("\nIs the survey valid? " + survey.validateSurvey());

            Candidate candidate1 = new Candidate("John", "Doe", "john@example.com", "1234567890");
            Candidate candidate2 = new Candidate("Jane", "Smith", "jane@example.com", "0987654321");
            Candidate candidate3 = new Candidate("Alice", "Johnson", "alice@example.com", "5555555555");

            survey.recordResponse(candidate1, q1, "Agree");
            survey.recordResponse(candidate1, q2, "Slightly Agree");
            survey.recordResponse(candidate1, q3, "Disagree");

            survey1.recordResponse(candidate1, q1, "Agree");
            survey1.recordResponse(candidate1, q2, "Slightly Agree");
            survey1.recordResponse(candidate1, q3, "Disagree");

            survey.recordResponse(candidate2, q1, "Slightly Disagree");
            survey.recordResponse(candidate2, q2, "Agree");
            survey.recordResponse(candidate2, q3, "Agree");

            survey.recordResponse(candidate3, q1, "Agree");
            survey.recordResponse(candidate3, q2, "Agree");

            System.out.println("Survey Results:");
            survey.printResults();

            System.out.println("\nMost common answer: " + survey.mostCommonAnswer());

            System.out.println("\nResponses from " + candidate1.getFirstName() + ":");
            survey.getCandidateResponses(candidate1);

            System.out.println("\nRemoving questions with low responses...");
            survey.removeLowResponseQuestions();
            System.out.println("Remaining questions:");
            for (Question q : survey.questions) {
                System.out.println(q.getText());
            }
            
            manager.addSurvey(survey);
            manager.addSurvey(survey1);
            manager.addCandidate(candidate1);
            manager.addCandidate(candidate2);
            manager.addCandidate(candidate3);

            System.out.println("\nMost active candidate: " + (manager.findMostActiveCandidate() != null ? manager.findMostActiveCandidate().getFirstName() : "None"));
        } catch (IllegalArgumentException | IllegalStateException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        
    }
}