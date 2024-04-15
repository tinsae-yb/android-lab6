package com.example.lab6.dialog

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import com.example.lab6.databinding.AddNewsDialogBinding
import com.example.lab6.databinding.AddSportDialogBinding
import com.example.lab6.fragments.NewsFragment
import com.example.lab6.fragments.SportsFragment
import com.google.android.material.dialog.MaterialAlertDialogBuilder

class AddNewsDialogFragment(val callback: AddNewsDialogCallback) : DialogFragment() {



    interface AddNewsDialogCallback {
        fun onNewsAdded(item: NewsFragment.Companion.NewsArticle)
    }

    lateinit var binding: AddNewsDialogBinding
    lateinit var dialog: AlertDialog
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity?.let {

            val builder = MaterialAlertDialogBuilder(it)
            binding = AddNewsDialogBinding.inflate(layoutInflater)
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


        binding.addNewsButton.setOnClickListener {
            val title = binding.addNewsDialogTitleTextField.editText?.text?.trim()
            val image = binding.addNewsDialogUrlTextField.editText?.text?.trim().toString()
            val description = binding.addNewsDialogDescritptionTextField.editText?.text?.trim()


            if (title.isNullOrEmpty() || image.isNullOrEmpty() || description.isNullOrEmpty()){


               Toast.makeText(context, "Fields can't be empty!!!", Toast.LENGTH_SHORT).show()

            }else{
                dialog.dismiss()
                callback.onNewsAdded(NewsFragment.Companion.NewsArticle(title, description , image))

            }

        }


        return super.onCreateView(inflater, container, savedInstanceState)
    }
}