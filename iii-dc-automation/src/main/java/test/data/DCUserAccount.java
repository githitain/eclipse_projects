package test.data;


import main.data.Patron;

public class DCUserAccount extends Patron
{
    private String homeLibrary;
    private String aliasNickname;
    private String emailAddress;

    public DCUserAccount setHomeLibrary(String homeLibrary) 
    {
        this.homeLibrary = homeLibrary;
        return this;
    }

    public DCUserAccount setAliasNickname(String aliasNickname) 
    {
        this.aliasNickname = aliasNickname;
        return this;
    }

    public DCUserAccount setEmailAddress(String emailAddress) 
    {
        this.emailAddress = emailAddress;
        return this;
    }

    public String getHomeLibrary() 
    {
        return homeLibrary;
    }

    public String getAliasNickname() {
        return aliasNickname;
    }
}
