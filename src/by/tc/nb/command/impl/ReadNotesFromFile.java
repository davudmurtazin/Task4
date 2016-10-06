package by.tc.nb.command.impl;

import by.tc.nb.bean.ReadNoteFromFileRequest;
import by.tc.nb.bean.Request;
import by.tc.nb.bean.Response;
import by.tc.nb.service.NoteBookService;
import by.tc.nb.service.ServiceFactory;
import by.tc.nb.service.exception.ServiceException;
import by.tc.nb.command.Command;
import by.tc.nb.command.exception.CommandException;

import java.io.IOException;

/**
 * Created by Davud_Murtazin on 9/29/2016.
 */
public class ReadNotesFromFile implements Command {
    @Override
    public Response execute(Request request) throws CommandException, ServiceException {
        if (request instanceof ReadNoteFromFileRequest){
            ServiceFactory service = ServiceFactory.getInstance();
            NoteBookService nbService = service.getNoteBookService();
            try{
                nbService.readNotesFromFile(((ReadNoteFromFileRequest) request).getFilePath());
            }catch (IOException e){
                throw new CommandException("Wrong path to the file!");
            }
            catch (ServiceException e){
                throw new ServiceException("Can not read from file!");
            }
            Response response = new Response();
            response.setErrorStatus(false);
            response.setResultMessage("All notes read from file!");

            return response;
        } else {
            throw new CommandException("Wrong request!");
        }
    }
}


