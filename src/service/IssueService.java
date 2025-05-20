package service;

import dtos.IssueFilter;
import enums.AgentStatus;
import enums.IssueStatus;
import enums.IssueType;
import exception.NoAvailableAgentException;
import models.Agent;
import models.Customer;
import models.Issue;
import repositories.AgentRepo;
import repositories.CustomerRepo;
import repositories.IssueRepo;
import strategy.AgentAssignStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class IssueService {
    private AgentRepo agentRepo;
    private IssueRepo issueRepo;
    private CustomerRepo customerRepo;
    private AgentAssignStrategy agentAssignStrategy;

    public IssueService(AgentRepo agentRepo, IssueRepo issueRepo, CustomerRepo customerRepo, AgentAssignStrategy agentAssignStrategy) {
        this.agentRepo = agentRepo;
        this.customerRepo = customerRepo;
        this.issueRepo = issueRepo;
        this.agentAssignStrategy = agentAssignStrategy;
    }

    public void updateIssue(String issueId, IssueStatus issueStatus, String comment) {
        Issue issue = issueRepo.getIssue(issueId);
        issue.setStatus(issueStatus);
        issue.setComment(comment);
    }

    public void resolveIssue(String issueId, String comment) {
        Issue issue = issueRepo.getIssue(issueId);
        issue.setComment(comment);
        issue.setStatus(IssueStatus.COMPLETED);
    }

    public void createIssue(String transactionId, IssueType issueType, String subject, String description, String email) {
        Customer customer = customerRepo.getCustomer(transactionId);
        if(customer == null) {
            customer = new Customer(email);
            customerRepo.addCustomer(customer);
        }
        Issue issue = new Issue(issueType, transactionId, subject, description, customer.getId());
        issueRepo.addIssue(issue);
        System.out.println(issue.toString());
    }

    public void assignIssue(String issueId) throws NoAvailableAgentException {
        Issue issue = issueRepo.getIssue(issueId);
        Agent agent = agentAssignStrategy.findAgent(issue.getIssueType());
        agent.addIssue(issue);
        agent.setStatus(AgentStatus.ASSIGNED);
        issue.assignAgent(agent.getId());
        issue.setStatus(IssueStatus.ASSIGNED);

    }

    public List<Issue> getIssue(IssueFilter issueFilter)
    {
        List<Issue> issues = new ArrayList<>(issueRepo.getIssues().values());
        return issues.stream().filter(issue -> issueFilter.getStatus()==null ||  issue.getStatus() == issueFilter.getStatus()).
                filter(issue ->  issueFilter.getIssueType()==null || issue.getIssueType() == issueFilter.getIssueType()).collect(Collectors.toList());

    }
}
