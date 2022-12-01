package org.raf.command;

import org.raf.specification.Specification;

public class GetDirFromNameOfFileCommand implements Command{

    private Specification storage;
    private String fileName;

    public GetDirFromNameOfFileCommand(Specification storage, String fileName) {
        this.storage = storage;
        this.fileName = fileName;
    }

    @Override
    public void execute() {
        this.storage.getDirFromNameOfFile(this.fileName);
    }

    @Override
    public String commandName() {
        return null;
    }
}
