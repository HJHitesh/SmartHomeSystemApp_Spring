package com.hitesh.smartHomeAutomationSystem.repository;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hitesh.smartHomeAutomationSystem.model.User;

import org.springframework.stereotype.Repository;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Repository
public class UserRepository {
    private final String FILE_PATH = "src/main/resources/persistence/users.json";
    private final ObjectMapper objectMapper = new ObjectMapper();

    public List<User> findAll() {
        try {
            return objectMapper.readValue(new File(FILE_PATH), new TypeReference<List<User>>() {});
        } catch (IOException e) {
            throw new RuntimeException("Error reading users.json", e);
        }
    }

    public Optional<User> findById(String id) {
        return findAll().stream().filter(user -> user.getId().equals(id)).findFirst();
    }

    public void save(User user) {
        List<User> users = findAll();
        users.removeIf(u -> u.getId().equals(user.getId()));
        users.add(user);
        writeToFile(users);
    }

    private void writeToFile(List<User> users) {
        try {
            objectMapper.writeValue(new File(FILE_PATH), users);
        } catch (IOException e) {
            throw new RuntimeException("Error writing to users.json", e);
        }
    }
}

