package com.maulanakurnia.agentvalorantv2.adapter

import android.app.Activity
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.maulanakurnia.agentvalorantv2.R
import com.maulanakurnia.agentvalorantv2.model.AgentModel
import com.maulanakurnia.agentvalorantv2.activity.DetailAgentActivity
import kotlinx.android.synthetic.main.item_list_agent.view.*

class AgentAdapter(val activity: Activity): RecyclerView.Adapter<AgentAdapter.ViewHolder>() {

    private var listAgent = arrayListOf<AgentModel>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_list_agent, parent, false))
    }

    override fun getItemCount(): Int {
        return listAgent.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(listAgent[position])
    }

    fun setData(item: List<AgentModel>) {
        listAgent.clear()
        listAgent.addAll(item)
    }

    inner class ViewHolder(private val view: View): RecyclerView.ViewHolder(view) {
        fun bind(agent: AgentModel) {
            with(view) {

                Glide.with(this.context)
                    .load(agent.image)
                    .apply(RequestOptions().override(350, 550))
                    .into(agent_image)

                agent_name.text = agent.name
                agent_role.text = agent.role
                agent_summary.text = agent.summary

                view.btnPreview.setOnClickListener {
                    val i = Intent(activity, DetailAgentActivity::class.java)
                    i.putExtra("IMAGE_KEY", agent.image)
                    i.putExtra("NAME_KEY", agent.name)
                    i.putExtra("ROLE_KEY", agent.role)
                    i.putExtra("SUMMARY_KEY", agent.summary)
                    activity.startActivity(i)
                }
            }
        }
    }
}
