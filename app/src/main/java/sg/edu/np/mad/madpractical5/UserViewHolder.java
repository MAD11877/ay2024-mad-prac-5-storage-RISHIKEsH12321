package sg.edu.np.mad.madpractical5;


import static androidx.core.content.ContextCompat.startActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

public class UserViewHolder extends RecyclerView.ViewHolder {
    TextView name;
    TextView des;

    ImageView smallImg;

    ImageView bigImg;
    private static final String TAG = "HolderActivity";
    public UserViewHolder(View itemView) {
        super(itemView);
        name = itemView.findViewById(R.id.tvName);
        des = itemView.findViewById(R.id.tvDes);
        smallImg = itemView.findViewById(R.id.ivImageSmall);
        bigImg = itemView.findViewById(R.id.ivImageBig);
        bigImg.setVisibility(View.GONE);



    }
}