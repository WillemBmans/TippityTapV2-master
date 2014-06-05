package com.tippitytapv2.app;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.AssetManager;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.util.Arrays.*;

/**
 * Created by Wietse on 6/5/2014.
 */
public class HighScoresClass implements  Serializable {


    public static String StringCreator() {
        String tester;
        tester = new String("");


        List<String> items = Arrays.asList(
                "up", "down", "strange", "charm", "top", "bottom"
        );



        try {


            OutputStream file = new FileOutputStream("scores.dat");
            OutputStream buffer = new BufferedOutputStream(file);
            ObjectOutput output = new ObjectOutputStream(buffer);

            try {
                output.writeObject(items);
            } finally {
                output.close();
            }
        } catch (IOException ex) {

        }


        try {

            InputStream file = new FileInputStream("Scores.dat");
            InputStream buffer = new BufferedInputStream(file);
            ObjectInput input = new ObjectInputStream(buffer);
            try {

                List<String> recoveredItems = (List<String>) input.readObject();


                for (String item : recoveredItems) {

                    tester += item;

                }
            } finally {
                input.close();

            }
        } catch (ClassNotFoundException ex) {

        } catch (IOException ex) {

        }
       return "x";
    }

    public static ArrayList<String> ScoreList(String input) {
        ArrayList<String> Scores;
        Scores = new ArrayList<String>();
        Scores.add(input);
        return Scores;


    }






}



