package com.example.lab6.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.example.lab6.databinding.AthleteViewBinding
import com.example.lab6.databinding.NewsViewBinding
import com.example.lab6.databinding.SportViewBinding
import com.example.lab6.fragments.AthletesFragment
import com.example.lab6.fragments.NewsFragment
import com.example.lab6.fragments.SportsFragment

class AthleteRecyclerViewAdapter(private val athletes : MutableList<AthletesFragment.Companion.Athlete>) : RecyclerView.Adapter<AthleteRecyclerViewAdapter.AthleteViewHolder>() {

    class  AthleteViewHolder(private val binding: AthleteViewBinding) : ViewHolder(binding.root){
        fun populate(athlete: AthletesFragment.Companion.Athlete){

            binding.athleteNameTextView.text = athlete.athleteName
            binding.athleteSportNameTextView.text = athlete.sportName
            binding.athleteCountryTextView.text = athlete.country
            binding.athleteBestPerformanceTextView.text = athlete.bestPerformance
            binding.athleteGoldMedalTextView.text = athlete.medals.gold.toString()
            binding.athleteSilverMedalTextView.text = athlete.medals.silver.toString()
            binding.athleteBronzeMedalTextView.text = athlete.medals.bronze.toString()
            binding.athleteFactTextView.text = athlete.facts



        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AthleteViewHolder {
        return AthleteViewHolder( AthleteViewBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun getItemCount(): Int {

        return athletes.size

    }

    override fun onBindViewHolder(holder: AthleteViewHolder, position: Int) {
        holder.populate(athletes[position])
    }
}