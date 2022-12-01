package org.raf.command;

import org.raf.specification.Specification;

public class GetFilesWithExtension implements Command{

    private Specification storage;
    private String dirPath;
    private String extension;

    public GetFilesWithExtension(Specification storage, String dirPath, String extension) {
        this.storage = storage;
        this.dirPath = dirPath;
        this.extension = extension;
    }

    @Override
    public void execute() {
        this.storage.getFilesWithExtension(this.dirPath, this.extension);
    }

    @Override
    public String commandName() {
        return null;
    }
}
