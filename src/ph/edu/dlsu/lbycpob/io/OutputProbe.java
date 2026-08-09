package ph.edu.dlsu.lbycpob.io;

import ph.edu.dlsu.lbycpob.circuit.Wire;
import ph.edu.dlsu.lbycpob.core.LogicComponent;

public final class OutputProbe implements LogicComponent {

    private final String name;
    private final Wire monitored;

    public OutputProbe(String name, Wire monitored) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("OutputProbe name must not be blank.");
        }

        if (monitored == null) {
            throw new IllegalArgumentException("Monitored wire must not be null.");
        }

        this.name = name;
        this.monitored = monitored;
    }

    @Override
    public void evaluate() {
        System.out.println(
                "OutputProbe [" + name + "] " + monitored
        );
    }

    @Override
    public String getName() {
        return name;
    }

    public Wire getMonitored() {
        return monitored;
    }
}