package defpackage;

import com.crashlytics.android.core.CodedOutputStream;
import java.io.IOException;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

/* compiled from: NativeCrashWriter */
class to {
    private static final ue a = new ue("", "", 0);
    private static final to$j[] b = new to$j[0];
    private static final to$m[] c = new to$m[0];
    private static final to$g[] d = new to$g[0];
    private static final to$b[] e = new to$b[0];
    private static final to$c[] f = new to$c[0];

    private static to$e a(ud crashEvent, tl logFileManager, Map<String, String> attributes) throws IOException {
        to$a applicationMessage = new to$a(new to$f(new to$l(crashEvent.b != null ? crashEvent.b : a), to.a(crashEvent.c), to.a(crashEvent.d)), to.a(to.a(crashEvent.e, attributes)));
        to$d deviceMessage = to.a(crashEvent.f);
        sw logByteString = logFileManager.a();
        if (logByteString == null) {
            akx.h().a("CrashlyticsCore", "No log data to include with this event.");
        }
        logFileManager.b();
        to$j logMessage = logByteString != null ? new to$h(logByteString) : new to$i();
        return new to$e(crashEvent.a, "ndk-crash", new to$j[]{applicationMessage, deviceMessage, logMessage});
    }

    private static ub[] a(ub[] ndkAttributes, Map<String, String> javaAttributes) {
        Map<String, String> sorted = new TreeMap(javaAttributes);
        if (ndkAttributes != null) {
            for (ub attr : ndkAttributes) {
                sorted.put(attr.a, attr.b);
            }
        }
        Entry[] entryArray = (Entry[]) sorted.entrySet().toArray(new Entry[sorted.size()]);
        ub[] merged = new ub[entryArray.length];
        for (int i = 0; i < merged.length; i++) {
            merged[i] = new ub((String) entryArray[i].getKey(), (String) entryArray[i].getValue());
        }
        return merged;
    }

    private static to$d a(uc deviceData) {
        return new to$d(((float) deviceData.f) / 100.0f, deviceData.g, deviceData.h, deviceData.a, deviceData.b - deviceData.d, deviceData.c - deviceData.e);
    }

    private static to$k a(uf[] threads) {
        to$m[] threadMessages = threads != null ? new to$m[threads.length] : c;
        for (int threadIdx = 0; threadIdx < threadMessages.length; threadIdx++) {
            uf threadData = threads[threadIdx];
            threadMessages[threadIdx] = new to$m(threadData, to.a(threadData.c));
        }
        return new to$k(threadMessages);
    }

    private static to$k a(uf$a[] frames) {
        to$g[] frameMessages = frames != null ? new to$g[frames.length] : d;
        for (int frameIdx = 0; frameIdx < frameMessages.length; frameIdx++) {
            frameMessages[frameIdx] = new to$g(frames[frameIdx]);
        }
        return new to$k(frameMessages);
    }

    private static to$k a(ua[] binaryImages) {
        to$b[] binaryImageMessages = binaryImages != null ? new to$b[binaryImages.length] : e;
        for (int i = 0; i < binaryImageMessages.length; i++) {
            binaryImageMessages[i] = new to$b(binaryImages[i]);
        }
        return new to$k(binaryImageMessages);
    }

    private static to$k a(ub[] customAttributes) {
        to$c[] customAttributeMessages = customAttributes != null ? new to$c[customAttributes.length] : f;
        for (int i = 0; i < customAttributeMessages.length; i++) {
            customAttributeMessages[i] = new to$c(customAttributes[i]);
        }
        return new to$k(customAttributeMessages);
    }

    public static void a(ud crashEventData, tl logFileManager, Map<String, String> customAttributes, CodedOutputStream cos) throws IOException {
        to.a(crashEventData, logFileManager, customAttributes).b(cos);
    }
}
