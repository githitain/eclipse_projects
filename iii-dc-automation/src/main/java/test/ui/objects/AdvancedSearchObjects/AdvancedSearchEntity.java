package test.ui.objects.AdvancedSearchObjects;


public class AdvancedSearchEntity extends AdvancedSearchFirstEntity{
    public AdvancedSearchBoolean booleanValue;

    public AdvancedSearchEntity(AdvancedSearchBoolean bool, AdvancedSearchFilter filter, String searchForValue){
        super(filter,searchForValue);
        booleanValue = bool;
    }

    public enum AdvancedSearchFilter{
        Keyword("Keyword"),
        Title("Title"),
        Subject("Subject"),
        Author("Author");

        private String name;

        private AdvancedSearchFilter(String valueName){
            name = valueName;
        }

        @Override
        public String toString(){
            return name;
        }
    }

    public enum AdvancedSearchBoolean{
        AND,OR,NOT
    }
}

