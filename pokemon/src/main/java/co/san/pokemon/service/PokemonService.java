package co.san.pokemon.service;

import java.util.List;

public interface PokemonService {

	List<PlayerVO> playerList();

	int signUp(PlayerVO vo);

	String showInfo(PlayerVO vo);

	PlayerVO signIn(PlayerVO vo);
	
	PlayerVO wildPokemon(PlayerVO vo);
	
	int save(PlayerVO vo);
}
