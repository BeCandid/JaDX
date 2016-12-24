package defpackage;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: GifResourceDecoder */
public class ou implements kp<InputStream, on> {
    private static final ou$b a = new ou$b();
    private static final ou$a b = new ou$a();
    private final Context c;
    private final ou$b d;
    private final ln e;
    private final ou$a f;
    private final om g;

    public ou(Context context, ln bitmapPool) {
        this(context, bitmapPool, a, b);
    }

    ou(Context context, ln bitmapPool, ou$b parserPool, ou$a decoderPool) {
        this.c = context;
        this.e = bitmapPool;
        this.f = decoderPool;
        this.g = new om(bitmapPool);
        this.d = parserPool;
    }

    public op a(InputStream source, int width, int height) {
        byte[] data = ou.a(source);
        kg parser = this.d.a(data);
        kd decoder = this.f.a(this.g);
        try {
            op a = a(data, width, height, parser, decoder);
            return a;
        } finally {
            this.d.a(parser);
            this.f.a(decoder);
        }
    }

    private op a(byte[] data, int width, int height, kg parser, kd decoder) {
        kf header = parser.b();
        if (header.a() <= 0 || header.b() != 0) {
            return null;
        }
        Bitmap firstFrame = a(decoder, header, data);
        if (firstFrame == null) {
            return null;
        }
        return new op(new on(this.c, this.g, this.e, no.b(), width, height, header, data, firstFrame));
    }

    private Bitmap a(kd decoder, kf header, byte[] data) {
        decoder.a(header, data);
        decoder.a();
        return decoder.f();
    }

    public String a() {
        return "";
    }

    private static byte[] a(InputStream is) {
        ByteArrayOutputStream buffer = new ByteArrayOutputStream(16384);
        try {
            byte[] data = new byte[16384];
            while (true) {
                int nRead = is.read(data);
                if (nRead == -1) {
                    break;
                }
                buffer.write(data, 0, nRead);
            }
            buffer.flush();
        } catch (IOException e) {
            Log.w("GifResourceDecoder", "Error reading data from stream", e);
        }
        return buffer.toByteArray();
    }
}
