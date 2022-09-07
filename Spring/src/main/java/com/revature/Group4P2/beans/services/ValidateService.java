package com.revature.Group4P2.beans.services;

import com.revature.Group4P2.entities.Users;
import org.springframework.stereotype.Service;

import java.util.regex.Pattern;

@Service
public class ValidateService {
    public boolean validateUsers(Users users) {
        boolean check = true;

        if(users.getFirstName() == null || !Pattern.matches("^[A-Za-z' -\\.]{2,20}$", users.getFirstName())) {
            check = false;
        }
        if(users.getLastName() == null || !Pattern.matches("^[A-Za-z' -\\.]{2,20}$", users.getFirstName())) {
            check = false;
        }
        if (users.getEmail() == null || !Pattern.matches("^[A-Za-z0-9\\.\\-_]+@[A-Za-z0-9\\-]+\\.[A-Za-z]{2,5}$", users.getEmail())) {
            check = false;
        }

        // ^(?=.*\d)(?=.*[a-z]).{4,20}$
        // original didnt work : (?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).{8,20}$
        if(users.getPassword() == null || !Pattern.matches("^(?=.*\\d)(?=.*[a-z]).{4,20}$", users.getPassword())) {
            check = false;
        }

        // original: ^(?=[a-zA-Z0-9._]{8,20}$)(?!.*[_.]{2})[^_.].*[^_.]$
        if(users.getUsername() == null || !Pattern.matches("^(?=.*\\d)(?=.*[a-z]).{4,20}$", users.getUsername())) {
            check = false;
        }

        if(users.getAddress() == null || !Pattern.matches("^[a-zA-Z0-9 ]*$", users.getAddress())) {
            check = false;
        }
        if(users.getCardNumber() == null || !Pattern.matches("^(?:(?<visa>4[0-9]{12}(?:[0-9]{3})?)|" +
                "(?<mastercard>5[1-5][0-9]{14})|" +
                "(?<discover>6(?:011|5[0-9]{2})[0-9]{12}))$", users.getCardNumber())) {
            check = false;
        }
        return check;
    }
}
