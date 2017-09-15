package objectRepository;

public class CaptureObjects {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RepositoryGenerator ebayHomeGen = new RepositoryGenerator("http://www.ebay.com", "home.repository");
		ebayHomeGen.buildNewRepository();
		RepositoryGenerator ebayHelpGen = new RepositoryGenerator("http://ocsnext.ebay.com/ocs/home?", "help.repository");
		ebayHelpGen.buildNewRepository();
	}

}
