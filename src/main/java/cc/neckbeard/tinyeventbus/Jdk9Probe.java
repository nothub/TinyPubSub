package cc.neckbeard.tinyeventbus;

import java.lang.reflect.Field;

public class Jdk9Probe implements AccessProbe {
    @Override
    public boolean accessible(Field field) {
        return field.canAccess(Bus.class);
    }
}
