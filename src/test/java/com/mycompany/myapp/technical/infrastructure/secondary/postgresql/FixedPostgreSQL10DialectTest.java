package com.mycompany.myapp.technical.infrastructure.secondary.postgresql;

import static org.assertj.core.api.Assertions.assertThat;

import java.sql.Types;
import java.util.LinkedHashMap;
import java.util.Map;
import org.hibernate.type.descriptor.sql.BinaryTypeDescriptor;
import org.hibernate.type.descriptor.sql.BlobTypeDescriptor;
import org.hibernate.type.descriptor.sql.BooleanTypeDescriptor;
import org.hibernate.type.descriptor.sql.SqlTypeDescriptor;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import com.mycompany.myapp.UnitTest;

@UnitTest
class FixedPostgreSQL10DialectTest {

  private final Map<Integer, String> registered = new LinkedHashMap<>();

  private FixedPostgreSQL10Dialect dialect;

  @BeforeEach
  void setup() {
    dialect =
      new FixedPostgreSQL10Dialect() {
        @Override
        protected void registerColumnType(int code, String name) {
          registered.put(code, name);
          super.registerColumnType(code, name);
        }
      };
  }

  @AfterEach
  void teardown() {
    registered.clear();
  }

  @Test
  void testBlobTypeRegister() {
    assertThat(registered.get(Types.BLOB)).contains("bytea");
  }

  @Test
  void testBlobTypeRemap() {
    SqlTypeDescriptor descriptor = dialect.remapSqlTypeDescriptor(BlobTypeDescriptor.DEFAULT);
    assertThat(descriptor).isEqualTo(BinaryTypeDescriptor.INSTANCE);
  }

  @Test
  void testOtherTypeRemap() {
    SqlTypeDescriptor descriptor = dialect.remapSqlTypeDescriptor(BooleanTypeDescriptor.INSTANCE);
    assertThat(descriptor).isEqualTo(BooleanTypeDescriptor.INSTANCE);
  }
}
