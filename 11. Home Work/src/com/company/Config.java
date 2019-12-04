package com.company;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Config {

    private final String root = "./files/";
    private final String differentValuesPath = "different_values/";
    private final String collectionStringPath = "collection_string/";
    private final String collectionContactsNotSerializable = "collection_contacts_not_serializable/";
    private final String collectionContactsIsSerializable = "collection_contacts_is_serializable/";

    public String getRoot(){
        return root;
    }

    public String getDifferentValuesPath() {
        return absPath(differentValuesPath, "values.dat");
    }

    public String getCollectionStringPath() {
        return absPath(collectionStringPath, "strings.dat");
    }

    public String getCollectionContactsNotSerializable() {
        return absPath(collectionContactsNotSerializable, "contacts.dat");
    }

    public String getCollectionContactsIsSerializable() {
        return absPath(collectionContactsIsSerializable, "contacts.dat");
    }

    private String absPath(String path, String fileName){
        Path absPath = Paths.get(root, path);
        new File(absPath.toString()).mkdirs();
        return Paths.get(root, path, fileName).toAbsolutePath().toString();
    }
}
