package defpackage;

import rx.subjects.SubjectSubscriptionManager;
import rx.subjects.SubjectSubscriptionManager.b;

/* compiled from: PublishSubject */
class asr$1 implements apz<b<T>> {
    final /* synthetic */ SubjectSubscriptionManager a;

    asr$1(SubjectSubscriptionManager subjectSubscriptionManager) {
        this.a = subjectSubscriptionManager;
    }

    public /* synthetic */ void call(Object x0) {
        a((b) x0);
    }

    public void a(b<T> o) {
        o.b(this.a.a(), this.a.f);
    }
}
