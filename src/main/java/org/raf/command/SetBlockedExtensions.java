package org.raf.command;

import org.raf.specification.Specification;

import java.util.List;

public class SetBlockedExtensions implements Command{

    private Specification storage;
    private List<String> extensions;

    public SetBlockedExtensions(Specification storage, List<String> extensions) {
        this.storage = storage;
        this.extensions = extensions;
    }

    @Override
    public void execute() {
        this.storage.setBlockedExtensions(this.extensions);
    }

    @Override
    public String commandName() {
        return null;
    }
}
