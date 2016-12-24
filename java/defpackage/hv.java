package defpackage;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.becandid.candid.data.Group;
import rx.schedulers.Schedulers;

/* compiled from: MeGroupsFragment */
public class hv extends Fragment {
    private View a;
    private RecyclerView b;
    private ho c;
    private aps d;

    public aps a() {
        return ik.a().i(0).b(Schedulers.io()).a(apv.a()).b(new hv$1(this));
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.a = inflater.inflate(2130968678, container, false);
        this.b = (RecyclerView) this.a.findViewById(2131624472);
        StaggeredGridLayoutManager sglm = new StaggeredGridLayoutManager(2, 1);
        this.b.setLayoutManager(sglm);
        this.c = new ho(getContext());
        this.b.setAdapter(this.c);
        this.b.addOnItemTouchListener(new hv$2(this, getContext()));
        this.b.addOnScrollListener(new hv$3(this, sglm, this.c));
        this.a.findViewById(2131624497).setOnClickListener(new hv$4(this));
        this.d = a();
        return this.a;
    }

    public void b() {
        this.d = a();
    }

    public void a(Group group) {
        if (this.c != null) {
            this.c.a(group);
        }
    }

    public void a(int groupId) {
        if (this.c != null) {
            this.c.c(groupId);
        }
    }
}
