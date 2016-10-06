package by.tc.nb.command.impl;

import by.tc.nb.bean.FindNoteByDateRequest;
import by.tc.nb.bean.FindNoteByDateResponse;
import by.tc.nb.bean.Request;
import by.tc.nb.bean.Response;
import by.tc.nb.service.NoteBookService;
import by.tc.nb.service.ServiceFactory;
import by.tc.nb.service.exception.ServiceException;
import by.tc.nb.command.Command;
import by.tc.nb.command.exception.CommandException;

/**
 * Created by Davud_Murtazin on 9/29/2016.
 */
public class FindNoteByDate implements Command {
    @Override
    public Response execute(Request request) throws CommandException {
        FindNoteByDateRequest req;

        if(request instanceof FindNoteByDateRequest) {
            req = (FindNoteByDateRequest) request;
        } else {
            throw new CommandException("Wrong request!");
        }

        String dateToFind = req.getDate();

        ServiceFactory service = ServiceFactory.getInstance();
        NoteBookService nbService = service.getNoteBookService();

        FindNoteByDateResponse response = new FindNoteByDateResponse();
        try{
            //nbService.findNoteByDate(strToFind);
            response.setFoundNotes(nbService.findNoteByContent(dateToFind));
            response.setErrorStatus(false);
            response.setResultMessage("Searching date found!");
        } catch (ServiceException e) {
            throw new CommandException("Wrong command!");
        }
        return response;
    }
}
