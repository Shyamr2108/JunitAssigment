package com.masai.junitTest;

import com.masai.junit.Contact;
import com.masai.junit.ContactManager;
import org.junit.jupiter.api.*;

public class ContactManagerTest {
    static ContactManager manager ;

    // Contact manager object is created
    @BeforeAll
    public static void setUp(){
        manager=new ContactManager();

    }

    //Contact object is created and added to the collection of contact manager
	@Test
	@DisplayName("Should Create Contact")
    void createContact(){
//        manager.addContact("Shyam","Ranjan","0452057075");
        Contact contact = new Contact("Shyam","Ranjan","0452057075");
        manager.addContact(contact);

        Assertions.assertNotNull(manager.getAllContacts());

    }

    // This method check RuntimeException throw when firstname is null
    @Test
	@DisplayName("Should Not Create Contact When First Name is Null")
    void notNullFName(){
        Throwable exception = Assertions.assertThrows(RuntimeException.class,
                ()->{manager.addContact(new Contact("","hafladhl","0986754987"));});
    }
    //Here the addContact function throw exception because phone number does not start with o
	@Test
    @DisplayName("Phone Number should start with 0")
    void checkNo(){
        Contact contact = new Contact("Shreya","Ranjan","452057075");
        Throwable exception = Assertions.assertThrows(RuntimeException.class,
                ()->{manager.addContact(contact);});


    }

    // Contact manager object is set null
	@AfterAll
    public static void setNull(){
        manager = null;
    }

}
