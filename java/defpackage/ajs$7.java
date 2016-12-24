package defpackage;

import com.google.gson.JsonSyntaxException;
import com.google.gson.stream.JsonToken;
import java.io.IOException;

/* compiled from: TypeAdapters */
class ajs$7 extends air<Character> {
    ajs$7() {
    }

    public /* synthetic */ Object b(ajv ajv) throws IOException {
        return a(ajv);
    }

    public Character a(ajv in) throws IOException {
        if (in.f() == JsonToken.i) {
            in.j();
            return null;
        }
        String str = in.h();
        if (str.length() == 1) {
            return Character.valueOf(str.charAt(0));
        }
        throw new JsonSyntaxException("Expecting character, got: " + str);
    }

    public void a(ajw out, Character value) throws IOException {
        out.b(value == null ? null : String.valueOf(value));
    }
}
