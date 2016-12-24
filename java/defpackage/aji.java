package defpackage;

import com.google.gson.JsonSyntaxException;
import com.google.gson.stream.JsonToken;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.util.Date;
import java.util.Locale;

/* compiled from: DateTypeAdapter */
public final class aji extends air<Date> {
    public static final ais a = new aji$1();
    private final DateFormat b = DateFormat.getDateTimeInstance(2, 2, Locale.US);
    private final DateFormat c = DateFormat.getDateTimeInstance(2, 2);

    public /* synthetic */ Object b(ajv ajv) throws IOException {
        return a(ajv);
    }

    public Date a(ajv in) throws IOException {
        if (in.f() != JsonToken.i) {
            return a(in.h());
        }
        in.j();
        return null;
    }

    private synchronized Date a(String json) {
        Date parse;
        try {
            parse = this.c.parse(json);
        } catch (ParseException e) {
            try {
                parse = this.b.parse(json);
            } catch (ParseException e2) {
                try {
                    parse = ajt.a(json, new ParsePosition(0));
                } catch (ParseException e3) {
                    throw new JsonSyntaxException(json, e3);
                }
            }
        }
        return parse;
    }

    public synchronized void a(ajw out, Date value) throws IOException {
        if (value == null) {
            out.f();
        } else {
            out.b(this.b.format(value));
        }
    }
}
