package fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.project.coconuc.R;

import java.util.ArrayList;

import viewAdapter.HomeFragmentRecyclerViewAdapter;


public class HomeFragment extends Fragment {
    public static final String TAG = "HomeFragment";
    private ArrayList<String> mCategories = new ArrayList<>();
    private ArrayList<String> mCategoryImageUrls = new ArrayList<>();

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        return super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.home_fragment, container, false);

        getImage();

        mRecyclerView = (RecyclerView) view.findViewById(R.id.rvCategory);
        mLayoutManager = new LinearLayoutManager(this.getActivity(), LinearLayoutManager.HORIZONTAL, false);

        Log.d("debugMode", "The application stopped after this");

        mRecyclerView.setLayoutManager(mLayoutManager);

        mAdapter = new HomeFragmentRecyclerViewAdapter(this.getActivity(), mCategories, mCategoryImageUrls);
        mRecyclerView.setAdapter(mAdapter);

        return view;
    }

        //Get data to bind to holder
    private void getImage(){
        Log.d(TAG, "initImageBitmaps");

        mCategories.add("Thể Thao - Dã Ngoại");
        mCategoryImageUrls.add("https://source.unsplash.com/random");

        mCategories.add("Máy Ảnh - Máy Quay Phim");
        mCategoryImageUrls.add("https://source.unsplash.com/random");

        mCategories.add("Laptop - Máy Vi Tính - Linh Kiện");
        mCategoryImageUrls.add("https://source.unsplash.com/random");

        mCategories.add("Nhà Sách Tiki");
        mCategoryImageUrls.add("https://source.unsplash.com/random");

        mCategories.add("Ô Tô - Xe Máy - Xe Đạp");
        mCategoryImageUrls.add("https://source.unsplash.com/random");

        mCategories.add("Voucher - Dịch vụ");
        mCategoryImageUrls.add("https://source.unsplash.com/random");

        mCategories.add("Bách Hóa Online");
        mCategoryImageUrls.add("https://source.unsplash.com/random");

        //initRecyclerView();
    }

//    private void initRecyclerView(){
//        Log.d(TAG,"initRecyclerView");
//
//        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
//        RecyclerView recyclerView = findViewById(R.id.rvCategory);
//        recyclerView.setLayoutManager(layoutManager);
//        HomeFragmentRecyclerViewAdapter adapter = new HomeFragmentRecyclerViewAdapter(this, mCategories, mCategoryImageUrls);
//        recyclerView.setAdapter(adapter);
//    }
}
