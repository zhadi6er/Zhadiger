package com.company;

public class Password {
    // passwordStr // it should contain uppercase and lowercase letters and digits
    // and its length must be more than 9 symbols

    public Password(String password) {
    }

    public Password() {

    }

    public boolean passwordChecker(String s) {

        boolean status = false;
        char [] array = s.toCharArray();
        int lower=0, upper=0, digits=0;

        if (s.length() > 8)
            status = true;

        for ( int i = 0;  i < array.length; i++) {
            if(Character.isDigit(array[i]))
                digits++;
            if(Character.isLowerCase(array[i]))
                lower++;
            if(Character.isUpperCase(array[i]))
                upper++;
        }

        if ( !(lower  > 0 ))
            status = false;

        if ( !(upper  > 0 ))
            status = false;

        if ( !(digits > 0 ))
            status = false;

        return status;
    }
}
