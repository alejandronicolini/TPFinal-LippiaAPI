package api.model.Project;

public class TimeEstimate {
    private String estimate;
    private String type;
    private String resetOption;
    private boolean active;
    private boolean includeNonBillable;

    public String getEstimate() {
        return estimate;
    }

    public void setEstimate(String estimate) {
        this.estimate = estimate;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getResetOption() {
        return resetOption;
    }

    public void setResetOption(String resetOption) {
        this.resetOption = resetOption;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public boolean isIncludeNonBillable() {
        return includeNonBillable;
    }

    public void setIncludeNonBillable(boolean includeNonBillable) {
        this.includeNonBillable = includeNonBillable;
    }
}
