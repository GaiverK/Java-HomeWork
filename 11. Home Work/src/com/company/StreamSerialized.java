package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Consumer;

public class StreamSerialized {

    private Consumer<? super Contact> contactConsumer = contact->{
        System.out.printf("Name: %s, Age: %d, Phone: %s, isActive: %b\n",
                contact.getName(),
                contact.getAge(),
                contact.getPhone(),
                contact.isActive()
        );
    };

    public void writeDifferentValues(String fileName) {
        try(DataOutputStream dos = new DataOutputStream(new FileOutputStream(fileName))){
            dos.writeInt(123);
            dos.writeUTF("Hello World");
            dos.writeBoolean(false);
        }catch (IOException e){
            System.out.println("Something wrong with file");
            e.printStackTrace();
        }
    }

    public void readDifferentValues(String fileName) {
        try(DataInputStream dis = new DataInputStream(new FileInputStream(fileName))){
            int num = dis.readInt();
            String str = dis.readUTF();
            boolean bool = dis.readBoolean();

            System.out.println("------------Different values------------");
            System.out.printf("The num is %d, String is %s, Boolean is %b",
                    num,
                    str,
                    bool
            );
        }catch (IOException e){
            System.out.println("Something wrong with file");
            e.printStackTrace();
        }
    }

    public void writeCollectionString(String fileName){
        List<String> stringCollection = new ArrayList<>();
        while (stringCollection.size() < 20) stringCollection.add(getRandomString(15));

        try(DataOutputStream dos = new DataOutputStream(new FileOutputStream(fileName))) {
            dos.writeInt(999);
            dos.writeInt(stringCollection.size());
            for( String str : stringCollection ){
                dos.writeUTF(str);
            }
            dos.writeInt(666);
        } catch (IOException e) {
            System.out.println("Something wrong with file");
            e.printStackTrace();
        }
    }

    public List<String> readCollectionString(String fileName){
        List<String> stringCollection = new ArrayList<>();

        try(DataInputStream dis = new DataInputStream(new FileInputStream(fileName))){
            dis.readInt();
            int collectionSize = dis.readInt();
            for(int i = 0; i < collectionSize; i++){
                stringCollection.add(dis.readUTF());
            }
        }catch (IOException e){
            System.out.println("Something wrong with file");
            e.printStackTrace();
        }

        // Print result
        System.out.println("\n\n------------Strings collection------------");
        stringCollection
                .stream()
                .forEach(System.out::println);

        return stringCollection;
    }

    public void writeContactsCollection(String fileName){
        List<Contact> contacts = new ArrayList<>();
        int howMany = 20;

        // Build contacts
        while (contacts.size() < howMany) contacts.add(Contact.getRandomContact());

        try(DataOutputStream dos = new DataOutputStream(new FileOutputStream(fileName))){
            dos.writeInt(contacts.size());
            for( Contact singleContact : contacts ){
                dos.writeUTF(singleContact.getName());
                dos.writeInt(singleContact.getAge());
                dos.writeUTF(singleContact.getPhone());
                dos.writeBoolean(singleContact.isActive());
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void readContactsCollection(String fileName){
        List<Contact> contacts = new ArrayList<>();

        try(DataInputStream dis = new DataInputStream(new FileInputStream(fileName))){
            int collectionSize = dis.readInt();
            for( int i = 0; i < collectionSize; i++ ){
                contacts.add(new Contact(
                    dis.readUTF(),
                    dis.readInt(),
                    dis.readUTF(),
                    dis.readBoolean()
                ));
            }
        }catch (IOException e){
            e.printStackTrace();
        }

        // Print Result
        System.out.println("\n\n------------Contacts collection------------");
        contacts
                .stream()
                .forEach(contactConsumer);
    }

    public void writeContactsCollectionSerializable(String filename){
        List<Contact> contacts = new ArrayList<>();
        int howMany = 20;

        // Build contacts
        while (contacts.size() < howMany) contacts.add(Contact.getRandomContact());

        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))){
            oos.writeInt(contacts.size());
            for( Contact singleContact : contacts ){
                oos.writeObject(singleContact);
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void readContactsCollectionSerializableBySize(String filename){
        List<Contact> contacts = new ArrayList<>();

        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))){
            int size = ois.readInt();
            for( int i = 0; i < size; i++ ){
                contacts.add((Contact)ois.readObject());
            }
        }catch (IOException | ClassNotFoundException e){
            e.printStackTrace();
        }

        // Print Result
        System.out.println("\n\n------------Contacts collection Serializable by Size------------");
        contacts
                .stream()
                .forEach(contactConsumer);

    }

    public void readContactsCollectionSerializableByAvailable(String filename){
        List<Contact> contacts = new ArrayList<>();

        try(FileInputStream fis = new FileInputStream(filename);ObjectInputStream ois = new ObjectInputStream(fis)){
            ois.readInt(); // Не хотел создавать новый writer
            while (fis.available() > 0){
                contacts.add( (Contact) ois.readObject() );
            }
        }catch (IOException | ClassNotFoundException e){
            e.printStackTrace();
        }

        // Print Result
        System.out.println("\n\n------------Contacts collection Serializable by Available------------");
        contacts
                .stream()
                .forEach(contactConsumer);

    }

    public void writeListContacts(String filename){
        List<Contact> contacts = new ArrayList<>();
        int howMany = 30;

        // Build contacts
        while (contacts.size() < howMany) contacts.add(Contact.getRandomContact());

        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))){
                oos.writeObject(contacts);
         }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void readListContacts(String filename){
        List<Contact> contacts = new ArrayList<>();
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))){
            contacts = (List<Contact>)ois.readObject();
        }catch (IOException e){
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        // Print Result
        System.out.println("\n\n------------Contacts collection by List------------");
        contacts
                .stream()
                .forEach(contactConsumer);
    }

    private String getRandomString(int size){
        String engAlphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        StringBuilder stringBuilder = new StringBuilder();
        while( stringBuilder.length() < size ){
            stringBuilder.append(engAlphabet.charAt(randomIntRange(0, engAlphabet.length() - 1)));
        }
        return stringBuilder.toString();
    }

    static int randomIntRange(int min, int max){
        int diff = max - min;
        Random random = new Random();
        int i = random.nextInt(diff + 1);
        i += min;
        return i;
    }
}
