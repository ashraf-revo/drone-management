package com.asrevo.drone.management.domain;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public record PackageNameValidator() {
    private final static Pattern pattern = Pattern.compile("^[A-Za-z0-9\\-_]*$");

    public boolean validate(String txt) {
        Matcher matcher = pattern.matcher(txt);
        return matcher.find();
    }
}
