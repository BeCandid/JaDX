package defpackage;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.net.Uri;
import android.util.Log;
import com.facebook.FacebookException;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

/* compiled from: NativeAppCallAttachmentStore */
public final class vy {
    private static final String a = vy.class.getName();
    private static File b;

    private vy() {
    }

    public static vy$a a(UUID callId, Bitmap attachmentBitmap) {
        wf.a((Object) callId, "callId");
        wf.a((Object) attachmentBitmap, "attachmentBitmap");
        return new vy$a(callId, attachmentBitmap, null, null);
    }

    public static vy$a a(UUID callId, Uri attachmentUri) {
        wf.a((Object) callId, "callId");
        wf.a((Object) attachmentUri, "attachmentUri");
        return new vy$a(callId, null, attachmentUri, null);
    }

    private static void a(Bitmap bitmap, File outputFile) throws IOException {
        Closeable outputStream = new FileOutputStream(outputFile);
        try {
            bitmap.compress(CompressFormat.JPEG, 100, outputStream);
        } finally {
            we.a(outputStream);
        }
    }

    private static void a(Uri imageUri, boolean isContentUri, File outputFile) throws IOException {
        InputStream inputStream;
        Closeable outputStream = new FileOutputStream(outputFile);
        if (isContentUri) {
            inputStream = ul.f().getContentResolver().openInputStream(imageUri);
        } else {
            try {
                inputStream = new FileInputStream(imageUri.getPath());
            } catch (Throwable th) {
                we.a(outputStream);
            }
        }
        we.a(inputStream, (OutputStream) outputStream);
        we.a(outputStream);
    }

    public static void a(Collection<vy$a> attachments) {
        File file;
        if (attachments != null && attachments.size() != 0) {
            if (b == null) {
                vy.c();
            }
            vy.b();
            List<File> filesToCleanup = new ArrayList();
            try {
                for (vy$a attachment : attachments) {
                    if (attachment.g) {
                        file = vy.a(attachment.a, attachment.c, true);
                        filesToCleanup.add(file);
                        if (attachment.d != null) {
                            vy.a(attachment.d, file);
                        } else if (attachment.e != null) {
                            vy.a(attachment.e, attachment.f, file);
                        }
                    }
                }
            } catch (Throwable exception) {
                Log.e(a, "Got unexpected exception:" + exception);
                for (File file2 : filesToCleanup) {
                    try {
                        file2.delete();
                    } catch (Exception e) {
                    }
                }
                throw new FacebookException(exception);
            }
        }
    }

    public static void a(UUID callId) {
        File dir = vy.a(callId, false);
        if (dir != null) {
            we.a(dir);
        }
    }

    public static File a(UUID callId, String attachmentName) throws FileNotFoundException {
        if (we.a(attachmentName) || callId == null) {
            throw new FileNotFoundException();
        }
        try {
            return vy.a(callId, attachmentName, false);
        } catch (IOException e) {
            throw new FileNotFoundException();
        }
    }

    static synchronized File a() {
        File file;
        synchronized (vy.class) {
            if (b == null) {
                b = new File(ul.f().getCacheDir(), "com.facebook.NativeAppCallAttachmentStore.files");
            }
            file = b;
        }
        return file;
    }

    static File b() {
        File dir = vy.a();
        dir.mkdirs();
        return dir;
    }

    static File a(UUID callId, boolean create) {
        if (b == null) {
            return null;
        }
        File dir = new File(b, callId.toString());
        if (!create || dir.exists()) {
            return dir;
        }
        dir.mkdirs();
        return dir;
    }

    static File a(UUID callId, String attachmentName, boolean createDirs) throws IOException {
        File dir = vy.a(callId, createDirs);
        if (dir == null) {
            return null;
        }
        try {
            return new File(dir, URLEncoder.encode(attachmentName, "UTF-8"));
        } catch (UnsupportedEncodingException e) {
            return null;
        }
    }

    public static void c() {
        we.a(vy.a());
    }
}
