package com.internship;

public class Candidate {
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;

    public Candidate(String firstName, String lastName, String email, String phoneNumber) {
        if (firstName == null || firstName.trim().isEmpty() || email == null || email.trim().isEmpty()) {
            throw new IllegalArgumentException("Candidate first name or email cannot be empty or null.");
        }
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}