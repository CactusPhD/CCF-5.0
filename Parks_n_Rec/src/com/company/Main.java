package com.company;

import java.io.IOException;
import java.io.FileReader;
import java.net.MalformedURLException;
import java.net.URL;

import org.apache.commons.io.IOUtils;

import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;

public class Main
{
    public static void main(String[] args) throws MalformedURLException, IOException
    {
        JsonReader input = new JsonReader(new FileReader("publicArt3.json"));
        // use the reader to read the json to a stream of tokens
        // we call the handle object method to handle the full json object. This
        // implies that the first token in JsonToken.BEGIN_OBJECT, which is
        // always true.
        handleObject(input);
    }

    /**
     * Handle an Object. Consume the first token which is BEGIN_OBJECT. Within
     * the Object there could be array or non array tokens. We write handler
     * methods for both. Noe the peek() method. It is used to find out the type
     * of the next token without actually consuming it.
     *
     * @param reader
     * @throws IOException
     */
    private static void handleObject(JsonReader reader) throws IOException
    {
        reader.beginObject();
        while (reader.hasNext()) {
            JsonToken token = reader.peek();
            if (token.equals(JsonToken.BEGIN_ARRAY))
                handleArray(reader);
            else if (token.equals(JsonToken.END_OBJECT)) {
                reader.endObject();
                return;
            } else
                handleNonArrayToken(reader, token);
        }

    }

    /**
     * Handle a json array. The first token would be JsonToken.BEGIN_ARRAY.
     * Arrays may contain objects or primitives.
     *
     * @param reader
     * @throws IOException
     */
    public static void handleArray(JsonReader reader) throws IOException
    {
        reader.beginArray();
        while (true) {
            JsonToken token = reader.peek();
            if (token.equals(JsonToken.END_ARRAY)) {
                reader.endArray();
                break;
            } else if (token.equals(JsonToken.BEGIN_OBJECT)) {
                handleObject(reader);
            } else if (token.equals(JsonToken.END_OBJECT)) {
                reader.endObject();
            } else
                handleNonArrayToken(reader, token);
        }
    }

    /**
     * Handle non array non object tokens
     *
     * @param reader
     * @param token
     * @throws IOException
     */
    public static void handleNonArrayToken(JsonReader reader, JsonToken token) throws IOException
    {
        if (token.equals(JsonToken.NAME)) {
            String name = reader.nextName();
            if(name.equals("properties")){
                reader.beginObject();
                for(int i=0;i<5;i++){
                    reader.nextName();
                    System.out.println(reader.nextString());
                }
                reader.endObject();
                //System.out.println(reader.nextName());
            } else if(name.equals("geometry")){
                reader.beginObject();
                for(int i=0;i<2;i++){
                    reader.nextName();
                    System.out.println(reader.nextDouble());
                }
            }
            //System.out.println(name);
        } else if (token.equals(JsonToken.STRING)) {
            String data = reader.nextString();
            System.out.println(data);
        } else if (token.equals(JsonToken.NUMBER)) {
            Double number = reader.nextDouble();
            System.out.println(number);
        } else {
            reader.skipValue();
        }
    }
}
