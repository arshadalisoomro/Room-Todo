package pk.edu.itcg.roomtodo.repository;

import android.app.Application;
import android.os.AsyncTask;
import android.util.Log;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.room.Delete;
import pk.edu.itcg.roomtodo.dao.NoteDao;
import pk.edu.itcg.roomtodo.db.NoteDatabase;
import pk.edu.itcg.roomtodo.model.Note;

public class DaoImpl implements NoteDao {

    private NoteDao noteDao;
    private LiveData<List<Note>> listLiveData;

    public DaoImpl(Application application){
        NoteDatabase noteDatabase = NoteDatabase.getInstance(application);
        noteDao = noteDatabase.noteDao();
        listLiveData = noteDao.getAllNotes();
    }

    @Override
    public void insert(Note note) {
        new InsertNoteTask(noteDao).execute(note);
    }

    @Override
    public void update(Note note) {
        new UpdateNoteTask(noteDao).execute(note);
    }

    @Override
    public void delete(Note note) {
        new DeleteNoteTask(noteDao).execute(note);
    }

    @Override
    public LiveData<List<Note>> getAllNotes() {
        return listLiveData;
    }

    private static class InsertNoteTask extends AsyncTask<Note, Void, Void>{

        private NoteDao noteDao;

        private InsertNoteTask(NoteDao noteDao){
            this.noteDao = noteDao;
        }

        @Override
        protected Void doInBackground(Note... notes) {
            noteDao.insert(notes[0]);
            Log.e("INSERT", "Note Inserted...");
            return null;
        }
    }

    private static class UpdateNoteTask extends AsyncTask<Note, Void, Void>{

        private NoteDao noteDao;

        private UpdateNoteTask(NoteDao noteDao){
            this.noteDao = noteDao;
        }

        @Override
        protected Void doInBackground(Note... notes) {
            noteDao.update(notes[0]);
            Log.e("UPDATE", "Note Updated...");
            return null;
        }
    }
    private static class DeleteNoteTask extends AsyncTask<Note, Void, Void>{

        private NoteDao noteDao;

        private DeleteNoteTask(NoteDao noteDao){
            this.noteDao = noteDao;
        }

        @Override
        protected Void doInBackground(Note... notes) {
            noteDao.delete(notes[0]);
            Log.e("DELETE", "Note Deleted...");
            return null;
        }
    }
}
