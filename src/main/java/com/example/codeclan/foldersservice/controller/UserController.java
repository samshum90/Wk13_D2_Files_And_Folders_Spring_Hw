package com.example.codeclan.foldersservice.controller;

import com.example.codeclan.foldersservice.models.Folder;
import com.example.codeclan.foldersservice.models.User;
import com.example.codeclan.foldersservice.repository.FolderRepository;
import com.example.codeclan.foldersservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserRepository userRepository;

    @GetMapping(value = "/users")
    public ResponseEntity<List<User>> getAllFolders(){
        List<User> foundUsers = userRepository.findAll();
        return new ResponseEntity<List<User>>(foundUsers, HttpStatus.OK);
    }

    @GetMapping(value = "/users/{id}")
    public ResponseEntity getUser(@PathVariable Long id){
        return new ResponseEntity<>(userRepository.findById(id), HttpStatus.OK);
    }
}
