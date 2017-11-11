package main.flags;

import main.utils.LogStatuses;
import main.utils.Logger;

public enum Flags {

	    BUFFER_LOCKED(false);
	
	    private volatile boolean value;
	
	    Flags(Boolean value) {
	        this.value = value;
	    }
	
	    public Boolean getValue() {
	        return value;
	    }
	
	    public void setValue(Boolean value) {
	        Logger.write(LogStatuses.INFO, String.format("Set flag %s value %s", name(), value.toString().toUpperCase()));
	        this.value = value;
	    }
}