

import java.time.LocalDate;
import java.util.Comparator;

public class Datemerger {


    private LocalDate startDate;

    private LocalDate endDate;

    public Datemerger(LocalDate startDate, LocalDate endDate) {
        this.startDate = startDate;
        this.endDate = endDate;
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

    public static final Comparator<Datemerger> START_DATE_COMPARATOR = (Datemerger o1, Datemerger o2) -> {
        if (o1.getStartDate() != null && o2.getStartDate() != null) {
            if (o1.getStartDate().isBefore(o2.getStartDate())) {
                return -1;
            }
            else {
                return o1.getStartDate().isAfter(o2.getStartDate()) ? 1 : 0;
            }
        }
        else if (o1.getStartDate() != null && o2.getStartDate() == null) {
            return -1;
        }
        else if (o1.getStartDate() == null && o2.getStartDate() != null) {
            return 1;
        }
        else {
            return 0;
        }
    };

    @Override
    public int hashCode() {
        final int totaldays = 31;
        int x = 1;
        x = totaldays * x + ((endDate == null) ? 0 : endDate.hashCode());
        x = totaldays * x + ((startDate == null) ? 0 : startDate.hashCode());
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
        Datemerger other = (Datemerger) obj;
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
        return true;
    }
}
