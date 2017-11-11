package main.data;

public enum ItemStatus 
{
    AVAILABLE ("AVAILABLE"),
    MISSING("MISSING"),
    MISSINGPLUS12("MISSINGPLUS12"),
    BILLED("BILLED"),
    IN_TRANSIT("IN TRANSIT"),
    WORKROOM("WORKROOM"),
    PROBLEM_SHELF("PROBLEM_SHELF"),
    WEEDING("WEEDING"),
    l("l"),
    STORAGE("STORAGE");

    private String name;

    ItemStatus(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return getName();
    }
}
