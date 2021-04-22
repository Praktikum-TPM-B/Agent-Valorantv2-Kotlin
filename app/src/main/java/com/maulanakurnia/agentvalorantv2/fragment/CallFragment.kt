package com.maulanakurnia.agentvalorantv2.fragment

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.textfield.TextInputLayout
import com.maulanakurnia.agentvalorantv2.R
import kotlinx.android.synthetic.main.fragement_call.*

class CallFragment: Fragment() {

    private val numberPhone: TextInputLayout?
        get() = number_phone

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragement_call, container, false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (activity as AppCompatActivity).supportActionBar?.title = "Dial Number Phone"

        btnDial.setOnClickListener{
            val intent = Intent(Intent.ACTION_DIAL,
                Uri.parse("tel:" + Uri.encode(numberPhone?.editText?.editableText.toString())))
            startActivity(intent)
        }
    }
}