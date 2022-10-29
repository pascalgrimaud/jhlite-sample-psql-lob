package com.mycompany.myapp.dummy.infrastructure.secondary;

import static org.assertj.core.api.Assertions.*;

import com.mycompany.myapp.UnitTest;
import java.util.UUID;
import org.junit.jupiter.api.Test;

@UnitTest
class BurgerEntityTest {

  @Test
  void shouldBuild() {
    UUID uuid = UUID.randomUUID();
    BurgerEntity entity = new BurgerEntity();
    entity.setId(uuid);
    entity.setName("name");
    entity.setFile(new byte[0]);

    assertThat(entity.getId()).isEqualTo(uuid);
    assertThat(entity.getName()).isEqualTo("name");
    assertThat(entity.getFile()).isNotNull();
  }
}
