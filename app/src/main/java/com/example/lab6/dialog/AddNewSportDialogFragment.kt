package com.example.lab6.dialog

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import com.example.lab6.databinding.AddSportDialogBinding
import com.example.lab6.fragments.SportsFragment
import com.google.android.material.dialog.MaterialAlertDialogBuilder

class AddNewSportDialogFragment(val callback: AddNewSportDialogCallback) : DialogFragment() {



    interface AddNewSportDialogCallback {
        fun onSportAdded(item: SportsFragment.Companion.Sport)
    }

    lateinit var binding: AddSportDialogBinding
    lateinit var dialog: AlertDialog
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity?.let {

            val builder = MaterialAlertDialogBuilder(it)
            binding = AddSportDialogBinding.inflate(layoutInflater)
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


        binding.addSportDialogAddButton.setOnClickListener {
            val type = binding.addSportDialogTypeTextView.editText?.text?.trim()
            val name = binding.addSportDialogNameTextView.editText?.text?.trim()
            val instruction = binding.addSportDialogInstructionTextArea.editText?.text?.trim()


            if (type.isNullOrEmpty() || name.isNullOrEmpty() || instruction.isNullOrEmpty()){


               Toast.makeText(context, "Fields can't be empty!!!", Toast.LENGTH_SHORT).show()

            }else{

                callback.onSportAdded(SportsFragment.Companion.Sport(type, name, instruction))
                dialog.dismiss()
            }

        }


        return super.onCreateView(inflater, container, savedInstanceState)
    }
}