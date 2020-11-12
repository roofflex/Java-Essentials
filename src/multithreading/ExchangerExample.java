package multithreading;

import java.util.List;
import java.util.concurrent.Exchanger;

public class ExchangerExample {

    // Exchanger is used when there's a need to exchange data between 2 threads at the same time
    // .exchange(arg) -  arg is the data that we want to send to the second thread,
    // returns the  data that was sent by second thread
    // .exchange() BLOCKS current thread until other thread invokes .exchange() method,
    // so they exchange the data AT EXACTLY THE SAME TIME
    public static void main(String[] args) throws InterruptedException {
        Exchanger<Action> exchanger = new Exchanger<>();
        List<Action> player1Actions = List.of(Action.ROCK, Action.SCISSORS, Action.PAPER);
        List<Action> player2Actions = List.of(Action.PAPER, Action.ROCK, Action.ROCK);
        Player player1 = new Player("Max", player1Actions, exchanger);
        Player player2 = new Player("Misha", player2Actions, exchanger);
        player1.start();
        player2.start();
        player1.join();
        player2.join();
        System.out.println("Game ends!");
    }
}


enum Action{
    ROCK, PAPER, SCISSORS
}

class Player extends Thread{
    private String name;
    private List<Action> actions;
    private Exchanger<Action> exchanger;

    public Player(String name, List<Action> actions, Exchanger<Action> exchanger) {
        this.name = name;
        this.actions = actions;
        this.exchanger = exchanger;
    }

    private void selectWinner(Action myAction, Action rivalAction){
        if((myAction == Action.ROCK && rivalAction == Action.SCISSORS) ||
            (myAction == Action.PAPER && rivalAction == Action.ROCK) || (myAction == Action.SCISSORS && rivalAction == Action.PAPER)){
            System.out.println(name + " WINS!!!");
        }
    }

    @Override
    public void run() {
        Action reply;
        for(Action action : actions){
            try {
                // this will block current thread until second thread also invokes .exchange()
                reply = exchanger.exchange(action);
                selectWinner(action, reply);
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}