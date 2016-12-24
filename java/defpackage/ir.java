package defpackage;

import com.becandid.candid.data.DataUtil;
import java.io.IOException;
import java.io.StringReader;
import okhttp3.ResponseBody;
import retrofit2.Converter;

/* compiled from: DecodingGsonResponseBodyConverter */
public class ir<T> implements Converter<ResponseBody, T> {
    private final aih a;
    private final air<T> b;

    public /* synthetic */ Object convert(Object obj) throws IOException {
        return a((ResponseBody) obj);
    }

    ir(aih gson, air<T> adapter) {
        this.a = gson;
        this.b = adapter;
    }

    public T a(ResponseBody value) throws IOException {
        try {
            T b = this.b.b(this.a.a(new StringReader(DataUtil.decodeIds(value.string()))));
            return b;
        } finally {
            value.close();
        }
    }
}
