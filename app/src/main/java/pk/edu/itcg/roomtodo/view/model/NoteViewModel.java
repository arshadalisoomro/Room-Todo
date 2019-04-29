package pk.edu.itcg.roomtodo.view.model;

import android.app.Application;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import pk.edu.itcg.roomtodo.dao.NoteDao;
import pk.edu.itcg.roomtodo.model.Note;
import pk.edu.itcg.roomtodo.repository.DaoImpl;

public class NoteViewModel extends AndroidViewModel implements NoteDao{

    private NoteDao noteDao;
    private LiveData<List<Note>> allNotes;

    public NoteViewModel(@NonNull Application application) {
        super(application);

        noteDao = new DaoImpl(application);
        allNotes = noteDao.getAllNotes();
    }


    @Override
    public void insert(Note note) {
        noteDao.insert(note);
    }

    @Override
    public void update(Note note) {
        noteDao.update(note);
    }

    @Override
    public void delete(Note note) {
        noteDao.delete(note);
    }

    @Override
    public LiveData<List<Note>> getAllNotes() {
        return allNotes;
    }
}
