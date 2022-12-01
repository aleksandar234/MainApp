package org.raf.command;

import org.raf.specification.Specification;

public class GetFilesWithSubstringCommand implements Command{

    private Specification storage;
    private String dirPath;
    private String subString;

    public GetFilesWithSubstringCommand(Specification storage, String dirPath, String subString) {
        this.storage = storage;
        this.dirPath = dirPath;
        this.subString = subString;
    }

    @Override
    public void execute() {
        this.storage.getFilesWithSubstring(this.dirPath, this.subString);
    }

    @Override
    public String commandName() {
        return null;
    }
}
