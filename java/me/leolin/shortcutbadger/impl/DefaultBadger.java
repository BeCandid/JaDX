package me.leolin.shortcutbadger.impl;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import defpackage.aot;
import defpackage.aov;
import java.util.ArrayList;
import java.util.List;
import me.leolin.shortcutbadger.ShortcutBadgeException;

public class DefaultBadger implements aot {
    public void a(Context context, ComponentName componentName, int badgeCount) throws ShortcutBadgeException {
        Intent intent = new Intent("android.intent.action.BADGE_COUNT_UPDATE");
        intent.putExtra("badge_count", badgeCount);
        intent.putExtra("badge_count_package_name", componentName.getPackageName());
        intent.putExtra("badge_count_class_name", componentName.getClassName());
        if (aov.a(context, intent)) {
            context.sendBroadcast(intent);
            return;
        }
        throw new ShortcutBadgeException("unable to resolve intent: " + intent.toString());
    }

    public List<String> a() {
        return new ArrayList(0);
    }
}
