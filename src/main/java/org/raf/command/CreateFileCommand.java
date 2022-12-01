package org.raf.command;

import org.raf.specification.Specification;

public class CreateFileCommand implements Command{

    private Specification storage;
    private String filePath;

    public CreateFileCommand(Specification storage, String filePath) {
        this.storage = storage;
        this.filePath = filePath;
    }

    @Override
    public void execute(){
        this.storage.createFile(this.filePath);
    }

    @Override
    public String commandName() {
        return null;
    }
}
