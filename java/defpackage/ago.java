package defpackage;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ServiceInfo;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.internal.zzamc;
import com.google.android.gms.measurement.AppMeasurement.a;
import com.google.android.gms.measurement.AppMeasurement.e;
import com.google.android.gms.measurement.internal.zzw;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.BitSet;
import java.util.List;
import java.util.Map;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

public class ago extends ahm {
    ago(ahk ahk) {
        super(ahk);
    }

    private Object a(int i, Object obj, boolean z) {
        if (obj == null) {
            return null;
        }
        if ((obj instanceof Long) || (obj instanceof Double)) {
            return obj;
        }
        if (obj instanceof Integer) {
            return Long.valueOf((long) ((Integer) obj).intValue());
        }
        if (obj instanceof Byte) {
            return Long.valueOf((long) ((Byte) obj).byteValue());
        }
        if (obj instanceof Short) {
            return Long.valueOf((long) ((Short) obj).shortValue());
        }
        if (!(obj instanceof Boolean)) {
            return obj instanceof Float ? Double.valueOf(((Float) obj).doubleValue()) : ((obj instanceof String) || (obj instanceof Character) || (obj instanceof CharSequence)) ? a(String.valueOf(obj), i, z) : null;
        } else {
            return Long.valueOf(((Boolean) obj).booleanValue() ? 1 : 0);
        }
    }

    public static String a(aby$b aby_b) {
        int i = 0;
        if (aby_b == null) {
            return "null";
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("\nevent_filter {\n");
        ago.a(stringBuilder, 0, "filter_id", aby_b.b);
        ago.a(stringBuilder, 0, "event_name", aby_b.c);
        ago.a(stringBuilder, 1, "event_count_filter", aby_b.f);
        stringBuilder.append("  filters {\n");
        aby$c[] aby_cArr = aby_b.d;
        int length = aby_cArr.length;
        while (i < length) {
            ago.a(stringBuilder, 2, aby_cArr[i]);
            i++;
        }
        ago.a(stringBuilder, 1);
        stringBuilder.append("}\n}\n");
        return stringBuilder.toString();
    }

    public static String a(aby$e aby_e) {
        if (aby_e == null) {
            return "null";
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("\nproperty_filter {\n");
        ago.a(stringBuilder, 0, "filter_id", aby_e.b);
        ago.a(stringBuilder, 0, "property_name", aby_e.c);
        ago.a(stringBuilder, 1, aby_e.d);
        stringBuilder.append("}\n");
        return stringBuilder.toString();
    }

    private static void a(StringBuilder stringBuilder, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            stringBuilder.append("  ");
        }
    }

    private static void a(StringBuilder stringBuilder, int i, aby$c aby_c) {
        if (aby_c != null) {
            ago.a(stringBuilder, i);
            stringBuilder.append("filter {\n");
            ago.a(stringBuilder, i, "complement", aby_c.d);
            ago.a(stringBuilder, i, "param_name", aby_c.e);
            ago.a(stringBuilder, i + 1, "string_filter", aby_c.b);
            ago.a(stringBuilder, i + 1, "number_filter", aby_c.c);
            ago.a(stringBuilder, i);
            stringBuilder.append("}\n");
        }
    }

    private static void a(StringBuilder stringBuilder, int i, aca$e aca_e) {
        if (aca_e != null) {
            ago.a(stringBuilder, i);
            stringBuilder.append("bundle {\n");
            ago.a(stringBuilder, i, "protocol_version", aca_e.b);
            ago.a(stringBuilder, i, "platform", aca_e.j);
            ago.a(stringBuilder, i, "gmp_version", aca_e.r);
            ago.a(stringBuilder, i, "uploading_gmp_version", aca_e.s);
            ago.a(stringBuilder, i, "gmp_app_id", aca_e.z);
            ago.a(stringBuilder, i, "app_id", aca_e.p);
            ago.a(stringBuilder, i, "app_version", aca_e.q);
            ago.a(stringBuilder, i, "app_version_major", aca_e.D);
            ago.a(stringBuilder, i, "firebase_instance_id", aca_e.C);
            ago.a(stringBuilder, i, "dev_cert_hash", aca_e.w);
            ago.a(stringBuilder, i, "app_store", aca_e.o);
            ago.a(stringBuilder, i, "upload_timestamp_millis", aca_e.e);
            ago.a(stringBuilder, i, "start_timestamp_millis", aca_e.f);
            ago.a(stringBuilder, i, "end_timestamp_millis", aca_e.g);
            ago.a(stringBuilder, i, "previous_bundle_start_timestamp_millis", aca_e.h);
            ago.a(stringBuilder, i, "previous_bundle_end_timestamp_millis", aca_e.i);
            ago.a(stringBuilder, i, "app_instance_id", aca_e.v);
            ago.a(stringBuilder, i, "resettable_device_id", aca_e.t);
            ago.a(stringBuilder, i, "device_id", aca_e.G);
            ago.a(stringBuilder, i, "limited_ad_tracking", aca_e.u);
            ago.a(stringBuilder, i, "os_version", aca_e.k);
            ago.a(stringBuilder, i, "device_model", aca_e.l);
            ago.a(stringBuilder, i, "user_default_language", aca_e.m);
            ago.a(stringBuilder, i, "time_zone_offset_minutes", aca_e.n);
            ago.a(stringBuilder, i, "bundle_sequential_index", aca_e.x);
            ago.a(stringBuilder, i, "service_upload", aca_e.A);
            ago.a(stringBuilder, i, "health_monitor", aca_e.y);
            ago.a(stringBuilder, i, aca_e.d);
            ago.a(stringBuilder, i, aca_e.B);
            ago.a(stringBuilder, i, aca_e.c);
            ago.a(stringBuilder, i);
            stringBuilder.append("}\n");
        }
    }

    private static void a(StringBuilder stringBuilder, int i, String str, aby$d aby_d) {
        if (aby_d != null) {
            ago.a(stringBuilder, i);
            stringBuilder.append(str);
            stringBuilder.append(" {\n");
            if (aby_d.b != null) {
                Object obj = "UNKNOWN_COMPARISON_TYPE";
                switch (aby_d.b.intValue()) {
                    case uu$h.com_facebook_profile_picture_view_com_facebook_is_cropped /*1*/:
                        obj = "LESS_THAN";
                        break;
                    case uu$h.com_facebook_login_view_com_facebook_logout_text /*2*/:
                        obj = "GREATER_THAN";
                        break;
                    case uu$h.com_facebook_login_view_com_facebook_tooltip_mode /*3*/:
                        obj = "EQUAL";
                        break;
                    case uu$h.com_facebook_like_view_com_facebook_auxiliary_view_position /*4*/:
                        obj = "BETWEEN";
                        break;
                }
                ago.a(stringBuilder, i, "comparison_type", obj);
            }
            ago.a(stringBuilder, i, "match_as_float", aby_d.c);
            ago.a(stringBuilder, i, "comparison_value", aby_d.d);
            ago.a(stringBuilder, i, "min_comparison_value", aby_d.e);
            ago.a(stringBuilder, i, "max_comparison_value", aby_d.f);
            ago.a(stringBuilder, i);
            stringBuilder.append("}\n");
        }
    }

    private static void a(StringBuilder stringBuilder, int i, String str, aby$f aby_f) {
        if (aby_f != null) {
            ago.a(stringBuilder, i);
            stringBuilder.append(str);
            stringBuilder.append(" {\n");
            if (aby_f.b != null) {
                Object obj = "UNKNOWN_MATCH_TYPE";
                switch (aby_f.b.intValue()) {
                    case uu$h.com_facebook_profile_picture_view_com_facebook_is_cropped /*1*/:
                        obj = "REGEXP";
                        break;
                    case uu$h.com_facebook_login_view_com_facebook_logout_text /*2*/:
                        obj = "BEGINS_WITH";
                        break;
                    case uu$h.com_facebook_login_view_com_facebook_tooltip_mode /*3*/:
                        obj = "ENDS_WITH";
                        break;
                    case uu$h.com_facebook_like_view_com_facebook_auxiliary_view_position /*4*/:
                        obj = "PARTIAL";
                        break;
                    case uu$h.com_facebook_like_view_com_facebook_horizontal_alignment /*5*/:
                        obj = "EXACT";
                        break;
                    case uu$h.CardView_cardUseCompatPadding /*6*/:
                        obj = "IN_LIST";
                        break;
                }
                ago.a(stringBuilder, i, "match_type", obj);
            }
            ago.a(stringBuilder, i, "expression", aby_f.c);
            ago.a(stringBuilder, i, "case_sensitive", aby_f.d);
            if (aby_f.e.length > 0) {
                ago.a(stringBuilder, i + 1);
                stringBuilder.append("expression_list {\n");
                for (String str2 : aby_f.e) {
                    ago.a(stringBuilder, i + 2);
                    stringBuilder.append(str2);
                    stringBuilder.append("\n");
                }
                stringBuilder.append("}\n");
            }
            ago.a(stringBuilder, i);
            stringBuilder.append("}\n");
        }
    }

    private static void a(StringBuilder stringBuilder, int i, String str, aca$f aca_f) {
        int i2 = 0;
        if (aca_f != null) {
            int i3;
            int i4;
            int i5 = i + 1;
            ago.a(stringBuilder, i5);
            stringBuilder.append(str);
            stringBuilder.append(" {\n");
            if (aca_f.c != null) {
                ago.a(stringBuilder, i5 + 1);
                stringBuilder.append("results: ");
                long[] jArr = aca_f.c;
                int length = jArr.length;
                i3 = 0;
                i4 = 0;
                while (i3 < length) {
                    Long valueOf = Long.valueOf(jArr[i3]);
                    int i6 = i4 + 1;
                    if (i4 != 0) {
                        stringBuilder.append(", ");
                    }
                    stringBuilder.append(valueOf);
                    i3++;
                    i4 = i6;
                }
                stringBuilder.append('\n');
            }
            if (aca_f.b != null) {
                ago.a(stringBuilder, i5 + 1);
                stringBuilder.append("status: ");
                long[] jArr2 = aca_f.b;
                int length2 = jArr2.length;
                i3 = 0;
                while (i2 < length2) {
                    Long valueOf2 = Long.valueOf(jArr2[i2]);
                    i4 = i3 + 1;
                    if (i3 != 0) {
                        stringBuilder.append(", ");
                    }
                    stringBuilder.append(valueOf2);
                    i2++;
                    i3 = i4;
                }
                stringBuilder.append('\n');
            }
            ago.a(stringBuilder, i5);
            stringBuilder.append("}\n");
        }
    }

    private static void a(StringBuilder stringBuilder, int i, String str, Object obj) {
        if (obj != null) {
            ago.a(stringBuilder, i + 1);
            stringBuilder.append(str);
            stringBuilder.append(": ");
            stringBuilder.append(obj);
            stringBuilder.append('\n');
        }
    }

    private static void a(StringBuilder stringBuilder, int i, aca$a[] aca_aArr) {
        if (aca_aArr != null) {
            int i2 = i + 1;
            for (aca$a aca_a : aca_aArr) {
                if (aca_a != null) {
                    ago.a(stringBuilder, i2);
                    stringBuilder.append("audience_membership {\n");
                    ago.a(stringBuilder, i2, "audience_id", aca_a.b);
                    ago.a(stringBuilder, i2, "new_audience", aca_a.e);
                    ago.a(stringBuilder, i2, "current_data", aca_a.c);
                    ago.a(stringBuilder, i2, "previous_data", aca_a.d);
                    ago.a(stringBuilder, i2);
                    stringBuilder.append("}\n");
                }
            }
        }
    }

    private static void a(StringBuilder stringBuilder, int i, aca$b[] aca_bArr) {
        if (aca_bArr != null) {
            int i2 = i + 1;
            for (aca$b aca_b : aca_bArr) {
                if (aca_b != null) {
                    ago.a(stringBuilder, i2);
                    stringBuilder.append("event {\n");
                    ago.a(stringBuilder, i2, "name", aca_b.c);
                    ago.a(stringBuilder, i2, "timestamp_millis", aca_b.d);
                    ago.a(stringBuilder, i2, "previous_timestamp_millis", aca_b.e);
                    ago.a(stringBuilder, i2, "count", aca_b.f);
                    ago.a(stringBuilder, i2, aca_b.b);
                    ago.a(stringBuilder, i2);
                    stringBuilder.append("}\n");
                }
            }
        }
    }

    private static void a(StringBuilder stringBuilder, int i, aca$c[] aca_cArr) {
        if (aca_cArr != null) {
            int i2 = i + 1;
            for (aca$c aca_c : aca_cArr) {
                if (aca_c != null) {
                    ago.a(stringBuilder, i2);
                    stringBuilder.append("param {\n");
                    ago.a(stringBuilder, i2, "name", aca_c.b);
                    ago.a(stringBuilder, i2, "string_value", aca_c.c);
                    ago.a(stringBuilder, i2, "int_value", aca_c.d);
                    ago.a(stringBuilder, i2, "double_value", aca_c.f);
                    ago.a(stringBuilder, i2);
                    stringBuilder.append("}\n");
                }
            }
        }
    }

    private static void a(StringBuilder stringBuilder, int i, aca$g[] aca_gArr) {
        if (aca_gArr != null) {
            int i2 = i + 1;
            for (aca$g aca_g : aca_gArr) {
                if (aca_g != null) {
                    ago.a(stringBuilder, i2);
                    stringBuilder.append("user_property {\n");
                    ago.a(stringBuilder, i2, "set_timestamp_millis", aca_g.b);
                    ago.a(stringBuilder, i2, "name", aca_g.c);
                    ago.a(stringBuilder, i2, "string_value", aca_g.d);
                    ago.a(stringBuilder, i2, "int_value", aca_g.e);
                    ago.a(stringBuilder, i2, "double_value", aca_g.g);
                    ago.a(stringBuilder, i2);
                    stringBuilder.append("}\n");
                }
            }
        }
    }

    public static boolean a(Context context, String str) {
        try {
            ServiceInfo serviceInfo = context.getPackageManager().getServiceInfo(new ComponentName(context, str), 4);
            if (serviceInfo != null && serviceInfo.enabled) {
                return true;
            }
        } catch (NameNotFoundException e) {
        }
        return false;
    }

    public static boolean a(Context context, String str, boolean z) {
        try {
            ActivityInfo receiverInfo = context.getPackageManager().getReceiverInfo(new ComponentName(context, str), 2);
            if (receiverInfo != null && receiverInfo.enabled && (!z || receiverInfo.exported)) {
                return true;
            }
        } catch (NameNotFoundException e) {
        }
        return false;
    }

    public static boolean a(Bundle bundle) {
        return bundle.getLong("_c") == 1;
    }

    static boolean a(String str) {
        xz.a(str);
        return str.charAt(0) != '_';
    }

    public static boolean a(long[] jArr, int i) {
        return i < jArr.length * 64 && (jArr[i / 64] & (1 << (i % 64))) != 0;
    }

    public static long[] a(BitSet bitSet) {
        int length = (bitSet.length() + 63) / 64;
        long[] jArr = new long[length];
        int i = 0;
        while (i < length) {
            jArr[i] = 0;
            int i2 = 0;
            while (i2 < 64 && (i * 64) + i2 < bitSet.length()) {
                if (bitSet.get((i * 64) + i2)) {
                    jArr[i] = jArr[i] | (1 << i2);
                }
                i2++;
            }
            i++;
        }
        return jArr;
    }

    public static String b(aca$d aca_d) {
        if (aca_d == null) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("\nbatch {\n");
        if (aca_d.b != null) {
            for (aca$e aca_e : aca_d.b) {
                if (aca_e != null) {
                    ago.a(stringBuilder, 1, aca_e);
                }
            }
        }
        stringBuilder.append("}\n");
        return stringBuilder.toString();
    }

    static long c(byte[] bArr) {
        long j = null;
        xz.a((Object) bArr);
        xz.a(bArr.length > 0);
        long j2 = 0;
        int length = bArr.length - 1;
        while (length >= 0 && length >= bArr.length - 8) {
            j2 += (((long) bArr[length]) & 255) << j;
            j += 8;
            length--;
        }
        return j2;
    }

    public static boolean c(String str, String str2) {
        return (str == null && str2 == null) ? true : str == null ? false : str.equals(str2);
    }

    static MessageDigest h(String str) {
        int i = 0;
        while (i < 2) {
            try {
                MessageDigest instance = MessageDigest.getInstance(str);
                if (instance != null) {
                    return instance;
                }
                i++;
            } catch (NoSuchAlgorithmException e) {
            }
        }
        return null;
    }

    public static boolean j(String str) {
        return !TextUtils.isEmpty(str) && str.startsWith("_");
    }

    private int k(String str) {
        return "_ldl".equals(str) ? y().A() : y().z();
    }

    public Bundle a(String str, Bundle bundle, List<String> list, boolean z) {
        if (bundle == null) {
            return null;
        }
        Bundle bundle2 = new Bundle(bundle);
        int b = y().b();
        int i = 0;
        for (String str2 : bundle.keySet()) {
            int d;
            if (list == null || !list.contains(str2)) {
                d = z ? d(str2) : 0;
                if (d == 0) {
                    d = e(str2);
                }
            } else {
                d = 0;
            }
            if (d != 0) {
                if (a(bundle2, d)) {
                    bundle2.putString("_ev", a(str2, y().e(), true));
                }
                bundle2.remove(str2);
            } else if (a(str2, bundle.get(str2)) || "_ev".equals(str2)) {
                if (ago.a(str2)) {
                    i++;
                    if (i > b) {
                        w().f().a("Event can't contain more then " + b + " params", str, bundle);
                        a(bundle2, 5);
                        bundle2.remove(str2);
                    }
                }
                i = i;
            } else {
                if (a(bundle2, 4)) {
                    bundle2.putString("_ev", a(str2, y().e(), true));
                }
                bundle2.remove(str2);
            }
        }
        return bundle2;
    }

    public String a(String str, int i, boolean z) {
        return str.length() > i ? z ? String.valueOf(str.substring(0, i)).concat("...") : null : str;
    }

    public void a(int i, String str, String str2) {
        Bundle bundle = new Bundle();
        a(bundle, i);
        if (!TextUtils.isEmpty(str)) {
            bundle.putString(str, str2);
        }
        this.n.l().a("auto", "_err", bundle);
    }

    public void a(aca$c aca_c, Object obj) {
        xz.a(obj);
        aca_c.c = null;
        aca_c.d = null;
        aca_c.f = null;
        if (obj instanceof String) {
            aca_c.c = (String) obj;
        } else if (obj instanceof Long) {
            aca_c.d = (Long) obj;
        } else if (obj instanceof Double) {
            aca_c.f = (Double) obj;
        } else {
            w().f().a("Ignoring invalid (type) event param value", obj);
        }
    }

    public void a(aca$g aca_g, Object obj) {
        xz.a(obj);
        aca_g.d = null;
        aca_g.e = null;
        aca_g.g = null;
        if (obj instanceof String) {
            aca_g.d = (String) obj;
        } else if (obj instanceof Long) {
            aca_g.e = (Long) obj;
        } else if (obj instanceof Double) {
            aca_g.g = (Double) obj;
        } else {
            w().f().a("Ignoring invalid (type) user attribute value", obj);
        }
    }

    public void a(Bundle bundle, String str, Object obj) {
        if (bundle != null) {
            if (obj instanceof Long) {
                bundle.putLong(str, ((Long) obj).longValue());
            } else if (obj instanceof String) {
                bundle.putString(str, String.valueOf(obj));
            } else if (obj instanceof Double) {
                bundle.putDouble(str, ((Double) obj).doubleValue());
            } else if (str != null) {
                w().B().a("Not putting event parameter. Invalid value type. name, type", str, obj != null ? obj.getClass().getSimpleName() : null);
            }
        }
    }

    public boolean a(long j, long j2) {
        return j == 0 || j2 <= 0 || Math.abs(p().a() - j) > j2;
    }

    public boolean a(Bundle bundle, int i) {
        if (bundle == null || bundle.getLong("_err") != 0) {
            return false;
        }
        bundle.putLong("_err", (long) i);
        return true;
    }

    boolean a(String str, int i, String str2) {
        if (str2 == null) {
            w().f().a("Name is required and can't be null. Type", str);
            return false;
        } else if (str2.length() <= i) {
            return true;
        } else {
            w().f().a("Name is too long. Type, maximum supported length, name", str, Integer.valueOf(i), str2);
            return false;
        }
    }

    public boolean a(String str, Object obj) {
        return ago.j(str) ? a("param", str, y().g(), obj) : a("param", str, y().f(), obj);
    }

    boolean a(String str, String str2) {
        if (str2 == null) {
            w().f().a("Name is required and can't be null. Type", str);
            return false;
        } else if (str2.length() == 0) {
            w().f().a("Name is required and can't be empty. Type", str);
            return false;
        } else if (Character.isLetter(str2.charAt(0))) {
            int i = 1;
            while (i < str2.length()) {
                char charAt = str2.charAt(i);
                if (charAt == '_' || Character.isLetterOrDigit(charAt)) {
                    i++;
                } else {
                    w().f().a("Name must consist of letters, digits or _ (underscores). Type, name", str, str2);
                    return false;
                }
            }
            return true;
        } else {
            w().f().a("Name must start with a letter. Type, name", str, str2);
            return false;
        }
    }

    boolean a(String str, String str2, int i, Object obj) {
        if (obj == null || (obj instanceof Long) || (obj instanceof Float) || (obj instanceof Integer) || (obj instanceof Byte) || (obj instanceof Short) || (obj instanceof Boolean) || (obj instanceof Double)) {
            return true;
        }
        if (!(obj instanceof String) && !(obj instanceof Character) && !(obj instanceof CharSequence)) {
            return false;
        }
        String valueOf = String.valueOf(obj);
        if (valueOf.length() <= i) {
            return true;
        }
        w().z().a("Value is too long; discarded. Value kind, name, value length", str, str2, Integer.valueOf(valueOf.length()));
        return false;
    }

    boolean a(String str, Map<String, String> map, String str2) {
        if (str2 == null) {
            w().f().a("Name is required and can't be null. Type", str);
            return false;
        } else if (str2.startsWith("firebase_")) {
            w().f().a("Name starts with reserved prefix. Type, name", str, str2);
            return false;
        } else if (map == null || !map.containsKey(str2)) {
            return true;
        } else {
            w().f().a("Name is reserved. Type, name", str, str2);
            return false;
        }
    }

    public byte[] a(aca$d aca_d) {
        try {
            byte[] bArr = new byte[aca_d.b()];
            zzamc a = zzamc.a(bArr);
            aca_d.a(a);
            a.b();
            return bArr;
        } catch (IOException e) {
            w().f().a("Data loss. Failed to serialize batch", e);
            return null;
        }
    }

    public byte[] a(byte[] bArr) throws IOException {
        try {
            OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
            gZIPOutputStream.write(bArr);
            gZIPOutputStream.close();
            byteArrayOutputStream.close();
            return byteArrayOutputStream.toByteArray();
        } catch (IOException e) {
            w().f().a("Failed to gzip content", e);
            throw e;
        }
    }

    public int b(String str) {
        return !b("event", str) ? 2 : !a("event", a.a, str) ? 13 : a("event", y().c(), str) ? 0 : 2;
    }

    public Object b(String str, Object obj) {
        if ("_ev".equals(str)) {
            return a(y().g(), obj, true);
        }
        return a(ago.j(str) ? y().g() : y().f(), obj, false);
    }

    boolean b(String str, String str2) {
        if (str2 == null) {
            w().f().a("Name is required and can't be null. Type", str);
            return false;
        } else if (str2.length() == 0) {
            w().f().a("Name is required and can't be empty. Type", str);
            return false;
        } else {
            char charAt = str2.charAt(0);
            if (Character.isLetter(charAt) || charAt == '_') {
                int i = 1;
                while (i < str2.length()) {
                    char charAt2 = str2.charAt(i);
                    if (charAt2 == '_' || Character.isLetterOrDigit(charAt2)) {
                        i++;
                    } else {
                        w().f().a("Name must start with a letter or _ (underscores). Type, name", str, str2);
                        return false;
                    }
                }
                return true;
            }
            w().f().a("Name must start with a letter or _ (underscores). Type, name", str, str2);
            return false;
        }
    }

    public byte[] b(byte[] bArr) throws IOException {
        try {
            InputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
            GZIPInputStream gZIPInputStream = new GZIPInputStream(byteArrayInputStream);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bArr2 = new byte[1024];
            while (true) {
                int read = gZIPInputStream.read(bArr2);
                if (read <= 0) {
                    gZIPInputStream.close();
                    byteArrayInputStream.close();
                    return byteArrayOutputStream.toByteArray();
                }
                byteArrayOutputStream.write(bArr2, 0, read);
            }
        } catch (IOException e) {
            w().f().a("Failed to ungzip content", e);
            throw e;
        }
    }

    public int c(String str) {
        return !b("user property", str) ? 6 : !a("user property", e.a, str) ? 15 : a("user property", y().d(), str) ? 0 : 6;
    }

    public int c(String str, Object obj) {
        return "_ldl".equals(str) ? a("user property referrer", str, k(str), obj) : a("user property", str, k(str), obj) ? 0 : 7;
    }

    public int d(String str) {
        return !a("event param", str) ? 3 : !a("event param", null, str) ? 14 : a("event param", y().e(), str) ? 0 : 3;
    }

    public long d(byte[] bArr) {
        xz.a((Object) bArr);
        MessageDigest h = ago.h("MD5");
        if (h != null) {
            return ago.c(h.digest(bArr));
        }
        w().f().a("Failed to get MD5");
        return 0;
    }

    public Object d(String str, Object obj) {
        return "_ldl".equals(str) ? a(k(str), obj, true) : a(k(str), obj, false);
    }

    public int e(String str) {
        return !b("event param", str) ? 3 : !a("event param", null, str) ? 14 : a("event param", y().e(), str) ? 0 : 3;
    }

    public boolean f(String str) {
        if (TextUtils.isEmpty(str)) {
            w().f().a("Measurement Service called without google_app_id");
            return false;
        } else if (!str.startsWith("1:")) {
            w().z().a("Measurement Service called with unknown id version", str);
            return true;
        } else if (g(str)) {
            return true;
        } else {
            w().f().a("Invalid google_app_id. Firebase Analytics disabled. See", "https://goo.gl/FZRIUV");
            return false;
        }
    }

    boolean g(String str) {
        xz.a((Object) str);
        return str.matches("^1:\\d+:android:[a-f0-9]+$");
    }

    public /* bridge */ /* synthetic */ void h() {
        super.h();
    }

    public /* bridge */ /* synthetic */ void i() {
        super.i();
    }

    public boolean i(String str) {
        j();
        if (q().checkCallingOrSelfPermission(str) == 0) {
            return true;
        }
        w().D().a("Permission not granted", str);
        return false;
    }

    public /* bridge */ /* synthetic */ void j() {
        super.j();
    }

    public /* bridge */ /* synthetic */ agq k() {
        return super.k();
    }

    public /* bridge */ /* synthetic */ agf l() {
        return super.l();
    }

    public /* bridge */ /* synthetic */ ahb m() {
        return super.m();
    }

    public /* bridge */ /* synthetic */ agu n() {
        return super.n();
    }

    public /* bridge */ /* synthetic */ agg o() {
        return super.o();
    }

    public /* bridge */ /* synthetic */ zn p() {
        return super.p();
    }

    public /* bridge */ /* synthetic */ Context q() {
        return super.q();
    }

    public /* bridge */ /* synthetic */ ags r() {
        return super.r();
    }

    public /* bridge */ /* synthetic */ ago s() {
        return super.s();
    }

    public /* bridge */ /* synthetic */ ahj t() {
        return super.t();
    }

    public /* bridge */ /* synthetic */ agi u() {
        return super.u();
    }

    public /* bridge */ /* synthetic */ zzw v() {
        return super.v();
    }

    public /* bridge */ /* synthetic */ ahd w() {
        return super.w();
    }

    public /* bridge */ /* synthetic */ ahh x() {
        return super.x();
    }

    public /* bridge */ /* synthetic */ agr y() {
        return super.y();
    }
}
