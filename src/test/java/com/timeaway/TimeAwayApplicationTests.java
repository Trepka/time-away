package com.timeaway;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.PostgreSQLContainer;

@SpringBootTest
class TimeAwayApplicationTests {
  // Just a testcontainers example
  private static final PostgreSQLContainer<?> pg = new PostgreSQLContainer<>("postgres:11")
    .withDatabaseName("test")
    .withUsername("user")
    .withPassword("pass")
    .withExposedPorts(5432);

  static {
    pg.start();
  }

  @DynamicPropertySource
  static void registerPgProperties(DynamicPropertyRegistry registry) {
    registry.add("spring.datasource.url",
      () -> String.format("jdbc:postgresql://localhost:%d/prop", pg.getMappedPort(5432)));
    registry.add("spring.datasource.username", pg::getUsername);
    registry.add("spring.datasource.password", pg::getPassword);
  }

  @Test
  void contextLoads() {
  }

}
