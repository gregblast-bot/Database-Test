package com.example.gardengang;

import android.content.Context;
import android.util.Log;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class PreCreateDB {

    public static void copyDB(Context context){
        try{
            String destPath = context.getApplicationInfo().dataDir + "/databases/";
            File f = new File(destPath);
            if(!f.exists()){
                f.mkdir();
                // Copy the db from assets folder into the databases folder
                rawCopy(context.getAssets().open("mydb.db"), new FileOutputStream(destPath + "/mydb.db"));
            }
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public static void rawCopy(InputStream inputStream, OutputStream outputStream) throws IOException{
        // Copy 1k bytes at a time
        byte[] buffer = new byte[1024];
        int length;
        while((length = inputStream.read(buffer)) > 0){
            outputStream.write(buffer, 0, length);
        }
        inputStream.close();
        outputStream.close();
    }
}
