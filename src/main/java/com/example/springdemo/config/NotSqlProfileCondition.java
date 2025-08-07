/**
 * Copyright 2025 (c) All rights by Robert Bosch GmbH. We reserve all rights of disposal such as
 * copying and passing on to third parties.
 *
 * @author: PMA4HC
 * @since: 07/Aug/2025
 */

package com.example.springdemo.config;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

public class NotSqlProfileCondition implements Condition {
  @Override
  public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
    String[] activeProfiles = context.getEnvironment().getActiveProfiles();
    for (String profile : activeProfiles) {
      if ("sql".equalsIgnoreCase(profile) || "h2".equalsIgnoreCase(profile)) {
        return false; // Do NOT exclude if "sql" is active
      }
    }
    return true; // Exclude if "sql" is NOT active
  }
}