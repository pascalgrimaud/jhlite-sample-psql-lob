package com.mycompany.myapp.dummy.infrastructure.secondary;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaBurgerRepository extends JpaRepository<BurgerEntity, UUID> {}
