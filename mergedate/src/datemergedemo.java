import java.time.LocalDate;
import java.util.*;

public class datemergedemo {
    public static void main(String[] args) throws Exception {
        List<Datemerger> dateRanges = new ArrayList<>();
        dateRanges.add(new Datemerger(LocalDate.of(2019, 1, 1), LocalDate.of(2019, 1, 30)));
        dateRanges.add(new Datemerger(LocalDate.of(2019, 1, 15), LocalDate.of(2019, 2, 15)));
        dateRanges.add(new Datemerger(LocalDate.of(2019, 3, 10), LocalDate.of(2019, 4, 15)));
        dateRanges.add(new Datemerger(LocalDate.of(2019, 4, 10), LocalDate.of(2019, 5, 15)));

        System.out.println("INPUT\nSTART DATE   END DATE");
        dateRanges.stream().forEach(dateRange -> System.out.println(dateRange.getStartDate() + "    " + dateRange.getEndDate()));

        List<Datemerger> mergedDateRange = mergeDateRange(dateRanges);

        System.out.println("OUTPUT\nSTART DATE   END DATE");
        mergedDateRange.stream().forEach(dateRange -> System.out.println(dateRange.getStartDate() + "   " + dateRange.getEndDate()));
    }


    private static List<Datemerger> mergeDateRange(List<Datemerger> dateRanges) {
        Set<Datemerger> mergedDateRangeSet = new HashSet<>();
        Collections.sort(dateRanges, Datemerger.START_DATE_COMPARATOR);

        mergedDateRangeSet.add(dateRanges.get(0));
        for (int i = 1; i < dateRanges.size(); i++) {
            Datemerger current = dateRanges.get(i);
            List<Datemerger> toBeAdded = new ArrayList<>();
            Boolean flag = false;
            for (Datemerger mergedRange : mergedDateRangeSet) {
                Datemerger merged = checkRepetition(mergedRange, current);
                if (merged == null) {
                    toBeAdded.add(current);
                }
                else {
                    mergedRange.setEndDate(merged.getEndDate());
                    mergedRange.setStartDate(merged.getStartDate());
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                mergedDateRangeSet.addAll(toBeAdded);
            }
            toBeAdded.clear();
        }
        List<Datemerger> mergedDateRangeList = new ArrayList<>(mergedDateRangeSet);
        Collections.sort(mergedDateRangeList, Datemerger.START_DATE_COMPARATOR);
        return mergedDateRangeList;
    }


    private static Datemerger checkRepetition(Datemerger mergedRange, Datemerger now) {
        if (mergedRange.getStartDate().isAfter(now.getEndDate()) || mergedRange.getEndDate().isBefore(now.getStartDate())) {
            return null;
        }
        else {
            return new Datemerger(mergedRange.getStartDate().isBefore(now.getStartDate()) ? mergedRange.getStartDate() : now.getStartDate(),
                    mergedRange.getEndDate().isAfter(now.getEndDate()) ? mergedRange.getEndDate() : now.getEndDate());
        }
    }
}
