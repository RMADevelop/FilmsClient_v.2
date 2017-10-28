package com.example.romanm.filmsclientv2.ui.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.romanm.filmsclientv2.R;


public class BaseInfoFragment extends Fragment {


    private static final String ARG_FILM_ID = "ARG_FILM_ID";
    private OnFragmentInteractionListener mListener;


    private int idFilm;

    public BaseInfoFragment() {
        // Required empty public constructor
    }


    public static BaseInfoFragment newInstance(int idFilm) {
        BaseInfoFragment fragment = new BaseInfoFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_FILM_ID, idFilm);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            idFilm = getArguments().getInt(ARG_FILM_ID);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_film_info_content, container, false);
        return view;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
