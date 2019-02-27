package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;
import static seedu.address.logic.parser.CliSyntax.PREFIX_COORDINATE;

import seedu.address.logic.CommandHistory;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.battleship.Battleship;

/**
 * Adds a battleship to the address book.
 */
public class PutCommand extends Command {

    public static final String COMMAND_WORD = "put";
    public static final String COMMAND_ALIAS = "p";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Puts a battleship on the map. "
            + "Parameters: "
            + PREFIX_COORDINATE + "COORDINATE "
            + "\n"
            + "Example: " + COMMAND_WORD + " "
            + PREFIX_COORDINATE + "a1 ";

    public static final String MESSAGE_SUCCESS = "Battleship put: %1$s";
    public static final String MESSAGE_DUPLICATE_PERSON = "There is already a battleship at the coordinate";

    private final Battleship toAdd;

    /**
     * Creates an AddCommand to add the specified {@code Battleship}
     */
    public PutCommand(Battleship battleship) {
        requireNonNull(battleship);
        toAdd = battleship;
    }

    @Override
    public CommandResult execute(Model model, CommandHistory history) throws CommandException {
        /*
        requireNonNull(model);
        if (model.hasPerson(toAdd)) {
            throw new CommandException(MESSAGE_DUPLICATE_PERSON);
        }

        model.addPerson(toAdd);
        model.commitAddressBook();
        return new CommandResult(String.format(MESSAGE_SUCCESS, toAdd));
        */
        return new CommandResult(String.format(MESSAGE_SUCCESS, toAdd));
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof PutCommand // instanceof handles nulls
                && toAdd.equals(((PutCommand) other).toAdd));
    }
}
