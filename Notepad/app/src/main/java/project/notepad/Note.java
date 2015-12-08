package project.notepad;

import android.content.Intent;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;

public class Note extends AppCompatActivity {
    TextView noteText;
    int i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note);

    }

    protected void onResume() {
        super.onResume();
        TextView textView = (TextView) findViewById(R.id.message);
        if (getIntent().hasExtra("noteText")) {
            textView.setText(getIntent().getStringExtra("noteText"));
            i = Integer.parseInt(getIntent().getStringExtra("id"));
        }
        else {
            i = -1;
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_note, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_save) {
            noteText = (TextView) findViewById(R.id.message);
            if(i > -1){
                Storage.updateNote(i, noteText.getText().toString());
            }
            else{
                Storage.addNote(noteText.getText().toString());
            }
            Intent intent = NavUtils.getParentActivityIntent(this);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            NavUtils.navigateUpTo(this, intent);

        }

        return super.onOptionsItemSelected(item);
    }
}
