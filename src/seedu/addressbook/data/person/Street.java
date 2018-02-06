package seedu.addressbook.data.person;

/**
 * Represents a Person's address street name in the address book.
 */
public class Street {

    public final String streetName;

    public Street(String streetName){
        this.streetName = streetName;
    }

    @Override
    public String toString() {
        return streetName;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Street // instanceof handles nulls
                && this.streetName.equals(((Street) other).streetName)); // state check
    }

    @Override
    public int hashCode() {
        return streetName.hashCode();
    }

}
