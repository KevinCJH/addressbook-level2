package seedu.addressbook.data.tag;

import java.util.Objects;

import seedu.addressbook.data.person.Person;

    /**
     * Represents the adding or deleting of a tag for a specific person that happened during a session
     */
    public class Tagging {

        private static final String ADD_TAGGING = "+";
        private static final String DELETE_TAGGING = "-";

        public enum ActionType {
            ADD, DELETE;
        }

        private Person person;
        private Tag tag;
        private ActionType actionType;

        public Tagging(Person person, Tag tag, ActionType actionType) {
            this.person = person;
            this.tag = tag;
            this.actionType = actionType;
        }

        public Person getPerson() {
            return person;
        }

        public Tag getTag() {
            return tag;
        }

        public ActionType getActionType() {
            return actionType;
        }

        @Override
        public boolean equals(Object obj) {
            return obj == this // short circuit if same object
                    || obj instanceof Tagging // instanceof handles null
                    && ((Tagging) obj).getPerson().equals(this.person)
                    && ((Tagging) obj).getTag().equals(this.tag)
                    && ((Tagging) obj).getActionType().equals(this.getActionType());
        }

        @Override
        public int hashCode() {
            return Objects.hash(person, tag, actionType);
        }

        @Override
        public String toString() {
            String actionType;

            if (this.actionType == ActionType.ADD){
                actionType = ADD_TAGGING;
            }else{
                actionType = DELETE_TAGGING;
            }

            return actionType + " " + person.getName() + " [" + tag + "]";
        }
    }

