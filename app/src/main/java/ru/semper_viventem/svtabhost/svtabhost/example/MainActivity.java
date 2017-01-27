package ru.semper_viventem.svtabhost.svtabhost.example;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import ru.semper_viventem.svtabhost.svtabhost.R;
import ru.semper_viventem.svtabhost.svtabhost.SvTabLib.SvTabHost;
import ru.semper_viventem.svtabhost.svtabhost.example.fragments.ExampleFragment;

public class MainActivity extends AppCompatActivity {

    private SvTabHost mSvTabHost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mSvTabHost = (SvTabHost)findViewById(R.id.vSvTabHost);
        mSvTabHost.initTabHost(getSupportFragmentManager());
        mSvTabHost.addTab(ExampleFragment.newInstance("Tab 1"), "Tab 1");
        mSvTabHost.addTab(ExampleFragment.newInstance("Tab 2"), "Tab 2");
        mSvTabHost.addTab(ExampleFragment.newInstance("Tab 3"), "Tab 3");
    }
}
