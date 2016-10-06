package by.tc.nb.command.impl;

import by.tc.nb.bean.Request;
import by.tc.nb.bean.Response;
import by.tc.nb.bean.ShowNotesRequest;
import by.tc.nb.service.NoteBookService;
import by.tc.nb.service.ServiceFactory;
import by.tc.nb.service.exception.ServiceException;
import by.tc.nb.command.Command;
import by.tc.nb.command.exception.CommandException;

/**
 * Created by Davud_Murtazin on 9/29/2016.
 */
public class ShowNotes implements Command {
    @Override
    public Response execute(Request request) throws CommandException, ServiceException {
        if(request instanceof ShowNotesRequest) {
            ServiceFactory service = ServiceFactory.getInstance();
            NoteBookService nbService = service.getNoteBookService();
            nbService.showAllNotes();

            Response response = new Response();
            response.setErrorStatus(false);
            response.setResultMessage("Show all notes!");

            return response;
        } else {
            throw new CommandException("Wrong request!");
        }
    }
}
