package by.tc.nb.command.impl;

import by.tc.nb.bean.AddNoteRequest;
import by.tc.nb.bean.Request;
import by.tc.nb.bean.Response;
import by.tc.nb.service.NoteBookService;
import by.tc.nb.service.ServiceFactory;
import by.tc.nb.service.exception.ServiceException;
import by.tc.nb.command.Command;
import by.tc.nb.command.exception.CommandException;

public class AddNewNote implements Command {

	@Override
	public Response execute(Request request) throws CommandException {
		AddNoteRequest req;

		if(request instanceof AddNoteRequest){
			req = (AddNoteRequest)request;
		}else{
			throw new CommandException("Wrong request");
		}
		
		String note = req.getNote();
		String date = req.getDate();

		ServiceFactory service = ServiceFactory.getInstance();
		NoteBookService nbService = service.getNoteBookService();

		try{
			nbService.addNote(note,date);
		} catch (ServiceException e) {
			throw new CommandException("Wrong command!");
		}
        Response response = new Response();
		response.setErrorStatus(false);
		response.setResultMessage("Note added!");

		return response;
	}

}
