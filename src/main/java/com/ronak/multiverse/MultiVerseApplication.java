package com.ronak.multiverse;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Main Application class
 * Enabling JPA Repos by this annotation
 */
@SpringBootApplication
@EnableJpaRepositories
public class MultiVerseApplication {
  public static void main(final String[] args) {
    SpringApplication.run(MultiVerseApplication.class, args);
  }
}
