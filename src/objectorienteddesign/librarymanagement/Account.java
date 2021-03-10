package objectorienteddesign.librarymanagement;

public abstract class Account {
    private String id;
    private String password;
    private MyLibrary.AccountStatus status;
    private Person person;

    public boolean resetPassword() {
        return false;
    }
}