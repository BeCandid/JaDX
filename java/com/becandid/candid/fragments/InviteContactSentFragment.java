package com.becandid.candid.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import com.becandid.candid.activities.InviteContactsActivity;

public class InviteContactSentFragment extends Fragment {
    private Unbinder a;
    private Bundle b;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(2130968676, container, false);
        this.a = ButterKnife.bind(this, view);
        this.b = getArguments();
        if (getActivity() instanceof InviteContactsActivity) {
            ((InviteContactsActivity) getActivity()).sendContactsToServer();
        }
        return view;
    }

    public void onDestroyView() {
        super.onDestroyView();
        this.a.unbind();
    }

    @OnClick({2131624445})
    public void onContactClose() {
        getActivity().finish();
    }

    @OnClick({2131624470})
    public void onClose() {
        getActivity().finish();
    }
}
