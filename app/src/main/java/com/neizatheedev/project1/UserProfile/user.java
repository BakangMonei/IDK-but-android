package com.neizatheedev.project1.UserProfile;

import java.util.Objects;

public class user {
    // Attributes
    String firstName, lastName, email, gender, dateOfBirth, address;
    int phoneNumber;

    // Super Constructor
    public user() {
        super();
    }

    // Constructors
    public user(String firstName, String lastName, String email, String gender, String dateOfBirth, String address, int phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    // Getters
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getGender() {
        return gender;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public String getAddress() {
        return address;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    // Setters
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }


    // toString()
    @Override
    public String toString() {
        return "user[ " +
                "firstName: " + firstName + '\'' +
                ", lastName: " + lastName + '\'' +
                ", email: " + email + '\'' +
                ", gender: " + gender + '\'' +
                ", dateOfBirth: " + dateOfBirth + '\'' +
                ", address: " + address + '\'' +
                ", phoneNumber: " + phoneNumber +
                ']';
    }

    // equals() & hashCodes()
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        user user = (user) o;
        return phoneNumber == user.phoneNumber &&
                firstName.equals(user.firstName) &&
                lastName.equals(user.lastName) &&
                email.equals(user.email) &&
                gender.equals(user.gender) &&
                dateOfBirth.equals(user.dateOfBirth) &&
                address.equals(user.address);
    }
    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, email, gender, dateOfBirth, address, phoneNumber);
    }
}