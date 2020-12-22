package com.codeahoy.userprofile.controller;

import com.codeahoy.userprofile.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1")
public class UserController {
    @Autowired
    private UserService service;

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @RequestMapping(
            path = "/users/{userId}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public @ResponseBody ResponseEntity<String> getUser(@PathVariable String userId) {
        return new ResponseEntity(service.getUserById(userId), HttpStatus.OK);
    }
}
