package defpackage;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import java.util.ArrayList;
import java.util.List;

/* compiled from: TabPagerAdapter */
public class hq extends FragmentPagerAdapter {
    protected final List<Fragment> a = new ArrayList();
    protected final List<CharSequence> b = new ArrayList();

    public hq(FragmentManager fragmentManager) {
        super(fragmentManager);
    }

    public Fragment getItem(int position) {
        return (Fragment) this.a.get(position);
    }

    public Fragment a(String title) {
        for (int i = 0; i < this.b.size(); i++) {
            if (((CharSequence) this.b.get(i)).equals(title)) {
                return (Fragment) this.a.get(i);
            }
        }
        return null;
    }

    public int getCount() {
        return this.a.size();
    }

    public void a(Fragment fragment, CharSequence title) {
        this.a.add(fragment);
        this.b.add(title);
    }

    public CharSequence getPageTitle(int position) {
        return (CharSequence) this.b.get(position);
    }
}
