package defpackage;

import com.google.gson.JsonSyntaxException;
import com.google.gson.stream.JsonToken;
import java.io.IOException;
import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/* compiled from: TimeTypeAdapter */
public final class ajq extends air<Time> {
    public static final ais a = new ajq$1();
    private final DateFormat b = new SimpleDateFormat("hh:mm:ss a");

    public /* synthetic */ Object b(ajv ajv) throws IOException {
        return a(ajv);
    }

    public synchronized Time a(ajv in) throws IOException {
        Time time;
        if (in.f() == JsonToken.i) {
            in.j();
            time = null;
        } else {
            try {
                time = new Time(this.b.parse(in.h()).getTime());
            } catch (ParseException e) {
                throw new JsonSyntaxException(e);
            }
        }
        return time;
    }

    public synchronized void a(ajw out, Time value) throws IOException {
        out.b(value == null ? null : this.b.format(value));
    }
}
