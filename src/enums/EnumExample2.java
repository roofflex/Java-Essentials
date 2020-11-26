package enums;

public class EnumExample2 {
    public static void main(String[] args) {
        WeekDaysWithMood w = WeekDaysWithMood.MONDAY;
        infoOfToday(w);
    }

    public static void infoOfToday(WeekDaysWithMood weekDay){
        switch (weekDay){
            case MONDAY:
            case TUESDAY:
            case WEDNESDAY:
            case THURSDAY:
            case FRIDAY:
                System.out.println("Time to work today!");
                break;
            case SATURDAY:
            case SUNDAY:
                System.out.println("Have a rest!");
                break;
        }
        System.out.println("Today i have " + weekDay.getMood());
    }
}

enum WeekDaysWithMood{
    MONDAY("Bad mood"),
    TUESDAY("Anxious mood"),
    WEDNESDAY("Helpful mood"),
    THURSDAY("Anxious mood"),
    FRIDAY("Great mood"),
    SATURDAY("Lazy mood"),
    SUNDAY("Great mood");

    private String mood;

    private WeekDaysWithMood(String mood){
        this.mood = mood;
    }

    public String getMood() {
        return mood;
    }
}
