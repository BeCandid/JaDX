package defpackage;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;

/* compiled from: CountryPicker */
class akn$1 implements OnItemClickListener {
    final /* synthetic */ akn a;

    akn$1(akn this$0) {
        this.a = this$0;
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
        if (this.a.f != null) {
            akp country = (akp) this.a.e.get(position);
            this.a.f.a(country.c(), country.b(), country.a(), country.d());
        }
    }
}
