package org.raf.command;

import org.raf.specification.Specification;

public class UploadCommand implements Command{

    private Specification storage;
    private String pathFromUpload;
    private String pathToUpload;

    public UploadCommand(Specification storage, String pathFromUpload, String pathToUpload) {
        this.storage = storage;
        this.pathFromUpload = pathFromUpload;
        this.pathToUpload = pathToUpload;
    }


    @Override
    public void execute(){
        this.storage.upload(this.pathFromUpload, this.pathToUpload);
    }

    @Override
    public String commandName() {
        return null;
    }
}
