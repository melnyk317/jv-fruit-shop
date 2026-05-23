package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.Operation;
import java.util.ArrayList;
import java.util.List;

public class DataConverterImpl implements DataConverter {

    @Override
    public List<FruitTransaction> convertToTransaction(List<String> lines) {
        List<FruitTransaction> result = new ArrayList<>();
        for (String data : lines) {
            result.add(parseLine(data));
        }
        return result;
    }

    private FruitTransaction parseLine(String line) {
        if (line == null || line.trim().isEmpty()) {
            throw new RuntimeException("Line is empty");
        }

        String[] data = line.split(",");

        if (data.length != 3) {
            throw new RuntimeException("Bad number of data");
        }

        String operationCode = data[0].trim();
        String fruit = data[1].trim();
        String quantityString = data[2].trim();

        if (operationCode.length() == 0) {
            throw new RuntimeException("Operation isn't provided");
        }

        if (fruit.length() == 0) {
            throw new RuntimeException("Fruit isn't provided");
        }

        if (quantityString.length() == 0) {
            throw new RuntimeException("Quantity isn't provided");
        }

        int quantity;

        try {
            quantity = Integer.parseInt(quantityString);
        } catch (NumberFormatException e) {
            throw new RuntimeException("Quantity must be a number: " + quantityString);
        }

        if (quantity <= 0) {
            throw new RuntimeException("Quantity must be a positive number: " + quantityString);
        }

        Operation operation = Operation.fromCode(operationCode);

        return new FruitTransaction(fruit, operation, quantity);
    }
}
