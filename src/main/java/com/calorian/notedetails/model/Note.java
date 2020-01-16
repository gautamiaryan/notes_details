package com.calorian.notedetails.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Aishu_notes")
public class Note {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="note_id")
	private Integer id;
	
	@Column(name="note_title")
	private String title;
	
	@Column(name="note_description")
	private String notes;
	
	@Column(name="note_createdtime")
	private LocalDateTime createdStamp;
	
	@Column(name="note_updatedtime")
	private LocalDateTime updatedStamp;
	
	
	@Column(name="user_id")
	private Long userId;


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getNotes() {
		return notes;
	}


	public void setNotes(String notes) {
		this.notes = notes;
	}


	public LocalDateTime getCreatedStamp() {
		return createdStamp;
	}


	public void setCreatedStamp(LocalDateTime createdStamp) {
		this.createdStamp = createdStamp;
	}


	public LocalDateTime getUpdatedStamp() {
		return updatedStamp;
	}


	public void setUpdatedStamp(LocalDateTime updatedStamp) {
		this.updatedStamp = updatedStamp;
	}


	public Long getUserId() {
		return userId;
	}


	public void setUserId(Long userId) {
		this.userId = userId;
	}
	
	
}
