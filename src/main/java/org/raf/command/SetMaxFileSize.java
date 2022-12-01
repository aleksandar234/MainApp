package org.raf.command;

import org.raf.specification.Specification;

public class SetMaxFileSize implements Command{

    private Specification storage;
    private int fileSize;

    public SetMaxFileSize(Specification storage, int fileSize) {
        this.storage = storage;
        this.fileSize = fileSize;
    }

    @Override
    public void execute(){
        this.storage.setMaxFileSize(this.fileSize);
    }

    @Override
    public String commandName() {
        return null;
    }
}
