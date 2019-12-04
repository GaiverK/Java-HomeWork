package com.company;

import java.io.File;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        StreamSerialized strz = new StreamSerialized();
        Config cnf = new Config();

        // Write and Read different values
        strz.writeDifferentValues(cnf.getDifferentValuesPath());
        strz.readDifferentValues(cnf.getDifferentValuesPath());

        // Write and Read collection of strings
        strz.writeCollectionString(cnf.getCollectionStringPath());
        strz.readCollectionString(cnf.getCollectionStringPath());

        // Write and Read collection of contacts by Data[Input/Output]
        strz.writeContactsCollection(cnf.getCollectionContactsNotSerializable());
        strz.readContactsCollection(cnf.getCollectionContactsNotSerializable());

        // Write and Read collection of contacts by Object[Input/Output]
        strz.writeContactsCollectionSerializable(cnf.getCollectionContactsIsSerializable());
        strz.readContactsCollectionSerializableBySize(cnf.getCollectionContactsIsSerializable());
        strz.readContactsCollectionSerializableByAvailable(cnf.getCollectionContactsIsSerializable());
        strz.writeListContacts(cnf.getCollectionContactsIsSerializable()); // Write List<Contact>
        strz.readListContacts(cnf.getCollectionContactsIsSerializable()); // Read List<Contact>

        String path = cnf.getRoot();
        FileWorker.showHowManyFilesStaticRecurs(path);

        System.out.println("\n\n------------How many Files Static recurs------------");
        System.out.println("Path (\""+ path +"\") contains - " + FileWorker.fileLength + " files");
        System.out.println("\n------------Files names------------");


        FileWorker.lFiles
                .stream()
                .forEach(file -> System.out.println(file.getName() + " in directory (\"" + file.getParentFile().getName() + "\")"));

        FileWorker.resetParams();

        System.out.println("\n\n------------How many Files default recurs------------");
        System.out.println("Path (\""+ path +"\") contains - " + FileWorker.showHowManyFilesRecursDefault(path) + " files");
        System.out.println("\n------------Files names------------");
    }

    private static class FileWorker{
        static int fileLength = 0;
        static List<File> lFiles = new ArrayList<>();

        static void showHowManyFilesStaticRecurs(String path){
            File getFile = new File(path);
            File[] files = getFile.listFiles();
            for( File f: files ){
                if( f.isDirectory() ) showHowManyFilesStaticRecurs(Paths.get(path, f.getName()).toAbsolutePath().toString());
                else {
                    lFiles.add(f);
                    fileLength++;
                }
            }
        }

        static int showHowManyFilesRecursDefault(String path){
            int fileCounts = 0;
            File getFile = new File(path);
            File[] files = getFile.listFiles();
            for( File f: files ){
                if( f.isDirectory() ) fileCounts += showHowManyFilesRecursDefault(Paths.get(path, f.getName()).toAbsolutePath().toString());
                else {
                    fileCounts++;
                }
            }

            return fileCounts;
        }

        static void resetParams(){
            fileLength = 0;
            lFiles = new ArrayList<>();
        }
    }
}
