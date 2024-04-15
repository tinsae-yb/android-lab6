package com.example.lab6.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import com.example.lab6.adapter.SportsRecyclerViewAdapter
import com.example.lab6.databinding.FragmentSportsBinding
import com.example.lab6.dialog.AddNewSportDialogFragment


class SportsFragment : Fragment() {

lateinit var binding: FragmentSportsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentSportsBinding.inflate(inflater, container, false)
       val sportsRecyclerViewAdapter  =   SportsRecyclerViewAdapter(sports)
        binding.sportsRecyclerView.adapter = sportsRecyclerViewAdapter


        binding.sportsRecyclerView.layoutManager = GridLayoutManager(this.context, 2)
        binding.sportsFab.setOnClickListener{

           AddNewSportDialogFragment( object : AddNewSportDialogFragment.AddNewSportDialogCallback{
               override fun onSportAdded(item: Sport) {
                   sports.add(0, item)
                   sportsRecyclerViewAdapter.notifyItemInserted(0)
                   binding.sportsRecyclerView.scrollToPosition(0)


               }
           }).show(parentFragmentManager, "ADD_NEW_SPORT_DIALOG")

        }
        return binding.root
    }



    companion object {


        val sports = mutableListOf<Sport>(
            Sport("Measure", "running","To excel in running, begin with proper warm-up exercises to prevent injury and enhance performance. Focus on maintaining good posture, engaging core muscles, and breathing rhythmically. Start with a comfortable pace, gradually increasing speed and distance as endurance improves. Pay attention to foot strike, aiming for a mid-foot landing to reduce stress on joints. Incorporate interval training to build speed and stamina, and don't forget to cool down and stretch post-run to aid recovery and flexibility. Lastly, listen to your body, rest when needed, and stay hydrated to support optimal performance and enjoyment of the sport." ),
            Sport("Precision","darts","To master darts, start with a solid stance, positioning your dominant foot slightly forward for stability. Grip the dart firmly but comfortably, ensuring a relaxed wrist for fluid motion. Focus on aiming at the specific target, using a consistent and controlled throwing motion. Keep your eye on the target and maintain a steady rhythm throughout your throw. Practice regularly to improve accuracy and precision, adjusting your aim as needed based on previous throws. Develop a mental routine to stay focused and confident, and remember to stay relaxed to avoid tensing up during crucial moments. Analyze your technique and adjust accordingly to continually refine your skills."),
            Sport("Spectacle","cheerleading","To excel in cheerleading, focus on mastering both individual skills and teamwork. Start by building strength and flexibility through regular conditioning exercises and stretching routines. Practice proper technique for jumps, tumbling, and stunts, ensuring safety measures are always in place. Develop trust and communication with your teammates to execute synchronized routines smoothly. Pay attention to timing and synchronization to create visually stunning performances. Embrace a positive attitude and encourage your teammates, fostering a supportive and inclusive team environment. Continuously refine your skills through consistent practice and seek feedback from coaches to improve. Stay dedicated, resilient, and passionate about the sport to reach your full potential as a cheerleader."),
            Sport("Combat", "boxing","To thrive in boxing, focus on honing your skills in technique, conditioning, and mental discipline. Start by mastering the fundamentals of stance, footwork, and basic punches such as the jab, cross, hook, and uppercut. Incorporate shadowboxing, bag work, and pad drills into your training regimen to refine your striking accuracy and speed. Build endurance and strength through cardiovascular exercises, strength training, and plyometrics to enhance your overall fitness and power. Practice defensive maneuvers such as slipping, blocking, and parrying to minimize the impact of your opponent's punches. Develop mental toughness and strategy by studying opponents, visualizing success, and maintaining focus during training and fights. Embrace discipline, perseverance, and respect for both yourself and your opponents to thrive in the demanding world of boxing."),
            Sport("Play","soccer","To excel in soccer, focus on mastering technical skills such as dribbling, passing, shooting, and ball control through regular practice and drills. Develop a strong understanding of positioning, both offensively and defensively, to effectively support your team and anticipate plays. Work on your agility, speed, and endurance through cardiovascular exercises, interval training, and agility drills to maintain peak physical condition during matches. Cultivate teamwork and communication skills to coordinate with teammates and execute cohesive strategies on the field. Study the game, analyze matches, and learn from experienced players and coaches to continually improve your understanding of tactics and game situations. Lastly, maintain a positive attitude, resilience, and dedication to consistently push yourself to reach your full potential as a soccer player.")

            )

        data class Sport(val type:CharSequence, val name: CharSequence, val instruction: CharSequence)

    }
}