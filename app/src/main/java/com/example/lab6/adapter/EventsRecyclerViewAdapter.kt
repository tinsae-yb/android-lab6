package com.example.lab6.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.example.lab6.databinding.EventViewBinding
import com.example.lab6.databinding.NewsViewBinding
import com.example.lab6.databinding.SportViewBinding
import com.example.lab6.fragments.EventsFragment
import com.example.lab6.fragments.NewsFragment
import com.example.lab6.fragments.SportsFragment
import java.text.SimpleDateFormat
import java.util.Locale

class EventsRecyclerViewAdapter(private val events : MutableList<EventsFragment.Companion.SportEvent>) : RecyclerView.Adapter<EventsRecyclerViewAdapter.SportEventViewHolder>() {

    class  SportEventViewHolder(private val binding: EventViewBinding) : ViewHolder(binding.root){
        fun populate(event : EventsFragment.Companion.SportEvent){

            binding.eventDateTextView.text =   SimpleDateFormat("EEE, MMM d, ''yy", Locale.getDefault()).format(event.eventDate)
            binding.eventDescriptionTextView.text = event.eventDescription
            binding.eventNameTextView.text = event.eventName


        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SportEventViewHolder {
        return SportEventViewHolder( EventViewBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun getItemCount(): Int {

        return events.size

    }

    override fun onBindViewHolder(holder: SportEventViewHolder, position: Int) {
        holder.populate(events[position])
    }
}