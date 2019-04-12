package seedu.address.logic.parser;

import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.commons.core.Messages.MESSAGE_UNKNOWN_COMMAND;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import seedu.address.logic.commands.AddAppointmentCommand;
import seedu.address.logic.commands.AddDoctorCommand;
import seedu.address.logic.commands.AddMedHistCommand;
import seedu.address.logic.commands.AddPatientCommand;
import seedu.address.logic.commands.AddPrescriptionCommand;
import seedu.address.logic.commands.ClearCommand;
import seedu.address.logic.commands.Command;
import seedu.address.logic.commands.DeleteDoctorCommand;
import seedu.address.logic.commands.DeletePatientCommand;
import seedu.address.logic.commands.DoctorMatchCommand;
import seedu.address.logic.commands.EditDoctorCommand;
import seedu.address.logic.commands.EditMedHistCommand;
import seedu.address.logic.commands.EditPatientCommand;
import seedu.address.logic.commands.EditPrescriptionCommand;
import seedu.address.logic.commands.ExitCommand;
import seedu.address.logic.commands.HelpCommand;
import seedu.address.logic.commands.HistoryCommand;
import seedu.address.logic.commands.ListAppointmentCommand;
import seedu.address.logic.commands.ListDoctorCommand;
import seedu.address.logic.commands.ListMedHistCommand;
import seedu.address.logic.commands.ListPatientCommand;
import seedu.address.logic.commands.ListPrescriptionCommand;
import seedu.address.logic.commands.MarkAppointmentCommand;
import seedu.address.logic.commands.RedoCommand;
import seedu.address.logic.commands.SearchAdvancedPatientCommand;
import seedu.address.logic.commands.SearchMedHistCommand;
import seedu.address.logic.commands.SearchPatientApptStatusCommand;
import seedu.address.logic.commands.SearchPatientCommand;
import seedu.address.logic.commands.SearchPatientPidCommand;
import seedu.address.logic.commands.SearchPatientTagCommand;
import seedu.address.logic.commands.SearchPrescriptionCommand;
import seedu.address.logic.commands.SelectDoctorCommand;
import seedu.address.logic.commands.SelectMedHistCommand;
import seedu.address.logic.commands.SelectPatientCommand;
import seedu.address.logic.commands.SelectPrescriptionCommand;
import seedu.address.logic.commands.SortMedHistCommand;
import seedu.address.logic.commands.UndoCommand;
import seedu.address.logic.parser.exceptions.ParseException;


/**
 * Parses user input.
 */
public class DocXParser {

    /**
     * Used for initial separation of command word and args.
     */
    private static final Pattern BASIC_COMMAND_FORMAT = Pattern.compile("(?<commandWord>\\S+)(?<arguments>.*)");

    /**
     * Parses user input into command for execution.
     *
     * @param userInput full user input string
     * @return the command based on the user input
     * @throws ParseException if the user input
     *                        does not conform the expected format
     */
    public Command parseCommand(String userInput) throws ParseException {
        final Matcher matcher = BASIC_COMMAND_FORMAT.matcher(userInput.trim());
        if (!matcher.matches()) {
            throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT, HelpCommand.MESSAGE_USAGE));
        }

        final String commandWord = matcher.group("commandWord");
        final String arguments = matcher.group("arguments");
        switch (commandWord) {

        case AddPatientCommand.COMMAND_WORD:
            return new AddPatientCommandParser().parse(arguments);

        case ListPatientCommand.COMMAND_WORD:
            return new ListPatientCommand();

        case EditPatientCommand.COMMAND_WORD:
            return new EditPatientCommandParser().parse(arguments);

        case SearchPatientCommand.COMMAND_WORD:
            return new SearchPatientCommandParser().parse(arguments);

        case SearchPatientPidCommand.COMMAND_WORD:
            return new SearchPatientPidCommandParser().parse(arguments);

        case SearchPatientTagCommand.COMMAND_WORD:
            return new SearchPatientTagCommandParser().parse(arguments);

        case SearchPatientApptStatusCommand.COMMAND_WORD:
            return new SearchPatientApptStatusCommandParser().parse(arguments);

        case SearchAdvancedPatientCommand.COMMAND_WORD:
            return new SearchAdvancedPatientCommandParser().parse(arguments);

        case DeletePatientCommand.COMMAND_WORD:
            return new DeleteCommandParser().parse(arguments);

        case AddDoctorCommand.COMMAND_WORD:
            return new AddDoctorCommandParser().parse(arguments);

        case AddAppointmentCommand.COMMAND_WORD:
            return new AddAppointmentCommandParser().parse(arguments);

        case ListAppointmentCommand.COMMAND_WORD:
            return new ListAppointmentCommandParser().parse(arguments);

        case MarkAppointmentCommand.COMMAND_WORD:
            return new MarkAppointmentCommandParser().parse(arguments);

        case ListDoctorCommand.COMMAND_WORD:
            return new ListDoctorCommandParser().parse(arguments);

        case EditDoctorCommand.COMMAND_WORD:
            return new EditDoctorCommandParser().parse(arguments);

        case DeleteDoctorCommand.COMMAND_WORD:
            return new DeleteDoctorCommandParser().parse(arguments);

        case SelectDoctorCommand.COMMAND_WORD:
            return new SelectDoctorCommandParser().parse(arguments);

        case DoctorMatchCommand.COMMAND_WORD:
            return (new DoctorMatchCommandParser().parse(arguments));

        case AddMedHistCommand.COMMAND_WORD:
            return new AddMedHistCommandParser().parse(arguments);

        case ListMedHistCommand.COMMAND_WORD:
            return new ListMedHistCommandParser().parse(arguments);

        case EditMedHistCommand.COMMAND_WORD:
            return new EditMedHistCommandParser().parse(arguments);

        case SelectPatientCommand.COMMAND_WORD:
            return new SelectPatientCommandParser().parse(arguments);

        case SearchMedHistCommand.COMMAND_WORD:
            return new SearchMedHistCommandParser().parse(arguments);

        case SelectMedHistCommand.COMMAND_WORD:
            return new SelectMedHistCommandParser().parse(arguments);

        case SortMedHistCommand.COMMAND_WORD:
            return new SortMedHistCommandParser().parse(arguments);

        case AddPrescriptionCommand.COMMAND_WORD:
            return new AddPrescriptionCommandParser().parse(arguments);

        case ListPrescriptionCommand.COMMAND_WORD:
            return new ListPrescriptionCommandParser().parse(arguments);

        case EditPrescriptionCommand.COMMAND_WORD:
            return new EditPrescriptionCommandParser().parse(arguments);

        case SearchPrescriptionCommand.COMMAND_WORD:
            return new SearchPrescriptionCommandParser().parse(arguments);

        case SelectPrescriptionCommand.COMMAND_WORD:
            return new SelectPrescriptionCommandParser().parse(arguments);

        case ClearCommand.COMMAND_WORD:
            return new ClearCommand();

        case HistoryCommand.COMMAND_WORD:
            return new HistoryCommand();

        case ExitCommand.COMMAND_WORD:
            return new ExitCommand();

        case HelpCommand.COMMAND_WORD:
            return new HelpCommand();

        case UndoCommand.COMMAND_WORD:
            return new UndoCommand();

        case RedoCommand.COMMAND_WORD:
            return new RedoCommand();

        default:
            throw new ParseException(MESSAGE_UNKNOWN_COMMAND);
        }
    }

}



