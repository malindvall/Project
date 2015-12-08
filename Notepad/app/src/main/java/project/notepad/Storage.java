package project.notepad;

import java.util.ArrayList;

public class Storage {
    private static ArrayList <String> notes = new ArrayList<>();


    public static void addNote(String string) {
        notes.add(string);
    }

    public static ArrayList<String> getNotes(){
        return notes;
    }

    public static void updateNote(int i, String string) {
        notes.set(i, string);

    }

    public static void deleteNote(int i) {
        notes.remove(i);
    }
}
