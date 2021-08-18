import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class Plan {
    private Integer taskId;
    private LocalDate startDate;
    private LocalDate endDate;
    public Plan(Integer taskId, LocalDate startDate, LocalDate endDate) {
        this.taskId = taskId;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Integer getTaskId() {
        return taskId;
    }

    public void setTaskId(Integer taskId) {
        this.taskId = taskId;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }
    // getter and setter
    public List<LocalDate> getStartAndEndDate(){

        return Arrays.asList(this.getStartDate(), this.getEndDate());
    }

    @Override
    public int hashCode() {
        final int totaldays = 31;
        int x = 1;
        x = totaldays * x + ((endDate == null) ? 0 : endDate.hashCode());
       x = totaldays * x + ((startDate == null) ? 0 : startDate.hashCode());
        x = totaldays * x + ((taskId == null) ? 0 : taskId.hashCode());
        return x;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Plan other = (Plan) obj;
        if (endDate == null) {
            if (other.endDate != null)
                return false;
        }
        else if (!endDate.equals(other.endDate))
            return false;
        if (startDate == null) {
            if (other.startDate != null)
                return false;
        }
        else if (!startDate.equals(other.startDate))
            return false;
        if (taskId == null) {
            if (other.taskId != null)
                return false;
        }
        else if (!taskId.equals(other.taskId))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return taskId +"\t"+ startDate+"\t" + endDate+"\n" ;
    }
}


