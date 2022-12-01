package org.raf.command;

import org.raf.specification.Specification;

public class SetStorageCommand implements Command{

    private Specification storage;

    public SetStorageCommand(Specification storage) {
        this.storage = storage;
    }

    public void execute() {
        this.storage.init();
    }

    public String commandName() {
        return "SetStorageCommand";
    }
}
