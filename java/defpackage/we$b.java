package defpackage;

import java.util.Map;

/* compiled from: Utility */
public class we$b {
    private boolean a;
    private String b;
    private boolean c;
    private boolean d;
    private int e;
    private Map<String, Map<String, we$a>> f;
    private vn g;

    private we$b(boolean supportsImplicitLogging, String nuxContent, boolean nuxEnabled, boolean customTabsEnabled, int sessionTimeoutInSeconds, Map<String, Map<String, we$a>> dialogConfigMap, vn errorClassification) {
        this.a = supportsImplicitLogging;
        this.b = nuxContent;
        this.c = nuxEnabled;
        this.d = customTabsEnabled;
        this.f = dialogConfigMap;
        this.g = errorClassification;
        this.e = sessionTimeoutInSeconds;
    }

    public boolean a() {
        return this.a;
    }

    public String b() {
        return this.b;
    }

    public boolean c() {
        return this.c;
    }

    public boolean d() {
        return this.d;
    }

    public Map<String, Map<String, we$a>> e() {
        return this.f;
    }

    public vn f() {
        return this.g;
    }
}
