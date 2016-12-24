package defpackage;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.drawable.GradientDrawable;
import android.media.ExifInterface;
import android.support.v7.app.AlertDialog.Builder;
import android.support.v7.widget.ListPopupWindow;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.text.Layout;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StyleSpan;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.Toast;
import com.becandid.candid.GossipApplication;
import com.becandid.candid.activities.BaseActivity;
import com.becandid.candid.data.AppState;
import com.becandid.candid.data.Group;
import com.becandid.candid.util.ViewUtils$8;
import com.becandid.candid.views.TagBox;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import rx.schedulers.Schedulers;

/* compiled from: ViewUtils */
public class jb {
    public static final int a = Color.parseColor("#50000000");
    public static final int b = AppState.config.getInt("android_max_chars", 140);
    public static final float c = AppState.config.getFloat("android_max_char_mult", 1.6f);

    public static LinearLayout a(Context context, String label) {
        return new TagBox(context, label);
    }

    public static int a(int dps, Context context) {
        return (int) ((((float) dps) * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static void a(Context ctx) {
        InputMethodManager inputManager = (InputMethodManager) ctx.getSystemService("input_method");
        View v = ((Activity) ctx).getCurrentFocus();
        if (v != null) {
            inputManager.hideSoftInputFromWindow(v.getWindowToken(), 0);
        }
    }

    public static void a(Context context, View view) {
        ((InputMethodManager) context.getSystemService("input_method")).hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

    public static void a(View view, String backgroundColor) {
        GradientDrawable shape = new GradientDrawable();
        shape.setShape(0);
        shape.setCornerRadius(20.0f);
        if (backgroundColor != null) {
            shape.setColor(Color.parseColor(backgroundColor));
        }
        view.setBackground(shape);
    }

    public static void a(View view) {
        GradientDrawable shape = new GradientDrawable();
        shape.setShape(0);
        shape.setCornerRadii(new float[]{0.0f, 0.0f, 0.0f, 0.0f, 20.0f, 20.0f, 20.0f, 20.0f});
        shape.setColor(a);
        view.setBackground(shape);
    }

    public static String a(String color, float percent) {
        float p;
        int f = Integer.parseInt(color.substring(1), 16);
        int t = percent < 0.0f ? 0 : 255;
        if (percent < 0.0f) {
            p = percent * -1.0f;
        } else {
            p = percent;
        }
        int R = f >> 16;
        int G = (f >> 8) & 255;
        int B = f & 255;
        return "#" + Integer.toString(((16777216 + ((Math.round(((float) (t - R)) * p) + R) * 65536)) + ((Math.round(((float) (t - G)) * p) + G) * 256)) + (Math.round(((float) (t - B)) * p) + B), 16).substring(1);
    }

    public static void a(Activity context, RelativeLayout container, List<String> tags) {
        if (tags == null || tags.isEmpty()) {
            tags = AppState.tags;
            rj.a(new Exception("GROUP TAGS is null or empty"));
        }
        DisplayMetrics metrics = new DisplayMetrics();
        context.getWindowManager().getDefaultDisplay().getMetrics(metrics);
        int screenWidth = metrics.widthPixels;
        int i = 0;
        int j = 0;
        while (i < tags.size()) {
            LinearLayout row = new LinearLayout(context);
            LayoutParams rowParam = new LayoutParams(-2, -1);
            rowParam.addRule(14);
            if (j != 0) {
                rowParam.addRule(3, context.getResources().getIdentifier(Integer.toString(j - 1), "id", context.getPackageName()));
            }
            row.setLayoutParams(rowParam);
            row.setId(j + 1);
            LinearLayout tag = jb.a((Context) context, (String) tags.get(i));
            tag.measure(0, 0);
            while (row.getMeasuredWidth() + tag.getMeasuredWidth() < screenWidth) {
                row.addView(tag);
                i++;
                row.measure(0, 0);
                if (i >= tags.size()) {
                    break;
                }
                tag = jb.a((Context) context, (String) tags.get(i));
                tag.measure(0, 0);
            }
            container.addView(row);
            j += 2;
        }
    }

    public static Spannable a(String caption, int color) {
        return jb.a(caption, color, 0, 0);
    }

    public static Spannable a(String caption, int color, int overrideMaxSize, int overrideMaxLines) {
        int maxSize;
        int maxLines;
        int i;
        if (overrideMaxSize <= 0) {
            maxSize = b;
        } else {
            maxSize = overrideMaxSize;
        }
        if (overrideMaxLines <= 0) {
            maxLines = 4;
        } else {
            maxLines = overrideMaxLines;
        }
        int preNewlineCount = 0;
        int postNewlineCount = 0;
        for (i = 0; i < caption.length(); i++) {
            if (caption.charAt(i) == '\n') {
                if (i >= maxSize || preNewlineCount >= maxLines) {
                    postNewlineCount++;
                } else {
                    preNewlineCount++;
                }
            }
        }
        if (Float.compare((float) caption.length(), ((float) maxSize) * c) < 0 && (preNewlineCount < maxLines || postNewlineCount < maxLines - 1)) {
            return new SpannableString(caption);
        }
        caption = caption.trim();
        int newlines = 0;
        int charCount = 0;
        int charIndex = 0;
        for (i = 0; i < caption.length(); i++) {
            if (caption.charAt(i) == '\n') {
                newlines++;
            } else {
                charCount++;
            }
            if (newlines == maxLines || charCount == maxSize) {
                charIndex = i;
                break;
            }
        }
        i = charIndex;
        while (i < caption.length() && i <= charIndex + 15) {
            if (caption.charAt(i) == ' ') {
                charIndex = i;
                break;
            }
            i++;
        }
        caption = caption.substring(0, charIndex) + "... " + "See More";
        Spannable spannable = new SpannableString(caption);
        spannable.setSpan(new ForegroundColorSpan(color), (caption.length() - "See More".length()) - 4, caption.length(), 33);
        spannable.setSpan(new RelativeSizeSpan(0.85f), caption.length() - "See More".length(), caption.length(), 33);
        return spannable;
    }

    public static Spannable a(String caption) {
        Spannable spannable = new SpannableString(caption);
        int end = caption.length() - 1;
        if (caption != null && caption.length() > 0) {
            while (caption.charAt(end) != ' ') {
                end--;
            }
        }
        if (end < caption.length() - 1) {
            spannable.setSpan(new StyleSpan(1), end, caption.length(), 33);
        }
        return spannable;
    }

    public static Builder a(Context context, String title, String message, String positiveBtn, String negativeBtn, int iconAttrId, boolean isReport, in$a onPositiveClick) {
        Builder builder = new Builder(context);
        builder.setTitle(title).setPositiveButton(positiveBtn, new jb$1(onPositiveClick)).setNegativeButton(negativeBtn, null);
        if (message != null) {
            builder.setMessage(message);
        }
        if (iconAttrId != -1) {
            builder.setIconAttribute(iconAttrId);
        }
        if (isReport) {
            builder.setSingleChoiceItems(new CharSequence[]{"Pornographic", "Solicitation and Spam", "Hate Speech", "Off Topic"}, -1, new jb$3());
        }
        return builder;
    }

    public static void a(Context context, int selectedPosition, int commentId) {
        String reason;
        switch (selectedPosition) {
            case uu$h.com_facebook_login_view_com_facebook_confirm_logout /*0*/:
                reason = "nsfw";
                break;
            case uu$h.com_facebook_profile_picture_view_com_facebook_is_cropped /*1*/:
                reason = "spam";
                break;
            case uu$h.com_facebook_login_view_com_facebook_logout_text /*2*/:
                reason = "hate";
                break;
            case uu$h.com_facebook_login_view_com_facebook_tooltip_mode /*3*/:
                reason = "offtopic";
                break;
            default:
                reason = "";
                break;
        }
        Map params = new HashMap();
        params.put("comment_id", Integer.toString(commentId));
        params.put("reason", reason);
        ik.a().g(params).b(Schedulers.io()).a(apv.a()).b(new jb$4(context, commentId, reason));
    }

    public static void b(Context context, int commentId, int postId) {
        Map params = new HashMap();
        params.put("comment_id", Integer.toString(commentId));
        ik.a().f(params).b(Schedulers.io()).a(apv.a()).b(new jb$5(context, commentId, postId));
    }

    public static void a(Context context, int selectedPosition, int commentId, int postId) {
        String reason;
        switch (selectedPosition) {
            case uu$h.com_facebook_login_view_com_facebook_confirm_logout /*0*/:
                reason = "nsfw";
                break;
            case uu$h.com_facebook_profile_picture_view_com_facebook_is_cropped /*1*/:
                reason = "spam";
                break;
            case uu$h.com_facebook_login_view_com_facebook_logout_text /*2*/:
                reason = "hate";
                break;
            case uu$h.com_facebook_login_view_com_facebook_tooltip_mode /*3*/:
                reason = "offtopic";
                break;
            default:
                reason = "";
                break;
        }
        Map params = new HashMap();
        params.put("comment_id", Integer.toString(commentId));
        params.put("reason", reason);
        ik.a().f(params).b(Schedulers.io()).a(apv.a()).b(new jb$6(context, commentId, postId));
    }

    public static void b(String uri, int orientation) {
        jb.a(uri, orientation, null);
    }

    public static void a(String uri, int orientation, String outUri) {
        if (uri.endsWith(".jpg") || uri.endsWith(".png")) {
            FileOutputStream out;
            Bitmap bitmap = BitmapFactory.decodeFile(uri);
            if (outUri != null) {
                try {
                    out = new FileOutputStream(outUri);
                } catch (Throwable e) {
                    rj.a(e);
                    Toast.makeText(GossipApplication.a().getApplicationContext(), "Can't upload this picture. Please try another one!", 0).show();
                    return;
                } catch (Throwable e2) {
                    rj.a(e2);
                    Toast.makeText(GossipApplication.a().getApplicationContext(), "Can't upload this picture. Please try another one!", 0).show();
                    return;
                } catch (Throwable e22) {
                    rj.a(e22);
                    Toast.makeText(GossipApplication.a().getApplicationContext(), "Can't upload this picture. Please try another one!", 0).show();
                    return;
                }
            }
            out = new FileOutputStream(uri);
            if (uri.endsWith(".jpg")) {
                bitmap.compress(CompressFormat.JPEG, 100, out);
            } else if (uri.endsWith(".png")) {
                bitmap.compress(CompressFormat.PNG, 100, out);
            }
            ExifInterface exif = new ExifInterface(uri);
            exif.setAttribute("Orientation", Integer.toString(orientation));
            exif.saveAttributes();
        }
    }

    public static Bitmap b(String filePath) {
        try {
            int orientation = new ExifInterface(filePath).getAttributeInt("Orientation", 0);
            Options options = new Options();
            options.inJustDecodeBounds = true;
            options.inPreferredConfig = Config.ARGB_8888;
            BitmapFactory.decodeFile(filePath, options);
            options.inSampleSize = Math.max(options.outWidth, options.outHeight) / 1920;
            options.inJustDecodeBounds = false;
            Bitmap bitmap = BitmapFactory.decodeFile(filePath, options);
            Matrix matrix = new Matrix();
            switch (orientation) {
                case uu$h.com_facebook_login_view_com_facebook_logout_text /*2*/:
                    matrix.setScale(-1.0f, 1.0f);
                    break;
                case uu$h.com_facebook_login_view_com_facebook_tooltip_mode /*3*/:
                    matrix.setRotate(180.0f);
                    break;
                case uu$h.com_facebook_like_view_com_facebook_auxiliary_view_position /*4*/:
                    matrix.setRotate(180.0f);
                    matrix.postScale(-1.0f, 1.0f);
                    break;
                case uu$h.com_facebook_like_view_com_facebook_horizontal_alignment /*5*/:
                    matrix.setRotate(90.0f);
                    matrix.postScale(-1.0f, 1.0f);
                    break;
                case uu$h.CardView_cardUseCompatPadding /*6*/:
                    matrix.setRotate(90.0f);
                    break;
                case uu$h.CardView_cardPreventCornerOverlap /*7*/:
                    matrix.setRotate(-90.0f);
                    matrix.postScale(-1.0f, 1.0f);
                    break;
                case uu$h.CardView_contentPadding /*8*/:
                    matrix.setRotate(-90.0f);
                    break;
                default:
                    return bitmap;
            }
            Bitmap bmRotated = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
            bitmap.recycle();
            return bmRotated;
        } catch (Throwable e) {
            rj.a(e);
            return null;
        } catch (Throwable e2) {
            rj.a(e2);
            return null;
        }
    }

    public static void a(CharSequence s, EditText view, ListPopupWindow popup, hg adapter) {
        Layout layout = view.getLayout();
        if (layout != null) {
            int pos = view.getSelectionStart();
            float y = (float) layout.getLineBaseline(layout.getLineForOffset(pos));
            popup.setHorizontalOffset((int) layout.getPrimaryHorizontal(pos));
            popup.setVerticalOffset((int) (((float) (-layout.getHeight())) + y));
            if (s.length() <= 0 || !s.toString().contains("#")) {
                popup.dismiss();
                return;
            }
            int endIndex = 0;
            for (String sub : s.toString().split("(?=#)")) {
                int startIndex = endIndex;
                endIndex += sub.length();
                if (startIndex + 1 < pos && pos <= endIndex && sub.length() > 2) {
                    CharSequence tag = s.subSequence(startIndex + 1, pos);
                    adapter.a().filter(tag);
                    ArrayList<Group> groups = adapter.a(tag.toString());
                    if (groups.isEmpty()) {
                        popup.dismiss();
                    } else {
                        if (groups.size() <= 3) {
                            if (popup.getHeight() != -2) {
                                popup.setHeight(-2);
                            }
                        } else if (popup.getHeight() != jb.a(90, view.getContext())) {
                            popup.setHeight(jb.a(90, view.getContext()));
                        }
                        if (!popup.isShowing()) {
                            popup.show();
                        }
                    }
                } else if (startIndex <= pos && pos <= endIndex && sub.length() <= 2) {
                    popup.dismiss();
                }
            }
        }
    }

    public static ClickableSpan a(String color, int postId, Context context, boolean seeMore, String opColor) {
        return new jb$7(context, seeMore, postId, opColor, color);
    }

    public static StyleSpan a() {
        return new ViewUtils$8(1);
    }

    public static ClickableSpan a(String color, int groupId, Context context) {
        return new jb$8(context, groupId, color);
    }

    public static ClickableSpan b(String color, int groupId, Context context) {
        return new jb$2(context, groupId, color);
    }

    public static void a(RecyclerView recyclerView, hf adapter) {
        ViewHolder holder = recyclerView.findViewHolderForAdapterPosition(adapter.getItemCount() - 1);
        if (holder instanceof je) {
            View rootView = ((je) holder).itemView;
            rootView.findViewById(2131624389).setVisibility(0);
            rootView.findViewById(2131624388).setVisibility(8);
        }
    }

    public static double b(Context context) {
        DisplayMetrics dm = new DisplayMetrics();
        ((BaseActivity) context).getWindowManager().getDefaultDisplay().getMetrics(dm);
        int width = dm.widthPixels;
        int height = dm.heightPixels;
        int dens = dm.densityDpi;
        return Math.sqrt(Math.pow(((double) width) / ((double) dm.xdpi), 2.0d) + Math.pow(((double) height) / ((double) dm.ydpi), 2.0d));
    }
}
