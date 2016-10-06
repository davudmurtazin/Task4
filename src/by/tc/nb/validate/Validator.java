package by.tc.nb.validate;

import by.tc.nb.bean.entity.Note;

import java.util.Objects;

/**
 * Created by Davud_Murtazin on 9/30/2016.
 */
public class Validator {

    public static boolean checkContent(String strToFind, Note note){
        String noteToLow = note.getContent().toLowerCase();
        String strToLow = strToFind.toLowerCase();
        //Second condition for finding in all notes the same context without considering register
        if(note.getContent().contains(strToFind) || Objects.equals(noteToLow, strToLow)) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean checkDate(String dateToFind, Note note) {
        if(note.getDate().contains(dateToFind)) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean isNote(String lineFromFile) {
        String regExp = "(0[1-9]|1[0-9]|2[0-9]|3[01])\\.(0[1-9]|1[012])\\.[0-9]{4}-(.*)";
        if(lineFromFile.matches(regExp)) {
            return true;
        } else {
            return false;
        }
    }
}
