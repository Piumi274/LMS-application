package com.example.myapplication12;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;

public class LecAdapter extends FirestoreRecyclerAdapter<Note, LecAdapter.NoteViewHolder> {
    Context context;
//Create Constructor
    public LecAdapter(@NonNull FirestoreRecyclerOptions<Note> options, Context context) {
        super(options);
        //assign this context
        this.context=context;
    }

    @Override
    protected void onBindViewHolder(@NonNull NoteViewHolder holder, int position, @NonNull Note model) {
        holder.tittleTextView.setText(model.title);
        holder.contentTextView.setText(model.content);
        holder.timestampTextView.setText(Utility.timestampToString(model.timestamp));


    }

    @NonNull
    @Override
    public NoteViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_note_item,parent,false);
        return  new NoteViewHolder(view);
    }

    //inherit
    class NoteViewHolder extends RecyclerView.ViewHolder{

        TextView tittleTextView,contentTextView,timestampTextView;
        //create constructor
        public NoteViewHolder(@NonNull View itemView) {
            super(itemView);

            tittleTextView=itemView.findViewById(R.id.note_title_text_View);
            contentTextView=itemView.findViewById(R.id.note_Content_text);
            timestampTextView=itemView.findViewById(R.id.note_timestamp_text_View);
        }
    }
}
