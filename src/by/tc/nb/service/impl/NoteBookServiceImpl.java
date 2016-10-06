package by.tc.nb.service.impl;

import by.tc.nb.bean.entity.Note;
import by.tc.nb.bean.entity.NoteBook;
import by.tc.nb.service.NoteBookService;
import by.tc.nb.service.exception.ServiceException;
import by.tc.nb.source.NoteBookProvider;
import by.tc.nb.validate.Validator;

import java.io.*;
import java.util.ArrayList;

public class NoteBookServiceImpl implements NoteBookService {

//	@Override
//	public void addNote(Note note, String date) throws ServiceException {
//		// parameters validation
//		if (note == null || "".equals(note)){
//			throw new ServiceException("Wrong parameter!");
//		}
//
//
//		Note newNote = new Note();
//
//		NoteBook noteBook = NoteBookProvider.getInstance().getNoteBook();
//		// noteBook.add(newNote);
//
//	}

	@Override
	public void addNote(String note, String date) throws ServiceException {
		if (note == null || date.isEmpty() && date==null || date.isEmpty()){
			throw new ServiceException("Wrong parameters!");
		}

		Note newNote = new Note(note,date);

		NoteBook noteBook = NoteBookProvider.getInstance().getNoteBook();
		noteBook.getNotes().add(newNote);
	}

	@Override
	public ArrayList<Note> findNoteByContent(String strToFind) throws ServiceException {
		ArrayList<Note> foundNotes = new ArrayList<>();
		if(strToFind.isEmpty()){
			throw new ServiceException("Wrong parameter!");
		}
		else {
			NoteBook noteBook = NoteBookProvider.getInstance().getNoteBook();

			for (Note note : noteBook.getNotes()) {
				if (Validator.checkContent(strToFind, note)) {
					foundNotes.add(note);
				}
			}
		}
		return foundNotes;
	}

	@Override
	public ArrayList<Note> findNoteByDate(String dateToFind) throws ServiceException {
		ArrayList<Note> foundNotes = new ArrayList<>();
		if(dateToFind.isEmpty()){
			throw new ServiceException("Wrong parameter!");
		}
		NoteBook noteBook = NoteBookProvider.getInstance().getNoteBook();

		for (Note note : noteBook.getNotes()) {
			if (Validator.checkDate(dateToFind,note)) {
				foundNotes.add(note);
			}
		}
		return foundNotes;
	}

	@Override
	public ArrayList<Note> readNotesFromFile(String filePath) throws ServiceException, IOException {
		NoteBook noteBook = NoteBookProvider.getInstance().getNoteBook();
		if(filePath.isEmpty()){
			throw new ServiceException("Wrong parameter!");
		}
		else {
			File file = new File(filePath);
			BufferedReader br = new BufferedReader(new FileReader(file));
			String line;
			int dashPosition;
			int contentBegins;
			while ((line = br.readLine()) != null) {
				if (Validator.isNote(line)) {
					dashPosition = line.indexOf('-');
					contentBegins = dashPosition + 1;
					Note note = new Note(line.substring(contentBegins),line.substring(1, dashPosition));
					noteBook.getNotes().add(note);
				} else {
					System.out.println("Line in file is not valid");
				}
			}
			br.close();
		}
		return noteBook.getNotes();
	}

	@Override
	public void writeNotesToFile(String filePath) throws ServiceException {
		NoteBook noteBook = NoteBookProvider.getInstance().getNoteBook();
		try{
			PrintStream printStream = new PrintStream( new BufferedOutputStream(new FileOutputStream(filePath, true)));
			for (Note note : noteBook.getNotes()){
				printStream.println(note.toString());
			}
			System.out.println("Access writing to file!");
			printStream.close();
		} catch (FileNotFoundException e) {
			throw new ServiceException("Can not write to file!");
		}
	}

	@Override
	public void clearNoteBook() throws ServiceException {
		NoteBook noteBook = NoteBookProvider.getInstance().getNoteBook();
		noteBook.getNotes().clear();
	}

	@Override
	public void showAllNotes() {
		NoteBook noteBook = NoteBookProvider.getInstance().getNoteBook();
		if(noteBook.getNotes().isEmpty()){
			System.out.println("Notebook is clear!");
		}
		else {
			System.out.println("All notes in notebook:");
			for (Note note : noteBook.getNotes()) {
				System.out.println(note);
			}
		}
	}
}
