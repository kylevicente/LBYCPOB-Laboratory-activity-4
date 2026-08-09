package ph.edu.dlsu.lbycpob.core;

/**
 * Represents a component in a digital logic circuit.
 */
public interface LogicComponent {

    /**
     * Reads the component's inputs (if any), computes an output, and drives
     * that output onto the component's output wire.
     *
     * A component that has no output wire (e.g. an output probe) may use this
     * method purely for its side effects such as printing to the console.
     */
    void evaluate();

    /**
     * Returns a human-readable name for this component used in diagnostic and
     * display output.
     *
     * @return non-null, non-blank component label
     */
    String getName();
}