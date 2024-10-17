package toni.aguilera.inditex.infraestructure;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootTest
public class HelloWorldTest extends IntegrationTestBase {
    @Autowired
    private JdbcTemplate jdbcTemplate;


    @Test
    public void testDatabaseIsRunning() {
        Integer count = jdbcTemplate.queryForObject("SELECT COUNT(*) FROM prices WHERE PRICE_LIST = 3", Integer.class);
        Assertions.assertEquals(1, count);
    }
}
