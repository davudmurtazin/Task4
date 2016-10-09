package by.tc.nb.command.impl;

import by.tc.nb.bean.Request;
import by.tc.nb.bean.Response;
import by.tc.nb.bean.DeserializeNoteBookRequest;
import by.tc.nb.bean.WriteNotesToFileRequest;
import by.tc.nb.command.Command;
import by.tc.nb.command.exception.CommandException;
import by.tc.nb.service.NoteBookService;
import by.tc.nb.service.ServiceFactory;
import by.tc.nb.service.exception.ServiceException;

import java.io.IOException;

/**
 * Created by Davud_Murtazin on 10/9/2016.
 */
public class DeserializeNoteBook implements Command {

    @Override
    public Response execute(Request request) throws CommandException, ServiceException {
        if(request instanceof DeserializeNoteBookRequest) {
            ServiceFactory service = ServiceFactory.getInstance();
            NoteBookService nbService = service.getNoteBookService();
            try {
                nbService.deserializeNotebook(((DeserializeNoteBookRequest)request).getFilePath());
            }
            catch (ServiceException e){
                throw new ServiceException("Can not write to file!");
            } catch (IOException e) {
                throw new CommandException("IOException!");
            }

            Response response = new Response();
            response.setErrorStatus(false);
            response.setResultMessage("All notes wrote to file!");
            return response;
        } else {
            throw new CommandException("Wrong request!");
        }
    }
}
