package Journal;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

public class PhoneContacts {
    private String userName;
    private String phoneNumber;

    public PhoneContacts(String userName, String phoneNumber) {
        this.userName = userName;
        this.phoneNumber = phoneNumber;
    }

    public String getUserName() {
        return userName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public static void print(List<PhoneContacts> phoneContacts){
        phoneContacts.forEach(item -> {
            System.out.println(item.getUserName() + " - " + item.getPhoneNumber());
        });
    }

    public static Collection<PhoneContacts> find(Collection<PhoneContacts> pContacts, String findMe){
        Collection<PhoneContacts> foundedContacts = new ArrayList<PhoneContacts>();
        for( PhoneContacts pC: pContacts ){
            if( pC.getPhoneNumber().contains(findMe) || pC.getUserName().contains(findMe) ){
                foundedContacts.add(pC);
            }
        }

        return foundedContacts;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PhoneContacts that = (PhoneContacts) o;
        return Objects.equals(userName, that.userName) &&
                Objects.equals(phoneNumber, that.phoneNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userName, phoneNumber);
    }
}
