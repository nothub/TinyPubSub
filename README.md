#### TinyEventBus

[![maven central](https://maven-badges.herokuapp.com/maven-central/cc.neckbeard/TinyEventBus/badge.svg)](https://maven-badges.herokuapp.com/maven-central/cc.neckbeard/TinyEventBus)

A tiny and fast pubsub implementation with subscriber priorities and event canceling for Java 8 and 11.

---

###### use

```java
void run() {
    Bus bus=new Bus();
    bus.reg(Sub.of(System.out::println));
    bus.pub("Hello World!");
}
```

```java
class Listenable {
    Sub<Long> sub = Sub.of(l -> ThreadLocalRandom.current().setSeed(l));
    void run() {
        Bus bus = new Bus();
        bus.reg(this);
        bus.pub(42L);
    }
}
```

[example](https://github.com/nothub/TinyEventBus/blob/master/src/test/java/cc/neckbeard/tinyeventbus/example/Example.java)
