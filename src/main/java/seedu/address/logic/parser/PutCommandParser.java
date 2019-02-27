package seedu.address.logic.parser;

import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.parser.CliSyntax.PREFIX_COORDINATE;
import static seedu.address.logic.parser.CliSyntax.PREFIX_NAME;

import java.util.stream.Stream;
import seedu.address.logic.commands.PutCommand;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.battleship.Battleship;
import seedu.address.model.person.Name;

/**
 * Parses input arguments and creates a new PutCommand object
 */
public class PutCommandParser implements Parser<PutCommand> {

    /**
     * Parses the given {@code String} of arguments in the context of the AddCommand
     * and returns an AddCommand object for execution.
     * @throws ParseException if the user input does not conform the expected format
     */
    public PutCommand parse(String args) throws ParseException {
        ArgumentMultimap argMultimap =
                ArgumentTokenizer.tokenize(args, PREFIX_COORDINATE);

        if (!arePrefixesPresent(argMultimap, PREFIX_COORDINATE)
                || !argMultimap.getPreamble().isEmpty()) {
            throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT, PutCommand.MESSAGE_USAGE));
        }


        Name name = ParserUtil.parseName(argMultimap.getValue(PREFIX_NAME).get());
        Battleship battleship = new Battleship(name, 2, 1);

        return new PutCommand(battleship);
    }

    /**
     * Returns true if none of the prefixes contains empty {@code Optional} values in the given
     * {@code ArgumentMultimap}.
     */
    private static boolean arePrefixesPresent(ArgumentMultimap argumentMultimap, Prefix... prefixes) {
        return Stream.of(prefixes).allMatch(prefix -> argumentMultimap.getValue(prefix).isPresent());
    }

}
