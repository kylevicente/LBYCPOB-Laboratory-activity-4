package ph.edu.dlsu.lbycpob.circuit;

import ph.edu.dlsu.lbycpob.core.LogicComponent;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class Circuit {

    private final String name;
    private final List<LogicComponent> components;

    public Circuit(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException(
                    "Circuit name must not be blank."
            );
        }

        this.name = name;
        this.components = new ArrayList<>();
    }

    public Circuit add(LogicComponent component) {
        if (component == null) {
            throw new IllegalArgumentException(
                    "Circuit component must not be null."
            );
        }

        components.add(component);
        return this;
    }

    public void evaluate() {
        System.out.println("=== Circuit: " + name + " ===");

        for (LogicComponent component : components) {
            component.evaluate();
        }

        System.out.println();
    }

    public String getName() {
        return name;
    }

    public List<LogicComponent> getComponents() {
        return Collections.unmodifiableList(components);
    }
}