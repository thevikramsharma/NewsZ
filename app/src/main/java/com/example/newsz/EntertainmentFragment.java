package com.example.newsz;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EntertainmentFragment extends Fragment {
    String api = "46d24548942a4ab181fc6d0765a42fef";
    ArrayList<ModelClass> modelClassArrayList;
    Adaptor adaptor;
    String country = "in";
    private RecyclerView recyclerView;
    private String category = "entertainment";

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.entertainmentfragment,null);
        recyclerView = view.findViewById(R.id.recyclerviewfrenter);
        modelClassArrayList = new ArrayList<>();
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        adaptor = new Adaptor(getContext(), modelClassArrayList);
        recyclerView.setAdapter(adaptor);

        findnews();

        return view;

    }

    private void findnews() {


        ApiUtilities.getApiInterface().getCategorynews(country,category,100,api).
                enqueue(new Callback<mainNews>() {
                    @Override
                    public void onResponse(Call<mainNews> call, Response<mainNews> response) {
                        if (response.isSuccessful()){
                            modelClassArrayList.addAll(response.body().getArticles());
                            adaptor.notifyDataSetChanged();
                        }
                    }

                    @Override
                    public void onFailure(Call<mainNews> call, Throwable t) {

                    }
                });
    }
}
