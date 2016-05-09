package com.example.xaviergutierrez.jsonread;

import android.app.IntentService;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

import com.google.gson.Gson;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * Created by xaviergutierrez on 30/1/16.
 */
public class MyService extends IntentService {


    /**
     * Creates an IntentService.  Invoked by your subclass's constructor.
     *
     * @param name Used to name the worker thread, important only for debugging.
     */
    public MyService(String name) {
        super(name);
    }

    public MyService(){
        super("MyService");

    }

    @Override
    protected void onHandleIntent(Intent intent) {

        try {

            Thread.sleep(10000);
            FileInputStream fileIn=openFileInput("mytextfile.json");
            java.util.Scanner scanner = new java.util.Scanner(fileIn);
            String theString = scanner.hasNext() ? scanner.next() : "";
            System.out.println("esto: "+theString);
            scanner.close();
            Log.i("Json: ", theString);
            Gson personaJson = new Gson();
            Persona persona = personaJson.fromJson(theString, Persona.class);
            Log.i("MyService: ",persona.toString());
            //escribiendo nuevo documento
            FileOutputStream fileout=openFileOutput("mytextfileJson3.txt", MODE_PRIVATE);
            OutputStreamWriter outputWriter=new OutputStreamWriter(fileout);
            outputWriter.write(theString);
            outputWriter.close();

            for (String nombre:fileList()) {
                if (nombre.endsWith(".json")){
                    deleteFile(nombre);
                    Log.i("nombre ", nombre);
                }
            }

            for (String nombre:fileList()) {

                    Log.i("nombre--: ", nombre);

            }


        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
