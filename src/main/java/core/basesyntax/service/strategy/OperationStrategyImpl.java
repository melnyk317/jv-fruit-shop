package core.basesyntax.service.strategy;

import java.util.Map;

import core.basesyntax.model.Operation;

public class OperationStrategyImpl implements OperationStrategy {
    private final Map<Operation, OperationHandler> handlers;

    public OperationStrategyImpl(Map<Operation, OperationHandler> handlers) {
        this.handlers = handlers;
    }

    @Override
    public OperationHandler getHandler(Operation operation) {
        return handlers.get(operation);
    }
    
}
