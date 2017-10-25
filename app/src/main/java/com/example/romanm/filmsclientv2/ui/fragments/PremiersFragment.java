package com.example.romanm.filmsclientv2.ui.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.arellomobile.mvp.MvpAppCompatFragment;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.example.romanm.filmsclientv2.R;
import com.example.romanm.filmsclientv2.mvp.presenters.PremiersPresenter;
import com.example.romanm.filmsclientv2.mvp.views.PremiersView;

public class PremiersFragment extends MvpAppCompatFragment implements PremiersView {

    @InjectPresenter
    PremiersPresenter premiersPresenter;


    public static final String ARG_TOP_RATED = "ARG_TOP_RATED";
    public static final String ARG_POPULAR = "ARG_POPULAR";
    public static final String ARG_UPCOMMING = "ARG_UPCOMMING";

    private static final String KEY_TYPE = "KEY_TYPE";


    public PremiersFragment() {
        // Required empty public constructor
    }

    public static PremiersFragment getInstance(String type) {
        Bundle bundle = new Bundle();
        bundle.putString(KEY_TYPE, type);
        PremiersFragment fragment = new PremiersFragment();
        fragment.setArguments(bundle);
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_premiers, container, false);


        initRV(view);
        return view;
    }

    private void initRV(View view) {
        RecyclerView rv = (RecyclerView) view.findViewById(R.id.rv_premiers);
        rv.setLayoutManager(new LinearLayoutManager(view.getContext()));
    }


//    @Override
//    public void onAttach(Context context) {
//        super.onAttach(context);
//        if (context instanceof PremiersContract.FragmentListener) {
//            mListener = (PremiersContract.FragmentListener) context;
//        } else {
//            throw new RuntimeException(context.toString()
//                    + " must implement OnFragmentInteractionListener");
//        }
//    }


//    @Override
//    public void onDetach() {
//        super.onDetach();
//        mListener = null;
//    }

//    @Override
//    public void onDestroy() {
//        super.onDestroy();
//        presenter = null;
//    }


}
