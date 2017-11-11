package test.data;

import main.data.Patron;

public enum EncoreUserAccounts 
{
    Default(new EncoreUserAccount().setHomeLibrary("Bellevue Teen Fiction").setAliasNickname("autotester")
            .setName("epam_autotester").setBarcode("9078563412").setPin("12345").setEmail("autotester@iii.com")
            .setAddress("100 Test St").setCity("Tucson").setState("AZ").setZipCode("65502")),

    SecondTestUser(new EncoreUserAccount().setHomeLibrary("Bellevue Teen Fiction").setAliasNickname("autotester")
            .setName("epam_autotester2").setBarcode("9078563413").setPin("12345").setEmail("autotester2@iii.com")
            .setAddress("100 Test St").setCity("Tucson").setState("AZ").setZipCode("65502"));

    private EncoreUserAccount encoreUserAccount;

    EncoreUserAccounts(Patron patron) {
        encoreUserAccount = (EncoreUserAccount) patron;
    }

    public String getName() {
        return encoreUserAccount.getName();
    }

    public EncoreUserAccount getUser() {
        return encoreUserAccount;
    }
}
