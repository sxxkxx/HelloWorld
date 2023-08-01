package co.san.pokemon.service;

import lombok.Data;

@Data
public class PlayerVO {
	private String name;
	private String pokemonName;
	private int pokemonLV;
	private int playerLV;
	private String pokemonType;
	private int pokemonATT;
	private int pokemonDEF;
	private int pokemonHP;
	private int pokemonMaxHP;
	private int pokemonEXP;
	private int pokemonMaxEXP;
	private int gold;

	@Override
	public String toString() {
		System.out.println(
				"플레이어 이름: " + name + " , 플레이어 레벨: " + playerLV + ", 포켓몬 이름: " + pokemonName + ", 포켓몬 레벨: " + pokemonLV);

		return null;
	}

	public String toString2() {
		System.out.println("유저 이름: " + name + " ,유저 레벨: " + playerLV);
		System.out.println("보유금액: " + gold + " 골드");
		System.out.println("포켓몬 이름: " + pokemonName);
		System.out.println("레벨: " + pokemonLV + ", " + pokemonType + "타입");
		System.out.println("공격력: " + pokemonATT + ", 방어력: " + pokemonDEF);
		System.out.println("포켓몬 HP: " + pokemonHP + "/" + pokemonMaxHP);
		System.out.println("포켓몬 경험치: " + pokemonEXP + "/" + pokemonMaxEXP);

		return null;
	}

	public String loginSuccess() {
		System.out.println(name + "님 환영합니다.");

		return null;

	}

	public String wildHi() {
		System.out.println("앗! " + name + "의 " + pokemonName + "(이)가 나타났다.");
		return null;
	}

	public String attack1() {

		System.out.println("⣴⣶⣶⣶⣾⣿⣿⣿⣿⣆");
		System.out.println("⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿");
		System.out.println("    ⠈⠻⠿⠿⠿⠋");
		System.out.println(pokemonName + "의 공격");
		return null;

	}

	public String attack2() {

		System.out.println("⣰⣿⣿⣿⣿⣷⣶⣶⣶⣦");
		System.out.println("⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿");
		System.out.println("⠙⠿⠿⠿⠟⠁⠀⠀⠀⠀");
		System.out.println(pokemonName + "의 공격");
		return null;

	}
}
