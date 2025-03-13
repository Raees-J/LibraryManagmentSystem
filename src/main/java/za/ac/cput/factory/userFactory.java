package za.ac.cput.factory;

import za.ac.cput.domain.User;
import za.ac.cput.util.Helper;

public class userFactory {
    public static User createUser(String userId, String name, String address) {
        if (Helper.isNullOrEmpty(userId) ||
                Helper.isNullOrEmpty(name) ||
                Helper.isNullOrEmpty(address))
            return null;

        return new User.Builder().setUserId(userId)
                .setName(name)
                .setAddress(address)
                .build();

    }

    public static User createUser(String userId, String name, String address, String contactNumber) {
        if (Helper.isNullOrEmpty(userId) ||
                Helper.isNullOrEmpty(name) ||
                Helper.isNullOrEmpty(address) ||
                Helper.isNullOrEmpty(contactNumber))
            return null;

        return new User.Builder().setUserId(userId)
                .setName(name)
                .setAddress(address)
                .setContactNumber(contactNumber)
                .build();

        }
}
