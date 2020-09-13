package generics.game;

public class Test {
    public static void main(String[] args) {
        Schoolboy schoolboy1 = new Schoolboy("Ivan", 13);
        Schoolboy schoolboy2 = new Schoolboy("Artem", 15);

        Student student1 = new Student("Vasya", 19);
        Student student2 = new Student("Sasha", 21);

        Team<Schoolboy> schoolboyTeam = new Team<>("Dragons");
        schoolboyTeam.addNewParticipant(schoolboy1);
        schoolboyTeam.addNewParticipant(schoolboy2);

        Team<Student> studentTeam = new Team<>("Wolwerines");
        studentTeam.addNewParticipant(student1);
        studentTeam.addNewParticipant(student2);

        System.out.println(studentTeam.playWith(schoolboyTeam));

    }
}
