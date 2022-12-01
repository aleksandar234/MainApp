package org.raf.command;

import org.raf.specification.Specification;

public class RenameCommand implements Command{

    private Specification storage;
    private String filePath;
    private String newName;

    public RenameCommand(Specification storage, String filePath, String newName) {
        this.storage = storage;
        this.filePath = filePath;
        this.newName = newName;
    }

    @Override
    public void execute(){
        this.storage.rename(this.filePath, this.newName);
    }

    @Override
    public String commandName() {
        return null;
    }
}
