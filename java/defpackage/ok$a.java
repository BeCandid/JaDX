package defpackage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

/* compiled from: FileToStreamDecoder */
class ok$a {
    ok$a() {
    }

    public InputStream a(File file) throws FileNotFoundException {
        return new FileInputStream(file);
    }
}
