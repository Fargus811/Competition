public class RunTests {
    public static void main(String[] args) {
        CoachRepositoryTest coachRepositoryTest = new CoachRepositoryTest();
        try {
            coachRepositoryTest.buildCoach();
        } catch (Exception e) {
            System.err.println("Неправильные значения");
        }

        LoginCommandTest loginCommandTest = new LoginCommandTest();
        try {
            loginCommandTest.loginWithFakeAccount();
        } catch (Exception e) {
            System.err.println("Неверный логин или пароль");
        }

        ShowAdminActionCommandTest showAdminActionCommandTest = new ShowAdminActionCommandTest();
        try {
            showAdminActionCommandTest.processTestWithUnexpectedCase();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
