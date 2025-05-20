package repositories;

import models.Issue;

import java.util.HashMap;
import java.util.Map;

public class IssueRepo {
    Map<String, Issue> issues;

    public IssueRepo() {
        issues = new HashMap<>();
    }

    public Map<String, Issue> getIssues() {
        return issues;
    }

    public Issue getIssue(String id) {
        return issues.get(id);
    }

    public void addIssue(Issue issue) {
        issues.put(issue.getId(), issue);
    }

}
