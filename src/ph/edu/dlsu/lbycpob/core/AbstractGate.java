package ph.edu.dlsu.lbycpob.core;

import ph.edu.dlsu.lbycpob.circuit.Wire;

/**
 * Base class for all binary (two-input) logic gates.
 */
public abstract class AbstractGate implements Driveable {

    private final String name;
    private final Wire inputA;
    private final Wire inputB;
    private final Wire output;

    protected AbstractGate(String name, Wire inputA, Wire inputB, Wire output) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Gate name must not be blank.");
        }

        if (inputA == null || inputB == null || output == null) {
            throw new IllegalArgumentException("Gate wires must not be null.");
        }

        this.name = name;
        this.inputA = inputA;
        this.inputB = inputB;
        this.output = output;
    }

    /**
     * Performs the common evaluation process for every binary gate.
     */
    @Override
    public final void evaluate() {
        boolean a = inputA.read();
        boolean b = inputB.read();

        boolean result = computeOutput(a, b);

        output.drive(result);
    }

    /**
     * Defines the Boolean operation performed by the concrete gate.
     */
    protected abstract boolean computeOutput(boolean a, boolean b);

    @Override
    public final String getName() {
        return name;
    }

    @Override
    public final Wire getOutput() {
        return output;
    }

    protected Wire getInputA() {
        return inputA;
    }

    protected Wire getInputB() {
        return inputB;
    }
}