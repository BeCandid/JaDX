package defpackage;

import android.text.TextUtils;
import com.google.android.gms.measurement.AppMeasurement.a;
import com.google.android.gms.measurement.AppMeasurement.d;
import com.google.android.gms.measurement.AppMeasurement.e;
import java.util.Arrays;
import java.util.BitSet;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;

public class agq extends agd {
    agq(ahk ahk) {
        super(ahk);
    }

    private Boolean a(aby$b aby_b, aca$b aca_b, long j) {
        Boolean a;
        if (aby_b.f != null) {
            a = new ahg(aby_b.f).a(j);
            if (a == null) {
                return null;
            }
            if (!a.booleanValue()) {
                return Boolean.valueOf(false);
            }
        }
        Set hashSet = new HashSet();
        for (aby$c aby_c : aby_b.d) {
            if (TextUtils.isEmpty(aby_c.e)) {
                w().z().a("null or empty param name in filter. event", aca_b.c);
                return null;
            }
            hashSet.add(aby_c.e);
        }
        Map dhVar = new dh();
        for (aca$c aca_c : aca_b.b) {
            if (hashSet.contains(aca_c.b)) {
                if (aca_c.d != null) {
                    dhVar.put(aca_c.b, aca_c.d);
                } else if (aca_c.f != null) {
                    dhVar.put(aca_c.b, aca_c.f);
                } else if (aca_c.c != null) {
                    dhVar.put(aca_c.b, aca_c.c);
                } else {
                    w().z().a("Unknown value for param. event, param", aca_b.c, aca_c.b);
                    return null;
                }
            }
        }
        for (aby$c aby_c2 : aby_b.d) {
            boolean equals = Boolean.TRUE.equals(aby_c2.d);
            CharSequence charSequence = aby_c2.e;
            if (TextUtils.isEmpty(charSequence)) {
                w().z().a("Event has empty param name. event", aca_b.c);
                return null;
            }
            Object obj = dhVar.get(charSequence);
            if (obj instanceof Long) {
                if (aby_c2.c == null) {
                    w().z().a("No number filter for long param. event, param", aca_b.c, charSequence);
                    return null;
                }
                a = new ahg(aby_c2.c).a(((Long) obj).longValue());
                if (a == null) {
                    return null;
                }
                if (((!a.booleanValue() ? 1 : 0) ^ equals) != 0) {
                    return Boolean.valueOf(false);
                }
            } else if (obj instanceof Double) {
                if (aby_c2.c == null) {
                    w().z().a("No number filter for double param. event, param", aca_b.c, charSequence);
                    return null;
                }
                a = new ahg(aby_c2.c).a(((Double) obj).doubleValue());
                if (a == null) {
                    return null;
                }
                if (((!a.booleanValue() ? 1 : 0) ^ equals) != 0) {
                    return Boolean.valueOf(false);
                }
            } else if (obj instanceof String) {
                if (aby_c2.b == null) {
                    w().z().a("No string filter for String param. event, param", aca_b.c, charSequence);
                    return null;
                }
                a = new agj(aby_c2.b).a((String) obj);
                if (a == null) {
                    return null;
                }
                if (((!a.booleanValue() ? 1 : 0) ^ equals) != 0) {
                    return Boolean.valueOf(false);
                }
            } else if (obj == null) {
                w().E().a("Missing param for filter. event, param", aca_b.c, charSequence);
                return Boolean.valueOf(false);
            } else {
                w().z().a("Unknown param type. event, param", aca_b.c, charSequence);
                return null;
            }
        }
        return Boolean.valueOf(true);
    }

    private Boolean a(aby$e aby_e, aca$g aca_g) {
        Boolean bool = null;
        aby$c aby_c = aby_e.d;
        if (aby_c == null) {
            w().z().a("Missing property filter. property", aca_g.c);
            return bool;
        }
        boolean equals = Boolean.TRUE.equals(aby_c.d);
        if (aca_g.e != null) {
            if (aby_c.c != null) {
                return agq.a(new ahg(aby_c.c).a(aca_g.e.longValue()), equals);
            }
            w().z().a("No number filter for long property. property", aca_g.c);
            return bool;
        } else if (aca_g.g != null) {
            if (aby_c.c != null) {
                return agq.a(new ahg(aby_c.c).a(aca_g.g.doubleValue()), equals);
            }
            w().z().a("No number filter for double property. property", aca_g.c);
            return bool;
        } else if (aca_g.d == null) {
            w().z().a("User property has no value, property", aca_g.c);
            return bool;
        } else if (aby_c.b != null) {
            return agq.a(new agj(aby_c.b).a(aca_g.d), equals);
        } else {
            if (aby_c.c == null) {
                w().z().a("No string or number filter defined. property", aca_g.c);
                return bool;
            }
            ahg ahg = new ahg(aby_c.c);
            if (aby_c.c.c == null || !aby_c.c.c.booleanValue()) {
                if (a(aca_g.d)) {
                    try {
                        return agq.a(ahg.a(Long.parseLong(aca_g.d)), equals);
                    } catch (NumberFormatException e) {
                        w().z().a("User property value exceeded Long value range. property, value", aca_g.c, aca_g.d);
                        return bool;
                    }
                }
                w().z().a("Invalid user property value for Long number filter. property, value", aca_g.c, aca_g.d);
                return bool;
            } else if (b(aca_g.d)) {
                try {
                    double parseDouble = Double.parseDouble(aca_g.d);
                    if (!Double.isInfinite(parseDouble)) {
                        return agq.a(ahg.a(parseDouble), equals);
                    }
                    w().z().a("User property value exceeded Double value range. property, value", aca_g.c, aca_g.d);
                    return bool;
                } catch (NumberFormatException e2) {
                    w().z().a("User property value exceeded Double value range. property, value", aca_g.c, aca_g.d);
                    return bool;
                }
            } else {
                w().z().a("Invalid user property value for Double number filter. property, value", aca_g.c, aca_g.d);
                return bool;
            }
        }
    }

    static Boolean a(Boolean bool, boolean z) {
        return bool == null ? null : Boolean.valueOf(bool.booleanValue() ^ z);
    }

    void a(String str, aby$a[] aby_aArr) {
        xz.a((Object) aby_aArr);
        for (aby$a aby_a : aby_aArr) {
            for (aby$b aby_b : aby_a.d) {
                String str2 = (String) a.a.get(aby_b.c);
                if (str2 != null) {
                    aby_b.c = str2;
                }
                for (aby$c aby_c : aby_b.d) {
                    str2 = (String) d.a.get(aby_c.e);
                    if (str2 != null) {
                        aby_c.e = str2;
                    }
                }
            }
            for (aby$e aby_e : aby_a.c) {
                str2 = (String) e.a.get(aby_e.c);
                if (str2 != null) {
                    aby_e.c = str2;
                }
            }
        }
        r().a(str, aby_aArr);
    }

    boolean a(String str) {
        return Pattern.matches("[+-]?[0-9]+", str);
    }

    aca$a[] a(String str, aca$b[] aca_bArr, aca$g[] aca_gArr) {
        int intValue;
        BitSet bitSet;
        BitSet bitSet2;
        Map map;
        Map map2;
        Boolean a;
        Object obj;
        xz.a(str);
        Set hashSet = new HashSet();
        dh dhVar = new dh();
        Map dhVar2 = new dh();
        dh dhVar3 = new dh();
        Map f = r().f(str);
        if (f != null) {
            for (Integer intValue2 : f.keySet()) {
                intValue = intValue2.intValue();
                aca$f aca_f = (aca$f) f.get(Integer.valueOf(intValue));
                bitSet = (BitSet) dhVar2.get(Integer.valueOf(intValue));
                bitSet2 = (BitSet) dhVar3.get(Integer.valueOf(intValue));
                if (bitSet == null) {
                    bitSet = new BitSet();
                    dhVar2.put(Integer.valueOf(intValue), bitSet);
                    bitSet2 = new BitSet();
                    dhVar3.put(Integer.valueOf(intValue), bitSet2);
                }
                for (int i = 0; i < aca_f.b.length * 64; i++) {
                    if (ago.a(aca_f.b, i)) {
                        w().E().a("Filter already evaluated. audience ID, filter ID", Integer.valueOf(intValue), Integer.valueOf(i));
                        bitSet2.set(i);
                        if (ago.a(aca_f.c, i)) {
                            bitSet.set(i);
                        }
                    }
                }
                aca$a aca_a = new aca$a();
                dhVar.put(Integer.valueOf(intValue), aca_a);
                aca_a.e = Boolean.valueOf(false);
                aca_a.d = aca_f;
                aca_a.c = new aca$f();
                aca_a.c.c = ago.a(bitSet);
                aca_a.c.b = ago.a(bitSet2);
            }
        }
        if (aca_bArr != null) {
            dh dhVar4 = new dh();
            for (aca$b aca_b : aca_bArr) {
                agw agw;
                agw a2 = r().a(str, aca_b.c);
                if (a2 == null) {
                    w().z().a("Event aggregate wasn't created during raw event logging. event", aca_b.c);
                    agw = new agw(str, aca_b.c, 1, 1, aca_b.d.longValue());
                } else {
                    agw = a2.a();
                }
                r().a(agw);
                long j = agw.c;
                map = (Map) dhVar4.get(aca_b.c);
                if (map == null) {
                    map = r().d(str, aca_b.c);
                    if (map == null) {
                        map = new dh();
                    }
                    dhVar4.put(aca_b.c, map);
                    map2 = map;
                } else {
                    map2 = map;
                }
                w().E().a("event, affected audience count", aca_b.c, Integer.valueOf(map2.size()));
                for (Integer intValue22 : map2.keySet()) {
                    int intValue3 = intValue22.intValue();
                    if (hashSet.contains(Integer.valueOf(intValue3))) {
                        w().E().a("Skipping failed audience ID", Integer.valueOf(intValue3));
                    } else {
                        bitSet = (BitSet) dhVar2.get(Integer.valueOf(intValue3));
                        bitSet2 = (BitSet) dhVar3.get(Integer.valueOf(intValue3));
                        if (((aca$a) dhVar.get(Integer.valueOf(intValue3))) == null) {
                            aca$a aca_a2 = new aca$a();
                            dhVar.put(Integer.valueOf(intValue3), aca_a2);
                            aca_a2.e = Boolean.valueOf(true);
                            bitSet = new BitSet();
                            dhVar2.put(Integer.valueOf(intValue3), bitSet);
                            bitSet2 = new BitSet();
                            dhVar3.put(Integer.valueOf(intValue3), bitSet2);
                        }
                        for (aby$b aby_b : (List) map2.get(Integer.valueOf(intValue3))) {
                            if (w().a(2)) {
                                w().E().a("Evaluating filter. audience, filter, event", Integer.valueOf(intValue3), aby_b.b, aby_b.c);
                                w().E().a("Filter definition", ago.a(aby_b));
                            }
                            if (aby_b.b == null || aby_b.b.intValue() > 256) {
                                w().z().a("Invalid event filter ID. id", String.valueOf(aby_b.b));
                            } else if (bitSet.get(aby_b.b.intValue())) {
                                w().E().a("Event filter already evaluated true. audience ID, filter ID", Integer.valueOf(intValue3), aby_b.b);
                            } else {
                                a = a(aby_b, aca_b, j);
                                ahd$a E = w().E();
                                String str2 = "Event filter result";
                                if (a == null) {
                                    obj = "null";
                                } else {
                                    Boolean bool = a;
                                }
                                E.a(str2, obj);
                                if (a == null) {
                                    hashSet.add(Integer.valueOf(intValue3));
                                } else {
                                    bitSet2.set(aby_b.b.intValue());
                                    if (a.booleanValue()) {
                                        bitSet.set(aby_b.b.intValue());
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        if (aca_gArr != null) {
            Map dhVar5 = new dh();
            for (aca$g aca_g : aca_gArr) {
                map = (Map) dhVar5.get(aca_g.c);
                if (map == null) {
                    map = r().e(str, aca_g.c);
                    if (map == null) {
                        map = new dh();
                    }
                    dhVar5.put(aca_g.c, map);
                    map2 = map;
                } else {
                    map2 = map;
                }
                w().E().a("property, affected audience count", aca_g.c, Integer.valueOf(map2.size()));
                for (Integer intValue222 : map2.keySet()) {
                    int intValue4 = intValue222.intValue();
                    if (hashSet.contains(Integer.valueOf(intValue4))) {
                        w().E().a("Skipping failed audience ID", Integer.valueOf(intValue4));
                    } else {
                        bitSet = (BitSet) dhVar2.get(Integer.valueOf(intValue4));
                        bitSet2 = (BitSet) dhVar3.get(Integer.valueOf(intValue4));
                        if (((aca$a) dhVar.get(Integer.valueOf(intValue4))) == null) {
                            aca_a2 = new aca$a();
                            dhVar.put(Integer.valueOf(intValue4), aca_a2);
                            aca_a2.e = Boolean.valueOf(true);
                            bitSet = new BitSet();
                            dhVar2.put(Integer.valueOf(intValue4), bitSet);
                            bitSet2 = new BitSet();
                            dhVar3.put(Integer.valueOf(intValue4), bitSet2);
                        }
                        for (aby$e aby_e : (List) map2.get(Integer.valueOf(intValue4))) {
                            if (w().a(2)) {
                                w().E().a("Evaluating filter. audience, filter, property", Integer.valueOf(intValue4), aby_e.b, aby_e.c);
                                w().E().a("Filter definition", ago.a(aby_e));
                            }
                            if (aby_e.b == null || aby_e.b.intValue() > 256) {
                                w().z().a("Invalid property filter ID. id", String.valueOf(aby_e.b));
                                hashSet.add(Integer.valueOf(intValue4));
                                break;
                            } else if (bitSet.get(aby_e.b.intValue())) {
                                w().E().a("Property filter already evaluated true. audience ID, filter ID", Integer.valueOf(intValue4), aby_e.b);
                            } else {
                                a = a(aby_e, aca_g);
                                ahd$a E2 = w().E();
                                String str3 = "Property filter result";
                                if (a == null) {
                                    obj = "null";
                                } else {
                                    bool = a;
                                }
                                E2.a(str3, obj);
                                if (a == null) {
                                    hashSet.add(Integer.valueOf(intValue4));
                                } else {
                                    bitSet2.set(aby_e.b.intValue());
                                    if (a.booleanValue()) {
                                        bitSet.set(aby_e.b.intValue());
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        aca$a[] aca_aArr = new aca$a[dhVar2.size()];
        int i2 = 0;
        for (Integer intValue2222 : dhVar2.keySet()) {
            intValue = intValue2222.intValue();
            if (!hashSet.contains(Integer.valueOf(intValue))) {
                aca_a2 = (aca$a) dhVar.get(Integer.valueOf(intValue));
                aca_a = aca_a2 == null ? new aca$a() : aca_a2;
                int i3 = i2 + 1;
                aca_aArr[i2] = aca_a;
                aca_a.b = Integer.valueOf(intValue);
                aca_a.c = new aca$f();
                aca_a.c.c = ago.a((BitSet) dhVar2.get(Integer.valueOf(intValue)));
                aca_a.c.b = ago.a((BitSet) dhVar3.get(Integer.valueOf(intValue)));
                r().a(str, intValue, aca_a.c);
                i2 = i3;
            }
        }
        return (aca$a[]) Arrays.copyOf(aca_aArr, i2);
    }

    boolean b(String str) {
        return Pattern.matches("[+-]?(([0-9]+\\.?)|([0-9]*\\.[0-9]+))", str);
    }

    protected void e() {
    }
}
