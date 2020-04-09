package com.aby.c0769778_w2020_mad3125_midterm.model;

import android.os.Parcel;
import android.os.Parcelable;

import org.joda.time.LocalDate;

public class CRACustomer implements Parcelable
{

    public CRACustomer(String SIN, String firstName, String lastName, Gender gender, LocalDate birthDate, Double grossIncome, Double rrspContributed) {
        this.SIN = SIN;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.birthDate = birthDate;
        this.grossIncome = grossIncome;
        this.rrspContributed = rrspContributed;
    }

    protected CRACustomer(Parcel in) {
        SIN = in.readString();
        firstName = in.readString();
        lastName = in.readString();
        grossIncome = in.readDouble();
        rrspContributed = in.readDouble();
    }

    public static final Creator<CRACustomer> CREATOR = new Creator<CRACustomer>() {
        @Override
        public CRACustomer createFromParcel(Parcel in) {
            return new CRACustomer(in);
        }

        @Override
        public CRACustomer[] newArray(int size) {
            return new CRACustomer[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(SIN);
        dest.writeString(firstName);
        dest.writeString(lastName);
        dest.writeDouble(grossIncome);
        dest.writeDouble(rrspContributed);
    }

    public enum Gender {
        Male, Female, Other
    }
    private String SIN;
    private String firstName;
    private String lastName;
    private Gender gender;
    private LocalDate birthDate;
    private double grossIncome;
    private double rrspContributed;

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

    public double getGrossIncome() {
        return grossIncome;
    }

    public void setGrossIncome(double grossIncome) {
        this.grossIncome = grossIncome;
    }

    public double getRrspContributed() {
        return rrspContributed;
    }

    public void setRrspContributed(double rrspContributed) {
        this.rrspContributed = rrspContributed;
    }
}
