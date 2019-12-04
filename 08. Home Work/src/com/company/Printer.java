package com.company;

import Journal.PhoneCallLog;
import Journal.PhoneCallMessage;

import java.util.List;
import java.util.Map;

public class Printer {

    public void printContactsAndLogs(Map<String, List<PhoneCallLog>> cLogs){
        System.out.println("==========================START===========================");
        for( String key : cLogs.keySet() ){
            System.out.println("Print logs for number " + key + ":");
            cLogs.get(key).forEach(item->{
                System.out.printf("\tAbonent A - %s,Abonent B - %s, Call type - %s, Call status - %s, Call date - %s\n",
                        item.getPhoneNumber(),
                        item.getCallerPhoneNumber(),
                        item.getType(),
                        item.getStatus(),
                        item.getCallDate()
                        );
            });
        }
        System.out.println("==========================STOP===========================");
    }

    public void printContactsAndMessages(Map<String, List<PhoneCallMessage>> cMessages){
        System.out.println("==========================START===========================");
        for( String key : cMessages.keySet() ){
            System.out.println("Print logs for number " + key + ":");
            cMessages.get(key).forEach(item->{
                System.out.println("--------------------------------------------------------------------------------");
                System.out.printf("\tAbonent number - %s\n\tMessage text: \n\t\t%s\n\tSend type - %s, Status - %s, Date - %s\n",
                        item.getPhoneNumber(),
                        item.getMessageText(),
                        item.getType(),
                        item.getStatus(),
                        item.getMessageDate()
                );
                System.out.println("--------------------------------------------------------------------------------");
            });
        }
        System.out.println("==========================STOP===========================");
    }
}
