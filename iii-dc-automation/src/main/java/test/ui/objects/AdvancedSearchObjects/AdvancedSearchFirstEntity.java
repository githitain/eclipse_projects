package test.ui.objects.AdvancedSearchObjects;

public class AdvancedSearchFirstEntity{
    public AdvancedSearchEntity.AdvancedSearchFilter searchFilter;
    public String searchValue;

    public AdvancedSearchFirstEntity(AdvancedSearchEntity.AdvancedSearchFilter filter, String searchForValue){
        searchFilter = filter;
        searchValue = searchForValue;
    }
}
