package com.library.library.service.collectionStrategy.addStrategy;

public class AddContext {
    private AddStrategy strategy;

    public AddContext(AddStrategy strategy){
        this.strategy = strategy;
    }

    public Object executeStrategy(Object item){
        return strategy.addItem(item);
    }
}
