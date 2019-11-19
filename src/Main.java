import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("Добро пожаловать в ЗОЖКино, перед тем как перейти дальше прошу введите логин");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String entry = bufferedReader.readLine();
            if (entry.equals("admin")) {
                System.out.println("Введите одну из предложенных команд: создание, обновление, удаление");
                adminControll();
                break;

            } else if (entry.equals("coach")) {

                break;
            } else if (entry.equals("user")) {

                break;
            } else {
                System.out.println("Неверный логин");
                System.out.println("Попробуйте ещё раз");
                continue;
            }


        }
        public static void adminControll() {
            String adminControl = bufferedReader.readLine();
            if ()
        }
    }

}
