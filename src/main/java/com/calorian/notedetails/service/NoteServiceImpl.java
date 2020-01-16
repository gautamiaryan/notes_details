package com.calorian.notedetails.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.calorian.notedetails.dao.InotesDAO;
import com.calorian.notedetails.dto.NoteDTO;
import com.calorian.notedetails.model.Note;

@Service
public class NoteServiceImpl  implements InoteService{

	@Autowired
	private InotesDAO noteDAO;

	@Autowired
	private WebClientService webClientService;
	
	@Transactional
	@Override
	public String create(NoteDTO noteDTO, String tocken) {
		Long user_id = webClientService.getUserId(tocken);
		if (user_id != 0) {
			Note note = noteDTOToNote(noteDTO);
			Note noteObj = noteDAO.createNote(note, user_id);
			if (noteObj != null) {
				return "Note is Created";
			}
		}
		return "Note is not Created";
	}

	@Transactional
	@Override
	public String update(Long noteId, NoteDTO noteDTO, String token) {
		Note note = noteDAO.getNoteById(noteId);
		Long user_id = webClientService.getUserId(token);
		if (user_id != 0) {
			if (noteDTO.getTitle() != null) {
				note.setTitle(noteDTO.getTitle());
			}
			if (noteDTO.getNote() != null) {
				note.setNotes(noteDTO.getNote());
			}
			note.setUpdatedStamp(LocalDateTime.now());
			if (noteDAO.updateNote(noteId, note, user_id) != null) {
				return "Note is updated";
			}
		}
		return "Note is not updated";

	}

	@Transactional
	@Override
	public String delete(Long noteId, String token) {
		Long user_id = webClientService.getUserId(token);
		if (user_id != 0) {
			Note note = noteDAO.deleteNote(noteId,user_id);
			if (note != null) {
				return "Note is deleted";
			}
		}
		return "Note is not found";
	}

	public Note noteDTOToNote(NoteDTO noteDTO) {
		Note note = new Note();
		note.setTitle(noteDTO.getTitle());
		note.setNotes(noteDTO.getNote());
		note.setCreatedStamp(LocalDateTime.now());
		note.setUpdatedStamp(LocalDateTime.now());
		return note;

	}

	@Override
	public List<Note> showAllNotes(String token) {
		
		List<Note> noteList = noteDAO.getAllNotes(token);
		if (noteList != null) {
			return noteList;
		}
		return null;
	}

	
	

}
