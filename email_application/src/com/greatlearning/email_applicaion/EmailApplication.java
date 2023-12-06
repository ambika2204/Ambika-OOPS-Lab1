package com.greatlearning.email_applicaion;

import com.greatlearning.email_applicaion.ICredentialServiceImpl;

import java.util.Scanner;
public class EmailApplication {
    public void employeeDetails(){
        ICredentialServiceImpl credentialService = new ICredentialServiceImpl() ;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your First Name :");
        String firstName = scanner.nextLine();

        while(firstName.isBlank()){
            System.out.println("First name can not be left blank.");
            System.out.println("Enter your First Name :");
            firstName = scanner.nextLine();
        }
        System.out.println("Enter your Last Name :");
        String lastName = scanner.nextLine();

        while(lastName.isBlank()){
            System.out.println("Last name can not be left blank.");
            System.out.println("Enter your Last Name :");
            lastName = scanner.nextLine();
        }
        System.out.println("Enter your your Department code from the following:");
        System.out.print("1. Technical" + "\n" + "2. Admin" + "\n" + "3. Human Resorce" + "\n" + "4. Legal" + "\n" );
        int code = scanner.nextInt();

        while(code <= 0 || code > 4){
            System.out.println("Enter the correct code:");
            code = scanner.nextInt();
        }

        String emailAddress = credentialService.generateEmailAddress(firstName, lastName,code);
        String password = credentialService.generatePassword();

        Employee employee = new Employee(firstName.trim(), lastName.trim(), emailAddress.trim(),password.trim());

        credentialService.displayCredentials(employee);
    }
}