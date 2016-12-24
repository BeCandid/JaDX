package defpackage;

import com.becandid.candid.data.EmptyClass;
import com.becandid.candid.models.GroupNameCheck;
import com.becandid.candid.models.NetworkData;
import com.becandid.candid.models.NetworkData.UploadResponse;
import com.becandid.candid.models.PostInfoResponse;
import java.util.Map;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/* compiled from: ApiService */
interface ik$a {
    @POST("api/block_thread")
    @FormUrlEncoded
    apl<NetworkData> A(@FieldMap Map<String, String> map);

    @POST("api/unblock_thread")
    @FormUrlEncoded
    apl<NetworkData> B(@FieldMap Map<String, String> map);

    @POST("api/delete_thread")
    @FormUrlEncoded
    apl<NetworkData> C(@FieldMap Map<String, String> map);

    @POST("api/get_my_info")
    apl<NetworkData> a();

    @POST("api/logout")
    @FormUrlEncoded
    apl<NetworkData> a(@Field("forever") int i);

    @POST("api/like_comment")
    @FormUrlEncoded
    apl<EmptyClass> a(@Field("comment_id") int i, @Field("value") int i2);

    @POST("api/report_group")
    @FormUrlEncoded
    apl<NetworkData> a(@Field("group_id") int i, @Field("reason") String str);

    @POST("api/update_group")
    @FormUrlEncoded
    apl<NetworkData> a(@Field("group_id") int i, @Field("group_name") String str, @Field("about") String str2, @Field("tags") String str3, @Field("source_url") String str4);

    @POST("api/get_post_info")
    @FormUrlEncoded
    apl<PostInfoResponse> a(@Field("url") String str);

    @POST("api/check_group_name")
    @FormUrlEncoded
    apl<GroupNameCheck> a(@Field("group_name") String str, @Field("will_use_duplicate") int i);

    @POST("api/report_post")
    @FormUrlEncoded
    apl<EmptyClass> a(@Field("post_id") String str, @Field("reason") String str2);

    @POST("api/update_device_token")
    @FormUrlEncoded
    apl<EmptyClass> a(@Field("device_token") String str, @Field("platform_type") String str2, @Field("version_type") String str3);

    @POST("api/create_group")
    @FormUrlEncoded
    apl<NetworkData> a(@Field("group_name") String str, @Field("about") String str2, @Field("tags") String str3, @Field("source_url") String str4);

    @POST("api/feed")
    @FormUrlEncoded
    apl<NetworkData> a(@Field("feed_type") String str, @Field("min_post_id") String str2, @FieldMap Map<String, String> map);

    @POST("api/add_post")
    @FormUrlEncoded
    apl<NetworkData> a(@FieldMap Map<String, String> map);

    @POST("api/splash_page")
    apl<ain> b();

    @POST("api/mark_read_activity")
    @FormUrlEncoded
    apl<EmptyClass> b(@Field("activity_id") int i);

    @POST("api/all_interacted_posts")
    @FormUrlEncoded
    apl<NetworkData> b(@Field("page") int i, @Field("num") String str);

    @POST("api/mute_post")
    @FormUrlEncoded
    apl<EmptyClass> b(@Field("post_id") String str);

    @POST("api/get_activity")
    @FormUrlEncoded
    apl<NetworkData> b(@Field("mark_read") String str, @Field("last_activity_id") String str2);

    @POST("api/like_post")
    @FormUrlEncoded
    apl<NetworkData> b(@Field("post_id") String str, @Field("value") String str2, @Field("is_rumor") String str3);

    @POST("api/add_nickname")
    @FormUrlEncoded
    apl<NetworkData> b(@Field("nickname") String str, @Field("post_id") String str2, @Field("target_post_name") String str3, @Field("ignore") String str4);

    @POST("api/post_comments")
    @FormUrlEncoded
    apl<NetworkData> b(@FieldMap Map<String, String> map);

    @POST("api/get_threads_requests_count")
    apl<NetworkData> c();

    @POST("api/join_group")
    @FormUrlEncoded
    apl<NetworkData> c(@Field("group_id") int i);

    @POST("api/my_posts_on_scroll")
    @FormUrlEncoded
    apl<NetworkData> c(@Field("page") int i, @Field("num") String str);

    @POST("api/unmute_post")
    @FormUrlEncoded
    apl<EmptyClass> c(@Field("post_id") String str);

    @POST("api/delete_post")
    @FormUrlEncoded
    apl<EmptyClass> c(@Field("post_id") String str, @Field("reason") String str2);

    @POST("api/invite_contacts")
    @FormUrlEncoded
    apl<EmptyClass> c(@Field("contacts_json") String str, @Field("upsell_id") String str2, @Field("name") String str3);

    @POST("api/new_user_hash")
    @FormUrlEncoded
    apl<ain> c(@FieldMap Map<String, String> map);

    @POST("api/mark_messages_visit")
    apl<NetworkData> d();

    @POST("api/skip_group")
    @FormUrlEncoded
    apl<NetworkData> d(@Field("group_id") int i);

    @POST("api/skip_upsell")
    @FormUrlEncoded
    apl<EmptyClass> d(@Field("upsell_id") String str);

    @POST("api/verify_phone_number")
    @FormUrlEncoded
    apl<NetworkData> d(@Field("otp_code") String str, @Field("phone_number") String str2);

    @POST("api/group_feed")
    @FormUrlEncoded
    apl<NetworkData> d(@Field("group_id") String str, @Field("min_post_id") String str2, @Field("num") String str3);

    @POST("api/sync_friends")
    @FormUrlEncoded
    apl<ain> d(@FieldMap Map<String, String> map);

    @POST("api/leave_group")
    @FormUrlEncoded
    apl<NetworkData> e(@Field("group_id") int i);

    @POST("api/generate_otp")
    @FormUrlEncoded
    apl<NetworkData> e(@Field("phone_number") String str);

    @POST("api/start_upload")
    @FormUrlEncoded
    apl<UploadResponse> e(@Field("content_type") String str, @Field("form_id") String str2);

    @POST("api/suggested_groups")
    @FormUrlEncoded
    apl<NetworkData> e(@FieldMap Map<String, String> map);

    @POST("api/profile")
    @FormUrlEncoded
    apl<NetworkData> f(@Field("user_id") int i);

    @POST("api/search_images")
    @FormUrlEncoded
    apl<ain> f(@Field("query") String str);

    @POST("api/mark_nickname_alert_shown")
    @FormUrlEncoded
    apl<NetworkData> f(@Field("post_id") String str, @Field("target_post_name") String str2);

    @POST("api/auto_join_fb_groups")
    @FormUrlEncoded
    apl<NetworkData> f(@FieldMap Map<String, String> map);

    @POST("api/invite_group_friends")
    @FormUrlEncoded
    apl<EmptyClass> g(@Field("group_id") int i);

    @POST("api/click_notification")
    @FormUrlEncoded
    apl<EmptyClass> g(@Field("notification_id") String str);

    @POST("api/update_activity_settings")
    @FormUrlEncoded
    apl<NetworkData> g(@FieldMap Map<String, String> map);

    @POST("api/delete_group")
    @FormUrlEncoded
    apl<NetworkData> h(@Field("group_id") int i);

    @POST("api/server_message_seen")
    @FormUrlEncoded
    apl<EmptyClass> h(@Field("message_type") String str);

    @POST("api/delete_comment")
    @FormUrlEncoded
    apl<NetworkData> h(@FieldMap Map<String, String> map);

    @POST("api/my_groups_on_scroll")
    @FormUrlEncoded
    apl<NetworkData> i(@Field("page") int i);

    @POST("api/search_user_threads")
    @FormUrlEncoded
    apl<NetworkData> i(@Field("search_string") String str);

    @POST("api/report_comment")
    @FormUrlEncoded
    apl<NetworkData> i(@FieldMap Map<String, String> map);

    @POST("api/add_comment")
    @FormUrlEncoded
    apl<NetworkData> j(@FieldMap Map<String, String> map);

    @POST("api/update_user_tags")
    @FormUrlEncoded
    apl<NetworkData> k(@FieldMap Map<String, String> map);

    @POST("api/search_groups")
    @FormUrlEncoded
    apl<ain> l(@FieldMap Map<String, String> map);

    @POST("api/search_links")
    @FormUrlEncoded
    apl<ain> m(@FieldMap Map<String, String> map);

    @POST("api/edit_post")
    @FormUrlEncoded
    apl<NetworkData> n(@FieldMap Map<String, String> map);

    @POST("api/edit_comment")
    @FormUrlEncoded
    apl<NetworkData> o(@FieldMap Map<String, String> map);

    @POST("api/update_user_info")
    @FormUrlEncoded
    apl<EmptyClass> p(@FieldMap Map<String, String> map);

    @POST("api/handle_message_request")
    @FormUrlEncoded
    apl<NetworkData> q(@FieldMap Map<String, String> map);

    @POST("api/add_message")
    @FormUrlEncoded
    apl<NetworkData> r(@FieldMap Map<String, String> map);

    @POST("api/get_threads_and_requests")
    @FormUrlEncoded
    apl<NetworkData> s(@FieldMap Map<String, String> map);

    @POST("api/get_thread")
    @FormUrlEncoded
    apl<NetworkData> t(@FieldMap Map<String, String> map);

    @POST("api/read_thread")
    @FormUrlEncoded
    apl<NetworkData> u(@FieldMap Map<String, String> map);

    @POST("api/login_fb_user")
    @FormUrlEncoded
    apl<NetworkData> v(@FieldMap Map<String, String> map);

    @POST("api/signupprocess")
    @FormUrlEncoded
    apl<NetworkData> w(@FieldMap Map<String, String> map);

    @POST("api/get_location_tags_groups")
    @FormUrlEncoded
    apl<NetworkData> x(@FieldMap Map<String, String> map);

    @POST("api/report_message")
    @FormUrlEncoded
    apl<NetworkData> y(@FieldMap Map<String, String> map);

    @POST("api/set_message_settings")
    @FormUrlEncoded
    apl<NetworkData> z(@FieldMap Map<String, String> map);
}
