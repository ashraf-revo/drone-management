package com.asrevo.drone.management.domain;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public record PackageCodeValidator() {
    private final static Pattern pattern = Pattern.compile("^[A-Z0-9\\-]*$");

    public boolean validate(String txt) {
        Matcher matcher = pattern.matcher(txt);
        return matcher.find();
    }
}
