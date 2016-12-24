package defpackage;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.util.SparseArray;
import android.view.ViewGroup;

/* compiled from: SmartFragmentStatePagerAdapter */
public abstract class hp extends FragmentStatePagerAdapter {
    private SparseArray<Fragment> a = new SparseArray();

    public hp(FragmentManager fragmentManager) {
        super(fragmentManager);
    }

    public Object instantiateItem(ViewGroup container, int position) {
        Fragment fragment = (Fragment) super.instantiateItem(container, position);
        this.a.put(position, fragment);
        return fragment;
    }

    public void destroyItem(ViewGroup container, int position, Object object) {
        this.a.remove(position);
        super.destroyItem(container, position, object);
    }

    public Fragment b(int position) {
        return (Fragment) this.a.get(position);
    }
}
