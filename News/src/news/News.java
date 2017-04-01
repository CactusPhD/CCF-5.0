package news;

import java.io.IOException;
import java.io.StringReader;
import java.net.MalformedURLException;
import java.net.URL;

import org.apache.commons.io.IOUtils;

import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;

class News {

    public static void main(String[] args) throws MalformedURLException, IOException {
        String url = "https://newsapi.org/v1/articles?source=google-news&sortBy=&apiKey=56720f37937b4243883d0bf54adddd21";
        String json = IOUtils.toString(new URL(url));
        JsonReader reader = new JsonReader(new StringReader(json));

        handleObject(reader);
    }

    /**
     * @param reader
     * @throws IOException
     */
    private static void handleObject(JsonReader reader) throws IOException {
        reader.beginObject();
        while (reader.hasNext()) {
            JsonToken token = reader.peek();
            if (token.equals(JsonToken.BEGIN_ARRAY)) {
                handleArray(reader);
            } else if (token.equals(JsonToken.END_OBJECT)) {
                reader.endObject();
                return;
            } else {
                handleNonArrayToken(reader, token);
            }
        }

    }

    /**
     * Handle a json array. The first token would be JsonToken.BEGIN_ARRAY.
     * Arrays may contain objects or primitives.
     *
     * @param reader
     * @throws IOException
     */
    public static void handleArray(JsonReader reader) throws IOException {
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
            } else {
                handleNonArrayToken(reader, token);
            }
        }
    }

    /**
     * Handle non array non object tokens
     *
     * @param reader
     * @param token
     * @throws IOException
     */
    public static void handleNonArrayToken(JsonReader reader, JsonToken token) throws IOException {
        if (token.equals(JsonToken.NAME)) {
            String name = reader.nextName();
            if (name.equals("title")) {
                String title = reader.nextString();
                System.out.println(title);
            } else if (name.equals("description")) {
                String desc = reader.nextString();

                System.out.println(desc);
            } else if (name.equals("url")) {
                String url = reader.nextString();

                System.out.println(url);
            } else {
            }

//        } else if (token.equals(JsonToken.STRING)) {
//            System.out.println(reader.nextString());
//        } else if (token.equals(JsonToken.NUMBER)) {
//            System.out.println(reader.nextDouble());
        } else {
            reader.skipValue();
        }
    }

}
