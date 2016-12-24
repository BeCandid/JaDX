package defpackage;

/* compiled from: SettingsData */
public class aoc {
    public final ano a;
    public final anz b;
    public final any c;
    public final anw d;
    public final anl e;
    public final anp f;
    public final long g;
    public final int h;
    public final int i;

    public aoc(long expiresAtMillis, ano appData, anz sessionData, any promptData, anw featuresData, anl analyticsSettingsData, anp betaSettingsData, int settingsVersion, int cacheDuration) {
        this.g = expiresAtMillis;
        this.a = appData;
        this.b = sessionData;
        this.c = promptData;
        this.d = featuresData;
        this.h = settingsVersion;
        this.i = cacheDuration;
        this.e = analyticsSettingsData;
        this.f = betaSettingsData;
    }

    public boolean a(long currentTimeMillis) {
        return this.g < currentTimeMillis;
    }
}
