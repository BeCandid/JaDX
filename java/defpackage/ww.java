package defpackage;

import com.facebook.share.model.ShareOpenGraphAction;
import com.facebook.share.model.ShareOpenGraphObject;
import com.facebook.share.model.SharePhoto;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: OpenGraphJSONUtility */
public final class ww {
    public static JSONObject a(ShareOpenGraphAction action, ww$a photoJSONProcessor) throws JSONException {
        JSONObject result = new JSONObject();
        for (String key : action.c()) {
            result.put(key, ww.a(action.a(key), photoJSONProcessor));
        }
        return result;
    }

    private static JSONObject a(ShareOpenGraphObject object, ww$a photoJSONProcessor) throws JSONException {
        JSONObject result = new JSONObject();
        for (String key : object.c()) {
            result.put(key, ww.a(object.a(key), photoJSONProcessor));
        }
        return result;
    }

    private static JSONArray a(List list, ww$a photoJSONProcessor) throws JSONException {
        JSONArray result = new JSONArray();
        for (Object item : list) {
            result.put(ww.a(item, photoJSONProcessor));
        }
        return result;
    }

    public static Object a(Object object, ww$a photoJSONProcessor) throws JSONException {
        if (object == null) {
            return JSONObject.NULL;
        }
        if ((object instanceof String) || (object instanceof Boolean) || (object instanceof Double) || (object instanceof Float) || (object instanceof Integer) || (object instanceof Long)) {
            return object;
        }
        if (object instanceof SharePhoto) {
            if (photoJSONProcessor != null) {
                return photoJSONProcessor.a((SharePhoto) object);
            }
            return null;
        } else if (object instanceof ShareOpenGraphObject) {
            return ww.a((ShareOpenGraphObject) object, photoJSONProcessor);
        } else {
            if (object instanceof List) {
                return ww.a((List) object, photoJSONProcessor);
            }
            throw new IllegalArgumentException("Invalid object found for JSON serialization: " + object.toString());
        }
    }
}
