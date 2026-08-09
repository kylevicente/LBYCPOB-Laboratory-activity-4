package ph.edu.dlsu.lbycpob.gates;

import ph.edu.dlsu.lbycpob.circuit.Wire;
import ph.edu.dlsu.lbycpob.core.AbstractGate;

public final class ANDGate extends AbstractGate {

    public ANDGate(Wire inputA, Wire inputB, Wire output) {
        super("AND", inputA, inputB, output);
    }

    @Override
    protected boolean computeOutput(boolean a, boolean b) {
        return a && b;
    }
}