/**
 * Copyright 2025 (c) All rights by Robert Bosch GmbH. We reserve all rights of disposal such as
 * copying and passing on to third parties.
 *
 * @author: PMA4HC
 * @since: 28/Jul/2025
 */

package com.example.springdemo.repository;

import com.example.springdemo.model.User;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Profile({"sql", "h2"})
public interface TodoRepository extends JpaRepository<User, Long> {

}
