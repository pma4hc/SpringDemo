/**
 * Copyright 2024 (c) All rights by Robert Bosch GmbH. We reserve all rights of disposal such as
 * copying and passing on to third parties.
 *
 * @author: PMA4HC
 * @since: 26/Mar/2024
 */

package com.example.springdemo.controller;

import com.example.springdemo.model.User;
import com.example.springdemo.repository.TodoRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Profile;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/users")
@Profile({"sql", "h2"})
@RequiredArgsConstructor
public class UsersController {

  private final TodoRepository todoRepository;

  @PostMapping
  @ResponseBody
  public ResponseEntity<User> insert(User entity){
    User savedUser = todoRepository.save(entity);
    return ResponseEntity.ok(savedUser);
  }

  @DeleteMapping("/{id}")
  @ResponseBody
  public ResponseEntity<String> delete(@PathVariable Long id){
    todoRepository.deleteById(id);
    return ResponseEntity.ok("Success");
  }

  @GetMapping
  @ResponseBody
  public ResponseEntity<Iterable<User>> getAllUsers(){
    List<User> all = todoRepository.findAll();
    return ResponseEntity.ok(all);
  }

  @GetMapping("/{id}")
  @ResponseBody
  public ResponseEntity<User> getUserById(@PathVariable Long id) {
    User user = todoRepository.findById(id).orElse(null);
    return ResponseEntity.ok(user);
  }
}
