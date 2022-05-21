package com.dragonapps.uninstalljava.list_adapters;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.dragonapps.uninstalljava.R;

import java.util.List;

public class PackageListAdapter extends RecyclerView.Adapter<PackageListAdapter.ViewHolder> {
    private final List<PackageInfo> packageInfoList;
    private final PackageManager packageManager;


    public PackageListAdapter(List<PackageInfo> packageInfoList, PackageManager packageManager) {
        this.packageInfoList = packageInfoList;
        this.packageManager = packageManager;
    }

    @NonNull
    @Override
    public PackageListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.package_list_view, parent, false);
        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull PackageListAdapter.ViewHolder holder, int position) {

        Drawable icon;
        try {
            icon = packageInfoList.get(position).applicationInfo.loadIcon(packageManager);
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
            icon = packageInfoList.get(5).applicationInfo.loadIcon(packageManager);
        }
        holder.packageNameTV.setText(packageInfoList.get(position).applicationInfo.loadLabel(packageManager));
        holder.packageIdTV.setText(packageInfoList.get(position).packageName);
        holder.packageIconIV.setImageDrawable(icon);

    }

    @Override
    public int getItemCount() {
        return packageInfoList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView packageNameTV;
        private final TextView packageIdTV;
        private final ImageView packageIconIV;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            packageNameTV = itemView.findViewById(R.id.package_name_tv);
            packageIdTV = itemView.findViewById(R.id.package_id_tv);
            packageIconIV = itemView.findViewById(R.id.package_icon_iv);
        }


    }
}
