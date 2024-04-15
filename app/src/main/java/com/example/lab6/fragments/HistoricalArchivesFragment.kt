package com.example.lab6.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import com.example.lab6.R
import com.example.lab6.adapter.EventsRecyclerViewAdapter
import com.example.lab6.databinding.EventViewBinding
import com.example.lab6.databinding.FragmentEventsBinding
import com.example.lab6.databinding.FragmentHistoricalArchivesBinding
import com.example.lab6.dialog.AddEventDialogFragment
import com.example.lab6.fragments.EventsFragment.Companion.SportEvent
import java.util.Date

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"


class HistoricalArchivesFragment : Fragment() {

    lateinit var binding: FragmentHistoricalArchivesBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHistoricalArchivesBinding.inflate(inflater, container, false)
        binding.historicRecyclerView.adapter = EventsRecyclerViewAdapter(historicSportEvents )
        binding.historicRecyclerView.layoutManager = GridLayoutManager(this.context, 2)


        binding.historicArchivesFab.setOnClickListener{

            Log.d("TAG", "onCreateView: asdASDASDasd asdasd as dasads")

            AddEventDialogFragment( object : AddEventDialogFragment.AddEventDialogCallback {
                override fun onEventAdd(item: SportEvent) {



                    historicSportEvents.add(0, item)
                    binding.historicRecyclerView.adapter?.notifyItemInserted(0)
                    binding.historicRecyclerView.scrollToPosition(0)


                }
            }).show(parentFragmentManager, "ADD_NEW_SPORT_DIALOG")

        }

        return binding.root
    }

    companion object {

        val historicSportEvents = mutableListOf(
            SportEvent(
                "First Modern Olympic Games",
                "The first modern Olympic Games held in Athens, Greece, marking the revival of the ancient Olympic Games.",
                Date(1896 - 1900, 3, 6) // Year: 1896, Month: April (0-based index), Day: 6
            ),
            SportEvent(
                "Miracle on Ice",
                "The United States ice hockey team's victory over the Soviet Union at the 1980 Winter Olympics in Lake Placid, New York.",
                Date(1980 - 1900, 1, 22) // Year: 1980, Month: February (0-based index), Day: 22
            ),
            SportEvent(
                "Jesse Owens at the 1936 Olympics",
                "Jesse Owens, an African American track and field athlete, won four gold medals at the 1936 Summer Olympics in Berlin, Germany.",
                Date(1936 - 1900, 7, 1) // Year: 1936, Month: August (0-based index), Day: 1
            ),
            SportEvent(
                "The Rumble in the Jungle",
                "The famous boxing match between Muhammad Ali and George Foreman in Kinshasa, Zaire (now Democratic Republic of the Congo) in 1974.",
                Date(1974 - 1900, 9, 30) // Year: 1974, Month: October (0-based index), Day: 30
            ),
            SportEvent(
                "The Thrilla in Manila",
                "The historic boxing match between Muhammad Ali and Joe Frazier in Quezon City, Metro Manila, Philippines in 1975.",
                Date(1975 - 1900, 10, 1) // Year: 1975, Month: November (0-based index), Day: 1
            ),
            SportEvent(
                "The Hand of God",
                "Diego Maradona's controversial handball goal for Argentina against England in the 1986 FIFA World Cup quarterfinals.",
                Date(1986 - 1900, 6, 22) // Year: 1986, Month: June (0-based index), Day: 22
            ),
            SportEvent(
                "The Miracle of Istanbul",
                "Liverpool FC's comeback from a 3-0 halftime deficit to defeat AC Milan in the 2005 UEFA Champions League final.",
                Date(2005 - 1900, 5, 25) // Year: 2005, Month: May (0-based index), Day: 25
            ),
            SportEvent(
                "The Black Power Salute",
                "Tommy Smith and John Carlos' raised fist protest during the medal ceremony at the 1968 Summer Olympics in Mexico City.",
                Date(1968 - 1900, 10, 16) // Year: 1968, Month: November (0-based index), Day: 16
            ),
            SportEvent(
                "The Munich Massacre",
                "The terrorist attack on the Israeli Olympic team at the 1972 Summer Olympics in Munich, Germany.",
                Date(1972 - 1900, 8, 5) // Year: 1972, Month: September (0-based index), Day: 5
            ),
            SportEvent(
                "The Fosbury Flop",
                "Dick Fosbury's innovative high jump technique, which revolutionized the sport of track and field at the 1968 Summer Olympics.",
                Date(1968 - 1900, 10, 18) // Year: 1968, Month: November (0-based index), Day: 18
            ))
    }
}