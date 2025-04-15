public class App {
    public static void main(String[] args) throws Exception {
        Admin.addUser("Derrick", "usry", "dmu1007", "carder93", 12345);
        Admin.addUser("User", "one", "one1007", "carder93", 12346);
        Admin.addUser("User", "two", "two1007", "carder93", 12347);
        Admin.printUsers();

        System.out.println();

        User i = Admin.searchName("user", "two");
        Admin.displayUserInfo(i.getAccessNum());
        System.out.println();

        Admin.removeUser(i.getAccessNum());
        Admin.printUsers();
    }
}
