package Journal;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class PhoneCallMessage {
    private String phoneNumber;
    private String messageText;
    private String messageDate;
    private String type;
    private String status;


    public PhoneCallMessage(String phoneNumber, String messageText, String messageDate, String type, String status) {
        this.phoneNumber = phoneNumber;
        this.messageText = messageText;
        this.messageDate = messageDate;
        this.type = type;
        this.status = status;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getMessageText() {
        return messageText;
    }

    public String getMessageDate() { return messageDate; }

    public String getType() {
        return type;
    }

    public String getStatus() {
        return status;
    }

    public static void print(List<PhoneCallMessage> phoneMessages){
        phoneMessages.forEach(item -> {
            System.out.println(item.getPhoneNumber() + " - " + item.getMessageText() + " - " + item.getMessageDate());
        });
    }

    public static Collection<PhoneCallMessage> find(Collection<PhoneCallMessage> pMessages, String keyWord, String parametr){
        Collection<PhoneCallMessage> foundedMessages = new ArrayList<>();

        for(PhoneCallMessage pMess : pMessages){
            switch (parametr){
                case "date":
                    if( pMess.getMessageDate().contains(keyWord) ){
                        foundedMessages.add(pMess);
                    }
                    break;
                case "phone":
                    if( pMess.getPhoneNumber().contains(keyWord) ){
                        foundedMessages.add(pMess);
                    }
                    break;
                case "text":
                    if( pMess.getMessageText().toLowerCase().contains(keyWord) ){
                        foundedMessages.add(pMess);
                    }
                    break;
                case "type":
                    if( pMess.getType().toLowerCase().contains(keyWord) ){
                        foundedMessages.add(pMess);
                    }
                    break;
                case "status":
                    if( pMess.getStatus().toLowerCase().contains(keyWord) ){
                        foundedMessages.add(pMess);
                    }
                    break;
                default:
                    if( pMess.getMessageText().toLowerCase().contains(keyWord) || pMess.getPhoneNumber().contains(keyWord) || pMess.getMessageDate().contains(keyWord) || pMess.getType().toLowerCase().contains(keyWord) || pMess.getStatus().toLowerCase().contains(keyWord) ){
                        foundedMessages.add(pMess);
                    }
            }
        }

        return  foundedMessages;
    }
}
