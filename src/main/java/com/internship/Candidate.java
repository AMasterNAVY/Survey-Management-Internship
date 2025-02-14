package com.internship;

import org.apache.commons.lang3.StringUtils;

public class Candidate {
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;

    public Candidate(String firstName, String lastName, String email, String phoneNumber) {
        if (checkString(firstName) || checkString(lastName) || checkString(email) || checkString(phoneNumber)) {
            throw new IllegalArgumentException("Candidate details must not be empty or null.");
        }
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public boolean checkString(String str) {
        return StringUtils.isEmpty(str);
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