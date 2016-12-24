package defpackage;

import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import android.util.Log;
import com.becandid.candid.GossipApplication;
import com.becandid.candid.data.AppState;
import com.becandid.candid.data.DataUtil;
import com.becandid.candid.data.EmptyClass;
import com.becandid.candid.data.FacebookInfo;
import com.becandid.candid.data.Group;
import com.becandid.candid.data.JavaNetCookieJar;
import com.becandid.candid.data.PersistentCookieStore;
import com.becandid.candid.data.Post;
import com.becandid.candid.models.GroupNameCheck;
import com.becandid.candid.models.NetworkData;
import com.becandid.candid.models.NetworkData.UploadResponse;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.InputStream;
import java.net.CookieManager;
import java.net.CookiePolicy;
import java.net.CookieStore;
import java.security.KeyStore;
import java.security.cert.Certificate;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManagerFactory;
import okhttp3.OkHttpClient.Builder;
import okhttp3.RequestBody;
import okhttp3.logging.HttpLoggingInterceptor;
import okhttp3.logging.HttpLoggingInterceptor.Level;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

/* compiled from: ApiService */
public class ik {
    public static CookieStore a;
    private static volatile ik b;
    private Retrofit c;
    private Retrofit d;
    private ik$a e;

    public static ik a() {
        if (b == null) {
            synchronized (ik.class) {
                if (b == null) {
                    b = new ik();
                }
            }
        }
        return b;
    }

    public ik() {
        if (this.c == null) {
            m(GossipApplication.d);
        }
        this.e = (ik$a) this.c.create(ik$a.class);
    }

    public void a(String baseUrl) {
        m(baseUrl);
        this.e = (ik$a) this.c.create(ik$a.class);
    }

    private void m(String baseUrl) {
        new HttpLoggingInterceptor().setLevel(Level.BODY);
        String userAgent = j();
        a = PersistentCookieStore.getCookieStore(GossipApplication.a().getApplicationContext());
        Builder builder = new Builder();
        if (AppState.config == null || AppState.config.getBoolean("use_limited_ca", true)) {
            SSLSocketFactory socketFactory = i();
            if (socketFactory != null) {
                builder.sslSocketFactory(socketFactory);
            }
        }
        builder.cookieJar(new JavaNetCookieJar(new CookieManager(a, CookiePolicy.ACCEPT_ALL)));
        builder.addInterceptor(new ik$c(this, userAgent));
        builder.addInterceptor(new ik$d(this));
        builder.connectTimeout(15, TimeUnit.SECONDS);
        builder.retryOnConnectionFailure(false);
        this.c = new Retrofit.Builder().baseUrl(baseUrl).addCallAdapterFactory(RxJavaCallAdapterFactory.create()).addConverterFactory(iq.a()).client(builder.build()).build();
    }

    private SSLSocketFactory i() {
        InputStream caInput;
        try {
            CertificateFactory cf = CertificateFactory.getInstance("X.509");
            caInput = new BufferedInputStream(GossipApplication.a().getAssets().open("AddTrustExternalCARoot.crt"));
            Certificate ca = cf.generateCertificate(caInput);
            Log.d("CA", ((X509Certificate) ca).getSubjectDN().toString());
            caInput.close();
            KeyStore keyStore = KeyStore.getInstance(KeyStore.getDefaultType());
            keyStore.load(null, null);
            keyStore.setCertificateEntry("ca", ca);
            TrustManagerFactory tmf = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
            tmf.init(keyStore);
            SSLContext context = SSLContext.getInstance("TLS");
            context.init(null, tmf.getTrustManagers(), null);
            return context.getSocketFactory();
        } catch (Throwable e) {
            rj.a(e);
            Log.d("SSLSocketFactory", e.toString());
            return null;
        } catch (Throwable th) {
            caInput.close();
        }
    }

    private String j() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("com.becandid.candid/1.6.9 ");
        stringBuilder.append("androidver/" + VERSION.RELEASE + " ");
        stringBuilder.append("model/" + Build.MODEL + " ");
        stringBuilder.append("ver_code/184 ");
        stringBuilder.append("make/" + Build.MANUFACTURER);
        return stringBuilder.toString();
    }

    public ik$b b(String domain) {
        String host = "s3.amazonaws.com";
        if (this.d == null || !this.d.baseUrl().host().equals(host)) {
            this.d = new Retrofit.Builder().baseUrl("https://" + host + "/").addConverterFactory(ScalarsConverterFactory.create()).addCallAdapterFactory(RxJavaCallAdapterFactory.create()).build();
        }
        return (ik$b) this.d.create(ik$b.class);
    }

    public apl<EmptyClass> a(Map<String, String> params) {
        return this.e.p(params).a(new ii("update user info failed"));
    }

    public apl<ain> b(Map<String, String> params) {
        return this.e.c((Map) params).a(new ii("new user hash failed"));
    }

    public apl<ain> c(Map<String, String> params) {
        return this.e.d((Map) params).a(new ii("sync friends failed"));
    }

    public apl<NetworkData> a(FacebookInfo fbInfo) {
        if (fbInfo.fbToken == null || fbInfo.fbToken.b() == null) {
            return null;
        }
        Map<String, String> fbJoinParams = new HashMap();
        fbJoinParams.put("fb_token", fbInfo.fbToken.b());
        if (fbInfo.schoolIds != null && fbInfo.schoolIds.size() > 0) {
            fbJoinParams.put("fb_school_ids", DataUtil.join(fbInfo.schoolIds));
        }
        if (fbInfo.jobIds != null && fbInfo.jobIds.size() > 0) {
            fbJoinParams.put("fb_job_ids", DataUtil.join(fbInfo.jobIds));
        }
        if (fbInfo.age != null) {
            fbJoinParams.put("age", fbInfo.age);
        }
        return this.e.f((Map) fbJoinParams).a(new ii("auto join facebook failed"));
    }

    public apl<NetworkData> a(int groupId, String minPostId) {
        return this.e.d(Integer.toString(groupId), minPostId, Integer.toString(k())).a(new ii("fetch group feed failed"));
    }

    public apl<EmptyClass> a(String data, String upId, String name) {
        String upsellId = "-7";
        if (upId == null || !upId.equals("0")) {
            upsellId = upId;
        }
        if (data == null) {
            return null;
        }
        return this.e.c(data, upsellId, name).a(new ii("invite contacts failed"));
    }

    public apl<NetworkData> a(String otpCode, String phoneNumber) {
        return this.e.d(otpCode, phoneNumber).b(new ik$1(this)).a(new ii("unable to verify phone number"));
    }

    public apl<EmptyClass> a(Post post, String reason) {
        if (reason == null) {
            reason = "owner";
        }
        return this.e.c(Integer.toString(post.post_id), reason).a(new ii("delete post failed"));
    }

    public apl<EmptyClass> b(Post post, String reason) {
        return this.e.a(Integer.toString(post.post_id), reason).a(new ii("report post failed"));
    }

    public apl<Post> b(String postId, String value, String isRumor) {
        return this.e.b(postId, value, isRumor).b(new ik$12(this)).a(new ii("like post failed"));
    }

    public apl<List<Post>> a(String feedType, String minPostId, String impressionLog, int relatedPostsPostId) {
        String type = feedType;
        if (feedType == null) {
            type = "home";
        }
        Map<String, String> params = new HashMap();
        if ("friends".equals(feedType)) {
            params.put("include_fb", "1");
            params.put("include_phone", "1");
        }
        if (!(impressionLog == null || impressionLog.isEmpty())) {
            params.put("seen_posts", impressionLog);
        }
        if (relatedPostsPostId > 0) {
            params.put("related_posts_post_id", Integer.toString(relatedPostsPostId));
        }
        params.put("include_comments", "1");
        params.put("num", Integer.toString(k()));
        return this.e.a(type, minPostId, (Map) params).b(new ik$18(this)).a(new ii("fetch feed failed"));
    }

    private int k() {
        if (AppState.config != null) {
            return AppState.config.getInt("android_num_posts_per_feed");
        }
        return 20;
    }

    public apl<GroupNameCheck> a(String groupName, boolean forCreatePost) {
        return this.e.a(groupName, forCreatePost ? 1 : 0).a(new ii("check group name failed"));
    }

    public apl<EmptyClass> c(String token) {
        return this.e.a(token, "android", "production").a(new ii("send GCM Token failed"));
    }

    public apl<Group> a(String groupName, String about, String tags, String sourceUrl) {
        return this.e.a(groupName, about, tags, sourceUrl).b(new ik$19(this)).a(new ii("create group failed"));
    }

    public apl<NetworkData> createPost(Post post, Map<String, String> linkParams) {
        HashMap<String, String> params = new HashMap();
        params.put("group_id", String.valueOf(post.group_id));
        if (post.caption != null) {
            params.put("caption", post.caption);
        }
        if (post.mentioned_groups_info != null) {
            params.put("mentioned_group_ids", post.mentioned_groups_info);
        }
        if (post.source_url != null) {
            params.put("source_url", post.source_url);
            params.put("width", String.valueOf(post.width));
            params.put("height", String.valueOf(post.height));
        }
        if (linkParams != null) {
            params.putAll(linkParams);
        }
        if (params.containsKey("source_url") && params.get("source_url") == null) {
            params.put("source_url", "");
        }
        if (post.friends_disabled == 1) {
            params.put("friends_disabled", "1");
        }
        return this.e.a((Map) params).b(new ik$20(this)).a(new ii("create post failed"));
    }

    public apl<Map<String, String>> d(String url) {
        return this.e.a(url).b(new ik$21(this)).a(new ii("Unable to get post info"));
    }

    public apl<Post> d(Map<String, String> params) {
        Context context = GossipApplication.a().getApplicationContext();
        try {
            if (context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode > 68) {
                params.put("threaded", Integer.toString(1));
            }
        } catch (Throwable e) {
            rj.a(e);
        }
        return this.e.b((Map) params).b(new ik$22(this)).a(new ii("Get post comments failed"));
    }

    public apl<NetworkData> b(String markRead, String lastActivityId) {
        return this.e.b(markRead, lastActivityId).a(new ii("Get activity failed"));
    }

    public apl<NetworkData> a(boolean forever) {
        return this.e.a(forever ? 1 : 0).a(new ii("Unable to logout"));
    }

    public apl<EmptyClass> e(String postId) {
        return this.e.b(postId);
    }

    public apl<EmptyClass> f(String postId) {
        return this.e.c(postId);
    }

    public apl<Group> a(int groupId, String groupName, String about, String tags, String sourceUrl) {
        return this.e.a(groupId, groupName, about, tags, sourceUrl).b(new ik$23(this)).a(new ii("update group failed"));
    }

    public apl<EmptyClass> a(int activityId) {
        return this.e.b(activityId);
    }

    public apl<NetworkData> b(int groupId) {
        return this.e.c(groupId).b(new ik$24(this)).a(new ii("join group failed"));
    }

    public apl<EmptyClass> a(Group group) {
        return this.e.d(group.group_id).b(new ik$2(this)).a(new ii("skip group failed"));
    }

    public apl<NetworkData> c(int group_id) {
        return this.e.e(group_id).b(new ik$3(this)).a(new ii("leave group failed"));
    }

    public apl<EmptyClass> e(Map<String, String> params) {
        return this.e.g((Map) params).b(new ik$4(this)).a(new ii("update activity settings failed"));
    }

    public apl<NetworkData> d(int userId) {
        return this.e.f(userId).b(new ik$5(this)).a(new ii("unable to get user profile"));
    }

    public apl<NetworkData> b() {
        return this.e.a().b(new ik$6(this)).a(new ii("unable to get your info"));
    }

    public apl<String> a(String domain, Map<String, String> s3_data, RequestBody fileBody) {
        return b(domain).a(s3_data, fileBody).b(new ik$7(this)).a(new ii("error uploading image to s3"));
    }

    public apl<UploadResponse> c(String uri, String filepath) {
        String mimeType = "image/jpg";
        return this.e.e("image/jpg", "edit_account").b(new ik$8(this, new File(filepath)));
    }

    public apl<NetworkData> a(FacebookInfo fbInfo, boolean forYou) {
        HashMap<String, String> params = new HashMap();
        if (forYou) {
            params.put("for_you", "1");
        }
        if (!(fbInfo == null || fbInfo.fbToken == null)) {
            params.put("fb_token", fbInfo.fbToken.b());
            if (!(fbInfo.jobIds == null || fbInfo.jobIds.isEmpty())) {
                params.put("fb_job_ids", DataUtil.join(fbInfo.jobIds));
            }
            if (!(fbInfo.schoolIds == null || fbInfo.schoolIds.isEmpty())) {
                params.put("fb_school_ids", DataUtil.join(fbInfo.schoolIds));
            }
        }
        if (AppState.location != null) {
            params.put("location", AppState.location.getLatitude() + "," + AppState.location.getLongitude() + "@" + (AppState.location.hasAccuracy() ? Float.valueOf(AppState.location.getAccuracy()) : "50"));
        }
        return this.e.e((Map) params).b(new ik$9(this)).a(new ii("unable to get suggested groups"));
    }

    public apl<NetworkData> f(Map<String, String> params) {
        return this.e.h((Map) params).b(new ik$10(this)).a(new ii("unable to delete comment"));
    }

    public apl<NetworkData> g(Map<String, String> params) {
        return this.e.i((Map) params).b(new ik$11(this)).a(new ii("unable to report comment"));
    }

    public apl<NetworkData> h(Map<String, String> params) {
        return this.e.j(params).b(new ik$13(this)).a(new ii("unable to add comment"));
    }

    public apl<EmptyClass> g(String upsellId) {
        return this.e.d(upsellId).a(new ii("unable to skip upsell"));
    }

    public apl<NetworkData> i(Map<String, String> params) {
        return this.e.k(params).b(new ik$14(this)).a(new ii(""));
    }

    public apl<NetworkData> h(String phoneNumber) {
        return this.e.e(phoneNumber).a(new ii("unable to generate otp code"));
    }

    public apl<EmptyClass> e(int groupId) {
        return this.e.g(groupId).a(new ii("unable to invite friends to group"));
    }

    public apl<ain> j(Map<String, String> params) {
        return this.e.l(params).a(new ii("unable to get search results"));
    }

    public apl<ain> k(Map<String, String> params) {
        return this.e.m(params).a(new ii("unable to get search results"));
    }

    public apl<NetworkData> b(int groupId, String reason) {
        return this.e.a(groupId, reason).b(new ik$15(this)).a(new ii("unable to report comment"));
    }

    public apl<NetworkData> f(int groupId) {
        return this.e.h(groupId).b(new ik$16(this)).a(new ii("unable to delete group"));
    }

    public apl<EmptyClass> a(int commentId, int value) {
        return this.e.a(commentId, value).a(new ii("unable to like comment"));
    }

    public apl<NetworkData> l(Map<String, String> params) {
        return this.e.n(params).a(new ii("unable to edit post"));
    }

    public apl<NetworkData> m(Map<String, String> params) {
        return this.e.o(params).a(new ii("unable to edit comment"));
    }

    public apl<ain> i(String query) {
        return this.e.f(query).a(new ii("unable to search for images"));
    }

    public apl<ain> c() {
        return this.e.b().a(new ii("unable to get splash page"));
    }

    public apl<NetworkData> g(int page) {
        return this.e.b(page, Integer.toString(k())).a(new ii("unable to get history page"));
    }

    public apl<NetworkData> h(int page) {
        return this.e.c(page, Integer.toString(k())).a(new ii("unable to get posts page"));
    }

    public apl<NetworkData> i(int page) {
        return this.e.i(page).a(new ii("unable to get groups page"));
    }

    public apl<EmptyClass> j(String notificationId) {
        return this.e.g(notificationId).a(new ii("unable to mark notification as clicked"));
    }

    public apl<NetworkData> d() {
        HashMap<String, String> params = new HashMap();
        if (!(AppState.fbInfo == null || AppState.fbInfo.fbToken == null)) {
            params.put("fb_uid", AppState.fbInfo.fbToken.i());
            params.put("fb_token", AppState.fbInfo.fbToken.b());
        }
        return this.e.v(params).a(new ii("unable to check for an existing facebook account"));
    }

    public apl<NetworkData> e() {
        HashMap<String, String> params = new HashMap();
        if (!(AppState.fbInfo == null || AppState.fbInfo.fbToken == null)) {
            params.put("fb_uid", AppState.fbInfo.fbToken.i());
            params.put("fb_token", AppState.fbInfo.fbToken.b());
        }
        if (!(AppState.contactsInfo == null || AppState.contactsInfo.phone_number == null)) {
            params.put("phone_number", AppState.contactsInfo.phone_number);
            params.put("otp_code", AppState.contactsInfo.otpCode);
            if (!(AppState.contactsInfo.contacts == null || AppState.contactsInfo.contacts.isEmpty())) {
                params.put("phone_contacts", DataUtil.join(AppState.contactsInfo.contacts));
            }
        }
        if (AppState.referralId != null) {
            params.put("referral_id", AppState.referralId);
        }
        return this.e.w(params).b(new ik$17(this)).a(new ii("unable to get or create a user"));
    }

    public apl<NetworkData> f() {
        HashMap<String, String> params = new HashMap();
        if (AppState.location != null) {
            params.put("location", AppState.location.getLatitude() + "," + AppState.location.getLongitude() + "@" + (AppState.location.hasAccuracy() ? Float.valueOf(AppState.location.getAccuracy()) : "50"));
        }
        if (AppState.fbInfo != null && AppState.fbInfo.age != null) {
            params.put("age", AppState.fbInfo.age);
        } else if (AppState.age != null) {
            params.put("age", AppState.age);
        }
        if (!(AppState.activeTags == null || AppState.activeTags.isEmpty())) {
            params.put("tags", DataUtil.join(AppState.activeTags));
        }
        if (AppState.fbInfo != null) {
            if (!(AppState.fbInfo.jobIds == null || AppState.fbInfo.jobIds.isEmpty())) {
                params.put("fb_job_ids", DataUtil.join(AppState.fbInfo.jobIds));
            }
            if (!(AppState.fbInfo.schoolIds == null || AppState.fbInfo.schoolIds.isEmpty())) {
                params.put("fb_school_ids", DataUtil.join(AppState.fbInfo.schoolIds));
            }
            if (!(AppState.fbInfo.friendIds == null || AppState.fbInfo.friendIds.isEmpty())) {
                params.put("fb_friends", DataUtil.join(AppState.fbInfo.friendIds));
            }
        }
        return this.e.x(params).a(new ii("unable to get groups for user signup"));
    }

    public apl<EmptyClass> k(String messageType) {
        return this.e.h(messageType).a(new ii("unable to set server message_sent seen"));
    }

    public apl<NetworkData> n(Map<String, String> params) {
        return this.e.t(params).a(new ii("unable to read message_sent thread"));
    }

    public apl<NetworkData> o(Map<String, String> params) {
        return this.e.r(params).a(new ii("unable to add message_sent"));
    }

    public apl<NetworkData> p(Map<String, String> params) {
        return this.e.s(params).a(new ii("unable to get threads and requests"));
    }

    public apl<NetworkData> q(Map<String, String> params) {
        return this.e.y(params).a(new ii("unable to report message"));
    }

    public apl<NetworkData> r(Map<String, String> params) {
        return this.e.z(params).a(new ii("unable to set message settings"));
    }

    public apl<NetworkData> s(Map<String, String> params) {
        return this.e.A(params).a(new ii("unable to block user"));
    }

    public apl<NetworkData> t(Map<String, String> params) {
        return this.e.B(params).a(new ii("unable to unblock user"));
    }

    public apl<NetworkData> u(Map<String, String> params) {
        return this.e.C(params).a(new ii("unable to delete thread"));
    }

    public apl<NetworkData> l(String searchString) {
        return this.e.i(searchString).a(new ii("unable to search user threads"));
    }

    public apl<NetworkData> v(Map<String, String> params) {
        return this.e.q(params).a(new ii("unable to handle message request"));
    }

    public apl<NetworkData> w(Map<String, String> params) {
        return this.e.u(params).a(new ii("unable to mark thread read"));
    }

    public apl<NetworkData> g() {
        return this.e.d().a(new ii("unable to mark messages visit"));
    }

    public apl<NetworkData> h() {
        return this.e.c().a(new ii("unable to get unread message count"));
    }

    public apl<NetworkData> c(String nickname, String postId, String userName) {
        return this.e.b(nickname, postId, userName, Integer.toString(nickname != null ? 0 : 1)).a(new ii("unable to add nickname to a thread"));
    }

    public apl<NetworkData> d(String postId, String userName) {
        return this.e.f(postId, userName).a(new ii("unable to mark nickname alert shown"));
    }
}
