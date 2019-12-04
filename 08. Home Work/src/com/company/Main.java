package com.company;

import GroupList.GroupList;
import GroupList.Pair;
import Journal.PhoneCallLog;
import Journal.PhoneCallMessage;
import Journal.PhoneContacts;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        //RandomInfoGenerator RIG = new RandomInfoGenerator(); // By default 50
        RandomInfoGenerator RIG = new RandomInfoGenerator(7, 350, 300); // By default 50
        Printer mPrint = new Printer();

        List<PhoneContacts> phoneContacts = new ArrayList<>();
        List<PhoneCallMessage> phoneMessages = new ArrayList<>();
        List<PhoneCallLog> phoneCallLogs = new ArrayList<>();

        // Generate data for all Lists and fill them
        RIG.generate(phoneContacts, phoneMessages, phoneCallLogs);

        /* Print data from Lists
        PhoneContacts.print(phoneContacts);
        PhoneCallMessage.print(phoneMessages);
        PhoneCallLog.print(phoneCallLogs);
         */

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter search keyword...");
//        String keyword = sc.nextLine();
        String keyword = "";

        /* Search by keyword test
        Collection<PhoneContacts> foundedContacts = PhoneContacts.find(phoneContacts, keyword);
        PhoneContacts.print((List<PhoneContacts>) foundedContacts);

        Collection<PhoneCallMessage> foundedMessages = PhoneCallMessage.find(phoneMessages, keyword, "date");
        PhoneCallMessage.print((List<PhoneCallMessage>) foundedMessages);

        Collection<PhoneCallLog> foundedLogs = PhoneCallLog.find(phoneCallLogs, keyword, "status");
        PhoneCallLog.print((List<PhoneCallLog>) foundedLogs);
         */

        GroupList groupList = new GroupList();
        Map<PhoneContacts, List<PhoneCallLog>> groupContactsAndLogs = groupList.groupContactsAndCalls(phoneContacts, phoneCallLogs);
        Map<PhoneContacts, List<PhoneCallMessage>> groupContactsAndMessages = groupList.groupContactsAndMessages(phoneContacts, phoneMessages);

        /* Print groups
        mPrint.printContactsAndLogs(groupContactsAndLogs);
        mPrint.printContactsAndMessages(groupContactsAndMessages);
         */

        // Sorting over Map

        Comparator<Map.Entry<PhoneContacts, List<PhoneCallLog>>> sizeLengthComparator =
                Comparator.comparingInt(e -> e.getValue().size());


        System.out.println("=====================TOP 5 by LOGS==========================");
        // Print to console top five by Logs
        groupContactsAndLogs
                .entrySet()
                .stream()
                .sorted(sizeLengthComparator.reversed())
                .limit(5)
                .forEach(item -> {
                        System.out.println(item.getKey().getUserName() + ", " + item.getKey().getPhoneNumber() + " - " + item.getValue().size() + " logs");
                });


        System.out.println("=====================THE END==========================");


        System.out.println("=====================TOP 5 by MESSAGES==========================");

        Comparator<Map.Entry<PhoneContacts, List<PhoneCallMessage>>> sizeLengthComparator2 =
                Comparator.comparingInt(e -> e.getValue().size());

        // Print to console top five by Messages
        groupContactsAndMessages
                .entrySet()
                .stream()
                .sorted(sizeLengthComparator2.reversed())
                .limit(5)
                .forEach(item -> {
                        System.out.println(item.getKey().getUserName() + ", " + item.getKey().getPhoneNumber() + " - " + item.getValue().size() + " messages");
                });
        System.out.println("=====================THE END==========================");


        // Sorting over List and Pair

        // Top 5 by Logs with Pair
        List<Pair<PhoneContacts,Integer>> top5 = new ArrayList<>();

        for( PhoneContacts key : groupContactsAndLogs.keySet() ){
            Pair fnp = new Pair<PhoneContacts, Integer>(key, groupContactsAndLogs.get(key).size());
            top5.add(fnp);
        }

        top5.sort((val1,val2)->Integer.compare(val2.getValue2(),val1.getValue2()));

        int howMany = 5;
        int starter = 0;

        for( Pair<PhoneContacts, Integer> one : top5 ){
            if(starter++ == howMany) break;
            System.out.println(one.getValue1().getUserName() + " - " + one.getValue2());
        }

        System.out.println("--------------------------------------------------------");

        // top 5 by Messages with Pair
        List<Pair<PhoneContacts,Integer>> top5mes = new ArrayList<>();

        for( PhoneContacts key : groupContactsAndMessages.keySet() ){
            Pair fnp = new Pair(key, groupContactsAndMessages.get(key).size());
            top5mes.add(fnp);
        }

        top5mes.sort((val1,val2)->Integer.compare(val2.getValue2(),val1.getValue2()));

        howMany = 5;
        starter = 0;

        for( Pair<PhoneContacts, Integer> one : top5mes ){
            if(starter++ == howMany) break;
            System.out.println(one.getValue1().getUserName() + " - " + one.getValue2());
        }
    }
}
