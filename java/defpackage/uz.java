package defpackage;

import android.content.Context;
import android.util.Log;
import com.facebook.appevents.AccessTokenAppIdPair;
import com.facebook.appevents.AppEvent;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.appevents.PersistedEvents;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.FileNotFoundException;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.List;

/* compiled from: AppEventStore */
class uz {
    private static final String a = uz.class.getName();

    uz() {
    }

    public static synchronized void a(AccessTokenAppIdPair accessTokenAppIdPair, vb appEvents) {
        synchronized (uz.class) {
            uz.b();
            PersistedEvents persistedEvents = uz.a();
            if (persistedEvents.containsKey(accessTokenAppIdPair)) {
                ((List) persistedEvents.get(accessTokenAppIdPair)).addAll(appEvents.b());
            } else {
                persistedEvents.put(accessTokenAppIdPair, appEvents.b());
            }
            uz.a(persistedEvents);
        }
    }

    public static synchronized PersistedEvents a() {
        PersistedEvents persistedEvents;
        Exception e;
        Throwable th;
        synchronized (uz.class) {
            uz.b();
            Closeable ois = null;
            HashMap<AccessTokenAppIdPair, List<AppEvent>> obj = null;
            persistedEvents = null;
            Context context = AppEventsLogger.d();
            try {
                Closeable ois2 = new uz$a(new BufferedInputStream(context.openFileInput("AppEventsLogger.persistedevents")));
                try {
                    obj = (HashMap) ois2.readObject();
                    we.a(ois2);
                    try {
                        context.getFileStreamPath("AppEventsLogger.persistedevents").delete();
                        if (obj != null) {
                            persistedEvents = new PersistedEvents(obj);
                        }
                        ois = ois2;
                    } catch (Exception ex) {
                        Log.w(a, "Got unexpected exception when removing events file: " + ex.toString());
                        ois = ois2;
                    }
                } catch (FileNotFoundException e2) {
                    ois = ois2;
                    we.a(ois);
                    try {
                        context.getFileStreamPath("AppEventsLogger.persistedevents").delete();
                        if (obj != null) {
                            persistedEvents = new PersistedEvents(obj);
                        }
                    } catch (Exception ex2) {
                        Log.w(a, "Got unexpected exception when removing events file: " + ex2.toString());
                    }
                    if (persistedEvents == null) {
                        persistedEvents = new PersistedEvents();
                    }
                    return persistedEvents;
                } catch (Exception e3) {
                    e = e3;
                    ois = ois2;
                    try {
                        Log.w(a, "Got unexpected exception while reading events: " + e.toString());
                        we.a(ois);
                        try {
                            context.getFileStreamPath("AppEventsLogger.persistedevents").delete();
                            if (obj != null) {
                                persistedEvents = new PersistedEvents(obj);
                            }
                        } catch (Exception ex22) {
                            Log.w(a, "Got unexpected exception when removing events file: " + ex22.toString());
                        }
                        if (persistedEvents == null) {
                            persistedEvents = new PersistedEvents();
                        }
                        return persistedEvents;
                    } catch (Throwable th2) {
                        th = th2;
                        we.a(ois);
                        try {
                            context.getFileStreamPath("AppEventsLogger.persistedevents").delete();
                            if (obj != null) {
                                persistedEvents = new PersistedEvents(obj);
                            }
                        } catch (Exception ex222) {
                            Log.w(a, "Got unexpected exception when removing events file: " + ex222.toString());
                        }
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    ois = ois2;
                    we.a(ois);
                    context.getFileStreamPath("AppEventsLogger.persistedevents").delete();
                    if (obj != null) {
                        persistedEvents = new PersistedEvents(obj);
                    }
                    throw th;
                }
            } catch (FileNotFoundException e4) {
                we.a(ois);
                context.getFileStreamPath("AppEventsLogger.persistedevents").delete();
                if (obj != null) {
                    persistedEvents = new PersistedEvents(obj);
                }
                if (persistedEvents == null) {
                    persistedEvents = new PersistedEvents();
                }
                return persistedEvents;
            } catch (Exception e5) {
                e = e5;
                Log.w(a, "Got unexpected exception while reading events: " + e.toString());
                we.a(ois);
                context.getFileStreamPath("AppEventsLogger.persistedevents").delete();
                if (obj != null) {
                    persistedEvents = new PersistedEvents(obj);
                }
                if (persistedEvents == null) {
                    persistedEvents = new PersistedEvents();
                }
                return persistedEvents;
            }
            if (persistedEvents == null) {
                persistedEvents = new PersistedEvents();
            }
        }
        return persistedEvents;
    }

    private static void a(PersistedEvents eventsToPersist) {
        Exception e;
        Throwable th;
        Closeable oos = null;
        try {
            Closeable oos2 = new ObjectOutputStream(new BufferedOutputStream(AppEventsLogger.d().openFileOutput("AppEventsLogger.persistedevents", 0)));
            try {
                oos2.writeObject(eventsToPersist);
                we.a(oos2);
                oos = oos2;
            } catch (Exception e2) {
                e = e2;
                oos = oos2;
                try {
                    Log.w(a, "Got unexpected exception while persisting events: " + e.toString());
                    we.a(oos);
                } catch (Throwable th2) {
                    th = th2;
                    we.a(oos);
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                oos = oos2;
                we.a(oos);
                throw th;
            }
        } catch (Exception e3) {
            e = e3;
            Log.w(a, "Got unexpected exception while persisting events: " + e.toString());
            we.a(oos);
        }
    }

    private static void b() {
    }
}
