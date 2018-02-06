package seedu.addressbook.data.person;

/**
 * Represents a Person's address unit number in the address book.
 */
public class Unit {

    public final String unitNumber;

    public Unit(String unitNumber){
        this.unitNumber = unitNumber;
    }

    @Override
    public String toString() {
        return unitNumber;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Unit // instanceof handles nulls
                && this.unitNumber.equals(((Unit) other).unitNumber)); // state check
    }

    @Override
    public int hashCode() {
        return unitNumber.hashCode();
    }

}
