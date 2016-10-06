package by.tc.nb.controller;

import by.tc.nb.bean.Request;
import by.tc.nb.bean.Response;
import by.tc.nb.command.Command;
import by.tc.nb.command.exception.CommandException;
import by.tc.nb.command.CommandHelper;
import by.tc.nb.service.exception.ServiceException;
import by.tc.nb.validate.CommandNameValidator;

public class Controller {
	private CommandHelper helper = new CommandHelper();

	public Controller(){}
	
	public Response doRequest(Request request) throws ServiceException {
		Response response = null;
		if(CommandNameValidator.isValidCommandName(request.getCommandName())){
			String commandName = request.getCommandName();

			Command command = helper.getCommand(commandName);
			try {
				response = command.execute(request);
			} catch (CommandException e) {
				response = new Response();
				response.setErrorStatus(true);
				response.setErrorMessage("ERROR!");
			} catch (ServiceException e) {
				throw new ServiceException("Fault request!");
			}

		}
		else{
			System.out.println("Incorrect command name!");
		}
		return response;
	}
}
