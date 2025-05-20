import repositories.AgentRepo;
import repositories.CustomerRepo;
import repositories.IssueRepo;
import service.AgentService;
import service.IssueService;
import strategy.FirstAvailableAgentStrategy;

public class Main {

    public static void main(String[] args) {
        AgentRepo agentRepo = new AgentRepo();
        CustomerRepo customerRepo = new CustomerRepo();
        IssueRepo issueRepo = new IssueRepo();

        // strategies
        FirstAvailableAgentStrategy firstAvailableAgentStrategy = new FirstAvailableAgentStrategy(agentRepo);

        AgentService agentService = new AgentService(agentRepo);
        IssueService issueService = new IssueService(agentRepo, issueRepo, customerRepo, firstAvailableAgentStrategy);



    }
}
