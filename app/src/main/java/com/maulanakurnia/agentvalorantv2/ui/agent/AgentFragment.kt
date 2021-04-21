package com.maulanakurnia.agentvalorantv2.ui.agent

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.maulanakurnia.agentvalorantv2.R
import kotlinx.android.synthetic.main.fragment_agent.*

class AgentFragment: Fragment() {
    private val rvAgent: RecyclerView
        get() = rv_agent_list

    private lateinit var agentAdapter: AgentAdapter
    private lateinit var agentViewModel: AgentViewModel

    override fun onCreateView( inflater: LayoutInflater, container: ViewGroup?,savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_agent, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        initViewModel()
        setupAdapter()
        showListCourse()
    }

    private fun initViewModel() {
        agentViewModel = ViewModelProviders.of(this).get(AgentViewModel::class.java)
    }

    private fun setupAdapter() {
        agentAdapter = AgentAdapter(requireActivity())
        agentAdapter.setData(agentViewModel.getCourse())
    }

    private fun showListCourse() {
        rvAgent.layoutManager = LinearLayoutManager(requireContext())
        rvAgent.setHasFixedSize(true)
        rvAgent.adapter = agentAdapter
    }

}