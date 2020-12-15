package com.salatt.firstvolley;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class DevelopersAdapter extends
        RecyclerView.Adapter<DevelopersAdapter.ViewHolder> {

    private List<DeveloperList> developerList;

    private Context mContext;

    public static final String KEY_NAME = "name";
    public static final String KEY_IMAGE = "image";
    public static final String KEY_URL = "url";

    public DevelopersAdapter(List<DeveloperList>developerList, Context context){
        this.developerList=developerList;
        this.mContext=context;
    }


    @NonNull
    @Override
    public DevelopersAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new
                ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.developers_list,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull DevelopersAdapter.ViewHolder holder, int position) {
        final DeveloperList currrentDeveloper=developerList.get(position);

        holder.login.setText(currrentDeveloper.getLogin());
        holder.html_url.setText(currrentDeveloper.getHtml_url());

        Picasso.with(mContext)
                .load(currrentDeveloper.getAvatar_url())
                .into(holder.avatar_url);

        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DeveloperList developerList1 = developerList.get(position);

                Intent skipIntent = new Intent(v.getContext(), ProfileActivity.class);
                skipIntent.putExtra(KEY_NAME, developerList1.getLogin());
                skipIntent.putExtra(KEY_IMAGE, developerList1.getAvatar_url());
                skipIntent.putExtra(KEY_URL, developerList1.getHtml_url());
                v.getContext().startActivity(skipIntent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return developerList.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder{

        public TextView login;
        public ImageView avatar_url;
        public TextView html_url;
        public LinearLayout linearLayout;

        public ViewHolder(@NonNull View itemView){
            super(itemView);

            login=itemView.findViewById(R.id.username);
            avatar_url=itemView.findViewById(R.id.imageView);
            html_url=itemView.findViewById(R.id.html_url);
            linearLayout=itemView.findViewById(R.id.linearLayout);
        }
    }
}
