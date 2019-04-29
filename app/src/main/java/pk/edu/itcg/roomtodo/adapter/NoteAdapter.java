package pk.edu.itcg.roomtodo.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;
import java.util.Objects;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.recyclerview.widget.RecyclerView;
import pk.edu.itcg.roomtodo.R;
import pk.edu.itcg.roomtodo.adapter.holder.NoteHolder;
import pk.edu.itcg.roomtodo.model.Note;

public class NoteAdapter extends RecyclerView.Adapter<NoteHolder> {

    //private Context context;
    private List<Note> allNotes;

    /*public NoteAdapter(Context context, LiveData<List<Note>> allNotes) {
        this.context = context;
        this.allNotes = allNotes;
    }*/

    @NonNull
    @Override
    public NoteHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_note, parent, false);

        return new NoteHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NoteHolder holder, int position) {
        holder.noteTitle.setText(Objects.requireNonNull(allNotes).get(position).getTitle());
        holder.noteDescription.setText(Objects.requireNonNull(allNotes).get(position).getDescription());
        holder.notePriority.setText(Objects.requireNonNull(allNotes).get(position).getPriority());
    }

    public void setAllNotes(List<Note> allNotes){
        this.allNotes = allNotes;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return Objects.requireNonNull(allNotes).size();
    }
}
