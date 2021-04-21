package com.maulanakurnia.agentvalorantv2.ui.agent

import androidx.lifecycle.ViewModel
import com.maulanakurnia.agentvalorantv2.data.AgentData
import com.maulanakurnia.agentvalorantv2.model.AgentModel

class AgentViewModel : ViewModel() {
    fun getCourse(): List<AgentModel> {
        return AgentData.generateAgent()
    }
}
