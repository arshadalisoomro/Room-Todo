package pk.edu.itcg.roomtodo.adapter.holder;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import pk.edu.itcg.roomtodo.R;

public class NoteHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.tv_note_title)
    public TextView noteTitle;

    @BindView(R.id.tv_note_priority)
    public TextView notePriority;

    @BindView(R.id.tv_note_description)
    public TextView noteDescription;

    public NoteHolder(@NonNull View itemView) {
        super(itemView);
        ButterKnife.bind(itemView);
    }
}
