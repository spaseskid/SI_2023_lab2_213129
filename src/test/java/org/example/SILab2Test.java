package org.example;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SILab2Test {
    private final User user1=new User("david","rokismoki!","david@yahoo.com");
    private final User user2=new User("dav","passwroko#","dav@hotmail.com");
    private final User user3=new User("Marko","markokoko#","marko@gmail.com");
    private final List<User> allUsers=new ArrayList<User>();

    @Test
    void everyBrenchTestingByMessage() {
        RuntimeException ex;
        allUsers.add(user1);
        allUsers.add(user2);
        allUsers.add(user3);
        ex=assertThrows(RuntimeException.class, ()->SILab2.function(null,allUsers));
        assertTrue(ex.getMessage().contains("Mandatory information missing!"));
        assertFalse(SILab2.function(new User(null, "rokismoki!", "david@yahoo.com"), allUsers));
        assertFalse(SILab2.function(new User("dav", "rok", "davidyahoo.com"), allUsers));
        assertFalse(SILab2.function(new User("dav", "roki smoki!", "david@yahoo.com"), allUsers));
        assertFalse(SILab2.function(new User("dav", "rokismoki!", "david@yahoo.com"), allUsers));
    }
    @Test
    void MultipleConditionTestingByMessage(){
        RuntimeException ex;
        allUsers.add(user1);
        allUsers.add(user2);
        allUsers.add(user3);
        ex=assertThrows(RuntimeException.class, ()->SILab2.function(null,allUsers));
        assertTrue(ex.getMessage().contains("Mandatory information missing!"));
        ex=assertThrows(RuntimeException.class, ()->SILab2.function(new User(null,null,null),allUsers));
        assertTrue(ex.getMessage().contains("Mandatory information missing!"));
        ex=assertThrows(RuntimeException.class, ()->SILab2.function(new User("dav",null,"david@yahoo.com"),allUsers));
        assertTrue(ex.getMessage().contains("Mandatory information missing!"));

        assertFalse(SILab2.function(new User("dav", "rokosmoki!", "david@yahoo.com"), allUsers));

    }
}