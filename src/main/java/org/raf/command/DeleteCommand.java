package org.raf.command;

import org.raf.specification.Specification;

public class DeleteCommand implements Command{

    private Specification storage;
    private String filePath;

    public DeleteCommand(Specification storage, String filePath) {
        this.storage = storage;
        this.filePath = filePath;
    }

    @Override
    public void execute(){
        this.storage.delete(this.filePath);
    }

    @Override
    public String commandName() {
        return null;
    }
}
