package ph.edu.dlsu.lbycpob.gates;

import ph.edu.dlsu.lbycpob.circuit.Wire;
import ph.edu.dlsu.lbycpob.core.AbstractGate;

public final class XNORGate extends AbstractGate {

    public XNORGate(Wire inputA, Wire inputB, Wire output) {
        super("XNOR", inputA, inputB, output);
    }

    @Override
    protected boolean computeOutput(boolean a, boolean b) {
        return !(a ^ b);
    }
}