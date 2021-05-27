package sg.edu.rp.c346.id20025732.democontextmenutranslation2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView tvTranslatedtext, tvTranslatedtext2;
    String wordClicked = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvTranslatedtext = findViewById(R.id.textViewTranslatedtext);
        tvTranslatedtext2 = findViewById(R.id.textViewTranslatedtext2);
        registerForContextMenu(tvTranslatedtext);
        registerForContextMenu(tvTranslatedtext2);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        menu.add(0, 0, 0, "English");
        menu.add(0, 1, 1, "Italian");
        if (v == tvTranslatedtext) {
            wordClicked = "Hello";
        } else if (v == tvTranslatedtext2) {
            wordClicked = "Bye";
        }

    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        if (wordClicked.equalsIgnoreCase("Hello")) {
            if (item.getItemId() == 0) {
                Toast.makeText(MainActivity.this, "English is chosen", Toast.LENGTH_SHORT).show();
                tvTranslatedtext.setText("Hello");

                return true;
            } else if (item.getItemId() == 1) {
                Toast.makeText(MainActivity.this, "Italian is chosen", Toast.LENGTH_SHORT).show();
                tvTranslatedtext.setText("Ciao");



                return true;
            }
        }


        if (wordClicked.equalsIgnoreCase("Bye")) {
            if (item.getItemId() == 0) {
                Toast.makeText(MainActivity.this, "English is chosen", Toast.LENGTH_SHORT).show();
                tvTranslatedtext2.setText("Bye");

                return true;
            } else if (item.getItemId() == 1) {
                Toast.makeText(MainActivity.this, "Italian is chosen", Toast.LENGTH_SHORT).show();
                tvTranslatedtext2.setText("Addio");

                return true;
            }

        }


        return super.onContextItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here.
        int id = item.getItemId();

        if (id == R.id.EnglishSelection) {
            tvTranslatedtext.setText("Hello ");
            tvTranslatedtext2.setText("Bye");
            return true;
        } else if (id == R.id.italianSelection) {
            tvTranslatedtext.setText("Ciao");
            tvTranslatedtext2.setText("Addio");
            return true;
        } else {
            tvTranslatedtext.setText("Error translation");
        }

        return super.onOptionsItemSelected(item);
    }
}

