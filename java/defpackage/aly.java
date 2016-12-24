package defpackage;

import java.io.Closeable;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.util.NoSuchElementException;
import java.util.logging.Level;
import java.util.logging.Logger;

/* compiled from: QueueFile */
public class aly implements Closeable {
    private static final Logger b = Logger.getLogger(aly.class.getName());
    int a;
    private final RandomAccessFile c;
    private int d;
    private aly$a e;
    private aly$a f;
    private final byte[] g = new byte[16];

    public aly(File file) throws IOException {
        if (!file.exists()) {
            aly.a(file);
        }
        this.c = aly.b(file);
        e();
    }

    private static void b(byte[] buffer, int offset, int value) {
        buffer[offset] = (byte) (value >> 24);
        buffer[offset + 1] = (byte) (value >> 16);
        buffer[offset + 2] = (byte) (value >> 8);
        buffer[offset + 3] = (byte) value;
    }

    private static void a(byte[] buffer, int... values) {
        int offset = 0;
        for (int value : values) {
            aly.b(buffer, offset, value);
            offset += 4;
        }
    }

    private static int a(byte[] buffer, int offset) {
        return ((((buffer[offset] & 255) << 24) + ((buffer[offset + 1] & 255) << 16)) + ((buffer[offset + 2] & 255) << 8)) + (buffer[offset + 3] & 255);
    }

    private void e() throws IOException {
        this.c.seek(0);
        this.c.readFully(this.g);
        this.a = aly.a(this.g, 0);
        if (((long) this.a) > this.c.length()) {
            throw new IOException("File is truncated. Expected length: " + this.a + ", Actual length: " + this.c.length());
        }
        this.d = aly.a(this.g, 4);
        int firstOffset = aly.a(this.g, 8);
        int lastOffset = aly.a(this.g, 12);
        this.e = a(firstOffset);
        this.f = a(lastOffset);
    }

    private void a(int fileLength, int elementCount, int firstPosition, int lastPosition) throws IOException {
        aly.a(this.g, fileLength, elementCount, firstPosition, lastPosition);
        this.c.seek(0);
        this.c.write(this.g);
    }

    private aly$a a(int position) throws IOException {
        if (position == 0) {
            return aly$a.a;
        }
        this.c.seek((long) position);
        return new aly$a(position, this.c.readInt());
    }

    private static void a(File file) throws IOException {
        File tempFile = new File(file.getPath() + ".tmp");
        RandomAccessFile raf = aly.b(tempFile);
        try {
            raf.setLength(4096);
            raf.seek(0);
            byte[] headerBuffer = new byte[16];
            aly.a(headerBuffer, 4096, 0, 0, 0);
            raf.write(headerBuffer);
            if (!tempFile.renameTo(file)) {
                throw new IOException("Rename failed!");
            }
        } finally {
            raf.close();
        }
    }

    private static RandomAccessFile b(File file) throws FileNotFoundException {
        return new RandomAccessFile(file, "rwd");
    }

    private int b(int position) {
        return position < this.a ? position : (position + 16) - this.a;
    }

    private void a(int position, byte[] buffer, int offset, int count) throws IOException {
        position = b(position);
        if (position + count <= this.a) {
            this.c.seek((long) position);
            this.c.write(buffer, offset, count);
            return;
        }
        int beforeEof = this.a - position;
        this.c.seek((long) position);
        this.c.write(buffer, offset, beforeEof);
        this.c.seek(16);
        this.c.write(buffer, offset + beforeEof, count - beforeEof);
    }

    private void b(int position, byte[] buffer, int offset, int count) throws IOException {
        position = b(position);
        if (position + count <= this.a) {
            this.c.seek((long) position);
            this.c.readFully(buffer, offset, count);
            return;
        }
        int beforeEof = this.a - position;
        this.c.seek((long) position);
        this.c.readFully(buffer, offset, beforeEof);
        this.c.seek(16);
        this.c.readFully(buffer, offset + beforeEof, count - beforeEof);
    }

    public void a(byte[] data) throws IOException {
        a(data, 0, data.length);
    }

    public synchronized void a(byte[] data, int offset, int count) throws IOException {
        aly.b(data, "buffer");
        if ((offset | count) < 0 || count > data.length - offset) {
            throw new IndexOutOfBoundsException();
        }
        int position;
        c(count);
        boolean wasEmpty = b();
        if (wasEmpty) {
            position = 16;
        } else {
            position = b((this.f.b + 4) + this.f.c);
        }
        aly$a newLast = new aly$a(position, count);
        aly.b(this.g, 0, count);
        a(newLast.b, this.g, 0, 4);
        a(newLast.b + 4, data, offset, count);
        a(this.a, this.d + 1, wasEmpty ? newLast.b : this.e.b, newLast.b);
        this.f = newLast;
        this.d++;
        if (wasEmpty) {
            this.e = this.f;
        }
    }

    public int a() {
        if (this.d == 0) {
            return 16;
        }
        if (this.f.b >= this.e.b) {
            return (((this.f.b - this.e.b) + 4) + this.f.c) + 16;
        }
        return (((this.f.b + 4) + this.f.c) + this.a) - this.e.b;
    }

    private int f() {
        return this.a - a();
    }

    public synchronized boolean b() {
        return this.d == 0;
    }

    private void c(int dataLength) throws IOException {
        int elementLength = dataLength + 4;
        int remainingBytes = f();
        if (remainingBytes < elementLength) {
            int newLength;
            int previousLength = this.a;
            do {
                remainingBytes += previousLength;
                newLength = previousLength << 1;
                previousLength = newLength;
            } while (remainingBytes < elementLength);
            d(newLength);
            int endOfLastElement = b((this.f.b + 4) + this.f.c);
            if (endOfLastElement < this.e.b) {
                FileChannel channel = this.c.getChannel();
                channel.position((long) this.a);
                int count = endOfLastElement - 4;
                if (channel.transferTo(16, (long) count, channel) != ((long) count)) {
                    throw new AssertionError("Copied insufficient number of bytes!");
                }
            }
            if (this.f.b < this.e.b) {
                int newLastPosition = (this.a + this.f.b) - 16;
                a(newLength, this.d, this.e.b, newLastPosition);
                this.f = new aly$a(newLastPosition, this.f.c);
            } else {
                a(newLength, this.d, this.e.b, this.f.b);
            }
            this.a = newLength;
        }
    }

    private void d(int newLength) throws IOException {
        this.c.setLength((long) newLength);
        this.c.getChannel().force(true);
    }

    public synchronized void a(aly$c reader) throws IOException {
        int position = this.e.b;
        for (int i = 0; i < this.d; i++) {
            aly$a current = a(position);
            reader.a(new aly$b(this, current, null), current.c);
            position = b((current.b + 4) + current.c);
        }
    }

    private static <T> T b(T t, String name) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(name);
    }

    public synchronized void c() throws IOException {
        if (b()) {
            throw new NoSuchElementException();
        } else if (this.d == 1) {
            d();
        } else {
            int newFirstPosition = b((this.e.b + 4) + this.e.c);
            b(newFirstPosition, this.g, 0, 4);
            int length = aly.a(this.g, 0);
            a(this.a, this.d - 1, newFirstPosition, this.f.b);
            this.d--;
            this.e = new aly$a(newFirstPosition, length);
        }
    }

    public synchronized void d() throws IOException {
        a(4096, 0, 0, 0);
        this.d = 0;
        this.e = aly$a.a;
        this.f = aly$a.a;
        if (this.a > 4096) {
            d(4096);
        }
        this.a = 4096;
    }

    public synchronized void close() throws IOException {
        this.c.close();
    }

    public boolean a(int dataSizeBytes, int maxSizeBytes) {
        return (a() + 4) + dataSizeBytes <= maxSizeBytes;
    }

    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(getClass().getSimpleName()).append('[');
        builder.append("fileLength=").append(this.a);
        builder.append(", size=").append(this.d);
        builder.append(", first=").append(this.e);
        builder.append(", last=").append(this.f);
        builder.append(", element lengths=[");
        try {
            a(new aly$1(this, builder));
        } catch (IOException e) {
            b.log(Level.WARNING, "read error", e);
        }
        builder.append("]]");
        return builder.toString();
    }
}
