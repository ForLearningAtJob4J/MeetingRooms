package ru.engineeroid.store;

public class StoreManager {
    private static final class Lazy {
        private static final Store INST = new PostgreHbnStore();
    }

    public static Store instOf() {
        return Lazy.INST;
    }
}
