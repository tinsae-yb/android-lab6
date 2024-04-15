package com.example.lab6.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.lab6.databinding.SportViewBinding
import com.example.lab6.fragments.SportsFragment

class SportsRecyclerViewAdapter(val sports : MutableList<SportsFragment.Companion.Sport>) : RecyclerView.Adapter<SportsRecyclerViewAdapter.SportViewHolder>() {

    class  SportViewHolder(val binding: SportViewBinding) : ViewHolder(binding.root){
        fun populate(sport : SportsFragment.Companion.Sport){
            binding.sportTypeTextView.text = sport.type
            binding.sportNameTextView.text = sport.name
            binding.sportInstructionTextView.text = sport.instruction

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SportViewHolder {
        return SportViewHolder( SportViewBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun getItemCount(): Int {

        return sports.size

    }

    override fun onBindViewHolder(holder: SportViewHolder, position: Int) {
        holder.populate(sports[position])
    }


}