package k4unl.minecraft.colorchat.lib;

import k4unl.minecraft.colorchat.commands.CommandColor;
import k4unl.minecraft.colorchat.lib.config.CCConfig;
import k4unl.minecraft.k4lib.lib.SpecialChars;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.server.MinecraftServer;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class User {

	private SpecialChars userColor;
	private String       nick;
	private String       realUserName;
	private boolean      hasNick;
	private Group        group;
	private EntityPlayer playerEntity;

	public User(String _username, SpecialChars _userColor, String _nick) {

		realUserName = _username;
		userColor = _userColor;
		nick = _nick;
	}

	public User(String _username) {

		realUserName = _username;
		List<String> keysAsArray = new ArrayList<String>(CommandColor.colors.keySet());
        String newClr = keysAsArray.get(new Random().nextInt(keysAsArray.size()));
        while(CCConfig.INSTANCE.isColorBlackListed(newClr)){
            newClr = keysAsArray.get(new Random().nextInt(keysAsArray.size()));
        }

        userColor = CommandColor.colors.get(newClr);
	}

	public String getUserName() {
		return realUserName;
	}
	
	public String getNick(){
        if(hasNick){
		    return nick;
        }else{
            return realUserName;
        }
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

	public EntityPlayer getPlayerEntity() {
		if(playerEntity == null) {
			for (EntityPlayer player : (List<EntityPlayer>) MinecraftServer.getServer().getEntityWorld().playerEntities) {
				if (player.getGameProfile().getName().equals(this.getUserName())) {
					playerEntity = player;
					return player;
				}
			}
		}else{
			return playerEntity;
		}
		return null;
	}

	public void updateDisplayName() {
		if(CCConfig.INSTANCE.getBool("changeDisplayName")) {
			getPlayerEntity().refreshDisplayName();
		}
	}
}
