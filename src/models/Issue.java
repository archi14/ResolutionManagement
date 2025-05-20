package models;

import enums.IssueStatus;
import enums.IssueType;

import java.util.UUID;

public class Issue {
    private String id;
    String subject;
    String transactionId;
    String description;
    private IssueType issueType;
    private IssueStatus status;
    String comment;
    String customerId;
    String assignedAgentId;

    public Issue(IssueType issueType, String transactionId, String subject, String description, String customerId) {
        this.issueType = issueType;
        this.status = IssueStatus.WAITING;
        this.customerId = customerId;
        this.description = description;
        this.subject = subject;
        this.transactionId = transactionId;
        this.id = UUID.randomUUID().toString();
        this.assignedAgentId = null;
    }

    public void assignAgent(String agentId) {
        this.assignedAgentId = agentId;
    }
    public void unassignAgent() {
        this.assignedAgentId = null;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getComment() {
        return comment;
    }

    public void setStatus(IssueStatus status) {
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public IssueType getIssueType() {
        return issueType;
    }

    public IssueStatus getStatus() {
        return status;
    }

    public String getTransactionId() {
        return transactionId;
    }

    @Override
    public String toString() {
        return "Issue{" +
                "id='" + id + '\'' +
                ", issueType=" + issueType.toString() +
                ", status=" + status.toString() +
                ", transactionId=" + transactionId +
                '}';
    }
}
