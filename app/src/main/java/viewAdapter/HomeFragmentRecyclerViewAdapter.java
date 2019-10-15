package viewAdapter;

import android.content.Context;
import android.text.Layout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;

import com.bumptech.glide.Glide;
import com.project.coconuc.R;

import java.util.ArrayList;

public class HomeFragmentRecyclerViewAdapter extends RecyclerView.Adapter<HomeFragmentRecyclerViewAdapter.ViewHolder> {
    private static final String TAG = "HomeFragment_RecyclerViewAdapter";

    //attributes
    private ArrayList<String> mCategories = new ArrayList<>();
    private ArrayList<String> mCategoryImageUrls = new ArrayList<>();
    private Context mContext;

    public HomeFragmentRecyclerViewAdapter(Context context,ArrayList<String> mCategories, ArrayList<String> mCategoryImageUrls){
        this.mCategories = mCategories;
        this.mCategoryImageUrls = mCategoryImageUrls;
        mContext = context;
    }

    @NonNull
    @Override
    //Inflate individual layout
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Log.d(TAG,"onCreateViewHolder: called");
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.home_recycler_view, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Log.d(TAG, "onBindViewHolder: called.");
        String category = mCategories.get(position);
        holder.name.setText(category);

        //bindding image
        String photoUrl = mCategoryImageUrls.get(position);

        Glide.with(mContext)
                .asBitmap()
                .load(photoUrl)
                .error(R.drawable.ic_image_black_24dp)
                .into(holder.image)
                ;
    }


    @Override
    public int getItemCount() {
        return mCategories.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView image;
        TextView name;

        public ViewHolder(View itemView){
            super(itemView);
            image = itemView.findViewById(R.id.categoryImg);
            name = itemView.findViewById(R.id.category);
        }
    }
}
