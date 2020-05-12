package com.example.codeclan.foldersservice.components;

import com.example.codeclan.foldersservice.models.File;
import com.example.codeclan.foldersservice.models.Folder;
import com.example.codeclan.foldersservice.models.User;
import com.example.codeclan.foldersservice.repository.FileRepository;
import com.example.codeclan.foldersservice.repository.FolderRepository;
import com.example.codeclan.foldersservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    private FileRepository fileRepository;

    @Autowired
    private FolderRepository folderRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        fileRepository.deleteAll();
        folderRepository.deleteAll();
        userRepository.deleteAll();

        User jack = new User("Jack");
        userRepository.save(jack);

        User john = new User("John");
        userRepository.save(john);


        Folder day1 = new Folder("day1", jack);
        folderRepository.save(day1);

        Folder week1 = new Folder("Week1",john);
        folderRepository.save(week1);


        File java = new File("Java",".java", 2, day1);
        fileRepository.save(java);

        File javaScript =  new File("Js",".js",5, week1);
        fileRepository.save(javaScript);

        File ruby = new File("ruby",".rb",2, day1);
        fileRepository.save(ruby);

    }
}
