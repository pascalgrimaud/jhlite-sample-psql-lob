package com.mycompany.myapp;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.springframework.security.test.context.support.WithMockUser;
import com.mycompany.myapp.authentication.infrastructure.primary.TestSecurityConfiguration;
import org.springframework.boot.test.context.SpringBootTest;

@WithMockUser
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@DisplayNameGeneration(ReplaceCamelCase.class)
@SpringBootTest(classes = { JhipsterSampleApplicationApp.class, TestSecurityConfiguration.class })
public @interface IntegrationTest {
  public String[] properties() default {};
}
