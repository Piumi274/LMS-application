package com.example.myapplication12;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.button.MaterialButton;
import com.google.firebase.Timestamp;
import com.google.firebase.firestore.DocumentReference;

public class EditLectureMaterial_Activity extends AppCompatActivity {
    EditText titleEditText,contentEditText;
    MaterialButton add,edit,delete;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_lecture_material);

        //add notes
        titleEditText =findViewById(R.id.note_title_text);
        contentEditText=findViewById(R.id.note_Content_text);


        add.setOnClickListener((v)-> saveTitile());


    }
    void saveTitile(){
String lTitle = titleEditText.getText().toString();
String lcontent= contentEditText.getText().toString();

if (lTitle==null || lTitle.isEmpty()){
    titleEditText.setError("Module Name Is Required");
    return;
    //add notes is finish

}
//save notes in firebase

Note note = new Note();
note.setTitle(lTitle);
note.setContent(lcontent);
note.setTimestamp(Timestamp.now());


saveNoteToFirebase(note);
    }
//save the notes
    void saveNoteToFirebase(Note note) {
        DocumentReference documentReference;
        documentReference = Utility.getCollectionReferenceForNotes().document();

        documentReference.set(note).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isSuccessful()) {
                    //note is added
                    Utility.showToast(EditLectureMaterial_Activity.this, "Lecture Materials Added Successfully");
                    finish();
                } else {
                    Utility.showToast(EditLectureMaterial_Activity.this, "Lecture Materials not Uploaded");
                }
            }
        });
    }
}