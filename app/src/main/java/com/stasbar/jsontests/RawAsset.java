package com.stasbar.jsontests;

import android.content.Context;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;

/**
 * Created by stasbar on 06.10.2017
 */

public class RawAsset {

    public static  String  getData1(Context context) {

        Writer writer = new StringWriter();
        try (InputStream is = context.getResources().openRawResource(R.raw.data1)) {

            char[] buffer = new char[1024];
            Reader reader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
            int n;
            while ((n = reader.read(buffer)) != -1) {
                writer.write(buffer, 0, n);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return writer.toString();
    }

    public static String getData2(Context context) {

        Writer writer = new StringWriter();
        try (InputStream is = context.getResources().openRawResource(R.raw.data2)) {

            char[] buffer = new char[1024];
            Reader reader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
            int n;
            while ((n = reader.read(buffer)) != -1) {
                writer.write(buffer, 0, n);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return writer.toString();
    }

    public static String getData3(Context context) {

        Writer writer = new StringWriter();
        try (InputStream is = context.getResources().openRawResource(R.raw.data3)) {

            char[] buffer = new char[1024];
            Reader reader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
            int n;
            while ((n = reader.read(buffer)) != -1) {
                writer.write(buffer, 0, n);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return writer.toString();
    }
}
