package defpackage;

import java.util.Arrays;
import java.util.Collection;

/* compiled from: MultiTransformation */
public class ko<T> implements kr<T> {
    private final Collection<? extends kr<T>> a;
    private String b;

    @SafeVarargs
    public ko(kr<T>... transformations) {
        if (transformations.length < 1) {
            throw new IllegalArgumentException("MultiTransformation must contain at least one Transformation");
        }
        this.a = Arrays.asList(transformations);
    }

    public lj<T> a(lj<T> resource, int outWidth, int outHeight) {
        lj<T> previous = resource;
        for (kr<T> transformation : this.a) {
            lj<T> transformed = transformation.a(previous, outWidth, outHeight);
            if (!(previous == null || previous.equals(resource) || previous.equals(transformed))) {
                previous.d();
            }
            previous = transformed;
        }
        return previous;
    }

    public String a() {
        if (this.b == null) {
            StringBuilder sb = new StringBuilder();
            for (kr<T> transformation : this.a) {
                sb.append(transformation.a());
            }
            this.b = sb.toString();
        }
        return this.b;
    }
}
