package ph.edu.dlsu.lbycpob.gates;

import ph.edu.dlsu.lbycpob.circuit.Wire;
import ph.edu.dlsu.lbycpob.core.AbstractGate;

public final class XORGate extends AbstractGate {

    public XORGate(Wire inputA, Wire inputB, Wire output) {
        super("XOR", inputA, inputB, output);
    }

    @Override
    protected boolean computeOutput(boolean a, boolean b) {
        return a ^ b;
    }
}