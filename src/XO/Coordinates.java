package XO;

/**
 * @author Nir Hazan 316009489 , May Seter 312123037
 * Record class Coordinates serves as "data carrier" for coordinates of game board cells.
 * A record class declares a sequence of fields, and then the appropriate accessors,
 * constructors, equals, hashCode, and toString methods are created automatically (Oracle).
 * @param row cell's row number.
 * @param col cell's column number.
 */
public record Coordinates(int row, int col) {}
