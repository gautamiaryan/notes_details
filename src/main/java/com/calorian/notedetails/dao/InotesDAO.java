package com.calorian.notedetails.dao;

import java.util.List;

import com.calorian.notedetails.model.Note;


public interface InotesDAO {

	Note createNote(Note note, Long userId);

	Note updateNote(Long noteId, Note note, Long userId);

	Note deleteNote(Long noteId, Long userId);

	Note getNoteById(Long noteId);

	List<Note> getAllNotes(String token);

}
