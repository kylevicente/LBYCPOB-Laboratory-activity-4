package ph.edu.dlsu.lbycpob.gates;

import ph.edu.dlsu.lbycpob.circuit.Wire;
import ph.edu.dlsu.lbycpob.core.AbstractGate;

public final class ORGate extends AbstractGate {

    public ORGate(Wire inputA, Wire inputB, Wire output) {
        super("OR", inputA, inputB, output);
    }

    @Override
    protected boolean computeOutput(boolean a, boolean b) {
        return a || b;
    }
}