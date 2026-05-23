package core.basesyntax.service.strategy;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;

public class PurchaseOperation implements OperationHandler {

    @Override
    public void apply(FruitTransaction transaction) {
        int old = Storage.storage.getOrDefault(transaction.getFruit(), 0);
        Storage.storage.put(transaction.getFruit(), old - transaction.getQuantity());
    }
    
}
