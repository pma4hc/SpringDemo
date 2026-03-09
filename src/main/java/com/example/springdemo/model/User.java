/**
 * Copyright 2025 (c) All rights by Robert Bosch GmbH. We reserve all rights of disposal such as
 * copying and passing on to third parties.
 *
 * @author: PMA4HC
 * @since: 28/Jul/2025
 */

package com.example.springdemo.model;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import org.springframework.context.annotation.Profile;

@Entity
@Profile({"sql", "h2"})
@Data
@Table(name = "todo")
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String description;

  private String details;

  private boolean done;

}