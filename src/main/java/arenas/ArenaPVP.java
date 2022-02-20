package arenas;

import players.Player;

public class ArenaPVP implements Arena{
    public Player player_1;
    public Player player_2;

    public ArenaPVP(Player player_1, Player player_2){
        this.player_1 = player_1;
        this.player_2 = player_2;
    }

    public Player getPlayer_1() {
        return player_1;
    }

    public Player getPlayer_2() {
        return player_2;
    }

}
