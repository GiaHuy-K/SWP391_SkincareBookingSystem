package com.seroter.skincare_booking.model;

import jakarta.validation.constraints.Pattern;

public class Therapist {
    public String TherapistID;
    @Pattern(regexp = "^[a-zA-Z ]+$", message = "Name must contain only letters and spaces!")
    public String FullName;
    @Pattern(regexp = "^\\d{4}-\\d{2}-\\d{2}$", message = "Birth date must be in the format yyyy-MM-dd!")
    public String BirthDate;
    @Pattern(regexp = "^(male|female)$", message = "Gender must be either male or female!")
    public String Gender;
    @Pattern(regexp = "^\\d{10}$", message = "Phone number must be 10 digits!")
    public String PhoneNumber;
    @Pattern(regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$", message = "Invalid email address!")
    public String Email;
    @Pattern(regexp = "^[a-zA-Z0-9 ]+$", message = "Address must contain only letters and spaces!")
    public String Address;
    public String Specialization;
    public String Experience;
    public String WorkSchedule;
}
