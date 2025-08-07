/**
 * Copyright 2024 (c) All rights by Robert Bosch GmbH. We reserve all rights of disposal such as
 * copying and passing on to third parties.
 *
 * @author: PMA4HC
 * @since: 26/Mar/2024
 */

package com.example.springdemo.controller;

import com.example.springdemo.model.Todo;
import com.example.springdemo.repository.TodoRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/sql")
@Profile({"sql", "h2"})
@RequiredArgsConstructor
public class SqlController {

  private final TodoRepository todoRepository;

  @GetMapping("/check")
  @ResponseBody
  public String check(){
    return "SQL profile is enabled";
  }

  @GetMapping("/insert")
  @ResponseBody
  public Todo insert(){
    Todo entity = new Todo();
    entity.setDescription("Test Todo");
    todoRepository.save(entity);
    return entity;
  }

  @GetMapping("/get")
  @ResponseBody
  public Iterable<Todo> get(){
    return todoRepository.findAll();
  }
}
