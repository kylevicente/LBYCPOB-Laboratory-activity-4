package ph.edu.dlsu.lbycpob.gates;

import ph.edu.dlsu.lbycpob.circuit.Wire;
import ph.edu.dlsu.lbycpob.core.AbstractUnaryGate;

public final class NOTGate extends AbstractUnaryGate {

    public NOTGate(Wire input, Wire output) {
        super("NOT", input, output);
    }

    @Override
    protected boolean computeOutput(boolean a) {
        return !a;
    }
}