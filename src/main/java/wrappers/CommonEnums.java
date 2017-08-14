package wrappers;


public class CommonEnums {

	 public static enum PageState
	    {
	        Open(true),
	        Close(false);
	    	
	    	private Boolean state;       
	        private PageState(Boolean s) {
	        	state = s;
	        }
	        public Boolean toState() {
	        	return state;
	        }
	    }
	 
	 public static enum CheckedState
	    {
	        Checked(true),
	        Unchecked(false);
	    	
	    	private Boolean state;       
	        private CheckedState(Boolean s) {
	        	state = s;
	        }
	        public Boolean toState() {
	        	return state;
	        }
	    }
	 
	 public static enum EnabledState
	    {
	        Enabled(true),
	        Disabled(false);
	    	
	    	private Boolean state;       
	        private EnabledState(Boolean s) {
	        	state = s;
	        }
	        public Boolean toState() {
	        	return state;
	        }
	    }
}
