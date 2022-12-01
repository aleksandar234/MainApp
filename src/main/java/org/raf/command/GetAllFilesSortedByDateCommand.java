package org.raf.command;

import org.raf.specification.Specification;

public class GetAllFilesSortedByDateCommand implements Command{

    private Specification storage;
    private String pathToDir;
    private String order;


    public GetAllFilesSortedByDateCommand(Specification storage, String pathToDir, String order) {
        this.storage = storage;
        this.pathToDir = pathToDir;
        this.order = order;
    }

    @Override
    public void execute() {
        this.storage.getAllFilesSortedByDate(this.pathToDir, this.order);
    }

    @Override
    public String commandName() {
        return null;
    }
}
