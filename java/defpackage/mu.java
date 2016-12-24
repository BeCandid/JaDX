package defpackage;

import android.util.Log;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* compiled from: StreamEncoder */
public class mu implements km<InputStream> {
    public boolean a(InputStream data, OutputStream os) {
        byte[] buffer = rb.a().b();
        while (true) {
            try {
                int read = data.read(buffer);
                if (read != -1) {
                    os.write(buffer, 0, read);
                } else {
                    rb.a().a(buffer);
                    return true;
                }
            } catch (IOException e) {
                if (Log.isLoggable("StreamEncoder", 3)) {
                    Log.d("StreamEncoder", "Failed to encode data onto the OutputStream", e);
                }
                rb.a().a(buffer);
                return false;
            } catch (Throwable th) {
                rb.a().a(buffer);
            }
        }
    }

    public String a() {
        return "";
    }
}
