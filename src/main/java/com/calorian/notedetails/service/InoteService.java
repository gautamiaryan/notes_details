package com.calorian.notedetails.service;

import java.util.List;

import com.calorian.notedetails.dto.NoteDTO;
import com.calorian.notedetails.model.Note;

public interface InoteService {
	
String create(NoteDTO noteDTO,String tocken);
	
	String  update(Long id,NoteDTO noteDTO,String token);
	
	String  delete(Long noteId,String token);
	
	List<Note> showAllNotes(String token);

}
