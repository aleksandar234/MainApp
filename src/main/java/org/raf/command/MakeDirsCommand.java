package org.raf.command;

import org.raf.specification.Specification;

public class MakeDirsCommand implements Command{

    private Specification storage;
    private int numOfDirs;

    public MakeDirsCommand(Specification storage, int numOfDirs) {
        this.storage = storage;
        this.numOfDirs = numOfDirs;
    }


    @Override
    public void execute(){
        storage.makeDirs(this.numOfDirs);
    }

    @Override
    public String commandName() {
        return null;
    }
}
