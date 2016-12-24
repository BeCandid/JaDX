package defpackage;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.logging.Logger;

/* compiled from: MetadataManager */
class aka {
    private static final Logger a = Logger.getLogger(aka.class.getName());
    private static final Map<Integer, akf$b> b = Collections.synchronizedMap(new HashMap());
    private static final Map<String, akf$b> c = Collections.synchronizedMap(new HashMap());
    private static final Set<Integer> d = ajx.a();
    private static final Set<String> e = ake.a();

    private aka() {
    }

    static akg a(ObjectInputStream in, int bufferSize) throws IOException {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        byte[] data = new byte[bufferSize];
        while (true) {
            int nRead = in.read(data, 0, bufferSize);
            if (nRead != -1) {
                outputStream.write(data, 0, nRead);
            } else {
                outputStream.flush();
                return akg.a(outputStream.toByteArray());
            }
        }
    }
}
