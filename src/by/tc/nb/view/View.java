package by.tc.nb.view;

import by.tc.nb.controller.UserMenu;
import by.tc.nb.service.exception.ServiceException;

public class View {
	public static void main(String[] args) throws ServiceException {
		UserMenu userMenu = new UserMenu();
		userMenu.begin();
	}
}
