package ph.edu.dlsu.lbycpob.core;

import ph.edu.dlsu.lbycpob.circuit.Wire;

/**
 * Base class for all unary (single-input) logic gates.
 */
public abstract class AbstractUnaryGate implements Driveable {

    private final String name;
    private final Wire input;
    private final Wire output;

    protected AbstractUnaryGate(String name, Wire input, Wire output) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Gate name must not be blank.");
        }

        if (input == null || output == null) {
            throw new IllegalArgumentException("Gate wires must not be null.");
        }

        this.name = name;
        this.input = input;
        this.output = output;
    }

    @Override
    public final void evaluate() {
        boolean value = input.read();

        boolean result = computeOutput(value);

        output.drive(result);
    }

    protected abstract boolean computeOutput(boolean a);

    @Override
    public final String getName() {
        return name;
    }

    @Override
    public final Wire getOutput() {
        return output;
    }

    protected Wire getInput() {
        return input;
    }
}