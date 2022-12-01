package org.raf.cli;

import org.raf.command.*;
import org.raf.googleApi.RemoteStorage;
import org.raf.local_storage.LocalStorage;
import org.raf.specification.Specification;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class MainApp implements Runnable{
    private boolean running;
    private Scanner scanner;
    private Specification storage;

    public MainApp() {
        this.scanner = new Scanner(System.in);
    }

    public void run() {
        running = true;
        while(running) {
            try {
                System.out.print("Enter komponente.command >> ");
                String line = scanner.nextLine();
                Command command = parseCommand(line);
                command.execute();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private Command parseCommand(String line) throws IOException {
        String[] commandParts = line.split(" ");
        if(commandParts.length < 1 || commandParts[0].isEmpty()) return null;
        String command = commandParts[0];
        switch (command) {
            case "init":
                if(commandParts.length != 3)
                    throw new IOException("Initializing a komponente.storage takes in 3 arguments => init local pathToInit");
                if(commandParts[1].equals("local")) {
                    storage = new LocalStorage(commandParts[2]);
                    return new SetStorageCommand(storage);
                }
                if(commandParts[1].equals("remote")) {
                    storage = new RemoteStorage(commandParts[2]);
                    return new SetStorageCommand(storage);
                }
            case "makeDirs":
                if(commandParts.length != 2)
                    throw new IOException("MakeDirs takes in 2 arguments => makeDirs numberOfDirs");
                return new MakeDirsCommand(storage, Integer.parseInt(commandParts[1]));
            case "setMaxFileSize":
                if(commandParts.length != 2)
                    throw new IOException("SetMaxFileSize takes in 2 arguments => setMaxFileSize fileSize");
                return new SetMaxFileSize(storage, Integer.parseInt(commandParts[1]));
            case "setBlockedExtensions":
                if(commandParts.length < 2)
                    throw new IOException("SetBlockedExtensions takes in 2 or more arguments => setMaxFileSize TXT PNG");
                List<String> extensions = addExtensions(commandParts);
                return new SetBlockedExtensions(storage, extensions);
            case "download":
                if(commandParts.length != 3)
                    throw new IOException("Download takes in 3 arguments => download coreFile newFile");
                return new DownloadCommand(storage, commandParts[1], commandParts[2]);
            case "upload":
                if(commandParts.length != 3)
                    throw new IOException("Upload takes in 3 arguments => upload fromDesktop toMyStorage");
                return new UploadCommand(storage, commandParts[1], commandParts[2]);
            case "rename":
                if(commandParts.length != 3)
                    throw new IOException("Renaming a file takes in 3 arguments => rename HL\\serious.txt something.txt");
                return new RenameCommand(storage, commandParts[1], commandParts[2]);
            case "createFile":
                if(commandParts.length != 2)
                    throw new IOException("Creating a file takes in 2 arguments => createFile filePath");
                return new CreateFileCommand(storage, commandParts[1]);
            case "delete":
                if(commandParts.length != 2)
                    throw new IOException("Deleting a file takes in 2 arguments => delete filePath");
                return new DeleteCommand(storage, commandParts[1]);
            case "getAllFilesInDir":
                if(commandParts.length != 2)
                    throw new IOException("GettingAllFilesInDir in 2 arguments => getAllFilesInDir filePath");
                return new GetAllFilesInDirCommand(storage, commandParts[1]);
            case "getAllFilesFromAllDirsInDir":
                if(commandParts.length != 2)
                    throw new IOException("GetAllFilesFromAllDirsInDir in 2 arguments => getAllFilesFromAllDirsInDir filePath");
                return new GetAllFilesFromAllDirsInDirCommand(storage, commandParts[1]);
            case "getFilesWithExtension":
                if(commandParts.length != 3)
                    throw new IOException("GetFilesWithExtension in 3 arguments => getFilesWithExtensions pathToDir extension");
                return new GetFilesWithExtension(storage, commandParts[1], commandParts[2]);
            case "getFilesWithSubstring":
                if(commandParts.length != 3)
                    throw new IOException("GetFilesWithSubstring in 3 arguments => getFilesWithSubstring pathToDir sub");
                return new GetFilesWithSubstringCommand(storage, commandParts[1], commandParts[2]);
            case "getFilesWithName":
                if(commandParts.length < 3)
                    throw new IOException("GetFilesWithName in 3 or more arguments => getFilesWithName pathToDir (String... names)");
                String[] allNames = addNames(commandParts);
                return new GetFilesWithNameCommand(storage, commandParts[1], allNames);
            case "getDirFromNameOfFile":
                if(commandParts.length != 2)
                    throw new IOException("GetDirFromNameOfFile in 2 arguments => getDirFromNameOfFile nameOfFile");
                return new GetDirFromNameOfFileCommand(storage, commandParts[1]);
            case "getAllFilesSortedByName":
                if(commandParts.length != 3)
                    throw new IOException("GetAllFilesSortedByName in 3 arguments => getAllFilesSortedByName pathToDir ascending|descending");
                return new GetAllFilesSortedByNameCommand(storage, commandParts[1], commandParts[2]);
            case "getAllFilesSortedByDate":
                if(commandParts.length != 3)
                    throw new IOException("GetAllFilesSortedByDate in 3 arguments => getAllFilesSortedByDate pathToDir ascending|descending");
                return new GetAllFilesSortedByDateCommand(storage, commandParts[1], commandParts[2]);
            case "getFilesCreatedInCertainTime":
                if(commandParts.length != 3)
                    throw new IOException("GetFilesCreatedInCertainTime in 3 arguments => getFilesCreatedInCertainTime pathToDir time");
                return new GetFilesCreatedInCertainTimeCommand(storage, commandParts[1], commandParts[2]);
        }
        throw new IOException("Invalid komponente.command " + command + ", please try again ?");
    }

    private String[] addNames(String[] commandParts) {
        List<String> names = new ArrayList<>();
        for(int i = 2; i < commandParts.length; i++) {
            names.add(commandParts[i]);
        }
        String[] allNames = new String[names.size()];
        int i = 0;
        for(String n: names) {
            allNames[i++] = n;
        }
        return allNames;
    }

    private List<String> addExtensions(String[] commandParts) {

        List<String> extensions = new LinkedList<>();
        for(int i = 1; i < commandParts.length; i++) {
            extensions.add(commandParts[i]);
        }
        return extensions;

    }

    public static void main(String[] args) {
        MainApp mainApp = new MainApp();
        mainApp.run();
    }


}
