package seedu.addressbook.data.person;

/**
 * Represents a Person's address postal code in the address book.
 */
public class PostalCode {

    public final String postalCode;

    public PostalCode(String postalCode){
        this.postalCode = postalCode;
    }

    @Override
    public String toString() {
        return postalCode;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof PostalCode // instanceof handles nulls
                && this.postalCode.equals(((PostalCode) other).postalCode)); // state check
    }

    @Override
    public int hashCode() {
        return postalCode.hashCode();
    }

}
