package defpackage;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;
import com.google.gson.LongSerializationPolicy;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.MalformedJsonException;
import java.io.EOFException;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicLongArray;

/* compiled from: Gson */
public final class aih {
    final aik a;
    final aiq b;
    private final ThreadLocal<Map<aju<?>, aih$a<?>>> c;
    private final Map<aju<?>, air<?>> d;
    private final List<ais> e;
    private final aiz f;
    private final boolean g;
    private final boolean h;
    private final boolean i;
    private final boolean j;
    private final boolean k;

    public aih() {
        this(aja.a, FieldNamingPolicy.a, Collections.emptyMap(), false, false, false, true, false, false, false, LongSerializationPolicy.a, Collections.emptyList());
    }

    aih(aja excluder, aig fieldNamingPolicy, Map<Type, aii<?>> instanceCreators, boolean serializeNulls, boolean complexMapKeySerialization, boolean generateNonExecutableGson, boolean htmlSafe, boolean prettyPrinting, boolean lenient, boolean serializeSpecialFloatingPointValues, LongSerializationPolicy longSerializationPolicy, List<ais> typeAdapterFactories) {
        this.c = new ThreadLocal();
        this.d = Collections.synchronizedMap(new HashMap());
        this.a = new aih$1(this);
        this.b = new aih$2(this);
        this.f = new aiz(instanceCreators);
        this.g = serializeNulls;
        this.i = generateNonExecutableGson;
        this.h = htmlSafe;
        this.j = prettyPrinting;
        this.k = lenient;
        List<ais> factories = new ArrayList();
        factories.add(ajs.Y);
        factories.add(ajn.a);
        factories.add(excluder);
        factories.addAll(typeAdapterFactories);
        factories.add(ajs.D);
        factories.add(ajs.m);
        factories.add(ajs.g);
        factories.add(ajs.i);
        factories.add(ajs.k);
        air longAdapter = aih.a(longSerializationPolicy);
        factories.add(ajs.a(Long.TYPE, Long.class, longAdapter));
        factories.add(ajs.a(Double.TYPE, Double.class, a(serializeSpecialFloatingPointValues)));
        factories.add(ajs.a(Float.TYPE, Float.class, b(serializeSpecialFloatingPointValues)));
        factories.add(ajs.x);
        factories.add(ajs.o);
        factories.add(ajs.q);
        factories.add(ajs.a(AtomicLong.class, aih.a(longAdapter)));
        factories.add(ajs.a(AtomicLongArray.class, aih.b(longAdapter)));
        factories.add(ajs.s);
        factories.add(ajs.z);
        factories.add(ajs.F);
        factories.add(ajs.H);
        factories.add(ajs.a(BigDecimal.class, ajs.B));
        factories.add(ajs.a(BigInteger.class, ajs.C));
        factories.add(ajs.J);
        factories.add(ajs.L);
        factories.add(ajs.P);
        factories.add(ajs.R);
        factories.add(ajs.W);
        factories.add(ajs.N);
        factories.add(ajs.d);
        factories.add(aji.a);
        factories.add(ajs.U);
        factories.add(ajq.a);
        factories.add(ajp.a);
        factories.add(ajs.S);
        factories.add(ajg.a);
        factories.add(ajs.b);
        factories.add(new ajh(this.f));
        factories.add(new ajm(this.f, complexMapKeySerialization));
        factories.add(new ajj(this.f));
        factories.add(ajs.Z);
        factories.add(new ajo(this.f, fieldNamingPolicy, excluder));
        this.e = Collections.unmodifiableList(factories);
    }

    private air<Number> a(boolean serializeSpecialFloatingPointValues) {
        if (serializeSpecialFloatingPointValues) {
            return ajs.v;
        }
        return new aih$3(this);
    }

    private air<Number> b(boolean serializeSpecialFloatingPointValues) {
        if (serializeSpecialFloatingPointValues) {
            return ajs.u;
        }
        return new aih$4(this);
    }

    static void a(double value) {
        if (Double.isNaN(value) || Double.isInfinite(value)) {
            throw new IllegalArgumentException(value + " is not a valid double value as per JSON specification. To override this" + " behavior, use GsonBuilder.serializeSpecialFloatingPointValues() method.");
        }
    }

    private static air<Number> a(LongSerializationPolicy longSerializationPolicy) {
        if (longSerializationPolicy == LongSerializationPolicy.a) {
            return ajs.t;
        }
        return new aih$5();
    }

    private static air<AtomicLong> a(air<Number> longAdapter) {
        return new aih$6(longAdapter).a();
    }

    private static air<AtomicLongArray> b(air<Number> longAdapter) {
        return new aih$7(longAdapter).a();
    }

    public <T> air<T> a(aju<T> type) {
        air<?> cached = (air) this.d.get(type);
        if (cached != null) {
            return cached;
        }
        Map<aju<?>, aih$a<?>> threadCalls = (Map) this.c.get();
        boolean requiresThreadLocalCleanup = false;
        if (threadCalls == null) {
            threadCalls = new HashMap();
            this.c.set(threadCalls);
            requiresThreadLocalCleanup = true;
        }
        air ongoingCall = (aih$a) threadCalls.get(type);
        if (ongoingCall != null) {
            return ongoingCall;
        }
        try {
            aih$a<T> call = new aih$a();
            threadCalls.put(type, call);
            for (ais factory : this.e) {
                air<T> candidate = factory.a(this, type);
                if (candidate != null) {
                    call.a(candidate);
                    this.d.put(type, candidate);
                    return candidate;
                }
            }
            throw new IllegalArgumentException("GSON cannot handle " + type);
        } finally {
            threadCalls.remove(type);
            if (requiresThreadLocalCleanup) {
                this.c.remove();
            }
        }
    }

    public <T> air<T> a(ais skipPast, aju<T> type) {
        boolean skipPastFound = false;
        if (!this.e.contains(skipPast)) {
            skipPastFound = true;
        }
        for (ais factory : this.e) {
            if (skipPastFound) {
                air<T> candidate = factory.a(this, type);
                if (candidate != null) {
                    return candidate;
                }
            } else if (factory == skipPast) {
                skipPastFound = true;
            }
        }
        throw new IllegalArgumentException("GSON cannot serialize " + type);
    }

    public <T> air<T> a(Class<T> type) {
        return a(aju.get((Class) type));
    }

    public String a(Object src) {
        if (src == null) {
            return a(aim.a);
        }
        return a(src, src.getClass());
    }

    public String a(Object src, Type typeOfSrc) {
        Appendable writer = new StringWriter();
        a(src, typeOfSrc, writer);
        return writer.toString();
    }

    public void a(Object src, Type typeOfSrc, Appendable writer) throws JsonIOException {
        try {
            a(src, typeOfSrc, a(aje.a(writer)));
        } catch (IOException e) {
            throw new JsonIOException(e);
        }
    }

    public void a(Object src, Type typeOfSrc, ajw writer) throws JsonIOException {
        air<?> adapter = a(aju.get(typeOfSrc));
        boolean oldLenient = writer.g();
        writer.b(true);
        boolean oldHtmlSafe = writer.h();
        writer.c(this.h);
        boolean oldSerializeNulls = writer.i();
        writer.d(this.g);
        try {
            adapter.a(writer, src);
            writer.b(oldLenient);
            writer.c(oldHtmlSafe);
            writer.d(oldSerializeNulls);
        } catch (IOException e) {
            throw new JsonIOException(e);
        } catch (Throwable th) {
            writer.b(oldLenient);
            writer.c(oldHtmlSafe);
            writer.d(oldSerializeNulls);
        }
    }

    public String a(ail jsonElement) {
        Appendable writer = new StringWriter();
        a(jsonElement, writer);
        return writer.toString();
    }

    public void a(ail jsonElement, Appendable writer) throws JsonIOException {
        try {
            a(jsonElement, a(aje.a(writer)));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public ajw a(Writer writer) throws IOException {
        if (this.i) {
            writer.write(")]}'\n");
        }
        ajw jsonWriter = new ajw(writer);
        if (this.j) {
            jsonWriter.c("  ");
        }
        jsonWriter.d(this.g);
        return jsonWriter;
    }

    public ajv a(Reader reader) {
        ajv jsonReader = new ajv(reader);
        jsonReader.a(this.k);
        return jsonReader;
    }

    public void a(ail jsonElement, ajw writer) throws JsonIOException {
        boolean oldLenient = writer.g();
        writer.b(true);
        boolean oldHtmlSafe = writer.h();
        writer.c(this.h);
        boolean oldSerializeNulls = writer.i();
        writer.d(this.g);
        try {
            aje.a(jsonElement, writer);
            writer.b(oldLenient);
            writer.c(oldHtmlSafe);
            writer.d(oldSerializeNulls);
        } catch (IOException e) {
            throw new JsonIOException(e);
        } catch (Throwable th) {
            writer.b(oldLenient);
            writer.c(oldHtmlSafe);
            writer.d(oldSerializeNulls);
        }
    }

    public <T> T a(String json, Class<T> classOfT) throws JsonSyntaxException {
        return ajd.a((Class) classOfT).cast(a(json, (Type) classOfT));
    }

    public <T> T a(String json, Type typeOfT) throws JsonSyntaxException {
        if (json == null) {
            return null;
        }
        return a(new StringReader(json), typeOfT);
    }

    public <T> T a(Reader json, Type typeOfT) throws JsonIOException, JsonSyntaxException {
        ajv jsonReader = a(json);
        Object object = a(jsonReader, typeOfT);
        aih.a(object, jsonReader);
        return object;
    }

    private static void a(Object obj, ajv reader) {
        if (obj != null) {
            try {
                if (reader.f() != JsonToken.j) {
                    throw new JsonIOException("JSON document was not fully consumed.");
                }
            } catch (MalformedJsonException e) {
                throw new JsonSyntaxException(e);
            } catch (IOException e2) {
                throw new JsonIOException(e2);
            }
        }
    }

    public <T> T a(ajv reader, Type typeOfT) throws JsonIOException, JsonSyntaxException {
        boolean isEmpty = true;
        boolean oldLenient = reader.p();
        reader.a(true);
        try {
            reader.f();
            isEmpty = false;
            T object = a(aju.get(typeOfT)).b(reader);
            reader.a(oldLenient);
            return object;
        } catch (EOFException e) {
            if (isEmpty) {
                reader.a(oldLenient);
                return null;
            }
            throw new JsonSyntaxException(e);
        } catch (IllegalStateException e2) {
            throw new JsonSyntaxException(e2);
        } catch (IOException e3) {
            throw new JsonSyntaxException(e3);
        } catch (Throwable th) {
            reader.a(oldLenient);
        }
    }

    public <T> T a(ail json, Class<T> classOfT) throws JsonSyntaxException {
        return ajd.a((Class) classOfT).cast(a(json, (Type) classOfT));
    }

    public <T> T a(ail json, Type typeOfT) throws JsonSyntaxException {
        if (json == null) {
            return null;
        }
        return a(new ajk(json), typeOfT);
    }

    public String toString() {
        return "{serializeNulls:" + this.g + "factories:" + this.e + ",instanceCreators:" + this.f + "}";
    }
}
