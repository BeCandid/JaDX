package defpackage;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Converter;
import retrofit2.Converter.Factory;
import retrofit2.Retrofit;

/* compiled from: DecodingGsonConverterFactory */
public final class iq extends Factory {
    private final aih a;

    public static iq a() {
        return iq.a(new aih());
    }

    public static iq a(aih gson) {
        return new iq(gson);
    }

    private iq(aih gson) {
        if (gson == null) {
            throw new NullPointerException("gson == null");
        }
        this.a = gson;
    }

    public Converter<ResponseBody, ?> responseBodyConverter(Type type, Annotation[] annotations, Retrofit retrofit) {
        return new ir(this.a, this.a.a(aju.get(type)));
    }

    public Converter<?, RequestBody> requestBodyConverter(Type type, Annotation[] parameterAnnotations, Annotation[] methodAnnotations, Retrofit retrofit) {
        return new iu(this.a, this.a.a(aju.get(type)));
    }
}
