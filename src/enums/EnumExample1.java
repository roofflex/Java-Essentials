package enums;

public class EnumExample1 {

    WeekDays weekDay;

    public EnumExample1(WeekDays weekDay) {
        this.weekDay = weekDay;
    }

    public static void main(String[] args) {
        EnumExample1 example1 = new EnumExample1(WeekDays.MONDAY);
        System.out.println(example1.weekDay);
        tasksToday(example1.weekDay);
    }

    public static void tasksToday(WeekDays weekDay){
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
    }
}

enum WeekDays{
    MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY;
}
