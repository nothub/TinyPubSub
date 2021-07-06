package cc.neckbeard.tinyeventbus;

import java.lang.reflect.Field;

public class Jdk8Probe implements AccessProbe {
    @Override
    public boolean accessible(Field field) {
        return field.isAccessible();
    }
}
