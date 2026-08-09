package ph.edu.dlsu.lbycpob.io;

import ph.edu.dlsu.lbycpob.circuit.Wire;
import ph.edu.dlsu.lbycpob.core.Driveable;

public final class InputPin implements Driveable {

    private final String name;
    private final Wire output;
    private boolean value;

    public InputPin(String name, Wire output) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("InputPin name must not be blank.");
        }

        if (output == null) {
            throw new IllegalArgumentException("Output wire must not be null.");
        }

        this.name = name;
        this.output = output;
        this.value = false;
    }

    public void setValue(boolean value) {
        this.value = value;
    }

    @Override
    public void evaluate() {
        output.drive(value);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Wire getOutput() {
        return output;
    }

    @Override
    public String toString() {
        return String.format(
                "InputPin[%s] value=%d output=%s",
                name,
                value ? 1 : 0,
                output
        );
    }
}