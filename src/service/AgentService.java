package service;

import enums.IssueType;
import models.Agent;
import repositories.AgentRepo;

import java.util.ArrayList;
import java.util.List;

public class AgentService {
    private static AgentRepo agentRepo;

    public AgentService(AgentRepo agentRepo) {
       this.agentRepo = agentRepo;
    }

    public void addAgent(String email, String name, List<IssueType> issues)
    {
        Agent agent = new Agent(email, name, issues);
        agentRepo.addAgent(agent);
        System.out.println(agent.toString() + " added");
    }

    public void viewAgentsWorkHistory()
    {
        List<Agent> agents = new ArrayList<>(agentRepo.getAgents().values());
        for(Agent agent : agents)
        {
            System.out.println(agent.toString());
            agent.displayIssues();
        }

    }
}
