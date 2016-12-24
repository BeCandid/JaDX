package defpackage;

import java.io.File;
import java.io.InputStream;

/* compiled from: StreamFileDataLoadProvider */
class ol$a implements kp<InputStream, File> {
    private ol$a() {
    }

    public lj<File> a(InputStream source, int width, int height) {
        throw new Error("You cannot decode a File from an InputStream by default, try either #diskCacheStratey(DiskCacheStrategy.SOURCE) to avoid this call or #decoder(ResourceDecoder) to replace this Decoder");
    }

    public String a() {
        return "";
    }
}
