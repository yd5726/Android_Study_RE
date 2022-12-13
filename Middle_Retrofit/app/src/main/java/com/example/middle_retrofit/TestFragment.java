package com.example.middle_retrofit;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.middle_retrofit.databinding.FragmentTestBinding;

public class TestFragment extends Fragment {
    FragmentTestBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentTestBinding.inflate(inflater);
        return binding.getRoot();
    }

    /*반드시 지켜야 할 것 : Fragment*/
    @Override
    public void onDestroyView(){
        super.onDestroyView();
        binding = null;
    }
}