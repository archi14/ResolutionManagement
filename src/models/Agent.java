package models;

import enums.AgentStatus;
import enums.IssueType;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Agent {
    private String id;
    private String name;
    String email;
    private List<IssueType> issuesExpertise;
    private List<Issue> assignedIssues;
    AgentStatus status;

    public Agent(String name, String email, List<IssueType> issues) {
        this.name = name;
        this.email = email;
        this.issuesExpertise = issues;
        this.id = UUID.randomUUID().toString();
        assignedIssues = new ArrayList<>();
        this.status = AgentStatus.IDLE;
    }

    public String getId() {
        return id;
    }

    public boolean isExpertise(IssueType issueType) {
        return issuesExpertise.contains(issueType);
    }
    public AgentStatus getStatus() {
        return status;
    }

    public void setStatus(AgentStatus status) {
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public List<Issue> getAssignedIssues() {
        return assignedIssues;
    }

    public void addIssue(Issue issue) {
        assignedIssues.add(issue);
    }

    public void displayIssues() {
        for(int i=0;i<assignedIssues.size();i++) {
            System.out.println(assignedIssues.get(i).toString());
        }
    }
    @Override
    public String toString() {
        return "Agent{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }


}
