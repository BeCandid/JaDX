package defpackage;

import java.util.Map;
import okhttp3.RequestBody;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.PartMap;

/* compiled from: ApiService */
interface ik$b {
    @POST("/likes.images")
    @Multipart
    apl<String> a(@PartMap Map<String, String> map, @Part("File") RequestBody requestBody);
}
