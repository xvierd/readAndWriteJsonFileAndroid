package com.example.xaviergutierrez.jsonread;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

import com.google.gson.Gson;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity {
    static final int READ_BLOCK_SIZE = 100;
    EditText textmsg;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        textmsg = (EditText) findViewById(R.id.editText1);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                WriteBtn();
            }
        });
    }


    // write text to file
    public void WriteBtn() {
        // add-write text into file
        try {
            FileOutputStream fileout = openFileOutput("mytextfile.json", MODE_PRIVATE);
            OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
            Persona persona = new Persona("Xavier","Rojas","04265541484");
            Gson personaJson = new Gson();
            String person = personaJson.toJson(persona);
            outputWriter.write(person);
            outputWriter.close();

            /*fileout=openFileOutput("mytextfile2.txt", MODE_PRIVATE);
            outputWriter=new OutputStreamWriter(fileout);
            outputWriter.write(textmsg.getText().toString());
            outputWriter.close();

            fileout=openFileOutput("mytextfile3.txt", MODE_PRIVATE);
            outputWriter=new OutputStreamWriter(fileout);
            outputWriter.write(textmsg.getText().toString());
            outputWriter.close();

            fileout=openFileOutput("mytextfile4.txt", MODE_PRIVATE);
            outputWriter=new OutputStreamWriter(fileout);
            outputWriter.write(textmsg.getText().toString());
            outputWriter.close();*/

            //display file saved message
            Toast.makeText(getBaseContext(), "File saved successfully!",
                    Toast.LENGTH_SHORT).show();
            startService(new Intent(getBaseContext(), MyService.class));
            Intent intent = new Intent(this, Main2Activity.class);
            startActivity(intent);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


}
