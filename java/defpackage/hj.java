package defpackage;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.becandid.candid.GossipApplication;
import com.becandid.candid.data.AppState;
import com.becandid.candid.fragments.main_tabs.ActivityTabFragment;
import com.becandid.candid.fragments.main_tabs.FeedTabFragment;
import com.becandid.candid.fragments.main_tabs.GroupTabFragment;
import com.becandid.candid.fragments.main_tabs.MeTabFragment;
import com.becandid.candid.fragments.main_tabs.MessageTabFragment;
import java.util.ArrayList;
import java.util.List;

/* compiled from: MainTabPagerAdapter */
public class hj extends hp {
    private int a = 5;
    private final List<String> b = new ArrayList();

    public hj(FragmentManager fragmentManager) {
        super(fragmentManager);
    }

    public Fragment getItem(int position) {
        switch (position) {
            case uu$h.com_facebook_login_view_com_facebook_confirm_logout /*0*/:
                return new FeedTabFragment();
            case uu$h.com_facebook_profile_picture_view_com_facebook_is_cropped /*1*/:
                return new GroupTabFragment();
            case uu$h.com_facebook_login_view_com_facebook_logout_text /*2*/:
                return new Fragment();
            case uu$h.com_facebook_login_view_com_facebook_tooltip_mode /*3*/:
                if (AppState.config.experimentConfig.containsKey("messaging_turned_on") && AppState.config.getBoolean("messaging_turned_on")) {
                    return new MessageTabFragment();
                }
                return new MeTabFragment();
            case uu$h.com_facebook_like_view_com_facebook_auxiliary_view_position /*4*/:
                if (AppState.config.experimentConfig.containsKey("messaging_turned_on") && AppState.config.getBoolean("messaging_turned_on")) {
                    return new MeTabFragment();
                }
                return new ActivityTabFragment();
            default:
                return null;
        }
    }

    public int getCount() {
        return this.a;
    }

    public void a(List<String> titles) {
        this.b.addAll(titles);
    }

    public View a(int position) {
        View tab = LayoutInflater.from(GossipApplication.a().getApplicationContext()).inflate(2130968693, null);
        ImageView button = (ImageView) tab.findViewById(2131624522);
        TextView textView = (TextView) tab.findViewById(2131624523);
        switch (position) {
            case uu$h.com_facebook_login_view_com_facebook_confirm_logout /*0*/:
                button.setImageResource(2130837716);
                textView.setTextColor(tab.getResources().getColor(2131558476));
                tab.findViewById(2131624521).setAlpha(1.0f);
                break;
            case uu$h.com_facebook_profile_picture_view_com_facebook_is_cropped /*1*/:
                button.setImageResource(2130838001);
                break;
            case uu$h.com_facebook_login_view_com_facebook_tooltip_mode /*3*/:
                button.setImageResource(2130838064);
                break;
            case uu$h.com_facebook_like_view_com_facebook_auxiliary_view_position /*4*/:
                button.setImageResource(2130838057);
                break;
        }
        textView.setText((CharSequence) this.b.get(position));
        return tab;
    }
}
