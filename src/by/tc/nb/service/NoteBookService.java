package by.tc.nb.service;

import by.tc.nb.bean.entity.Note;
import by.tc.nb.service.exception.ServiceException;

import java.io.IOException;
import java.util.ArrayList;

public interface NoteBookService {
	
	void addNote(String note, String date) throws ServiceException;

	ArrayList<Note> findNoteByContent(String strToFind) throws ServiceException;

	ArrayList<Note> findNoteByDate(String dateToFind) throws ServiceException;

	ArrayList<Note> readNotesFromFile(String filePath) throws ServiceException, IOException;

	void writeNotesToFile(String filePath) throws ServiceException;

	void clearNoteBook() throws ServiceException;

	void showAllNotes();
}
