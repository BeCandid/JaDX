package com.becandid.candid.models;

import defpackage.apr;

public class EmptySubscriber extends apr<Object> {
    public void onCompleted() {
    }

    public void onError(Throwable e) {
    }

    public void onNext(Object o) {
    }
}
