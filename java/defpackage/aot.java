package defpackage;

import android.content.ComponentName;
import android.content.Context;
import java.util.List;
import me.leolin.shortcutbadger.ShortcutBadgeException;

/* compiled from: Badger */
public interface aot {
    List<String> a();

    void a(Context context, ComponentName componentName, int i) throws ShortcutBadgeException;
}
