package dtos;

import enums.IssueStatus;
import enums.IssueType;

public class IssueFilter {
    private final IssueType issueType;
    private final IssueStatus status;

    public IssueFilter(Builder builder)
    {
        this.issueType = builder.issueType;
        this.status = builder.status;
    }

    public IssueType getIssueType() {
        return issueType;
    }

    public IssueStatus getStatus() {
        return status;
    }

    public static class Builder {
        private IssueType issueType;
        private IssueStatus status;

        public Builder setStatus(IssueStatus status)
        {
            this.status = status;
            return this;
        }

        public Builder setType(IssueType type)
        {
            this.issueType = type;
            return this;
        }

        public IssueFilter build()
        {
            return new IssueFilter(this);
        }
    }

}

