package com.maulanakurnia.agentvalorantv2.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.maulanakurnia.agentvalorantv2.R
import com.maulanakurnia.agentvalorantv2.adapter.AgentAdapter
import com.maulanakurnia.agentvalorantv2.data.AgentData
import com.maulanakurnia.agentvalorantv2.model.AgentModel
import kotlinx.android.synthetic.main.fragment_agent.*

class AgentFragment: Fragment() {
    private val rvAgent: RecyclerView
        get() = rv_agent_list

    private lateinit var agentAdapter: AgentAdapter

    private fun getAgent(): List<AgentModel> {
        return AgentData.generateAgent()
    }

    override fun onCreateView( inflater: LayoutInflater, container: ViewGroup?,savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_agent, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        (activity as AppCompatActivity).supportActionBar?.title = "List Agent"

        // Setup Adapter
        agentAdapter = AgentAdapter(requireActivity())
        agentAdapter.setData(getAgent())

        // Setup List
        rvAgent.layoutManager = LinearLayoutManager(requireContext())
        rvAgent.setHasFixedSize(true)
        rvAgent.adapter = agentAdapter
    }

}