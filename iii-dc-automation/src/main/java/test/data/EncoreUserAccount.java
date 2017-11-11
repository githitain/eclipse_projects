package test.data;


import main.data.Patron;

public class EncoreUserAccount extends Patron{
    private String homeLibrary;
    private String aliasNickname;
    private String emailAddress;

    public EncoreUserAccount setHomeLibrary(String homeLibrary) 
    {
        this.homeLibrary = homeLibrary;
        return this;
    }

    public EncoreUserAccount setAliasNickname(String aliasNickname) {
        this.aliasNickname = aliasNickname;
        return this;
    }

    public EncoreUserAccount setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
        return this;
    }

    public String getHomeLibrary() {
        return homeLibrary;
    }

    public String getAliasNickname() {
        return aliasNickname;
    }
}
