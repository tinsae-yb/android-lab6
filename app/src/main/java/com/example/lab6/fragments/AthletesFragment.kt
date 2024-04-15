package com.example.lab6.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.lab6.R
import com.example.lab6.adapter.AthleteRecyclerViewAdapter
import com.example.lab6.databinding.FragmentAthletesBinding
import com.example.lab6.dialog.AddAthleteDialogFragment
import com.example.lab6.dialog.AddEventDialogFragment

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class AthletesFragment : Fragment() {

    lateinit var binding: FragmentAthletesBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
     binding = FragmentAthletesBinding.inflate(inflater, container,false);

        binding.athleteRecyclerView.adapter = AthleteRecyclerViewAdapter(athletes)
        binding.athleteRecyclerView.layoutManager = GridLayoutManager(this.context, 1)
        binding.athletesFab.setOnClickListener{

            AddAthleteDialogFragment( object : AddAthleteDialogFragment.AddAthleteDialogCallback {
                override fun onEventAdd(item: Athlete) {



                    athletes.add(0, item)
                    binding.athleteRecyclerView.adapter?.notifyItemInserted(0)
                    binding.athleteRecyclerView.scrollToPosition(0)


                }
            }).show(parentFragmentManager, "ADD_NEW_SPORT_DIALOG")

        }

        return binding.root

    }

    companion object {

        data class Athlete(
            val athleteName: CharSequence,
            val sportName: CharSequence,
            val country: CharSequence,
            val bestPerformance: CharSequence,
            val medals: Medals,
            val facts: CharSequence
        )

        data class Medals(
            val gold: Int,
            val silver: Int,
            val bronze: Int
        )

        val athletes: MutableList<Athlete> = mutableListOf(
            Athlete(
                athleteName = "Usain Bolt",
                sportName = "Athletics",
                country = "Jamaica",
                bestPerformance = "World Record Holder in 100m and 200m",
                medals = Medals(gold = 8, silver = 0, bronze = 0),
                facts = "Considered the fastest man in the world."
            ),
            Athlete(
                athleteName = "Simone Biles",
                sportName = "Gymnastics",
                country = "United States",
                bestPerformance = "Multiple-time Olympic gold medalist",
                medals = Medals(gold = 7, silver = 3, bronze = 1),
                facts = "One of the most decorated gymnasts in history."
            ),
            Athlete(
                athleteName = "Michael Phelps",
                sportName = "Swimming",
                country = "United States",
                bestPerformance = "Most decorated Olympian of all time",
                medals = Medals(gold = 23, silver = 3, bronze = 2),
                facts = "Known as the 'Flying Fish' for his speed in the water."
            ),
            Athlete(
                athleteName = "Serena Williams",
                sportName = "Tennis",
                country = "United States",
                bestPerformance = "Multiple Grand Slam singles titles",
                medals = Medals(gold = 4, silver = 0, bronze = 0),
                facts = "Considered one of the greatest tennis players of all time."
            ),
            Athlete(
                athleteName = "Lionel Messi",
                sportName = "Football",
                country = "Argentina",
                bestPerformance = "Winner of multiple Ballon d'Or awards",
                medals = Medals(gold = 1, silver = 1, bronze = 0),
                facts = "Regarded as one of the greatest footballers of all time."
            ),
            Athlete(
                athleteName = "Katie Ledecky",
                sportName = "Swimming",
                country = "United States",
                bestPerformance = "Multiple Olympic gold medalist",
                medals = Medals(gold = 7, silver = 3, bronze = 2),
                facts = "Known for her dominance in freestyle swimming events."
            ),
            Athlete(
                athleteName = "Cristiano Ronaldo",
                sportName = "Football",
                country = "Portugal",
                bestPerformance = "Winner of multiple FIFA Ballon d'Or awards",
                medals = Medals(gold = 2, silver = 2, bronze = 0),
                facts = "One of the most prolific goal scorers in football history."
            ),
            Athlete(
                athleteName = "Allyson Felix",
                sportName = "Athletics",
                country = "United States",
                bestPerformance = "Multiple Olympic gold medalist",
                medals = Medals(gold = 6, silver = 3, bronze = 1),
                facts = "One of the most decorated female track and field athletes."
            ),
            Athlete(
                athleteName = "Rafael Nadal",
                sportName = "Tennis",
                country = "Spain",
                bestPerformance = "Multiple Grand Slam singles titles",
                medals = Medals(gold = 2, silver = 1, bronze = 0),
                facts = "Known for his dominance on clay courts."
            ),
            Athlete(
                athleteName = "LeBron James",
                sportName = "Basketball",
                country = "United States",
                bestPerformance = "Multiple-time NBA champion and MVP",
                medals = Medals(gold = 2, silver = 0, bronze = 1),
                facts = "Considered one of the greatest basketball players of all time."
            )
        )


    }
}