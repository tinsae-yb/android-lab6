package com.example.lab6.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import com.example.lab6.R
import com.example.lab6.adapter.EventsRecyclerViewAdapter
import com.example.lab6.databinding.FragmentEventsBinding
import com.example.lab6.dialog.AddEventDialogFragment
import com.example.lab6.dialog.AddNewsDialogFragment
import java.util.Date



class EventsFragment : Fragment() {


    lateinit var binding: FragmentEventsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

         binding = FragmentEventsBinding.inflate(inflater, container, false)
        binding.eventRecyclerView.adapter = EventsRecyclerViewAdapter(sportEvents )
        binding.eventRecyclerView.layoutManager = GridLayoutManager(this.context, 2)

        binding.eventFab.setOnClickListener{

            AddEventDialogFragment( object : AddEventDialogFragment.AddEventDialogCallback {
                override fun onEventAdd(item: SportEvent) {



                    sportEvents.add(0, item)
                    binding.eventRecyclerView.adapter?.notifyItemInserted(0)
                    binding.eventRecyclerView.scrollToPosition(0)


                }
            }).show(parentFragmentManager, "ADD_NEW_SPORT_DIALOG")

        }

        return binding.root
    }

    companion object {

        data class SportEvent(
            val eventName: CharSequence,
            val eventDescription: CharSequence,
            val eventDate: Date
        )

        val sportEvents = mutableListOf(
            SportEvent(
                "UEFA Champions League Quarterfinals",
                "Exciting matches between the top football clubs in Europe as they compete to advance to the semifinals of the UEFA Champions League.",
                Date(124, 3, 12) // Year: 2024, Month: April (0-based index), Day: 12
            ),
            SportEvent(
                "NBA Playoffs First Round",
                "Intense basketball matchups featuring the top teams in the NBA as they battle it out in the first round of the playoffs.",
                Date(124, 3, 14) // Year: 2024, Month: April (0-based index), Day: 14
            ),
            SportEvent(
                "Masters Tournament",
                "The prestigious golf tournament held annually at Augusta National Golf Club, where top golfers from around the world compete for the coveted green jacket.",
                Date(124, 3, 11) // Year: 2024, Month: April (0-based index), Day: 11
            ),
            SportEvent(
                "French Open",
                "One of the four Grand Slam tennis tournaments, held at Roland Garros Stadium in Paris, featuring top tennis players competing on clay courts.",
                Date(124, 4, 26) // Year: 2024, Month: May (0-based index), Day: 26
            ),
            SportEvent(
                "Tokyo Olympics Opening Ceremony",
                "The grand opening ceremony of the Summer Olympics, featuring spectacular performances, cultural displays, and the Parade of Nations.",
                Date(124, 6, 23) // Year: 2024, Month: July (0-based index), Day: 23
            ),
            SportEvent(
                "MLB All-Star Game",
                "The annual exhibition baseball game showcasing the best players from the American and National Leagues, held midway through the MLB season.",
                Date(124, 6, 9) // Year: 2024, Month: July (0-based index), Day: 9
            ),
            SportEvent(
                "Wimbledon Championships",
                "The oldest tennis tournament in the world, held at the All England Club in London, featuring top tennis players competing on grass courts.",
                Date(124, 5, 24) // Year: 2024, Month: June (0-based index), Day: 24
            ),
            SportEvent(
                "Summer Paralympics",
                "The international multi-sport event for athletes with disabilities, held in parallel with the Summer Olympics, showcasing extraordinary athletic achievements.",
                Date(124, 7, 28) // Year: 2024, Month: August (0-based index), Day: 28
            ),
            SportEvent(
                "Ryder Cup",
                "The prestigious golf competition between teams representing Europe and the United States, held biennially, alternating between courses in Europe and the US.",
                Date(124, 8, 27) // Year: 2024, Month: September (0-based index), Day: 27
            ),
            SportEvent(
                "NFL Kickoff Game",
                "The opening game of the NFL regular season, featuring a highly anticipated matchup between two NFL teams to start the football season.",
                Date(124, 8, 5) // Year: 2024, Month: September (0-based index), Day: 5
            )
        )

    }
}