package com.company;
import java.io.*;
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
        JsonReader input = new JsonReader(new FileReader("parkBoundaries.json"));
        PrintWriter writer = new PrintWriter("parkBoundariez.json");
        writer.print("{\"type\":\t\"FeatureCollection\",  \"features\": [");
        // use the reader to read the json to a stream of tokens
        // we call the handle object method to handle the full json object. This
        // implies that the first token in JsonToken.BEGIN_OBJECT, which is
        // always true.
        handleObject(input,writer);
        writer.close();

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
    private static void handleObject(JsonReader reader,PrintWriter writer) throws IOException
    {
        reader.beginObject();
        while (reader.hasNext()) {
            JsonToken token = reader.peek();
            if (token.equals(JsonToken.BEGIN_ARRAY))
                handleArray(reader,writer);
            else if (token.equals(JsonToken.END_OBJECT)) {
                reader.endObject();
                return;
            } else
                handleNonArrayToken(reader, token,writer);
        }

    }

    /**
     * Handle a json array. The first token would be JsonToken.BEGIN_ARRAY.
     * Arrays may contain objects or primitives.
     *
     * @param reader
     * @throws IOException
     */
    public static void handleArray(JsonReader reader,PrintWriter writer) throws IOException
    {
        reader.beginArray();
        while (true) {
            JsonToken token = reader.peek();
            if (token.equals(JsonToken.END_ARRAY)) {
                reader.endArray();
                break;
            } else if (token.equals(JsonToken.BEGIN_OBJECT)) {
                handleObject(reader,writer);
            } else if (token.equals(JsonToken.END_OBJECT)) {
                reader.endObject();
            } else
                handleNonArrayToken(reader, token,writer);
        }
    }

    /**
     * Handle non array non object tokens
     *
     * @param reader
     * @param token
     * @throws IOException
     */
    public static void handleNonArrayToken(JsonReader reader, JsonToken token,PrintWriter writer) throws IOException
    {
        reader.setLenient(true);
        if (token.equals(JsonToken.NAME)) {
            String name = reader.nextName();
            if(name.equals("attributes")){
                writer.print("{\"attributes\": {");
                reader.beginObject();
                reader.nextName();
                reader.nextDouble();//objectid
                reader.nextName();
                writer.print("\"NAME\": \""+reader.nextString()+"\",");//name
                reader.nextName();
                reader.nextString();//type
                reader.nextName();
                writer.print("\"ACRES\": "+reader.nextDouble()+",");//acres
                reader.nextName();
                writer.print("\"CHARACTERI\": \" "+reader.nextString()+" \"},");//descript
                reader.nextName();
                reader.nextString();//linkdata
                reader.nextName();
                reader.nextString();//source
                reader.nextName();
                reader.nextDouble();//area
                reader.nextName();
                reader.nextDouble();//length
                reader.endObject();
                //System.out.println(reader.nextName());
            } else if(name.equals("geometry")){
                writer.print(" \"geometry\": {");
                reader.beginObject();
                reader.nextName();
                reader.beginArray();
                reader.beginArray();
                reader.beginArray();
                writer.print("\"x\": "+reader.nextDouble()+",");//x
                writer.print("\"y\": "+reader.nextDouble() +//y
                        "    }\n" +
                        "  },");
                reader.endArray();
                reader.endArray();
                reader.endArray();
                reader.endObject();

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
