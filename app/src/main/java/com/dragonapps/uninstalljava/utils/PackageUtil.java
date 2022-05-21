package com.dragonapps.uninstalljava.utils;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;

import java.util.ArrayList;
import java.util.List;

public class PackageUtil {
    List<PackageInfo> appsList = new ArrayList<>();


    public List<PackageInfo> getAllPackages(){
        return appsList;
    }
    public void get(PackageManager packageManager){
        appsList =  packageManager.getInstalledPackages(PackageManager.GET_UNINSTALLED_PACKAGES);
    }
}
