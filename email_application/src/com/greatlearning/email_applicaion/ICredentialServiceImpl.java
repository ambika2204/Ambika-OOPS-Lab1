package com.greatlearning.email_applicaion;

import java.util.Random;

public class ICredentialServiceImpl implements ICredentialService {
    String firstName, lastName;
    int departmentCode;
    @Override
    public String generateEmailAddress(String firstName, String lastName, int departmentCode){
        StringBuilder sb = new StringBuilder();
        String deptName = getDepartmentName(departmentCode);
        sb.append(firstName.toLowerCase().trim())
                .append(".")
                .append(lastName.toLowerCase().trim())
                .append("@")
                .append(deptName)
                .append(".")
                .append("gl")
                .append(".")
                .append("com");
        return sb.toString();
    }
    @Override
    public String generatePassword(){
        String capitalLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String smallLetters = "abcdefghijklmnopqrstuvwxyz";
        String specialChar = "@#%$^&*()!~";
        String numbers = "0123456789";
        String createPwdFrom =  capitalLetters.concat(smallLetters).concat(specialChar).concat(numbers);
        Random random = new Random();
        StringBuilder pwdCreated = new StringBuilder();

        for(int index = 1; index <= 2; index++){
            int ranVal = random.nextInt(capitalLetters.length());
            char randomCharVal = capitalLetters.charAt(ranVal);
            pwdCreated.append(randomCharVal);
        }
        for(int index = 1; index <= 2; index++){
            int ranVal = random.nextInt(smallLetters.length());
            char randomCharVal = smallLetters.charAt(ranVal);
            pwdCreated.append(randomCharVal);
        }
        for(int index = 1; index <= 2; index++){
            int ranVal = random.nextInt(numbers.length());
            char randomCharVal = numbers.charAt(ranVal);
            pwdCreated.append(randomCharVal);
        }
        for(int index = 1; index <= 2; index++){
            int ranVal = random.nextInt(specialChar.length());
            char randomCharVal = specialChar.charAt(ranVal);
            pwdCreated.append(randomCharVal);
        }

        return pwdCreated.toString();
    }

    @Override
    public void displayCredentials(Employee employee){
        System.out.println("Dear " + employee.getFirstName() + ", your generated credentials are as follows" );
        System.out.println("Email -------------> "+ employee.getEmailAddress());
        System.out.println("password ----------> "+ employee.getPassword());
    }

    private String getDepartmentName(int code){
        String deptName = null;
        switch(code) {
            case 1:
                deptName = "tech";
                break;
            case 2:
                deptName = "admin";
                break;
            case 3:
                deptName = "hr";
                break;
            case 4:
                deptName = "legal";
                break;
        }
    return deptName;
    }
}
