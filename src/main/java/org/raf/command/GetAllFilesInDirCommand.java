package org.raf.command;

import org.raf.specification.Specification;

public class GetAllFilesInDirCommand implements Command{

    private Specification storage;
    private String pathToDir;

    public GetAllFilesInDirCommand(Specification storage, String pathToDir) {
        this.storage = storage;
        this.pathToDir = pathToDir;
    }

    @Override
    public void execute(){
        this.storage.getAllFilesInDir(this.pathToDir);
    }

    @Override
    public String commandName() {
        return null;
    }
}
