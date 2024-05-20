package sg.edu.np.mad.madpractical5;

import static androidx.core.content.ContextCompat.startActivity;

import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import java.util.ArrayList;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

public class UserAdapter extends RecyclerView.Adapter<UserViewHolder> {
    ArrayList<User> data;

    private static final String TAG = "UserAdapter";

    public UserAdapter(ArrayList<User> input, ListActivity listActivity) {
        data = input;
    }

    @NonNull
    public UserViewHolder onCreateViewHolder(
            ViewGroup parent,
            int viewType) {
        View item = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.custom_activity_list,
                parent,
                false);
        return new UserViewHolder(item);
    }

    public void onBindViewHolder(
            UserViewHolder holder,
            int position) {
        User s = data.get(position);
        holder.name.setText(s.name);
        holder.des.setText(s.description);

        Log.d(TAG, "onBindViewHolder Name: " + s.name);
        char Lastchar = s.name.charAt(s.name.length() - 1);
        if (Lastchar == '7'){
            holder.bigImg.setVisibility(View.VISIBLE);
            Log.d(TAG, "onBindViewHolder: Visible" );
        }
        else{
            holder.bigImg.setVisibility(View.GONE);
        }
        holder.smallImg.setOnClickListener(v -> {
            AlertDialog.Builder builder = new AlertDialog.Builder(v.getContext());
            builder.setTitle("Profile");
            builder.setMessage(s.getName());
            builder.setCancelable(true);

            builder.setPositiveButton("View", (dialog, which) -> {
                Intent listActivity = new Intent(holder.smallImg.getContext(), MainActivity.class);
                listActivity.putExtra("ID",s.getID());
                startActivity(v.getContext(), listActivity, null);
            });

            builder.setNegativeButton("Cancel", (dialog, which) -> {
            });

            AlertDialog alert = builder.create();
            alert.show();

        });
    }

    public int getItemCount() {
        return data.size();
    }
}
