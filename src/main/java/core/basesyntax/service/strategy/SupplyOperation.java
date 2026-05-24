package core.basesyntax.service.strategy;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;

public class SupplyOperation implements OperationHandler {
    @Override
    public void apply(FruitTransaction transaction) {
        int old = Storage.getStorage().getOrDefault(transaction.getFruit(), 0);
        if (old < transaction.getQuantity()) {
            throw new RuntimeException("Negative number of " 
                    + transaction.getFruit() + " in storage");
        }
        Storage.getStorage().put(transaction.getFruit(), old + transaction.getQuantity());
    }
}
