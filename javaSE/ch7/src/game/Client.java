package game;

import game.player.Farmer;
import game.player.Lord;
import game.player.Player;
import game.poker.BigKing;
import game.poker.NormalPoker;
import game.poker.Poker;
import game.poker.SmallKing;
import game.system.AbstractGeneratePoker;
import game.system.GeneratePoker;

public class Client {

	public static void main(String[] args) {
		String[] player_names = {"杨白劳","周扒皮","小白菜"};

        Player[] players = Player.getPlayers(player_names);
		
		AbstractGeneratePoker agp = new GeneratePoker();
		agp.run(players); //发牌
		
		for (int i = 0; i < players.length; i++) {
            Player player = players[i];
            String role = player instanceof Lord ? "地主" : "农民";
			System.out.print(role + "：" + players[i].getNickName() + "的手牌：");
			print(players[i].getHands());
		}
	}
	private static void print(Poker[] arr2) {
		
		for (Poker poker : arr2) {//遍历arr2对象数组，数组的每个元素的类型为Poker，每个对象起名为poker
			if (poker instanceof BigKing) {
				BigKing k1 = (BigKing)poker;
				System.out.print(k1.getType() + " ");
			} else if (poker instanceof SmallKing) {
				SmallKing k2 = (SmallKing)poker;
				System.out.print(k2.getType() + " ");
			} else if (poker instanceof NormalPoker) {
				NormalPoker normal = (NormalPoker)poker;
				System.out.print(poker.getPoint() + normal.getShape() + " ");
			}
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println();
	}

}
