package by.tc.nb.bean.entity;

import java.io.Serializable;
import java.util.ArrayList;

public class NoteBook implements Serializable{
	private ArrayList<Note> notes = new ArrayList<Note>();;

	public NoteBook() {
	}

	public NoteBook(ArrayList<Note> notes) {
		this.notes = notes;
	}

	public ArrayList<Note> getNotes() {
		return notes;
	}
}
