package ph.edu.dlsu.lbycpob.circuit;

import ph.edu.dlsu.lbycpob.core.LogicComponent;
import ph.edu.dlsu.lbycpob.io.InputPin;
import ph.edu.dlsu.lbycpob.io.OutputProbe;

import java.util.ArrayList;
import java.util.List;

public final class TruthTableRunner {

    private TruthTableRunner() {
        // Utility class - no instantiation
    }

    public static void run(Circuit circuit) {

        List<InputPin> pins = new ArrayList<>();
        List<OutputProbe> probes = new ArrayList<>();

        for (LogicComponent component : circuit.getComponents()) {

            if (component instanceof InputPin inputPin) {
                pins.add(inputPin);
            }

            if (component instanceof OutputProbe outputProbe) {
                probes.add(outputProbe);
            }
        }

        if (pins.isEmpty()) {
            System.out.println(
                    "No InputPin instances found in circuit '"
                            + circuit.getName() + "'."
            );
            return;
        }

        int combinations = 1 << pins.size();

        System.out.println();
        System.out.println("=== Truth Table: " + circuit.getName() + " ===");

        for (int row = 0; row < combinations; row++) {

            for (int i = 0; i < pins.size(); i++) {
                boolean value = ((row >> (pins.size() - 1 - i)) & 1) == 1;
                pins.get(i).setValue(value);
            }

            evaluateSilently(circuit);

            System.out.print("Inputs: ");

            for (InputPin pin : pins) {
                System.out.print(
                        pin.getName()
                                + "="
                                + (pin.getOutput().read() ? "1" : "0")
                                + " "
                );
            }

            System.out.print("| Outputs: ");

            for (OutputProbe probe : probes) {
                System.out.print(
                        probe.getName()
                                + "="
                                + getProbeValue(probe)
                                + " "
                );
            }

            System.out.println();
        }

        System.out.println();
    }

    private static String getProbeValue(OutputProbe probe) {

        return probe.getMonitored().read() ? "1" : "0";
    }

    private static void evaluateSilently(Circuit circuit) {

        java.io.PrintStream originalOut = System.out;

        try {
            System.setOut(new java.io.PrintStream(
                    new java.io.OutputStream() {
                        @Override
                        public void write(int b) {
                            // Discard output
                        }
                    }
            ));

            for (LogicComponent component : circuit.getComponents()) {
                component.evaluate();
            }

        } finally {
            System.setOut(originalOut);
        }
    }
}