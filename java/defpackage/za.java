package defpackage;

import java.util.Iterator;

public class za {
    private final String a;

    private za(String str) {
        this.a = str;
    }

    public static za a(String str) {
        return new za(str);
    }

    CharSequence a(Object obj) {
        return obj instanceof CharSequence ? (CharSequence) obj : obj.toString();
    }

    public final String a(Iterable<?> iterable) {
        return a(new StringBuilder(), iterable).toString();
    }

    public final StringBuilder a(StringBuilder stringBuilder, Iterable<?> iterable) {
        Iterator it = iterable.iterator();
        if (it.hasNext()) {
            stringBuilder.append(a(it.next()));
            while (it.hasNext()) {
                stringBuilder.append(this.a);
                stringBuilder.append(a(it.next()));
            }
        }
        return stringBuilder;
    }
}
