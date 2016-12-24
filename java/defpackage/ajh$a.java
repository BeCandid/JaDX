package defpackage;

import com.google.gson.stream.JsonToken;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Collection;

/* compiled from: CollectionTypeAdapterFactory */
final class ajh$a<E> extends air<Collection<E>> {
    private final air<E> a;
    private final ajc<? extends Collection<E>> b;

    public /* synthetic */ Object b(ajv ajv) throws IOException {
        return a(ajv);
    }

    public ajh$a(aih context, Type elementType, air<E> elementTypeAdapter, ajc<? extends Collection<E>> constructor) {
        this.a = new ajr(context, elementTypeAdapter, elementType);
        this.b = constructor;
    }

    public Collection<E> a(ajv in) throws IOException {
        if (in.f() == JsonToken.i) {
            in.j();
            return null;
        }
        Collection<E> collection = (Collection) this.b.a();
        in.a();
        while (in.e()) {
            collection.add(this.a.b(in));
        }
        in.b();
        return collection;
    }

    public void a(ajw out, Collection<E> collection) throws IOException {
        if (collection == null) {
            out.f();
            return;
        }
        out.b();
        for (E element : collection) {
            this.a.a(out, element);
        }
        out.c();
    }
}
