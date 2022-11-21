package api.model.Project;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;


public class Api_ProjectResponse {

    private String id;
    private String name;
    private HourlyRate hourlyRate;
    private String clientId;
    private String client;
    private String workspaceId;
    private boolean billable;
    private List<Membership> memberships;
    private String color;
    private Estimate EstimateObject;
    private boolean archived;
    private List <Tasks> tasks;
    private String note;
    private String duration;
    private String costRate;
    private TimeEstimate TimeEstimate;
    private String budgetEstimate;
    private List<CustomField> customFields;
    @JsonProperty("public")
    private boolean publico;
    private boolean template;
    private boolean favorite;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HourlyRate getHourlyRate() {
        return hourlyRate;
    }

    public void setHourlyRate(HourlyRate hourlyRate) {
        this.hourlyRate = hourlyRate;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public String getWorkspaceId() {
        return workspaceId;
    }

    public void setWorkspaceId(String workspaceId) {
        this.workspaceId = workspaceId;
    }

    public boolean isBillable() {
        return billable;
    }

    public void setBillable(boolean billable) {
        this.billable = billable;
    }

    public List<Membership> getMemberships() {
        return memberships;
    }

    public void setMemberships(List<Membership> memberships) {
        this.memberships = memberships;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Estimate getEstimateObject() {
        return EstimateObject;
    }

    public void setEstimateObject(Estimate estimateObject) {
        EstimateObject = estimateObject;
    }

    public boolean isArchived() {
        return archived;
    }

    public void setArchived(boolean archived) {
        this.archived = archived;
    }

    public List<Tasks> getTasks() {
        return tasks;
    }

    public void setTasks(List<Tasks> tasks) {
        this.tasks = tasks;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getCostRate() {
        return costRate;
    }

    public void setCostRate(String costRate) {
        this.costRate = costRate;
    }

    public api.model.Project.TimeEstimate getTimeEstimate() {
        return TimeEstimate;
    }

    public void setTimeEstimate(api.model.Project.TimeEstimate timeEstimate) {
        TimeEstimate = timeEstimate;
    }

    public String getBudgetEstimate() {
        return budgetEstimate;
    }

    public void setBudgetEstimate(String budgetEstimate) {
        this.budgetEstimate = budgetEstimate;
    }

    public List<CustomField> getCustomFields() {
        return customFields;
    }

    public void setCustomFields(List<CustomField> customFields) {
        this.customFields = customFields;
    }

    public boolean isPublico() {
        return publico;
    }

    public void setPublico(boolean publico) {
        this.publico = publico;
    }

    public boolean isTemplate() {
        return template;
    }

    public void setTemplate(boolean template) {
        this.template = template;
    }

    public boolean isFavorite() {
        return favorite;
    }

    public void setFavorite(boolean favorite) {
        this.favorite = favorite;
    }


}
