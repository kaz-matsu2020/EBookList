package model;

public class PreventXSSLogic {
	public String preventXSS(String text) {
	    return text.replaceAll("&", "&amp;")
                .replaceAll("<", "&lt;")
                .replaceAll(">", "&gt;")
                .replaceAll("\"", "&quot;")
                .replaceAll("'", "&#x27;");
	}
}
