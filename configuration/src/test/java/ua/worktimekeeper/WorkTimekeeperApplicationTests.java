package ua.worktimekeeper;

import org.jooq.DSLContext;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class WorkTimekeeperApplicationTests {

    @Autowired
    DSLContext dsl;

    @Test
    void testTest() {
    }

}
