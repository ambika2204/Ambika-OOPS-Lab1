package com.greatlearning.email_applicaion;

public interface ICredentialService {
    public String generateEmailAddress(String firstName, String lastName, int departmentCode);

    public String generatePassword();

    public void displayCredentials(Employee employee);
}