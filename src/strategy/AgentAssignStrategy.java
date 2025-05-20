package strategy;

import enums.IssueType;
import exception.NoAvailableAgentException;
import models.Agent;
import repositories.AgentRepo;

public interface AgentAssignStrategy {
    public Agent findAgent(IssueType issueType) throws NoAvailableAgentException;
}
