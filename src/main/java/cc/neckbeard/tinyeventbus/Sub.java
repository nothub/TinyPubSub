package cc.neckbeard.tinyeventbus;

import net.jodah.typetools.TypeResolver;
import org.jetbrains.annotations.NotNull;

import java.util.function.Consumer;

public class Sub<T> implements Comparable<Sub<T>> {

    public final int prio;
    public final Class<?> type;
    public final Consumer<T> consumer;

    public Sub(Consumer<T> consumer, int prio) {
        this.prio = prio;
        this.type = TypeResolver.resolveRawArguments(Consumer.class, consumer.getClass())[0];
        this.consumer = consumer;
    }

    public Sub(int prio, Consumer<T> consumer) {
        this(consumer, prio);
    }

    public Sub(Consumer<T> consumer) {
        this(consumer, 0);
    }

    public static <T> Sub<T> of(Consumer<T> consumer, int prio) {
        return new Sub<>(consumer, prio);
    }

    public static <T> Sub<T> of(int prio, Consumer<T> consumer) {
        return new Sub<>(consumer, prio);
    }

    public static <T> Sub<T> of(Consumer<T> consumer) {
        return new Sub<>(consumer);
    }

    public void accept(Object o) {
        //noinspection unchecked
        consumer.accept((T) o);
    }

    @Override
    public int compareTo(@NotNull Sub<T> sub) {
        if (sub.prio != prio) {
            return Integer.compare(sub.prio, prio);
        }
        if (sub.consumer.hashCode() != consumer.hashCode()) {
            return Integer.compare(sub.consumer.hashCode(), consumer.hashCode());
        }
        return Integer.compare(sub.hashCode(), hashCode());
    }

}
