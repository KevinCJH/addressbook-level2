package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;
import java.io.*;

/**
 * Represents a Person's address in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValidAddress(String)}
 */
public class Address {

    public static final String EXAMPLE = "123, some street, #11-11, 123456";
    public static final String MESSAGE_ADDRESS_CONSTRAINTS = "Person addresses must be in this format: Block, Street, Unit, Postal Code";
    public static final String ADDRESS_VALIDATION_REGEX = ".+";
    public static final int BLOCK_NUMBER = 0;
    public static final int STREET_NAME = 1;
    public static final int UNIT_NUMBER = 2;
    public static final int POSTAL_CODE = 3;

    private final Block blockNumber;
    private final Street streetName;
    private final Unit unitNumber;
    private final PostalCode postalCode;
    private boolean isPrivate;

    /**
     * Validates given address.
     *
     * @throws IllegalValueException if given address string is invalid.
     */
    public Address(String address, boolean isPrivate) throws IllegalValueException {
        String trimmedAddress = address.trim();
        this.isPrivate = isPrivate;
        if (!isValidAddress(trimmedAddress)) {
            throw new IllegalValueException(MESSAGE_ADDRESS_CONSTRAINTS);
        }

        String[] trimmedAddressParts = trimmedAddress.split(", ");
        blockNumber = new Block(trimmedAddressParts[BLOCK_NUMBER].replace("a/", "")); //Remove the '/a' from block number
        streetName = new Street(trimmedAddressParts[STREET_NAME]);
        unitNumber = new Unit(trimmedAddressParts[UNIT_NUMBER]);
        postalCode = new PostalCode(trimmedAddressParts[POSTAL_CODE]);

    }

    /**
     * Returns true if a given string is a valid person address.
     */
    public static boolean isValidAddress(String test) {
        return test.matches(ADDRESS_VALIDATION_REGEX);
    }

    @Override
    public String toString() {
        return blockNumber.toString() + ", " + streetName.toString() + ", "
                + unitNumber.toString() + ", " + postalCode.toString();
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Address // instanceof handles nulls
                && this.toString().equals(((Address) other).toString())); // state check
    }

    @Override
    public int hashCode() {
        return this.toString().hashCode();
    }

    public boolean isPrivate() {
        return isPrivate;
    }
}
