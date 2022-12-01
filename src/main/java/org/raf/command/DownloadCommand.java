package org.raf.command;

import org.raf.specification.Specification;

public class DownloadCommand implements Command{

    private Specification storage;
    private String coreFile;
    private String newFile;

    public DownloadCommand(Specification storage, String coreFile, String newFile) {
        this.storage = storage;
        this.coreFile = coreFile;
        this.newFile = newFile;
    }

    @Override
    public void execute(){
        this.storage.download(this.coreFile, this.newFile);
    }

    @Override
    public String commandName() {
        return null;
    }
}
