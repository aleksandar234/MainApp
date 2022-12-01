package org.raf.command;

import org.raf.specification.Specification;

public class GetFilesCreatedInCertainTimeCommand implements Command{

    private Specification storage;
    private String pathToDir;
    private String date;

    public GetFilesCreatedInCertainTimeCommand(Specification storage, String pathToDir, String date) {
        this.storage = storage;
        this.pathToDir = pathToDir;
        this.date = date;
    }

    @Override
    public void execute() {
        this.storage.getFilesCreatedInCertainTime(this.pathToDir, this.date);
    }

    @Override
    public String commandName() {
        return null;
    }
}
