package com.geektech.java3hw7;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.geektech.java3hw7.databinding.ItemSongBinding;

import java.util.ArrayList;

public class SongAdapter extends RecyclerView.Adapter<SongAdapter.SongViewHolder> {

    private ArrayList<Song> songs;
    private Click click;

    public SongAdapter(ArrayList<Song> songs, Click cLickListener) {
        this.click = cLickListener;
        this.songs = songs;
    }

    @NonNull
    @Override
    public SongViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new SongViewHolder(ItemSongBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull SongViewHolder holder, int position) {
        holder.bind(songs.get(position));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                click.ClickListen(songs.get(position));
            }
        });
    }

    @Override
    public int getItemCount() {
        return songs.size();
    }

    class SongViewHolder extends RecyclerView.ViewHolder{

        private ItemSongBinding binding;
        public SongViewHolder(ItemSongBinding itemView) {
            super(itemView.getRoot());
            binding = itemView;
        }

        public void bind(Song song) {
            binding.textNumber.setText((song.getNumber()));
            binding.textOne.setText(song.getName());
            binding.textTwo.setText(song.getSinger());
            binding.textTime.setText(song.getTime());
        }
    }
}
