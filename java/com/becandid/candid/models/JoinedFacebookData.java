package com.becandid.candid.models;

import defpackage.ain;

public class JoinedFacebookData {
    public NetworkData autoJoin;
    public ain hash;

    public JoinedFacebookData(ain hash, NetworkData autoJoin) {
        this.hash = hash;
        this.autoJoin = autoJoin;
    }
}
