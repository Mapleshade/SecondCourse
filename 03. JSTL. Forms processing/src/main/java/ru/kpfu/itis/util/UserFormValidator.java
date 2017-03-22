package ru.kpfu.itis.util;


import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import ru.kpfu.itis.model.Operation;
import ru.kpfu.itis.model.User;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserFormValidator implements Validator {

    static Pattern p = Pattern.compile("\\d+");

    @Override
    public boolean supports(Class<?> aClass) {
        return Operation.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Operation operation = (Operation) o;
        if (operation.getFirst() == null) {
            errors.rejectValue("first", "", "Введите первый параметр");
        }

        if (operation.getSecond() == null) {
            errors.rejectValue("second", "", "Введите второй параметр");
        }

        if(operation.getSecond().equals("0") && operation.getOperand().equals("/")) {
            errors.rejectValue("second", "", "На ноль делить нельзя");
        }

        Matcher f = p.matcher(operation.getFirst());
        Matcher s = p.matcher(operation.getSecond());

        if (!f.matches()) {
            errors.rejectValue("first", "", "Тут можно только цифру");
        }

        if (!s.matches()) {
            errors.rejectValue("second", "", "Тут можно только цифру");
        }

    }
}
