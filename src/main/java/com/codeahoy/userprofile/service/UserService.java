package com.codeahoy.userprofile.service;

import com.codeahoy.userprofile.model.User;
import io.unlaunch.UnlaunchClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UnlaunchClient unlaunchClient;

    public User getUserById(String id) {

        // Evaluate the feature flag
        String variation = unlaunchClient.getVariation("implement-async-calls", id);

        if (variation.equals("on")) {
            // Call the New algorithm if the flag returns: on
            return newAlgorithm(id);
        } else {
            // Call the Old algorithm if flag returns: off
            return oldAlgorithm(id);
        }
    }

    /**
     * Old algorithm
     * @return user
     */
    private User oldAlgorithm(String id) {
        User user = new User();
        user.setName(id);
        user.setDebugReason("old algorithm");
        return user;
    }

    /**
     * New method
     * @return user
     */
    private User newAlgorithm(String id) {
        User user = new User();
        user.setName(id);
        user.setDebugReason("NEW algorithm");
        return user;
    }

}
