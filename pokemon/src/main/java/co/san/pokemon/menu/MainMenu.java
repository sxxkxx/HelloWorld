package co.san.pokemon.menu;

import java.util.List;
import java.util.Scanner;

import co.san.pokemon.service.PlayerVO;
import co.san.pokemon.service.PokemonService;
import co.san.pokemon.serviceImpl.PokemonServiceImpl;

public class MainMenu {
	private Scanner sc = new Scanner(System.in);
	PokemonService ps = new PokemonServiceImpl();

	private void mainTitle() {
		System.out.println("===== 포켓몬스터 =====");
		System.out.println("==== 1.신규 생성 ====");
		System.out.println("==== 2.이어 하기 ====");
		System.out.println("==== 3.종료 ========");
		System.out.println("===== 메뉴 선택 =====");
	}

	private void ingameTitle(PlayerVO user) {
		System.out.println("===== " + user.getName() + " =====");
		System.out.println("==== 1.내 정보 =====");
		System.out.println("==== 2.모험 출발 ====");
		System.out.println("==== 3.포켓몬센터 ====");
		System.out.println("==== 4.메인 메뉴 ====");
		System.out.println("==== 5.로그 아웃 ====");
		System.out.println("===== 메뉴 선택 =====");
	}

	private void huntMenu() {
		System.out.println("===== 모험 출발 =====");
		System.out.println("==== 1.야생 포켓몬 ===");
		System.out.println("==== 2.체육관 도전 ===");
		System.out.println("==== 3.마을 귀환 ====");
		System.out.println("===== 메뉴 선택 =====");
	}

	private void battleMenu() {
		System.out.println("===== 전투 시작 =====");
		System.out.println("==== 1.공격 ========");
		System.out.println("==== 2.? ===");
		System.out.println("==== 3.도망 치기  ====");
		System.out.println("===== 메뉴 선택 =====");
	}

	public void run() {
		boolean b = false;
		do {
			mainTitle();
			System.out.print("메뉴를 선택하세요>> ");
			int key = Integer.parseInt(sc.nextLine());
			switch (key) {
			case 1:
				signUp();
				break;
			case 2:
				playerList();
				signIn();
				break;
			case 3:
				System.out.println("===== 게임 종료 =====");
				b = true;
				break;
			}

		} while (!b);
		sc.close();
	}

	public void signUp() {

		System.out.print("이름 입력 >> ");
		String name = sc.nextLine();
		System.out.println("포켓몬 선택");
		System.out.println("1: 이상해씨, 2: 파이리, 3: 꼬부기");
		int select = Integer.parseInt(sc.nextLine());
		String pokemon = "";
		String type = "";
		if (select == 1) {
			pokemon = "이상해씨";
			type = "풀";
		} else if (select == 2) {
			pokemon = "파이리";
			type = "불";
		} else if (select == 3) {
			pokemon = "꼬부기";
			type = "물";
		}
		PlayerVO vo = new PlayerVO();
		vo.setName(name);
		vo.setPokemonName(pokemon);
		vo.setPokemonType(type);

		if (ps.signUp(vo) != 0) {
			System.out.println("생성 완료");

		} else {
			System.out.println("생성 실패");
		}
	}

	public void playerList() {
		List<PlayerVO> playerList = ps.playerList();
		if (!playerList.isEmpty()) {
			for (PlayerVO player : playerList) {
				player.toString();
			}
		} else {
			System.out.println("플레이어가 존재하지 않음");
		}
	}

	public void signIn() {
		System.out.print("이름 입력 >> ");
		String name = sc.nextLine();
		PlayerVO vo;
		vo = new PlayerVO();
		vo.setName(name);
		PlayerVO user = ps.signIn(vo);
		if (user.getPokemonName() != null) {
			user.loginSuccess();
			ingame(user);
		} else {
			System.out.println("없는 이름");
		}
	}

	public void ingame(PlayerVO user) {
		boolean stop = false;
		do {
			ingameTitle(user);
			System.out.print("메뉴를 선택하세요>> ");
			int key = Integer.parseInt(sc.nextLine());
			switch (key) {
			case 1:
				ps.showInfo(user);
				break;
			case 2:
				hunt(user);
				break;
			case 3:
				break;
			case 4:
				break;
			case 5:
				System.out.println("===== 로그 아웃 =====");
				stop = true;
				break;
			}

		} while (!stop);
	}

	public void hunt(PlayerVO user) {
		boolean b = false;
		do {
			huntMenu();
			System.out.print("메뉴를 선택하세요>> ");
			int key = Integer.parseInt(sc.nextLine());
			switch (key) {
			case 1:
				PlayerVO enemy = ps.wildPokemon(user);
				enemy.wildHi();
				battle(user, enemy);
				break;
			case 2:

				break;
			case 3:
				System.out.println("===== 마을로 =====");
				b = true;
				break;
			}

		} while (!b);
	}

	public void wildPokemon(PlayerVO user) {
		PlayerVO wildPokemon = ps.wildPokemon(user);
		wildPokemon.wildHi();
	}

	public void battle(PlayerVO user, PlayerVO enemy) {
		boolean b = false;
		while (!b) {
			battleMenu();
			System.out.print("메뉴를 선택하세요>> ");
			int key = Integer.parseInt(sc.nextLine());
			switch (key) {
			case 1:
				attack1(user, enemy);
				if (enemy.getPokemonHP() < 1) {
					b = true;
					System.out.println(enemy.getName() + "의 " + enemy.getPokemonName() + "(이)가 쓰러졌다.");
					win(user, enemy);
				} else {
					attack2(user, enemy);
				}
				if (user.getPokemonHP() < 1) {
					b = true;
					System.out.println(user.getName() + "의 " + user.getPokemonName() + "(이)가 쓰러졌다.");
				}
				break;
			case 2:

				break;
			case 3:
				System.out.println("===== 도망 성공 =====");
				b = true;
				break;
			}
		}
	}

	public void attack1(PlayerVO user, PlayerVO enemy) {
		System.out.println();
		user.attack1();
		enemy.setPokemonHP(
				enemy.getPokemonHP() - (user.getPokemonATT() - (int) Math.round(enemy.getPokemonDEF() * 0.8)));
		System.out.println(user.getPokemonName() + "의 체력 " + user.getPokemonHP() + "/" + user.getPokemonMaxHP());
		System.out.println(enemy.getPokemonName() + "의 체력 " + enemy.getPokemonHP() + "/" + enemy.getPokemonMaxHP());
		System.out.println();
	}

	public void attack2(PlayerVO user, PlayerVO enemy) {
		System.out.println();
		enemy.attack2();
		user.setPokemonHP(user.getPokemonHP() - (enemy.getPokemonATT() - (int) Math.round(user.getPokemonDEF() * 0.8)));
		System.out.println(user.getPokemonName() + "의 체력 " + user.getPokemonHP() + "/" + user.getPokemonMaxHP());
		System.out.println(enemy.getPokemonName() + "의 체력 " + enemy.getPokemonHP() + "/" + enemy.getPokemonMaxHP());
		System.out.println();
	}

	public void win(PlayerVO user, PlayerVO enemy) {
		user.setPokemonEXP(user.getPokemonEXP() + enemy.getPokemonEXP());
		System.out.println(user.getPokemonName() + "의 경험치가 " + enemy.getPokemonEXP() + " 올랐다!");
		System.out.println(user.getPokemonName() + "의 경험치 " + user.getPokemonEXP() + "/" + user.getPokemonMaxEXP());
		LvUp(user);
		user.setGold(user.getGold() + enemy.getGold());
		System.out.println(enemy.getGold() + " 골드 획득!");
		System.out.println("보유금액: " + user.getGold());
	}

	public void LvUp(PlayerVO user) {
		if (user.getPokemonEXP() >= user.getPokemonMaxEXP()) {
			user.setPokemonEXP(user.getPokemonEXP() - user.getPokemonMaxEXP());
			user.setPokemonLV(user.getPokemonLV() + 1);
			user.setPokemonMaxEXP(user.getPokemonMaxEXP() + 10);
			user.setPokemonATT(user.getPokemonATT() + 10);
			user.setPokemonDEF(user.getPokemonDEF() + 10);
			user.setPokemonMaxHP(user.getPokemonMaxHP() + 10);
			user.setPokemonHP(user.getPokemonMaxHP());
			System.out.println("레벨업!!");
		}
	}

}
