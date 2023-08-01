package co.san.pokemon.service;

import lombok.Data;

@Data
public class PokemonVO {
	private int pokemonNo;
	private String pokemonName;
	private String pokemonType;

	@Override
	public String toString() {
		System.out.print("도감번호: " + pokemonNo);
		System.out.print(", 포켓몬이름: " + pokemonName);
		System.out.println(", 타입: " + pokemonType);
		return null;
	}

}
