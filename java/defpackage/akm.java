package defpackage;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.List;
import java.util.Locale;

/* compiled from: CountryListAdapter */
public class akm extends BaseAdapter {
    List<akp> a;
    LayoutInflater b = ((LayoutInflater) this.c.getSystemService("layout_inflater"));
    private Context c;

    private int a(String drawableName) {
        try {
            return akl$b.class.getField(drawableName).getInt(null);
        } catch (Exception e) {
            Log.e("CountryCodePicker", "Failure to get drawable id.", e);
            return -1;
        }
    }

    public akm(Context context, List<akp> countries) {
        this.c = context;
        this.a = countries;
    }

    public int getCount() {
        return this.a.size();
    }

    public Object getItem(int arg0) {
        return null;
    }

    public long getItemId(int arg0) {
        return 0;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        akm$a cell;
        View cellView = convertView;
        akp country = (akp) this.a.get(position);
        if (convertView == null) {
            cell = new akm$a();
            cellView = this.b.inflate(akl$d.row, null);
            cell.a = (TextView) cellView.findViewById(akl$c.row_title);
            cell.b = (ImageView) cellView.findViewById(akl$c.row_icon);
            cellView.setTag(cell);
        } else {
            cell = (akm$a) cellView.getTag();
        }
        cell.a.setText(country.c());
        int drawableId = a("flag_" + country.b().toLowerCase(Locale.ENGLISH));
        country.a(drawableId);
        cell.b.setImageResource(drawableId);
        return cellView;
    }
}
