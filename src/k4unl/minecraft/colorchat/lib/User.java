package k4unl.minecraft.colorchat.lib;


public class User {
	private SpecialChars userColor;
	private String nick;
	private String realUserName;
	private boolean hasNick;
	private Group group;
	
	public User(String _username, SpecialChars _userColor, String _nick){
		realUserName = _username;
		userColor = _userColor;
		nick = _nick;
	}
	
	public User(String _username) {
		realUserName = _username;
		userColor = SpecialChars.getRandom();
	}

	public String getUserName() {
		return realUserName;
	}
	
	public String getNick(){
		return nick;
	}
	
	public SpecialChars getColor(){
		return userColor;
	}
	
	public void setNick(String newNick){
		nick = newNick;
		hasNick = true;
	}
	
	public void resetNick(){
		hasNick = false;
	}
	
	public void setUserColor(SpecialChars newColor){
		userColor = newColor;
	}

	public boolean hasNick() {
		return hasNick;
	}
	
	public Group getGroup(){
		return group;
	}
	public void setGroup(Group newGroup){
		group = newGroup;
	}
}
