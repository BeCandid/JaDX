package defpackage;

import com.facebook.AccessToken;
import com.facebook.FacebookException;
import com.facebook.FacebookRequestError;
import com.facebook.GraphRequest;
import com.facebook.LoggingBehavior;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

/* compiled from: GraphResponse */
public class uo {
    private final HttpURLConnection a;
    private final JSONObject b;
    private final JSONArray c;
    private final FacebookRequestError d;
    private final String e;
    private final GraphRequest f;

    uo(GraphRequest request, HttpURLConnection connection, String rawResponse, JSONObject graphObject) {
        this(request, connection, rawResponse, graphObject, null, null);
    }

    uo(GraphRequest request, HttpURLConnection connection, String rawResponse, JSONArray graphObjects) {
        this(request, connection, rawResponse, null, graphObjects, null);
    }

    uo(GraphRequest request, HttpURLConnection connection, FacebookRequestError error) {
        this(request, connection, null, null, null, error);
    }

    uo(GraphRequest request, HttpURLConnection connection, String rawResponse, JSONObject graphObject, JSONArray graphObjects, FacebookRequestError error) {
        this.f = request;
        this.a = connection;
        this.e = rawResponse;
        this.b = graphObject;
        this.c = graphObjects;
        this.d = error;
    }

    public final FacebookRequestError a() {
        return this.d;
    }

    public final JSONObject b() {
        return this.b;
    }

    public String toString() {
        String responseCode;
        try {
            Locale locale = Locale.US;
            String str = "%d";
            Object[] objArr = new Object[1];
            objArr[0] = Integer.valueOf(this.a != null ? this.a.getResponseCode() : 200);
            responseCode = String.format(locale, str, objArr);
        } catch (IOException e) {
            responseCode = "unknown";
        }
        return "{Response: " + " responseCode: " + responseCode + ", graphObject: " + this.b + ", error: " + this.d + "}";
    }

    public static List<uo> a(HttpURLConnection connection, un requests) {
        List<uo> a;
        Closeable stream = null;
        try {
            if (connection.getResponseCode() >= 400) {
                stream = connection.getErrorStream();
            } else {
                stream = connection.getInputStream();
            }
            a = uo.a((InputStream) stream, connection, requests);
        } catch (FacebookException facebookException) {
            vx.a(LoggingBehavior.REQUESTS, "Response", "Response <Error>: %s", facebookException);
            a = uo.a((List) requests, connection, facebookException);
        } catch (Throwable exception) {
            vx.a(LoggingBehavior.REQUESTS, "Response", "Response <Error>: %s", exception);
            a = uo.a((List) requests, connection, new FacebookException(exception));
        } finally {
            we.a(stream);
        }
        return a;
    }

    static List<uo> a(InputStream stream, HttpURLConnection connection, un requests) throws FacebookException, JSONException, IOException {
        vx.a(LoggingBehavior.INCLUDE_RAW_RESPONSES, "Response", "Response (raw)\n  Size: %d\n  Response:\n%s\n", Integer.valueOf(we.a(stream).length()), responseString);
        return uo.a(we.a(stream), connection, requests);
    }

    static List<uo> a(String responseString, HttpURLConnection connection, un requests) throws FacebookException, JSONException, IOException {
        vx.a(LoggingBehavior.REQUESTS, "Response", "Response\n  Id: %s\n  Size: %d\n  Responses:\n%s\n", requests.b(), Integer.valueOf(responseString.length()), uo.a(connection, (List) requests, new JSONTokener(responseString).nextValue()));
        return uo.a(connection, (List) requests, new JSONTokener(responseString).nextValue());
    }

    private static List<uo> a(HttpURLConnection connection, List<GraphRequest> requests, Object object) throws FacebookException, JSONException {
        GraphRequest request;
        int numRequests = requests.size();
        List<uo> responses = new ArrayList(numRequests);
        Object originalResult = object;
        if (numRequests == 1) {
            request = (GraphRequest) requests.get(0);
            try {
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("body", object);
                jsonObject.put("code", connection != null ? connection.getResponseCode() : 200);
                JSONArray jsonArray = new JSONArray();
                jsonArray.put(jsonObject);
                object = jsonArray;
            } catch (Exception e) {
                responses.add(new uo(request, connection, new FacebookRequestError(connection, e)));
            } catch (Exception e2) {
                responses.add(new uo(request, connection, new FacebookRequestError(connection, e2)));
            }
        }
        if ((object instanceof JSONArray) && ((JSONArray) object).length() == numRequests) {
            jsonArray = (JSONArray) object;
            for (int i = 0; i < jsonArray.length(); i++) {
                request = (GraphRequest) requests.get(i);
                try {
                    responses.add(uo.a(request, connection, jsonArray.get(i), originalResult));
                } catch (Exception e22) {
                    responses.add(new uo(request, connection, new FacebookRequestError(connection, e22)));
                } catch (Exception e222) {
                    responses.add(new uo(request, connection, new FacebookRequestError(connection, e222)));
                }
            }
            return responses;
        }
        throw new FacebookException("Unexpected number of results");
    }

    private static uo a(GraphRequest request, HttpURLConnection connection, Object object, Object originalResult) throws JSONException {
        if (object instanceof JSONObject) {
            JSONObject jsonObject = (JSONObject) object;
            FacebookRequestError error = FacebookRequestError.a(jsonObject, originalResult, connection);
            if (error != null) {
                if (error.b() == 190 && we.a(request.f())) {
                    AccessToken.a(null);
                }
                return new uo(request, connection, error);
            }
            Object body = we.a(jsonObject, "body", "FACEBOOK_NON_JSON_RESULT");
            if (body instanceof JSONObject) {
                return new uo(request, connection, body.toString(), (JSONObject) body);
            }
            if (body instanceof JSONArray) {
                return new uo(request, connection, body.toString(), (JSONArray) body);
            }
            object = JSONObject.NULL;
        }
        if (object == JSONObject.NULL) {
            return new uo(request, connection, object.toString(), (JSONObject) null);
        }
        throw new FacebookException("Got unexpected object type in response, class: " + object.getClass().getSimpleName());
    }

    public static List<uo> a(List<GraphRequest> requests, HttpURLConnection connection, FacebookException error) {
        int count = requests.size();
        List<uo> responses = new ArrayList(count);
        for (int i = 0; i < count; i++) {
            responses.add(new uo((GraphRequest) requests.get(i), connection, new FacebookRequestError(connection, (Exception) error)));
        }
        return responses;
    }
}
