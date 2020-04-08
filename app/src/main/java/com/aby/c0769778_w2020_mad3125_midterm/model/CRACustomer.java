package com.aby.c0769778_w2020_mad3125_midterm.model;

import org.joda.time.LocalDate;

public class CRACustomer
{
    public enum Gender {
        Male, Female, Other
    }
    private String SIN;
    private String firstName;
    private String lastName;
    private Gender gender;
    private LocalDate birthDate;
    private Float grossIncome;
    private Float rrspContributed;


    public CRACustomer(String SIN, String firstName, String lastName, Gender gender, LocalDate birthDate, Float grossIncome, Float rrspContributed) {
        this.SIN = SIN;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.birthDate = birthDate;
        this.grossIncome = grossIncome;
        this.rrspContributed = rrspContributed;
    }

    public String getFullName()
    {
        return lastName.toUpperCase() + ", " + firstName;
    }

    public String getSIN() {
        return SIN;
    }

    public void setSIN(String SIN) {
        this.SIN = SIN;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public Float getGrossIncome() {
        return grossIncome;
    }

    public void setGrossIncome(Float grossIncome) {
        this.grossIncome = grossIncome;
    }

    public Float getRrspContributed() {
        return rrspContributed;
    }

    public void setRrspContributed(Float rrspContributed) {
        this.rrspContributed = rrspContributed;
    }
}
