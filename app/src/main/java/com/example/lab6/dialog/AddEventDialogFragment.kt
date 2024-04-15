package com.example.lab6.dialog

import android.app.DatePickerDialog
import android.app.Dialog
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.DatePicker
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import com.example.lab6.databinding.AddEventDialogBinding
import com.example.lab6.databinding.AddNewsDialogBinding
import com.example.lab6.databinding.AddSportDialogBinding
import com.example.lab6.fragments.EventsFragment
import com.example.lab6.fragments.NewsFragment
import com.example.lab6.fragments.SportsFragment
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.util.Calendar
import java.util.Date
import java.util.Locale

class AddEventDialogFragment(val callback: AddEventDialogCallback) : DialogFragment() {



    interface AddEventDialogCallback {
        fun onEventAdd(item: EventsFragment.Companion.SportEvent)
    }

    lateinit var binding: AddEventDialogBinding
    lateinit var dialog: AlertDialog
    var eventName : CharSequence? = ""
    var eventDescription : CharSequence? = ""
    var date : Date?  = null
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity?.let {

            val builder = MaterialAlertDialogBuilder(it)
            binding = AddEventDialogBinding.inflate(layoutInflater)
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

        binding.addEventDialogSelectDateButton.setOnClickListener {
            showDatePickerDialog{
                date = it
                binding.addEventDialogSelectDateButton.text = SimpleDateFormat("EEE, MMM d, ''yy", Locale.getDefault()).format(it)
            }

        }

        binding.addNewsButton.setOnClickListener {
            eventName = binding.addEventDialogEventNameTextField.editText?.text?.trim()

             eventDescription = binding.addEventDialogDescriptionTextArea.editText?.text?.trim()


            if (eventName.isNullOrEmpty() || eventDescription.isNullOrEmpty() || date == null){


               Toast.makeText(context, "Fields can't be empty!!!", Toast.LENGTH_SHORT).show()

            }else{

                callback.onEventAdd(EventsFragment.Companion.SportEvent(eventName!!,
                    eventDescription!!, date!!
                ))
                dialog.dismiss()
            }

        }


        return super.onCreateView(inflater, container, savedInstanceState)
    }

    private fun showDatePickerDialog( onSelected :  (Date)->Unit  ) {
        val calendar = Calendar.getInstance()

        val datePickerDialog = this.context?.let {
            DatePickerDialog(
                it,
                { _, year, monthOfYear, dayOfMonth ->



                    onSelected(Date(year, monthOfYear, dayOfMonth))
                },
                calendar.get(Calendar.YEAR),
                calendar.get(Calendar.MONTH),
                calendar.get(Calendar.DAY_OF_MONTH)
            )
        }

        datePickerDialog?.show()
    }


}