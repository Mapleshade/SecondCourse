package ru.kpfu.itis.service.impl;

import org.springframework.stereotype.Service;
import ru.kpfu.itis.model.Operation;
import ru.kpfu.itis.service.CalculatorService;

/**
 * Created by Elina on 21.03.2017.
 */
@Service
public class CalculatorServiceImpl implements CalculatorService {

    @Override
    public double Calculate(Operation operation) {

        double first = Double.parseDouble (operation.getFirst());
        double second = Double.parseDouble (operation.getSecond());

        switch (operation.getOperand()) {
            case "+":
                return  first + second;
            case "-":
                return first - second;
            case "*":
                return first * second;
            case "/":
                return first / second;
        }

        return 0;
    }
}
