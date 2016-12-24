package defpackage;

import java.security.PrivilegedAction;

/* compiled from: PlatformDependent */
class aqw$1 implements PrivilegedAction<ClassLoader> {
    aqw$1() {
    }

    public /* synthetic */ Object run() {
        return a();
    }

    public ClassLoader a() {
        return ClassLoader.getSystemClassLoader();
    }
}
