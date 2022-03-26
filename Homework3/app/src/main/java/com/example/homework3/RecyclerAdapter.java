package com.example.homework3;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder>
{
    private List<App> appList;

    public RecyclerAdapter(List<App> appList)
    {
        this.appList = appList;
    }

    @NonNull
    @Override
    public RecyclerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);

        viewHolder.appImage.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                int position = viewHolder.getAdapterPosition();
                App app = appList.get(position);
                Toast.makeText(parent.getContext(), app.getName(), Toast.LENGTH_SHORT).show();
            }
        });

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerAdapter.ViewHolder holder, int position)
    {
        App app = appList.get(position);
        holder.appName.setText(app.getName());
        holder.appImage.setImageResource(app.getImageId());
    }

    @Override
    public int getItemCount()
    {
        return appList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder
    {
        private final TextView appName;
        private final ImageView appImage;

        public ViewHolder(@NonNull View itemView)
        {
            super(itemView);
            appName = (TextView) itemView.findViewById(R.id.app_name);
            appImage = (ImageView) itemView.findViewById(R.id.app_image);
        }
    }
}
