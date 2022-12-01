package org.raf.command;

import org.raf.specification.Specification;

public class GetAllFilesFromAllDirsInDirCommand implements Command{

    private Specification storage;
    private String pathToDir;

    public GetAllFilesFromAllDirsInDirCommand(Specification storage, String pathToDir) {
        this.storage = storage;
        this.pathToDir = pathToDir;
    }

    @Override
    public void execute() {
        this.storage.getAllFilesFromAllDirsInDir(this.pathToDir);
    }

    @Override
    public String commandName() {
        return null;
    }



}
