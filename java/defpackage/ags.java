package defpackage;

import android.annotation.TargetApi;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.CursorWindow;
import android.database.sqlite.SQLiteCursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.util.Pair;
import com.google.android.gms.internal.zzamc;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class ags extends agd {
    private static final Map<String, String> a = new dh(16);
    private final ags$c b = new ags$c(this, q(), B());
    private final agk c = new agk(p());

    static {
        a.put("app_version", "ALTER TABLE apps ADD COLUMN app_version TEXT;");
        a.put("app_store", "ALTER TABLE apps ADD COLUMN app_store TEXT;");
        a.put("gmp_version", "ALTER TABLE apps ADD COLUMN gmp_version INTEGER;");
        a.put("dev_cert_hash", "ALTER TABLE apps ADD COLUMN dev_cert_hash INTEGER;");
        a.put("measurement_enabled", "ALTER TABLE apps ADD COLUMN measurement_enabled INTEGER;");
        a.put("last_bundle_start_timestamp", "ALTER TABLE apps ADD COLUMN last_bundle_start_timestamp INTEGER;");
        a.put("day", "ALTER TABLE apps ADD COLUMN day INTEGER;");
        a.put("daily_public_events_count", "ALTER TABLE apps ADD COLUMN daily_public_events_count INTEGER;");
        a.put("daily_events_count", "ALTER TABLE apps ADD COLUMN daily_events_count INTEGER;");
        a.put("daily_conversions_count", "ALTER TABLE apps ADD COLUMN daily_conversions_count INTEGER;");
        a.put("remote_config", "ALTER TABLE apps ADD COLUMN remote_config BLOB;");
        a.put("config_fetched_time", "ALTER TABLE apps ADD COLUMN config_fetched_time INTEGER;");
        a.put("failed_config_fetch_time", "ALTER TABLE apps ADD COLUMN failed_config_fetch_time INTEGER;");
        a.put("app_version_int", "ALTER TABLE apps ADD COLUMN app_version_int INTEGER;");
        a.put("firebase_instance_id", "ALTER TABLE apps ADD COLUMN firebase_instance_id TEXT;");
        a.put("daily_error_events_count", "ALTER TABLE apps ADD COLUMN daily_error_events_count INTEGER;");
    }

    ags(ahk ahk) {
        super(ahk);
    }

    private boolean J() {
        return q().getDatabasePath(B()).exists();
    }

    @TargetApi(11)
    static int a(Cursor cursor, int i) {
        if (VERSION.SDK_INT >= 11) {
            return cursor.getType(i);
        }
        CursorWindow window = ((SQLiteCursor) cursor).getWindow();
        int position = cursor.getPosition();
        return window.isNull(position, i) ? 0 : window.isLong(position, i) ? 1 : window.isFloat(position, i) ? 2 : window.isString(position, i) ? 3 : window.isBlob(position, i) ? 4 : -1;
    }

    private long a(String str, String[] strArr) {
        Cursor cursor = null;
        try {
            cursor = A().rawQuery(str, strArr);
            if (cursor.moveToFirst()) {
                long j = cursor.getLong(0);
                if (cursor != null) {
                    cursor.close();
                }
                return j;
            }
            throw new SQLiteException("Database returned empty set");
        } catch (SQLiteException e) {
            w().f().a("Database error", str, e);
            throw e;
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
        }
    }

    private long a(String str, String[] strArr, long j) {
        Cursor cursor = null;
        try {
            cursor = A().rawQuery(str, strArr);
            if (cursor.moveToFirst()) {
                j = cursor.getLong(0);
                if (cursor != null) {
                    cursor.close();
                }
            } else if (cursor != null) {
                cursor.close();
            }
            return j;
        } catch (SQLiteException e) {
            w().f().a("Database error", str, e);
            throw e;
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
        }
    }

    private void a(String str, aby$a aby_a) {
        Object obj = null;
        c();
        j();
        xz.a(str);
        xz.a((Object) aby_a);
        xz.a(aby_a.d);
        xz.a(aby_a.c);
        if (aby_a.b == null) {
            w().z().a("Audience with no ID");
            return;
        }
        int intValue = aby_a.b.intValue();
        for (aby$b aby_b : aby_a.d) {
            if (aby_b.b == null) {
                w().z().a("Event filter with no ID. Audience definition ignored. appId, audienceId", str, aby_a.b);
                return;
            }
        }
        for (aby$e aby_e : aby_a.c) {
            if (aby_e.b == null) {
                w().z().a("Property filter with no ID. Audience definition ignored. appId, audienceId", str, aby_a.b);
                return;
            }
        }
        Object obj2 = 1;
        for (aby$b a : aby_a.d) {
            if (!a(str, intValue, a)) {
                obj2 = null;
                break;
            }
        }
        if (obj2 != null) {
            for (aby$e a2 : aby_a.c) {
                if (!a(str, intValue, a2)) {
                    break;
                }
            }
        }
        obj = obj2;
        if (obj == null) {
            b(str, intValue);
        }
    }

    private boolean a(String str, int i, aby$b aby_b) {
        c();
        j();
        xz.a(str);
        xz.a((Object) aby_b);
        if (TextUtils.isEmpty(aby_b.c)) {
            w().z().a("Event filter had no event name. Audience definition ignored. audienceId, filterId", Integer.valueOf(i), String.valueOf(aby_b.b));
            return false;
        }
        try {
            byte[] bArr = new byte[aby_b.b()];
            zzamc a = zzamc.a(bArr);
            aby_b.a(a);
            a.b();
            ContentValues contentValues = new ContentValues();
            contentValues.put("app_id", str);
            contentValues.put("audience_id", Integer.valueOf(i));
            contentValues.put("filter_id", aby_b.b);
            contentValues.put("event_name", aby_b.c);
            contentValues.put("data", bArr);
            try {
                if (A().insertWithOnConflict("event_filters", null, contentValues, 5) == -1) {
                    w().f().a("Failed to insert event filter (got -1)");
                }
                return true;
            } catch (SQLiteException e) {
                w().f().a("Error storing event filter", e);
                return false;
            }
        } catch (IOException e2) {
            w().f().a("Configuration loss. Failed to serialize event filter", e2);
            return false;
        }
    }

    private boolean a(String str, int i, aby$e aby_e) {
        c();
        j();
        xz.a(str);
        xz.a((Object) aby_e);
        if (TextUtils.isEmpty(aby_e.c)) {
            w().z().a("Property filter had no property name. Audience definition ignored. audienceId, filterId", Integer.valueOf(i), String.valueOf(aby_e.b));
            return false;
        }
        try {
            byte[] bArr = new byte[aby_e.b()];
            zzamc a = zzamc.a(bArr);
            aby_e.a(a);
            a.b();
            ContentValues contentValues = new ContentValues();
            contentValues.put("app_id", str);
            contentValues.put("audience_id", Integer.valueOf(i));
            contentValues.put("filter_id", aby_e.b);
            contentValues.put("property_name", aby_e.c);
            contentValues.put("data", bArr);
            try {
                if (A().insertWithOnConflict("property_filters", null, contentValues, 5) != -1) {
                    return true;
                }
                w().f().a("Failed to insert property filter (got -1)");
                return false;
            } catch (SQLiteException e) {
                w().f().a("Error storing property filter", e);
                return false;
            }
        } catch (IOException e2) {
            w().f().a("Configuration loss. Failed to serialize property filter", e2);
            return false;
        }
    }

    SQLiteDatabase A() {
        j();
        try {
            return this.b.getWritableDatabase();
        } catch (SQLiteException e) {
            w().z().a("Error opening database", e);
            throw e;
        }
    }

    String B() {
        if (!y().O()) {
            return y().L();
        }
        if (y().P()) {
            return y().L();
        }
        w().A().a("Using secondary database");
        return y().M();
    }

    public String C() {
        Cursor rawQuery;
        Object e;
        Throwable th;
        String str = null;
        try {
            rawQuery = A().rawQuery("select app_id from queue where app_id not in (select app_id from apps where measurement_enabled=0) order by rowid limit 1;", null);
            try {
                if (rawQuery.moveToFirst()) {
                    str = rawQuery.getString(0);
                    if (rawQuery != null) {
                        rawQuery.close();
                    }
                } else if (rawQuery != null) {
                    rawQuery.close();
                }
            } catch (SQLiteException e2) {
                e = e2;
                try {
                    w().f().a("Database error getting next bundle app id", e);
                    if (rawQuery != null) {
                        rawQuery.close();
                    }
                    return str;
                } catch (Throwable th2) {
                    th = th2;
                    if (rawQuery != null) {
                        rawQuery.close();
                    }
                    throw th;
                }
            }
        } catch (SQLiteException e3) {
            e = e3;
            rawQuery = null;
            w().f().a("Database error getting next bundle app id", e);
            if (rawQuery != null) {
                rawQuery.close();
            }
            return str;
        } catch (Throwable th3) {
            rawQuery = null;
            th = th3;
            if (rawQuery != null) {
                rawQuery.close();
            }
            throw th;
        }
        return str;
    }

    void D() {
        j();
        c();
        if (J()) {
            long a = x().f.a();
            long b = p().b();
            if (Math.abs(b - a) > y().U()) {
                x().f.a(b);
                E();
            }
        }
    }

    void E() {
        j();
        c();
        if (J()) {
            int delete = A().delete("queue", "abs(bundle_end_timestamp - ?) > cast(? as integer)", new String[]{String.valueOf(p().a()), String.valueOf(y().T())});
            if (delete > 0) {
                w().E().a("Deleted stale rows. rowsDeleted", Integer.valueOf(delete));
            }
        }
    }

    public long F() {
        return a("select max(bundle_end_timestamp) from queue", null, 0);
    }

    public long G() {
        return a("select max(timestamp) from raw_events", null, 0);
    }

    public boolean H() {
        return a("select count(1) > 0 from raw_events", null) != 0;
    }

    public ags$a a(long j, String str, boolean z, boolean z2, boolean z3) {
        Cursor query;
        Object e;
        Throwable th;
        xz.a(str);
        j();
        c();
        String[] strArr = new String[]{str};
        ags$a ags_a = new ags$a();
        try {
            SQLiteDatabase A = A();
            query = A.query("apps", new String[]{"day", "daily_events_count", "daily_public_events_count", "daily_conversions_count", "daily_error_events_count"}, "app_id=?", new String[]{str}, null, null, null);
            try {
                if (query.moveToFirst()) {
                    if (query.getLong(0) == j) {
                        ags_a.b = query.getLong(1);
                        ags_a.a = query.getLong(2);
                        ags_a.c = query.getLong(3);
                        ags_a.d = query.getLong(4);
                    }
                    ags_a.b++;
                    if (z) {
                        ags_a.a++;
                    }
                    if (z2) {
                        ags_a.c++;
                    }
                    if (z3) {
                        ags_a.d++;
                    }
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("day", Long.valueOf(j));
                    contentValues.put("daily_public_events_count", Long.valueOf(ags_a.a));
                    contentValues.put("daily_events_count", Long.valueOf(ags_a.b));
                    contentValues.put("daily_conversions_count", Long.valueOf(ags_a.c));
                    contentValues.put("daily_error_events_count", Long.valueOf(ags_a.d));
                    A.update("apps", contentValues, "app_id=?", strArr);
                    if (query != null) {
                        query.close();
                    }
                    return ags_a;
                }
                w().z().a("Not updating daily counts, app is not known", str);
                if (query != null) {
                    query.close();
                }
                return ags_a;
            } catch (SQLiteException e2) {
                e = e2;
                try {
                    w().f().a("Error updating daily counts", e);
                    if (query != null) {
                        query.close();
                    }
                    return ags_a;
                } catch (Throwable th2) {
                    th = th2;
                    if (query != null) {
                        query.close();
                    }
                    throw th;
                }
            }
        } catch (SQLiteException e3) {
            e = e3;
            query = null;
            w().f().a("Error updating daily counts", e);
            if (query != null) {
                query.close();
            }
            return ags_a;
        } catch (Throwable th3) {
            th = th3;
            query = null;
            if (query != null) {
                query.close();
            }
            throw th;
        }
    }

    public agw a(String str, String str2) {
        Object e;
        Cursor cursor;
        Throwable th;
        Cursor cursor2 = null;
        xz.a(str);
        xz.a(str2);
        j();
        c();
        try {
            Cursor query = A().query("events", new String[]{"lifetime_count", "current_bundle_count", "last_fire_timestamp"}, "app_id=? and name=?", new String[]{str, str2}, null, null, null);
            try {
                if (query.moveToFirst()) {
                    agw agw = new agw(str, str2, query.getLong(0), query.getLong(1), query.getLong(2));
                    if (query.moveToNext()) {
                        w().f().a("Got multiple records for event aggregates, expected one");
                    }
                    if (query == null) {
                        return agw;
                    }
                    query.close();
                    return agw;
                }
                if (query != null) {
                    query.close();
                }
                return null;
            } catch (SQLiteException e2) {
                e = e2;
                cursor = query;
                try {
                    w().f().a("Error querying events", str, str2, e);
                    if (cursor != null) {
                        cursor.close();
                    }
                    return null;
                } catch (Throwable th2) {
                    th = th2;
                    cursor2 = cursor;
                    if (cursor2 != null) {
                        cursor2.close();
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                cursor2 = query;
                if (cursor2 != null) {
                    cursor2.close();
                }
                throw th;
            }
        } catch (SQLiteException e3) {
            e = e3;
            cursor = null;
            w().f().a("Error querying events", str, str2, e);
            if (cursor != null) {
                cursor.close();
            }
            return null;
        } catch (Throwable th4) {
            th = th4;
            if (cursor2 != null) {
                cursor2.close();
            }
            throw th;
        }
    }

    public List<agn> a(String str) {
        Object e;
        Cursor cursor;
        Throwable th;
        Cursor cursor2 = null;
        xz.a(str);
        j();
        c();
        List<agn> arrayList = new ArrayList();
        try {
            Cursor query = A().query("user_attributes", new String[]{"name", "set_timestamp", "value"}, "app_id=?", new String[]{str}, null, null, "rowid", String.valueOf(y().G()));
            try {
                if (query.moveToFirst()) {
                    do {
                        String string = query.getString(0);
                        long j = query.getLong(1);
                        Object b = b(query, 2);
                        if (b == null) {
                            w().f().a("Read invalid user property value, ignoring it");
                        } else {
                            arrayList.add(new agn(str, string, j, b));
                        }
                    } while (query.moveToNext());
                    if (query != null) {
                        query.close();
                    }
                    return arrayList;
                }
                if (query != null) {
                    query.close();
                }
                return arrayList;
            } catch (SQLiteException e2) {
                e = e2;
                cursor = query;
            } catch (Throwable th2) {
                th = th2;
                cursor2 = query;
            }
        } catch (SQLiteException e3) {
            e = e3;
            cursor = null;
            try {
                w().f().a("Error querying user properties", str, e);
                if (cursor != null) {
                    cursor.close();
                }
                return null;
            } catch (Throwable th3) {
                th = th3;
                cursor2 = cursor;
                if (cursor2 != null) {
                    cursor2.close();
                }
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            if (cursor2 != null) {
                cursor2.close();
            }
            throw th;
        }
    }

    public List<Pair<aca$e, Long>> a(String str, int i, int i2) {
        Cursor query;
        Object e;
        Cursor cursor;
        Throwable th;
        boolean z = true;
        j();
        c();
        xz.b(i > 0);
        if (i2 <= 0) {
            z = false;
        }
        xz.b(z);
        xz.a(str);
        List<Pair<aca$e, Long>> emptyList;
        try {
            query = A().query("queue", new String[]{"rowid", "data"}, "app_id=?", new String[]{str}, null, null, "rowid", String.valueOf(i));
            try {
                if (query.moveToFirst()) {
                    List<Pair<aca$e, Long>> arrayList = new ArrayList();
                    int i3 = 0;
                    while (true) {
                        long j = query.getLong(0);
                        int length;
                        try {
                            byte[] b = s().b(query.getBlob(1));
                            if (!arrayList.isEmpty() && b.length + i3 > i2) {
                                break;
                            }
                            aas a = aas.a(b);
                            aca$e aca_e = new aca$e();
                            try {
                                aca$e aca_e2 = (aca$e) aca_e.a(a);
                                length = b.length + i3;
                                arrayList.add(Pair.create(aca_e, Long.valueOf(j)));
                            } catch (IOException e2) {
                                w().f().a("Failed to merge queued bundle", str, e2);
                                length = i3;
                            }
                            if (!query.moveToNext() || length > i2) {
                                break;
                            }
                            i3 = length;
                        } catch (IOException e22) {
                            w().f().a("Failed to unzip queued bundle", str, e22);
                            length = i3;
                        }
                    }
                    if (query != null) {
                        query.close();
                    }
                    return arrayList;
                }
                emptyList = Collections.emptyList();
                if (query == null) {
                    return emptyList;
                }
                query.close();
                return emptyList;
            } catch (SQLiteException e3) {
                e = e3;
                cursor = query;
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (SQLiteException e4) {
            e = e4;
            cursor = null;
            try {
                w().f().a("Error querying bundles", str, e);
                emptyList = Collections.emptyList();
                if (cursor == null) {
                    return emptyList;
                }
                cursor.close();
                return emptyList;
            } catch (Throwable th3) {
                th = th3;
                query = cursor;
                if (query != null) {
                    query.close();
                }
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            query = null;
            if (query != null) {
                query.close();
            }
            throw th;
        }
    }

    public void a(long j) {
        j();
        c();
        if (A().delete("queue", "rowid=?", new String[]{String.valueOf(j)}) != 1) {
            w().f().a("Deleted fewer rows from queue than expected");
        }
    }

    public void a(aca$e aca_e) {
        j();
        c();
        xz.a((Object) aca_e);
        xz.a(aca_e.p);
        xz.a(aca_e.g);
        D();
        long a = p().a();
        if (aca_e.g.longValue() < a - y().T() || aca_e.g.longValue() > y().T() + a) {
            w().z().a("Storing bundle outside of the max uploading time span. now, timestamp", Long.valueOf(a), aca_e.g);
        }
        try {
            byte[] bArr = new byte[aca_e.b()];
            zzamc a2 = zzamc.a(bArr);
            aca_e.a(a2);
            a2.b();
            bArr = s().a(bArr);
            w().E().a("Saving bundle, size", Integer.valueOf(bArr.length));
            ContentValues contentValues = new ContentValues();
            contentValues.put("app_id", aca_e.p);
            contentValues.put("bundle_end_timestamp", aca_e.g);
            contentValues.put("data", bArr);
            try {
                if (A().insert("queue", null, contentValues) == -1) {
                    w().f().a("Failed to insert bundle (got -1)");
                }
            } catch (SQLiteException e) {
                w().f().a("Error storing bundle", e);
            }
        } catch (IOException e2) {
            w().f().a("Data loss. Failed to serialize bundle", e2);
        }
    }

    public void a(agc agc) {
        xz.a((Object) agc);
        j();
        c();
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", agc.b());
        contentValues.put("app_instance_id", agc.c());
        contentValues.put("gmp_app_id", agc.d());
        contentValues.put("resettable_device_id_hash", agc.e());
        contentValues.put("last_bundle_index", Long.valueOf(agc.o()));
        contentValues.put("last_bundle_start_timestamp", Long.valueOf(agc.g()));
        contentValues.put("last_bundle_end_timestamp", Long.valueOf(agc.h()));
        contentValues.put("app_version", agc.i());
        contentValues.put("app_store", agc.k());
        contentValues.put("gmp_version", Long.valueOf(agc.l()));
        contentValues.put("dev_cert_hash", Long.valueOf(agc.m()));
        contentValues.put("measurement_enabled", Boolean.valueOf(agc.n()));
        contentValues.put("day", Long.valueOf(agc.s()));
        contentValues.put("daily_public_events_count", Long.valueOf(agc.t()));
        contentValues.put("daily_events_count", Long.valueOf(agc.u()));
        contentValues.put("daily_conversions_count", Long.valueOf(agc.v()));
        contentValues.put("config_fetched_time", Long.valueOf(agc.p()));
        contentValues.put("failed_config_fetch_time", Long.valueOf(agc.q()));
        contentValues.put("app_version_int", Long.valueOf(agc.j()));
        contentValues.put("firebase_instance_id", agc.f());
        contentValues.put("daily_error_events_count", Long.valueOf(agc.w()));
        try {
            if (A().insertWithOnConflict("apps", null, contentValues, 5) == -1) {
                w().f().a("Failed to insert/update app (got -1)");
            }
        } catch (SQLiteException e) {
            w().f().a("Error storing app", e);
        }
    }

    public void a(agv agv, long j) {
        j();
        c();
        xz.a((Object) agv);
        xz.a(agv.a);
        aca$b aca_b = new aca$b();
        aca_b.e = Long.valueOf(agv.e);
        aca_b.b = new aca$c[agv.f.a()];
        Iterator it = agv.f.iterator();
        int i = 0;
        while (it.hasNext()) {
            String str = (String) it.next();
            aca$c aca_c = new aca$c();
            int i2 = i + 1;
            aca_b.b[i] = aca_c;
            aca_c.b = str;
            s().a(aca_c, agv.f.a(str));
            i = i2;
        }
        try {
            byte[] bArr = new byte[aca_b.b()];
            zzamc a = zzamc.a(bArr);
            aca_b.a(a);
            a.b();
            w().E().a("Saving event, name, data size", agv.b, Integer.valueOf(bArr.length));
            ContentValues contentValues = new ContentValues();
            contentValues.put("app_id", agv.a);
            contentValues.put("name", agv.b);
            contentValues.put("timestamp", Long.valueOf(agv.d));
            contentValues.put("metadata_fingerprint", Long.valueOf(j));
            contentValues.put("data", bArr);
            try {
                if (A().insert("raw_events", null, contentValues) == -1) {
                    w().f().a("Failed to insert raw event (got -1)");
                }
            } catch (SQLiteException e) {
                w().f().a("Error storing raw event", e);
            }
        } catch (IOException e2) {
            w().f().a("Data loss. Failed to serialize event params/data", e2);
        }
    }

    public void a(agw agw) {
        xz.a((Object) agw);
        j();
        c();
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", agw.a);
        contentValues.put("name", agw.b);
        contentValues.put("lifetime_count", Long.valueOf(agw.c));
        contentValues.put("current_bundle_count", Long.valueOf(agw.d));
        contentValues.put("last_fire_timestamp", Long.valueOf(agw.e));
        try {
            if (A().insertWithOnConflict("events", null, contentValues, 5) == -1) {
                w().f().a("Failed to insert/update event aggregates (got -1)");
            }
        } catch (SQLiteException e) {
            w().f().a("Error storing event aggregates", e);
        }
    }

    void a(ContentValues contentValues, String str, Object obj) {
        xz.a(str);
        xz.a(obj);
        if (obj instanceof String) {
            contentValues.put(str, (String) obj);
        } else if (obj instanceof Long) {
            contentValues.put(str, (Long) obj);
        } else if (obj instanceof Double) {
            contentValues.put(str, (Double) obj);
        } else {
            throw new IllegalArgumentException("Invalid value type");
        }
    }

    public void a(String str, int i) {
        xz.a(str);
        j();
        c();
        try {
            A().execSQL("delete from user_attributes where app_id=? and name in (select name from user_attributes where app_id=? and name like '_ltv_%' order by set_timestamp desc limit ?,10);", new String[]{str, str, String.valueOf(i)});
        } catch (SQLiteException e) {
            w().f().a("Error pruning currencies", str, e);
        }
    }

    void a(String str, int i, aca$f aca_f) {
        c();
        j();
        xz.a(str);
        xz.a((Object) aca_f);
        try {
            byte[] bArr = new byte[aca_f.b()];
            zzamc a = zzamc.a(bArr);
            aca_f.a(a);
            a.b();
            ContentValues contentValues = new ContentValues();
            contentValues.put("app_id", str);
            contentValues.put("audience_id", Integer.valueOf(i));
            contentValues.put("current_results", bArr);
            try {
                if (A().insertWithOnConflict("audience_filter_values", null, contentValues, 5) == -1) {
                    w().f().a("Failed to insert filter results (got -1)");
                }
            } catch (SQLiteException e) {
                w().f().a("Error storing filter results", e);
            }
        } catch (IOException e2) {
            w().f().a("Configuration loss. Failed to serialize filter results", e2);
        }
    }

    public void a(String str, long j, ags$b ags_b) {
        Object string;
        Object e;
        Throwable th;
        Cursor cursor = null;
        xz.a((Object) ags_b);
        j();
        c();
        Cursor cursor2;
        try {
            String str2;
            SQLiteDatabase A = A();
            String string2;
            if (TextUtils.isEmpty(str)) {
                cursor = A.rawQuery("select app_id, metadata_fingerprint from raw_events where app_id in (select app_id from apps where config_fetched_time >= ?) order by rowid limit 1;", new String[]{String.valueOf(j)});
                if (cursor.moveToFirst()) {
                    string = cursor.getString(0);
                    string2 = cursor.getString(1);
                    cursor.close();
                    str2 = string2;
                    cursor2 = cursor;
                } else if (cursor != null) {
                    cursor.close();
                    return;
                } else {
                    return;
                }
            }
            cursor = A.rawQuery("select metadata_fingerprint from raw_events where app_id = ? order by rowid limit 1;", new String[]{str});
            if (cursor.moveToFirst()) {
                string2 = cursor.getString(0);
                cursor.close();
                str2 = string2;
                cursor2 = cursor;
            } else if (cursor != null) {
                cursor.close();
                return;
            } else {
                return;
            }
            try {
                cursor2 = A.query("raw_events_metadata", new String[]{"metadata"}, "app_id=? and metadata_fingerprint=?", new String[]{string, str2}, null, null, "rowid", "2");
                if (cursor2.moveToFirst()) {
                    aas a = aas.a(cursor2.getBlob(0));
                    aca$e aca_e = new aca$e();
                    try {
                        aca$e aca_e2 = (aca$e) aca_e.a(a);
                        if (cursor2.moveToNext()) {
                            w().z().a("Get multiple raw event metadata records, expected one");
                        }
                        cursor2.close();
                        ags_b.a(aca_e);
                        cursor = A.query("raw_events", new String[]{"rowid", "name", "timestamp", "data"}, "app_id=? and metadata_fingerprint=?", new String[]{string, str2}, null, null, "rowid", null);
                        if (cursor.moveToFirst()) {
                            do {
                                try {
                                    long j2 = cursor.getLong(0);
                                    aas a2 = aas.a(cursor.getBlob(3));
                                    aca$b aca_b = new aca$b();
                                    try {
                                        aca$b aca_b2 = (aca$b) aca_b.a(a2);
                                        aca_b.c = cursor.getString(1);
                                        aca_b.d = Long.valueOf(cursor.getLong(2));
                                        if (!ags_b.a(j2, aca_b)) {
                                            if (cursor != null) {
                                                cursor.close();
                                                return;
                                            }
                                            return;
                                        }
                                    } catch (IOException e2) {
                                        w().f().a("Data loss. Failed to merge raw event", string, e2);
                                    }
                                } catch (SQLiteException e3) {
                                    e = e3;
                                }
                            } while (cursor.moveToNext());
                            if (cursor != null) {
                                cursor.close();
                                return;
                            }
                            return;
                        }
                        w().z().a("Raw event data disappeared while in transaction");
                        if (cursor != null) {
                            cursor.close();
                            return;
                        }
                        return;
                    } catch (IOException e22) {
                        w().f().a("Data loss. Failed to merge raw event metadata", string, e22);
                        if (cursor2 != null) {
                            cursor2.close();
                            return;
                        }
                        return;
                    }
                }
                w().f().a("Raw event metadata record is missing");
                if (cursor2 != null) {
                    cursor2.close();
                }
            } catch (SQLiteException e4) {
                e = e4;
                cursor = cursor2;
                try {
                    w().f().a("Data loss. Error selecting raw event", e);
                    if (cursor != null) {
                        cursor.close();
                    }
                } catch (Throwable th2) {
                    th = th2;
                    cursor2 = cursor;
                    if (cursor2 != null) {
                        cursor2.close();
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                if (cursor2 != null) {
                    cursor2.close();
                }
                throw th;
            }
        } catch (SQLiteException e32) {
            e = e32;
        } catch (Throwable th4) {
            th = th4;
            cursor2 = cursor;
            if (cursor2 != null) {
                cursor2.close();
            }
            throw th;
        }
    }

    public void a(String str, byte[] bArr) {
        xz.a(str);
        j();
        c();
        ContentValues contentValues = new ContentValues();
        contentValues.put("remote_config", bArr);
        try {
            if (((long) A().update("apps", contentValues, "app_id = ?", new String[]{str})) == 0) {
                w().f().a("Failed to update remote config (got 0)");
            }
        } catch (SQLiteException e) {
            w().f().a("Error storing remote config", e);
        }
    }

    void a(String str, aby$a[] aby_aArr) {
        c();
        j();
        xz.a(str);
        xz.a((Object) aby_aArr);
        SQLiteDatabase A = A();
        A.beginTransaction();
        try {
            e(str);
            for (aby$a a : aby_aArr) {
                a(str, a);
            }
            A.setTransactionSuccessful();
        } finally {
            A.endTransaction();
        }
    }

    public void a(List<Long> list) {
        xz.a((Object) list);
        j();
        c();
        StringBuilder stringBuilder = new StringBuilder("rowid in (");
        for (int i = 0; i < list.size(); i++) {
            if (i != 0) {
                stringBuilder.append(",");
            }
            stringBuilder.append(((Long) list.get(i)).longValue());
        }
        stringBuilder.append(")");
        int delete = A().delete("raw_events", stringBuilder.toString(), null);
        if (delete != list.size()) {
            w().f().a("Deleted fewer rows from raw events table than expected", Integer.valueOf(delete), Integer.valueOf(list.size()));
        }
    }

    public boolean a(agn agn) {
        xz.a((Object) agn);
        j();
        c();
        if (c(agn.a, agn.b) == null) {
            if (ago.a(agn.b)) {
                if (a("select count(1) from user_attributes where app_id=? and name not like '!_%' escape '!'", new String[]{agn.a}) >= ((long) y().F())) {
                    return false;
                }
            }
            if (a("select count(1) from user_attributes where app_id=?", new String[]{agn.a}) >= ((long) y().G())) {
                return false;
            }
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", agn.a);
        contentValues.put("name", agn.b);
        contentValues.put("set_timestamp", Long.valueOf(agn.c));
        a(contentValues, "value", agn.d);
        try {
            if (A().insertWithOnConflict("user_attributes", null, contentValues, 5) == -1) {
                w().f().a("Failed to insert/update user property (got -1)");
            }
        } catch (SQLiteException e) {
            w().f().a("Error storing user property", e);
        }
        return true;
    }

    public long b(aca$e aca_e) throws IOException {
        j();
        c();
        xz.a((Object) aca_e);
        xz.a(aca_e.p);
        try {
            byte[] bArr = new byte[aca_e.b()];
            zzamc a = zzamc.a(bArr);
            aca_e.a(a);
            a.b();
            long d = s().d(bArr);
            ContentValues contentValues = new ContentValues();
            contentValues.put("app_id", aca_e.p);
            contentValues.put("metadata_fingerprint", Long.valueOf(d));
            contentValues.put("metadata", bArr);
            try {
                A().insertWithOnConflict("raw_events_metadata", null, contentValues, 4);
                return d;
            } catch (SQLiteException e) {
                w().f().a("Error storing raw event metadata", e);
                throw e;
            }
        } catch (IOException e2) {
            w().f().a("Data loss. Failed to serialize event metadata", e2);
            throw e2;
        }
    }

    public agc b(String str) {
        Cursor query;
        Object e;
        Throwable th;
        xz.a(str);
        j();
        c();
        try {
            query = A().query("apps", new String[]{"app_instance_id", "gmp_app_id", "resettable_device_id_hash", "last_bundle_index", "last_bundle_start_timestamp", "last_bundle_end_timestamp", "app_version", "app_store", "gmp_version", "dev_cert_hash", "measurement_enabled", "day", "daily_public_events_count", "daily_events_count", "daily_conversions_count", "config_fetched_time", "failed_config_fetch_time", "app_version_int", "firebase_instance_id", "daily_error_events_count"}, "app_id=?", new String[]{str}, null, null, null);
            try {
                if (query.moveToFirst()) {
                    agc agc = new agc(this.n, str);
                    agc.a(query.getString(0));
                    agc.b(query.getString(1));
                    agc.c(query.getString(2));
                    agc.f(query.getLong(3));
                    agc.a(query.getLong(4));
                    agc.b(query.getLong(5));
                    agc.e(query.getString(6));
                    agc.f(query.getString(7));
                    agc.d(query.getLong(8));
                    agc.e(query.getLong(9));
                    agc.a((query.isNull(10) ? 1 : query.getInt(10)) != 0);
                    agc.i(query.getLong(11));
                    agc.j(query.getLong(12));
                    agc.k(query.getLong(13));
                    agc.l(query.getLong(14));
                    agc.g(query.getLong(15));
                    agc.h(query.getLong(16));
                    agc.c(query.isNull(17) ? -2147483648L : (long) query.getInt(17));
                    agc.d(query.getString(18));
                    agc.m(query.getLong(19));
                    agc.a();
                    if (query.moveToNext()) {
                        w().f().a("Got multiple records for app, expected one");
                    }
                    if (query == null) {
                        return agc;
                    }
                    query.close();
                    return agc;
                }
                if (query != null) {
                    query.close();
                }
                return null;
            } catch (SQLiteException e2) {
                e = e2;
                try {
                    w().f().a("Error querying app", str, e);
                    if (query != null) {
                        query.close();
                    }
                    return null;
                } catch (Throwable th2) {
                    th = th2;
                    if (query != null) {
                        query.close();
                    }
                    throw th;
                }
            }
        } catch (SQLiteException e3) {
            e = e3;
            query = null;
            w().f().a("Error querying app", str, e);
            if (query != null) {
                query.close();
            }
            return null;
        } catch (Throwable th3) {
            th = th3;
            query = null;
            if (query != null) {
                query.close();
            }
            throw th;
        }
    }

    Object b(Cursor cursor, int i) {
        int a = ags.a(cursor, i);
        switch (a) {
            case uu$h.com_facebook_login_view_com_facebook_confirm_logout /*0*/:
                w().f().a("Loaded invalid null value from database");
                return null;
            case uu$h.com_facebook_profile_picture_view_com_facebook_is_cropped /*1*/:
                return Long.valueOf(cursor.getLong(i));
            case uu$h.com_facebook_login_view_com_facebook_logout_text /*2*/:
                return Double.valueOf(cursor.getDouble(i));
            case uu$h.com_facebook_login_view_com_facebook_tooltip_mode /*3*/:
                return cursor.getString(i);
            case uu$h.com_facebook_like_view_com_facebook_auxiliary_view_position /*4*/:
                w().f().a("Loaded invalid blob type value, ignoring it");
                return null;
            default:
                w().f().a("Loaded invalid unknown value type, ignoring it", Integer.valueOf(a));
                return null;
        }
    }

    public String b(long j) {
        Cursor rawQuery;
        Object e;
        Throwable th;
        String str = null;
        j();
        c();
        try {
            rawQuery = A().rawQuery("select app_id from apps where app_id in (select distinct app_id from raw_events) and config_fetched_time < ? order by failed_config_fetch_time limit 1;", new String[]{String.valueOf(j)});
            try {
                if (rawQuery.moveToFirst()) {
                    str = rawQuery.getString(0);
                    if (rawQuery != null) {
                        rawQuery.close();
                    }
                } else {
                    w().E().a("No expired configs for apps with pending events");
                    if (rawQuery != null) {
                        rawQuery.close();
                    }
                }
            } catch (SQLiteException e2) {
                e = e2;
                try {
                    w().f().a("Error selecting expired configs", e);
                    if (rawQuery != null) {
                        rawQuery.close();
                    }
                    return str;
                } catch (Throwable th2) {
                    th = th2;
                    if (rawQuery != null) {
                        rawQuery.close();
                    }
                    throw th;
                }
            }
        } catch (SQLiteException e3) {
            e = e3;
            rawQuery = str;
            w().f().a("Error selecting expired configs", e);
            if (rawQuery != null) {
                rawQuery.close();
            }
            return str;
        } catch (Throwable th3) {
            rawQuery = str;
            th = th3;
            if (rawQuery != null) {
                rawQuery.close();
            }
            throw th;
        }
        return str;
    }

    void b(String str, int i) {
        c();
        j();
        xz.a(str);
        SQLiteDatabase A = A();
        A.delete("property_filters", "app_id=? and audience_id=?", new String[]{str, String.valueOf(i)});
        A.delete("event_filters", "app_id=? and audience_id=?", new String[]{str, String.valueOf(i)});
    }

    public void b(String str, String str2) {
        xz.a(str);
        xz.a(str2);
        j();
        c();
        try {
            w().E().a("Deleted user attribute rows:", Integer.valueOf(A().delete("user_attributes", "app_id=? and name=?", new String[]{str, str2})));
        } catch (SQLiteException e) {
            w().f().a("Error deleting user attribute", str, str2, e);
        }
    }

    public long c(String str) {
        xz.a(str);
        j();
        c();
        try {
            SQLiteDatabase A = A();
            String valueOf = String.valueOf(y().f(str));
            return (long) A.delete("raw_events", "rowid in (select rowid from raw_events where app_id=? order by rowid desc limit -1 offset ?)", new String[]{str, valueOf});
        } catch (SQLiteException e) {
            w().f().a("Error deleting over the limit events", e);
            return 0;
        }
    }

    public agn c(String str, String str2) {
        Object e;
        Cursor cursor;
        Throwable th;
        Cursor cursor2 = null;
        xz.a(str);
        xz.a(str2);
        j();
        c();
        try {
            Cursor query = A().query("user_attributes", new String[]{"set_timestamp", "value"}, "app_id=? and name=?", new String[]{str, str2}, null, null, null);
            try {
                if (query.moveToFirst()) {
                    agn agn = new agn(str, str2, query.getLong(0), b(query, 1));
                    if (query.moveToNext()) {
                        w().f().a("Got multiple records for user property, expected one");
                    }
                    if (query == null) {
                        return agn;
                    }
                    query.close();
                    return agn;
                }
                if (query != null) {
                    query.close();
                }
                return null;
            } catch (SQLiteException e2) {
                e = e2;
                cursor = query;
                try {
                    w().f().a("Error querying user property", str, str2, e);
                    if (cursor != null) {
                        cursor.close();
                    }
                    return null;
                } catch (Throwable th2) {
                    th = th2;
                    cursor2 = cursor;
                    if (cursor2 != null) {
                        cursor2.close();
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                cursor2 = query;
                if (cursor2 != null) {
                    cursor2.close();
                }
                throw th;
            }
        } catch (SQLiteException e3) {
            e = e3;
            cursor = null;
            w().f().a("Error querying user property", str, str2, e);
            if (cursor != null) {
                cursor.close();
            }
            return null;
        } catch (Throwable th4) {
            th = th4;
            if (cursor2 != null) {
                cursor2.close();
            }
            throw th;
        }
    }

    Map<Integer, List<aby$b>> d(String str, String str2) {
        Cursor query;
        Object e;
        Throwable th;
        c();
        j();
        xz.a(str);
        xz.a(str2);
        Map<Integer, List<aby$b>> dhVar = new dh();
        try {
            query = A().query("event_filters", new String[]{"audience_id", "data"}, "app_id=? AND event_name=?", new String[]{str, str2}, null, null, null);
            if (query.moveToFirst()) {
                do {
                    aas a = aas.a(query.getBlob(1));
                    aby$b aby_b = new aby$b();
                    try {
                        aby$b aby_b2 = (aby$b) aby_b.a(a);
                        try {
                            int i = query.getInt(0);
                            List list = (List) dhVar.get(Integer.valueOf(i));
                            if (list == null) {
                                list = new ArrayList();
                                dhVar.put(Integer.valueOf(i), list);
                            }
                            list.add(aby_b);
                        } catch (SQLiteException e2) {
                            e = e2;
                        }
                    } catch (IOException e3) {
                        w().f().a("Failed to merge filter", str, e3);
                    }
                } while (query.moveToNext());
                if (query != null) {
                    query.close();
                }
                return dhVar;
            }
            Map<Integer, List<aby$b>> emptyMap = Collections.emptyMap();
            if (query == null) {
                return emptyMap;
            }
            query.close();
            return emptyMap;
        } catch (SQLiteException e4) {
            e = e4;
            query = null;
            try {
                w().f().a("Database error querying filters", e);
                if (query != null) {
                    query.close();
                }
                return null;
            } catch (Throwable th2) {
                th = th2;
                if (query != null) {
                    query.close();
                }
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            query = null;
            if (query != null) {
                query.close();
            }
            throw th;
        }
    }

    public byte[] d(String str) {
        Object e;
        Throwable th;
        xz.a(str);
        j();
        c();
        Cursor query;
        try {
            query = A().query("apps", new String[]{"remote_config"}, "app_id=?", new String[]{str}, null, null, null);
            try {
                if (query.moveToFirst()) {
                    byte[] blob = query.getBlob(0);
                    if (query.moveToNext()) {
                        w().f().a("Got multiple records for app config, expected one");
                    }
                    if (query == null) {
                        return blob;
                    }
                    query.close();
                    return blob;
                }
                if (query != null) {
                    query.close();
                }
                return null;
            } catch (SQLiteException e2) {
                e = e2;
                try {
                    w().f().a("Error querying remote config", str, e);
                    if (query != null) {
                        query.close();
                    }
                    return null;
                } catch (Throwable th2) {
                    th = th2;
                    if (query != null) {
                        query.close();
                    }
                    throw th;
                }
            }
        } catch (SQLiteException e3) {
            e = e3;
            query = null;
            w().f().a("Error querying remote config", str, e);
            if (query != null) {
                query.close();
            }
            return null;
        } catch (Throwable th3) {
            th = th3;
            query = null;
            if (query != null) {
                query.close();
            }
            throw th;
        }
    }

    Map<Integer, List<aby$e>> e(String str, String str2) {
        Object e;
        Throwable th;
        c();
        j();
        xz.a(str);
        xz.a(str2);
        Map<Integer, List<aby$e>> dhVar = new dh();
        Cursor query;
        try {
            query = A().query("property_filters", new String[]{"audience_id", "data"}, "app_id=? AND property_name=?", new String[]{str, str2}, null, null, null);
            if (query.moveToFirst()) {
                do {
                    aas a = aas.a(query.getBlob(1));
                    aby$e aby_e = new aby$e();
                    try {
                        aby$e aby_e2 = (aby$e) aby_e.a(a);
                        try {
                            int i = query.getInt(0);
                            List list = (List) dhVar.get(Integer.valueOf(i));
                            if (list == null) {
                                list = new ArrayList();
                                dhVar.put(Integer.valueOf(i), list);
                            }
                            list.add(aby_e);
                        } catch (SQLiteException e2) {
                            e = e2;
                        }
                    } catch (IOException e3) {
                        w().f().a("Failed to merge filter", str, e3);
                    }
                } while (query.moveToNext());
                if (query != null) {
                    query.close();
                }
                return dhVar;
            }
            Map<Integer, List<aby$e>> emptyMap = Collections.emptyMap();
            if (query == null) {
                return emptyMap;
            }
            query.close();
            return emptyMap;
        } catch (SQLiteException e4) {
            e = e4;
            query = null;
            try {
                w().f().a("Database error querying filters", e);
                if (query != null) {
                    query.close();
                }
                return null;
            } catch (Throwable th2) {
                th = th2;
                if (query != null) {
                    query.close();
                }
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            query = null;
            if (query != null) {
                query.close();
            }
            throw th;
        }
    }

    protected void e() {
    }

    void e(String str) {
        c();
        j();
        xz.a(str);
        SQLiteDatabase A = A();
        A.delete("property_filters", "app_id=?", new String[]{str});
        A.delete("event_filters", "app_id=?", new String[]{str});
    }

    Map<Integer, aca$f> f(String str) {
        Cursor query;
        Object e;
        Cursor cursor;
        Throwable th;
        c();
        j();
        xz.a(str);
        try {
            query = A().query("audience_filter_values", new String[]{"audience_id", "current_results"}, "app_id=?", new String[]{str}, null, null, null);
            try {
                if (query.moveToFirst()) {
                    Map<Integer, aca$f> dhVar = new dh();
                    do {
                        int i = query.getInt(0);
                        aas a = aas.a(query.getBlob(1));
                        aca$f aca_f = new aca$f();
                        try {
                            aca$f aca_f2 = (aca$f) aca_f.a(a);
                            dhVar.put(Integer.valueOf(i), aca_f);
                        } catch (IOException e2) {
                            w().f().a("Failed to merge filter results. appId, audienceId, error", str, Integer.valueOf(i), e2);
                        }
                    } while (query.moveToNext());
                    if (query != null) {
                        query.close();
                    }
                    return dhVar;
                }
                if (query != null) {
                    query.close();
                }
                return null;
            } catch (SQLiteException e3) {
                e = e3;
                cursor = query;
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (SQLiteException e4) {
            e = e4;
            cursor = null;
            try {
                w().f().a("Database error querying filter results", e);
                if (cursor != null) {
                    cursor.close();
                }
                return null;
            } catch (Throwable th3) {
                th = th3;
                query = cursor;
                if (query != null) {
                    query.close();
                }
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            query = null;
            if (query != null) {
                query.close();
            }
            throw th;
        }
    }

    public void f() {
        c();
        A().beginTransaction();
    }

    public void g() {
        c();
        A().setTransactionSuccessful();
    }

    void g(String str) {
        c();
        j();
        xz.a(str);
        try {
            SQLiteDatabase A = A();
            String[] strArr = new String[]{str};
            int delete = A.delete("audience_filter_values", "app_id=?", strArr) + (((((((A.delete("events", "app_id=?", strArr) + 0) + A.delete("user_attributes", "app_id=?", strArr)) + A.delete("apps", "app_id=?", strArr)) + A.delete("raw_events", "app_id=?", strArr)) + A.delete("raw_events_metadata", "app_id=?", strArr)) + A.delete("event_filters", "app_id=?", strArr)) + A.delete("property_filters", "app_id=?", strArr));
            if (delete > 0) {
                w().E().a("Deleted application data. app, records", str, Integer.valueOf(delete));
            }
        } catch (SQLiteException e) {
            w().f().a("Error deleting application data. appId, error", str, e);
        }
    }

    public void h(String str) {
        try {
            A().execSQL("delete from raw_events_metadata where app_id=? and metadata_fingerprint not in (select distinct metadata_fingerprint from raw_events where app_id=?)", new String[]{str, str});
        } catch (SQLiteException e) {
            w().f().a("Failed to remove unused event metadata", e);
        }
    }

    public long i(String str) {
        xz.a(str);
        return a("select count(1) from events where app_id=? and name not like '!_%' escape '!'", new String[]{str}, 0);
    }

    public void z() {
        c();
        A().endTransaction();
    }
}
