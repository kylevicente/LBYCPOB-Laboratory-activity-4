package ph.edu.dlsu.lbycpob.core;

import ph.edu.dlsu.lbycpob.circuit.Wire;

public interface Driveable extends LogicComponent {
    Wire getOutput();
}