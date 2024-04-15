package com.example.lab6.dialog

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import com.example.lab6.databinding.AddNewAthleteDialogBinding
import com.example.lab6.fragments.AthletesFragment
import com.google.android.material.dialog.MaterialAlertDialogBuilder

class AddAthleteDialogFragment(val callback: AddAthleteDialogCallback) : DialogFragment() {


    interface AddAthleteDialogCallback {
        fun onEventAdd(item: AthletesFragment.Companion.Athlete)
    }

    lateinit var binding: AddNewAthleteDialogBinding
    lateinit var dialog: AlertDialog

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity?.let {

            val builder = MaterialAlertDialogBuilder(it)
            binding = AddNewAthleteDialogBinding.inflate(layoutInflater)
            builder.setView(binding.root)
            dialog = builder.create()
            return dialog

        } ?: throw IllegalStateException("Activity cannot be null")
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        binding.addAthleteDialogAddButton.setOnClickListener {

            val athleteName = binding.addAthleteDialogNameField.editText?.text?.trim()
            val sportName = binding.addAthleteDialogSportField.editText?.text?.trim()
            val country = binding.addAthleteDialogCountryField.editText?.text?.trim()
            val bestPerformance =
                binding.addAthleteDialogBestPerformanceField.editText?.text?.trim()
            val gold = binding.addAthleteDialogGoldField.editText?.text?.trim()
            val silver = binding.addAthleteDialogSilverField.editText?.text?.trim()
            val bronze = binding.addAthleteDialogBronzeField.editText?.text?.trim()
            val facts = binding.addAthleteDialogFactsField.editText?.text?.trim()


            if (athleteName.isNullOrEmpty() ||
                sportName.isNullOrEmpty() ||
                country.isNullOrEmpty() ||
                bestPerformance.isNullOrEmpty() ||
                gold.isNullOrEmpty() ||
                silver.isNullOrEmpty() ||
                bronze.isNullOrEmpty() ||
                facts.isNullOrEmpty()

            ) {
                Toast.makeText(context, "Fields can't be empty!!!", Toast.LENGTH_SHORT).show()


            } else {
                try {
                    val gold = Integer.parseInt(gold.toString())
                    val silver = Integer.parseInt(gold.toString())
                    val bronze = Integer.parseInt(gold.toString())

                   callback.onEventAdd( AthletesFragment.Companion.Athlete(athleteName, sportName, country, bestPerformance, AthletesFragment.Companion.Medals(gold, silver, bronze), facts))
                    dialog.dismiss()
                }catch (ex : NumberFormatException){
                    Toast.makeText(context, "Make sure the medals are proper numbers", Toast.LENGTH_SHORT).show()

                }



            }

        }


        return super.onCreateView(inflater, container, savedInstanceState)
    }


}