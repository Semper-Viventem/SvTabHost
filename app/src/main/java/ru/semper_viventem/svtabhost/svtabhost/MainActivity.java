package ru.semper_viventem.svtabhost.svtabhost;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import ru.semper_viventem.svtabhost.svtabhost.SvTabLib.SvTabHost;

public class MainActivity extends AppCompatActivity {

    private SvTabHost mSvTabHost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }
}
