package ph.edu.dlsu.lbycpob.circuit;

/**
 * Models a physical wire in a digital circuit.
 *
 * A Wire carries a single boolean signal from a source (driver)
 * to one or more destinations (readers).
 */
public final class Wire {

    private final String name;
    private boolean signal;

    public Wire(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Wire name must not be blank.");
        }

        this.name = name;
        this.signal = false;
    }

    public String getName() {
        return name;
    }

    public boolean read() {
        return signal;
    }

    public void drive(boolean value) {
        this.signal = value;
    }

    @Override
    public String toString() {
        return name + "=" + (signal ? "1" : "0");
    }
}