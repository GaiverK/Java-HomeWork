package Journal;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class PhoneCallLog {
    private String phoneNumber;
    private String callerPhoneNumber;
    private String type;
    private String status;
    private String callDate;

    public PhoneCallLog(String phoneNumber, String callerPhoneNumber, String type, String status, String callDate) {
        this.phoneNumber = phoneNumber;
        this.callerPhoneNumber = callerPhoneNumber;
        this.type = type;
        this.status = status;
        this.callDate = callDate;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getCallerPhoneNumber() {
        return callerPhoneNumber;
    }

    public String getType() {
        return type;
    }

    public String getStatus() {
        return status;
    }

    public String getCallDate() {
        return callDate;
    }

    public static void print(List<PhoneCallLog> phoneLogs){
        phoneLogs.forEach(item -> {
            System.out.println(item.getPhoneNumber() + " - " + item.getCallerPhoneNumber() + " - " + item.getType() + " - " + item.getStatus() + " - " + item.getCallDate());
        });
    }

    public static Collection<PhoneCallLog> find(Collection<PhoneCallLog> pLogs, String keyWord, String parametr){
        Collection<PhoneCallLog> foundedLogs = new ArrayList<>();
        keyWord = keyWord.toLowerCase();

        for(PhoneCallLog log : pLogs){
            switch (parametr){
                case "date":
                    if( log.getCallDate().contains(keyWord) ){
                        foundedLogs.add(log);
                    }
                    break;
                case "phone":
                    if( log.getPhoneNumber().contains(keyWord) ){
                        foundedLogs.add(log);
                    }
                    break;
                case "type":
                    if( log.getType().toLowerCase().contains(keyWord) ){
                        foundedLogs.add(log);
                    }
                    break;
                case "status":
                    if( log.getStatus().toLowerCase().contains(keyWord) ){
                        foundedLogs.add(log);
                    }
                    break;
                default:
                    if( log.getPhoneNumber().toLowerCase().contains(keyWord) || log.getCallerPhoneNumber().contains(keyWord) || log.getType().contains(keyWord) || log.getStatus().contains(keyWord) || log.getCallDate().contains(keyWord) ){
                        foundedLogs.add(log);
                    }
            }
        }

        return  foundedLogs;
    }
}
