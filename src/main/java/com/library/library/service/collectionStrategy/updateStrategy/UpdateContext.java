package com.library.library.service.collectionStrategy.updateStrategy;

public class UpdateContext {
    private UpdateStrategy strategy;

    public UpdateContext(UpdateStrategy strategy){
        this.strategy = strategy;
    }

    public Object executeStrategy(Object item, String id){
        return strategy.updateItem(item, id);
    }
}
