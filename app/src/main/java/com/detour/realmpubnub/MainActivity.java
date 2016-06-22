package com.detour.realmpubnub;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.pubnub.api.PNConfiguration;
import com.pubnub.api.PubNub;
import com.pubnub.api.enums.PNReconnectionPolicy;

import io.realm.Realm;
import io.realm.RealmConfiguration;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        RealmConfiguration realmConfig = new RealmConfiguration.Builder(getApplicationContext())
                .modules(Realm.getDefaultModule()) //include app & detourapi schema
                .schemaVersion(1) // Must be bumped when the schema changes
                .deleteRealmIfMigrationNeeded() //Just re-fetch if schema changed
                .build();
        // Get a Realm instance for this thread
        Realm.getInstance(realmConfig);


        PNConfiguration configuration = (new PNConfiguration()).setPublishKey("dfdfd").setSubscribeKey("sdfds").setReconnectionPolicy(PNReconnectionPolicy.LINEAR);
        new PubNub(configuration);



    }
}
