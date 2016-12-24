package defpackage;

import java.lang.reflect.Type;

/* compiled from: ConstructorConstructor */
class aiz$6 implements ajc<T> {
    final /* synthetic */ Class a;
    final /* synthetic */ Type b;
    final /* synthetic */ aiz c;
    private final ajf d = ajf.a();

    aiz$6(aiz this$0, Class cls, Type type) {
        this.c = this$0;
        this.a = cls;
        this.b = type;
    }

    public T a() {
        try {
            return this.d.a(this.a);
        } catch (Exception e) {
            throw new RuntimeException("Unable to invoke no-args constructor for " + this.b + ". " + "Register an InstanceCreator with Gson for this type may fix this problem.", e);
        }
    }
}
