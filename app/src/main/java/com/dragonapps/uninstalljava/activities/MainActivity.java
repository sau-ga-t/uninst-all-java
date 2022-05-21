package com.dragonapps.uninstalljava.activities;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;

import com.dragonapps.uninstalljava.R;
import com.dragonapps.uninstalljava.list_adapters.PackageListAdapter;
import com.dragonapps.uninstalljava.utils.PackageUtil;

public class MainActivity extends AppCompatActivity {
    PackageUtil packageUtil = new PackageUtil();
    RecyclerView packageListRV;

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        PackageManager packageManager = getApplicationContext().getPackageManager();
        packageUtil.get(packageManager);
        packageListRV = findViewById(R.id.package_list_rv);
        packageListRV.setLayoutManager(new LinearLayoutManager(this));
        packageListRV.setAdapter(new PackageListAdapter(packageUtil.getAllPackages(), packageManager));
    }
}