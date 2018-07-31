package FarmBank;


public class Account extends FarmBank {

    private String username;
    private String name;
    private String surname;
    private String password;
    private String password_again;
    private String listoflocations;

    public Account() {

    }

    public Account(String username, String name, String surname, String password, String password_again, String listoflocations) {

        this.username = username;
        this.name = name;
        this.surname = surname;
        this.password = password;
        this.password_again = password_again;
        this.listoflocations = listoflocations;
    }



    public String getUsername() {

        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {

        return surname;
    }

    public String toString() {
        return (username + "\n" + name + "\n" + surname + "\n" + password + "\n" + password_again + "\n" + listoflocations);
    }

    public String getListoflocations() {

        return listoflocations;
    }





}


