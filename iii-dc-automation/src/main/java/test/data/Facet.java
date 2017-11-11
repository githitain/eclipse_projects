package test.data;

public enum Facet {
    AVAILABILITY("Availability", false),
    SEARCH_FOUND_IN("Search Found In", false),
    FORMAT("Format", true),
    COLLECTION("Collection", true),
    LOCATION("Location", true),
    LANGUAGE("Language", true),
    PLACE("Place", true),
    PUBLISH_DATE("Publish Date", false);
    
    private String name;
    private boolean hasMore;

    Facet(String name, boolean hasMore) {
        this.name = name;
        this.hasMore = hasMore;
    }
    
    public String getName() {
        return name;
    }

    public boolean hasMore() {
        return hasMore;
    }
}
