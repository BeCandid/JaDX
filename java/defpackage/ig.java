package defpackage;

import android.content.Context;
import com.becandid.candid.GossipApplication;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: BadgeFactory */
public class ig {
    private static volatile ig a;
    private Map<String, ig$a> b = new HashMap();

    private ig() {
        Context context = GossipApplication.a().getApplicationContext();
        String badgeName = "new";
        this.b.put(badgeName, new ig$a(this, badgeName, "Newbie", 2130838080, context.getString(2131230804), "#ff9999"));
        badgeName = "allstar";
        this.b.put(badgeName, new ig$a(this, badgeName, "All Star", 2130837584, context.getString(2131230798), "#00ccff"));
        badgeName = "explorer";
        this.b.put(badgeName, new ig$a(this, badgeName, "Explorer", 2130837712, context.getString(2131230799), "#f4df2a"));
        badgeName = "giver";
        this.b.put(badgeName, new ig$a(this, badgeName, "Giver", 2130837976, context.getString(2131230800), "#78eeee"));
        badgeName = "gossip";
        this.b.put(badgeName, new ig$a(this, badgeName, "Gossip", 2130837977, context.getString(2131230801), "#41ee8f"));
        badgeName = "hater";
        this.b.put(badgeName, new ig$a(this, badgeName, "Hater", 2130838004, context.getString(2131230802), "#f33c2c"));
        badgeName = "influencer";
        this.b.put(badgeName, new ig$a(this, badgeName, "Influencer", 2130838030, context.getString(2131230803), "#ffd176"));
        badgeName = "positive";
        this.b.put(badgeName, new ig$a(this, badgeName, "Positive", 2130838171, context.getString(2131230805), "#fca3ff"));
        badgeName = "social";
        this.b.put(badgeName, new ig$a(this, badgeName, "Socializer", 2130838214, context.getString(2131230806), "#83d9ff"));
    }

    public static ig a() {
        if (a == null) {
            synchronized (ig.class) {
                if (a == null) {
                    a = new ig();
                }
            }
        }
        return a;
    }

    public ig$a a(String name) {
        return (ig$a) this.b.get(name);
    }

    public List<ig$a> b() {
        Collection<ig$a> collection = this.b.values();
        if (collection instanceof List) {
            return (List) collection;
        }
        return new ArrayList(collection);
    }
}
