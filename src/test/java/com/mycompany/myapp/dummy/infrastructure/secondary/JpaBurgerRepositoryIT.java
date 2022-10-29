package com.mycompany.myapp.dummy.infrastructure.secondary;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import com.mycompany.myapp.IntegrationTest;
import java.util.List;
import java.util.UUID;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

@IntegrationTest
class JpaBurgerRepositoryIT {

  @Autowired
  private JpaBurgerRepository jpaBurgerRepository;

  @Test
  @Transactional
  void shouldFindAll() {
    UUID uuid = UUID.randomUUID();
    BurgerEntity entity = new BurgerEntity();
    entity.setId(uuid);
    entity.setName("name");
    entity.setFile(new byte[1]);
    jpaBurgerRepository.save(entity);

    List<BurgerEntity> result = jpaBurgerRepository.findAll();

    assertThat(result).hasSize(1);
  }
}
