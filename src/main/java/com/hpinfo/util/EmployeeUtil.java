package com.hpinfo.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class EmployeeUtil {

    private static final String PREFIX = "EMP";
    private static final int ID_LENGTH = 6;
    private static int lastId = 200500;
    private static final String EMAIL_DOMAIN = "@hpinfosystem.com";

    public static synchronized String generateEmployeeId() {
        lastId++;
        String numberPart = String.format("%0" + ID_LENGTH + "d", lastId);
        log.info("Generated Employee ID: " + PREFIX + numberPart);
        return PREFIX + numberPart;
    }

    public static String generateEmail(String firstName, String lastName) {
        if (firstName == null || lastName == null) {
            throw new IllegalArgumentException("First name and last name must not be null.");
        }
        String email = firstName.trim().toLowerCase() + "." + lastName.trim().toLowerCase() + EMAIL_DOMAIN;
        log.info("generated email id for the employee :", email);
        return email;
    }

    public static String base64Encode(String input) {
        return java.util.Base64.getEncoder().encodeToString(input.getBytes());
    }
}

