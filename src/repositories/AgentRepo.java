package repositories;

import models.Agent;

import java.util.HashMap;
import java.util.Map;

public class AgentRepo {
    Map<String, Agent> agents;
    public AgentRepo() {
        agents = new HashMap<>();
    }

    public Agent getAgent(String id) {
        return agents.get(id);
    }

    public void addAgent(Agent agent) {
        agents.put(agent.getId(), agent);
    }

    public void removeAgent(String id) {
        agents.remove(id);
    }

    public Map<String, Agent> getAgents() {
        return agents;
    }
}
