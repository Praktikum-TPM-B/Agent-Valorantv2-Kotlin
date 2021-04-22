package com.maulanakurnia.agentvalorantv2.activity

import android.net.Uri
import android.os.Bundle
import android.view.MenuItem
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.maulanakurnia.agentvalorantv2.R

class DetailAgentActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        if (supportActionBar != null)
            supportActionBar!!.setDisplayHomeAsUpEnabled(true)

        var img:ImageView         = findViewById(R.id.agent_image)
        var nameTxt: TextView     = findViewById(R.id.agent_name)
        var roleTxt: TextView     = findViewById(R.id.agent_role)
        var summaryTxt: TextView  = findViewById(R.id.agent_summary)

        val i = this.intent

        val images  = i.extras!!.getString("IMAGE_KEY")
        val name    = i.extras!!.getString("NAME_KEY")
        val role    = i.extras!!.getString("ROLE_KEY")
        val summary = i.extras!!.getString("SUMMARY_KEY")

        title = "Detail $name"

        img.setImageURI(Uri.parse(images))
        nameTxt.text = name
        roleTxt.text = role
        summaryTxt.text = summary

        Glide.with(this)
            .load(images)
            .into(img)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home)
            finish()
        return super.onOptionsItemSelected(item)
    }
    override fun onBackPressed() {
        finish()
    }
}