package seedu.budgetbaby.logic.parser;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static seedu.budgetbaby.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.budgetbaby.commons.core.Messages.MESSAGE_UNKNOWN_COMMAND;

import seedu.budgetbaby.logic.commands.AddFrCommand;
import seedu.budgetbaby.logic.commands.BudgetBabyCommand;
import seedu.budgetbaby.logic.commands.HelpCommand;
import seedu.budgetbaby.logic.parser.exceptions.ParseException;

/**
 * Parses user input.
 */
public class BudgetBabyParser {

    /**
     * Used for initial separation of command word and args.
     */
    private static final Pattern BASIC_COMMAND_FORMAT = Pattern.compile("(?<commandWord>\\S+)(?<arguments>.*)");

    /**
     * Parses user input into command for execution.
     *
     * @param userInput full user input string
     * @return the command based on the user input
     * @throws ParseException if the user input does not conform the expected format
     */
    public BudgetBabyCommand parseCommand(String userInput) throws ParseException {
        final Matcher matcher = BASIC_COMMAND_FORMAT.matcher(userInput.trim());
        if (!matcher.matches()) {
            throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT, HelpCommand.MESSAGE_USAGE));
        }

        final String commandWord = matcher.group("commandWord");
        final String arguments = matcher.group("arguments");
        switch (commandWord) {

        case AddFrCommand.COMMAND_WORD:
            return new AddFrCommandParser().parse(arguments);

        default:
            throw new ParseException(MESSAGE_UNKNOWN_COMMAND);
        }
    }

}
