package br.com.infnet.CrudAlunoDevops.service;

import org.springframework.stereotype.Service;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;

@Service
public class MyService {

    private final MeterRegistry registry;
    private final Counter myCounter;

    public MyService(MeterRegistry registry) {
        this.registry = registry;
        this.myCounter = Counter.builder("my_counter")
                                .description("My Counter")
                                .register(registry);
    }

    public void doSomething() {
        // Increment the counter
        myCounter.increment();
    }
}

