package com.geektech.java3hw7;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.geektech.java3hw7.databinding.FragmentSecondBinding;

import java.util.ArrayList;

public class SecondFragment extends Fragment {
    private FragmentSecondBinding binding;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentSecondBinding.inflate(LayoutInflater.from(getContext()),container,false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ArrayList<Song> songs = new ArrayList<>();
        songs.add(new Song("1","Blank Space", "Taylor Swift", "5:32"));
        songs.add(new Song("2","Watch Me", "Taylor Swift", "5:32"));
        songs.add(new Song("3","Earned It", "Taylor Swift", "5:32"));
        songs.add(new Song("4","Kara Jorgo", "Taylor Swift", "5:32"));
        songs.add(new Song("5","Only One", "Taylor Swift", "5:32"));
        songs.add(new Song("6","The End", "Taylor Swift", "5:32"));
        songs.add(new Song("7","Siuuu Space", "Taylor Swift", "5:32"));
        songs.add(new Song("8","Crish Space", "Taylor Swift", "5:32"));

        SongAdapter adapter = new SongAdapter(songs, new Click() {
            @Override
            public void ClickListen(Song song) {
                Intent intent = new Intent(getActivity(), SecondActivity.class);
                intent.putExtra("key",song.getName());
                startActivity(intent);
            }
        });
        binding.recycler.setAdapter(adapter);
    }
}