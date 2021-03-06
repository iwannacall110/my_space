package com.wangshan.service.impl;

import com.wangshan.dao.NoteBookDao;
import com.wangshan.dao.NoteBookGroupDao;
import com.wangshan.dao.NoteDao;
import com.wangshan.dao.UserHasNoteBookGroupDao;
import com.wangshan.models.Forms.NoteForm;
import com.wangshan.models.Note;
import com.wangshan.models.NoteBook;
import com.wangshan.models.NoteBookGroup;
import com.wangshan.models.UserHasNoteBookGroup;
import com.wangshan.models.forms.UserHasNoteBookGroupForm;
import com.wangshan.service.NoteService;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2015/11/15.
 */
@Service
public class NoteServiceImpl implements NoteService {
    @Autowired
    private NoteBookGroupDao noteBookGroupDao;
    @Autowired
    private NoteDao noteDao;
    @Autowired
    private NoteBookDao noteBookDao;
    @Autowired
    private UserHasNoteBookGroupDao userHasNoteBookGroupDao;

    @Transactional
    @Override
    public NoteBookGroup addNoteBookGroup(Long user, String name){
        NoteBookGroup nbg = new NoteBookGroup(name, 0, 1, DateTime.now(), DateTime.now());
        noteBookGroupDao.addNoteBookGroup(nbg);
        UserHasNoteBookGroup uhnbg = new UserHasNoteBookGroup(user, nbg.getId(), 1, DateTime.now(), DateTime.now());
        userHasNoteBookGroupDao.insertUserHasNoteBookGroup(uhnbg);
        return nbg;
    }

    @Override
    public List<Note> getNotes(){
        return noteDao.selectNotes();
    }

    @Override
    public List<NoteBook> getNoteBooks(){ return noteBookDao.selectNoteBooks();}

    @Override
    public List<UserHasNoteBookGroupForm> getNoteBookGroupByUser(Long id){
        return userHasNoteBookGroupDao.selectNoteBookGroupByUser(id);
    }

    @Override
    public Note getNote(Long id){
        return noteDao.selectNote(id);
    }

    @Override
    public List<Note> getNoteLitesByGroup(Long group){
        return noteDao.selectNoteLitesByGroup(group);
    }

    @Override
    public List<Note> getNoteLitesByBook(Long noteBook){
        return noteDao.selectNoteLitesByBook(noteBook);
    }

    @Override
    public List<Note> getNoteLites(){
        return noteDao.selectNoteLites();
    }

    @Override
    public Boolean updateNoteContent(Note note) {
        return noteDao.updateNoteContent(note);
    }

    @Override
    public List<NoteBookGroup> getNoteBookGroup(Long user){
        return noteBookGroupDao.selectGroupByUser(user);
    }

    @Override
    public Long addNoteBook(NoteBook noteBook){
        noteBookDao.addNoteBook(noteBook);
        return noteBook.getId();
    }

    @Override
    @Transactional
    public Boolean deleteNoteBook(Long id){
        NoteBook noteBook = noteBookDao.selectNoteBook(id);
        noteBookGroupDao.reduceNoteCount(noteBook.getNoteBookGroup());
        NoteBook nb = new NoteBook(id, 0, DateTime.now());
        noteBookDao.deleteNoteBook(nb);
        return true;
    }

    @Override
    @Transactional
    public Long addNote(Note note){
        noteDao.addNote(note);
        noteBookDao.addNoteCount(note.getNoteBook());
        noteBookGroupDao.addNoteCount(note.getNoteBookGroup());
        return note.getId();
    }

    @Override
    public Integer updateNoteBook(NoteBook noteBook){
        return noteBookDao.updateNoteBook(noteBook);
    }

    @Override
    public Integer updateNote(Note note){
        return noteDao.updateNote(note);
    }

    @Override
    @Transactional
    public Boolean deleteNote(Long id){
        Note note = noteDao.selectNote(id);
        noteBookDao.reduceNoteCount(note.getNoteBook());
        noteBookGroupDao.reduceNoteCount(note.getNoteBookGroup());
        Note n = new Note(id, 0, DateTime.now());
        noteDao.deleteNote(n);
        return true;
    }
}
