package ru.semper_viventem.svtabhost.svtabhost.example.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import ru.semper_viventem.svtabhost.svtabhost.R;

/**
 * @author Kulikov Konstantin
 * @since 28.01.2017.
 */

public class ExampleFragment extends Fragment {
    private static final String TITLE_TEXT = "title_text";

    public static ExampleFragment newInstance(String title) {

        Bundle args = new Bundle();
        args.putString(TITLE_TEXT, title);

        ExampleFragment fragment = new ExampleFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_example, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        TextView titleTextView = (TextView) getView().findViewById(R.id.vTextViewTitle);
        titleTextView.setText(getArguments().getString(TITLE_TEXT, ""));
    }
}
