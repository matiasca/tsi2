package uy.com.arnaldocastro.servicedesk.movil;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import uy.com.arnaldocastro.servicedesk.movil.Contact;

public class ContactsView implements Serializable{
    
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Contact contact = new Contact();
    
    private List<Contact> contacts;

    public ContactsView() {
        contacts = new ArrayList<Contact>();
    }
    
    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }
    
    public List<Contact> getContacts() {
        return contacts;
    }
    
    public String saveContact(){
        if(!contacts.contains(contact)) {
            contacts.add(contact);
        }
        
        return "pm:main";
    }
    
    public String prepareNewContact() {
        contact = new Contact();
        
        return "pm:new";
    }

}
