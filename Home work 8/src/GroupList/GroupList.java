package GroupList;

import Journal.PhoneCallLog;
import Journal.PhoneCallMessage;
import Journal.PhoneContacts;

import java.util.*;

public class GroupList {


    public Map<PhoneContacts, List<PhoneCallLog>> groupContactsAndCalls(List<PhoneContacts> phoneContacts, List<PhoneCallLog> phoneCallLogs){
        Map<PhoneContacts, List<PhoneCallLog>> mapGroup = new HashMap<>();
        phoneContacts.forEach(item ->{
            List<PhoneCallLog> groupLogsByNumber = new ArrayList<>();
            phoneCallLogs.forEach(secItem -> {
                if( item.getPhoneNumber().equals(secItem.getPhoneNumber()) ) groupLogsByNumber.add(secItem);
            });

            mapGroup.put(item, groupLogsByNumber);
        });

        return  mapGroup;
    }

    public Map<PhoneContacts, List<PhoneCallMessage>> groupContactsAndMessages(List<PhoneContacts> phoneContacts, List<PhoneCallMessage> phoneCallMessages) {
        Map<PhoneContacts, List<PhoneCallMessage>> mapGroup = new HashMap<>();

        phoneContacts.forEach(item ->{
            List<PhoneCallMessage> groupMessagesByNumber = new ArrayList<>();
            phoneCallMessages.forEach(secItem -> {
                if( item.getPhoneNumber().equals(secItem.getPhoneNumber()) ) groupMessagesByNumber.add(secItem);
            });

            mapGroup.put(item, groupMessagesByNumber);
        });

        return  mapGroup;
    }


}
