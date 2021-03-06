package defpackage;

import com.google.gson.JsonIOException;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSyntaxException;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.MalformedJsonException;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;

/* compiled from: JsonParser */
public final class aio {
    public ail a(String json) throws JsonSyntaxException {
        return a(new StringReader(json));
    }

    public ail a(Reader json) throws JsonIOException, JsonSyntaxException {
        try {
            ajv jsonReader = new ajv(json);
            ail element = a(jsonReader);
            if (element.l() || jsonReader.f() == JsonToken.j) {
                return element;
            }
            throw new JsonSyntaxException("Did not consume the entire document.");
        } catch (MalformedJsonException e) {
            throw new JsonSyntaxException(e);
        } catch (IOException e2) {
            throw new JsonIOException(e2);
        } catch (NumberFormatException e3) {
            throw new JsonSyntaxException(e3);
        }
    }

    public ail a(ajv json) throws JsonIOException, JsonSyntaxException {
        boolean lenient = json.p();
        json.a(true);
        try {
            ail a = aje.a(json);
            json.a(lenient);
            return a;
        } catch (StackOverflowError e) {
            throw new JsonParseException("Failed parsing JSON source: " + json + " to Json", e);
        } catch (OutOfMemoryError e2) {
            throw new JsonParseException("Failed parsing JSON source: " + json + " to Json", e2);
        } catch (Throwable th) {
            json.a(lenient);
        }
    }
}
