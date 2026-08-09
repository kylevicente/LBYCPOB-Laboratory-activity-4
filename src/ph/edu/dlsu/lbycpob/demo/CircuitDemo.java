package ph.edu.dlsu.lbycpob.demo;

import ph.edu.dlsu.lbycpob.circuit.Circuit;
import ph.edu.dlsu.lbycpob.circuit.TruthTableRunner;
import ph.edu.dlsu.lbycpob.circuit.Wire;
import ph.edu.dlsu.lbycpob.gates.*;
import ph.edu.dlsu.lbycpob.io.InputPin;
import ph.edu.dlsu.lbycpob.io.OutputProbe;

public class CircuitDemo {

    public static void main(String[] args) {

        singleGateDemo();

        halfAdderDemo();
    }

    private static void singleGateDemo() {

        System.out.println("================================");
        System.out.println("       SINGLE GATE DEMO");
        System.out.println("================================");

        Wire inputA = new Wire("A");
        Wire inputB = new Wire("B");

        Wire andOutput = new Wire("AND_OUT");
        Wire orOutput = new Wire("OR_OUT");
        Wire xorOutput = new Wire("XOR_OUT");
        Wire nandOutput = new Wire("NAND_OUT");
        Wire norOutput = new Wire("NOR_OUT");
        Wire xnorOutput = new Wire("XNOR_OUT");

        InputPin pinA = new InputPin("A", inputA);
        InputPin pinB = new InputPin("B", inputB);

        Circuit circuit = new Circuit("Logic Gates");

        circuit
                .add(pinA)
                .add(pinB)
                .add(new ANDGate(inputA, inputB, andOutput))
                .add(new ORGate(inputA, inputB, orOutput))
                .add(new XORGate(inputA, inputB, xorOutput))
                .add(new NANDGate(inputA, inputB, nandOutput))
                .add(new NORGate(inputA, inputB, norOutput))
                .add(new XNORGate(inputA, inputB, xnorOutput))
                .add(new OutputProbe("AND", andOutput))
                .add(new OutputProbe("OR", orOutput))
                .add(new OutputProbe("XOR", xorOutput))
                .add(new OutputProbe("NAND", nandOutput))
                .add(new OutputProbe("NOR", norOutput))
                .add(new OutputProbe("XNOR", xnorOutput));

        pinA.setValue(false);
        pinB.setValue(false);

        System.out.println("\nA=0, B=0");
        circuit.evaluate();

        pinA.setValue(false);
        pinB.setValue(true);

        System.out.println("\nA=0, B=1");
        circuit.evaluate();

        pinA.setValue(true);
        pinB.setValue(false);

        System.out.println("\nA=1, B=0");
        circuit.evaluate();

        pinA.setValue(true);
        pinB.setValue(true);

        System.out.println("\nA=1, B=1");
        circuit.evaluate();

        System.out.println("\nTruth Table:");
        TruthTableRunner.run(circuit);

        notGateDemo();
    }

    private static void notGateDemo() {

        System.out.println("================================");
        System.out.println("          NOT GATE DEMO");
        System.out.println("================================");

        Wire input = new Wire("NOT_INPUT");
        Wire output = new Wire("NOT_OUTPUT");

        InputPin pin = new InputPin("A", input);

        Circuit circuit = new Circuit("NOT Gate");

        circuit
                .add(pin)
                .add(new NOTGate(input, output))
                .add(new OutputProbe("NOT", output));

        pin.setValue(false);

        System.out.println("\nA=0");
        circuit.evaluate();

        pin.setValue(true);

        System.out.println("\nA=1");
        circuit.evaluate();

        System.out.println();
    }

    private static void halfAdderDemo() {

        System.out.println("================================");
        System.out.println("          HALF ADDER");
        System.out.println("================================");

        Wire wireA = new Wire("A");
        Wire wireB = new Wire("B");

        Wire sum = new Wire("SUM");
        Wire carry = new Wire("CARRY");

        InputPin pinA = new InputPin("A", wireA);
        InputPin pinB = new InputPin("B", wireB);

        Circuit halfAdder = new Circuit("Half Adder");

        halfAdder
                .add(pinA)
                .add(pinB)
                .add(new XORGate(wireA, wireB, sum))
                .add(new ANDGate(wireA, wireB, carry))
                .add(new OutputProbe("SUM", sum))
                .add(new OutputProbe("CARRY", carry));

        pinA.setValue(true);
        pinB.setValue(true);

        System.out.println("Testing A=1, B=1:");
        halfAdder.evaluate();

        System.out.println("Expected: SUM=0, CARRY=1");

        System.out.println("\nHalf Adder Truth Table:");
        TruthTableRunner.run(halfAdder);
    }
}