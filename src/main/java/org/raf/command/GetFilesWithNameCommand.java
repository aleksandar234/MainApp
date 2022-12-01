package org.raf.command;

import org.raf.specification.Specification;

public class GetFilesWithNameCommand implements Command{

    private Specification storage;
    private String dirPath;
    private String[] fileNames;

    public GetFilesWithNameCommand(Specification storage, String dirPath, String... fileNames) {
        this.storage = storage;
        this.dirPath = dirPath;
        this.fileNames = fileNames;
    }

    @Override
    public void execute() {
        this.storage.getFilesWithName(this.dirPath, this.fileNames);
    }

    @Override
    public String commandName() {
        return null;
    }
}
