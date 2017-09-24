package by.home.dao;

import by.home.model.Message;
import by.home.model.Profile;

import java.util.HashMap;
import java.util.Map;

public class Dao {

    private static Map<Long, Message> messages = new HashMap<>();
    private static Map<String, Profile> profiles = new HashMap<>();

    static {
        messages.put(1L, new Message(1, "hello world", "Vladimir"));
        messages.put(2L, new Message(2, "Hello Jersey", "Alex"));
        profiles.put("Vladimir", new Profile(1L, "Vladimir", "Zhyhar", "Vladimir"));
    }

    public static Map<Long, Message> getMessages() {
        return messages;
    }

    public static Map<String, Profile> getProfiles() {
        return profiles;
    }
}
