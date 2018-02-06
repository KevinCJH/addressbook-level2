package seedu.addressbook.data.person;

/**
 * Represents a Person's address block number in the address book.
 */
public class Block {

    public final String blockNumber;

    public Block(String blockNumber){
        this.blockNumber = blockNumber;
    }

    @Override
    public String toString() {
        return blockNumber;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Block // instanceof handles nulls
                && this.blockNumber.equals(((Block) other).blockNumber)); // state check
    }

    @Override
    public int hashCode() {
        return blockNumber.hashCode();
    }

}
