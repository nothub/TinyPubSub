package cc.neckbeard.tinyeventbus.tests;

import cc.neckbeard.tinyeventbus.Bus;
import cc.neckbeard.tinyeventbus.Sub;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;

@Execution(ExecutionMode.SAME_THREAD)
class InstanceTests {

    private static Bus bus;
    private static boolean invoked;

    Sub<BooleanEvent> sub = Sub.of(e -> invoked = e.value);

    @BeforeAll
    static void setUp() {
        bus = new Bus();
        invoked = false;
    }

    @Test
    @Order(0)
    void reg() {
        bus.reg(sub);
        bus.pub(new BooleanEvent(true));
        Assertions.assertTrue(invoked);
    }

    @Test
    @Order(1)
    void del() {
        bus.del(sub);
        bus.pub(new BooleanEvent(true));
        Assertions.assertFalse(invoked);
    }

}