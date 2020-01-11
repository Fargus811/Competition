package ui.command;

import java.util.List;

public class ExitCommand implements Command {

    @Override
    public String getInstruction() {
        return null;
    }

    @Override
    public int getParamsNumber() {
        return 0;
    }

    @Override
    public String[] getParamInstructions() {
        return new String[0];
    }

    @Override
    public CommandResult process(List<String> params) {
        return new CommandResult(null, null);
    }

    public static void main(String[] args) {
        Thread t = new Thread1();
        t.start();


        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("33333");
            }
        });
        t2.start();
    }

    static class Thread1 extends Thread{

        @Override
        public void run() {
            System.out.println("asasas");
        }

    }

    static class Thread2 implements Runnable{

        @Override
        public void run() {
            System.out.println("222222");
        }
    }


}
