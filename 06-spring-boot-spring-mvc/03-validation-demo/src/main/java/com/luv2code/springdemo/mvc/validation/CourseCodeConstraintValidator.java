package com.luv2code.springdemo.mvc.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class CourseCodeConstraintValidator implements ConstraintValidator<CourseCode,String> {

    private String coursePrefix;

    @Override
    public void initialize(CourseCode constraintAnnotation) {
        coursePrefix=constraintAnnotation.value();
        //annotation kullanilirken verilecek valueyu kabul etmesi icin
    }

    @Override
    public boolean isValid(String theCode, ConstraintValidatorContext context) {

        boolean result;
        if(theCode != null){
            result=theCode.startsWith(coursePrefix);
        } else{
            result = true;
        }
        return result;
    }
}
