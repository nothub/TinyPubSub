package cc.neckbeard.tinyeventbus;

import java.lang.reflect.Field;

public interface AccessProbe {
    boolean accessible(Field field);
}
