package strategy;

import enums.AgentStatus;
import enums.IssueType;
import exception.NoAvailableAgentException;
import models.Agent;
import repositories.AgentRepo;

import java.util.ArrayList;
import java.util.List;

public class FirstAvailableAgentStrategy implements AgentAssignStrategy {
    private AgentRepo agentRepo;

    public FirstAvailableAgentStrategy(AgentRepo agentRepo) {
        this.agentRepo = agentRepo;
    }
    @Override
    public Agent findAgent(IssueType issueType) throws NoAvailableAgentException {
        List<Agent> agents = new ArrayList<>(agentRepo.getAgents().values());
        for (Agent agent : agents) {
            if(agent.getStatus() == AgentStatus.IDLE && agent.isExpertise(issueType))
            {
                return agent;
            }
        }
        throw new NoAvailableAgentException("No agent is avaiable for the issueType " + issueType.toString());
    }
}
