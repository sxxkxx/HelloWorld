package co.san.pokemon.serviceImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.san.pokemon.common.DataSource;
import co.san.pokemon.service.PlayerVO;
import co.san.pokemon.service.PokemonService;

public class PokemonServiceImpl implements PokemonService {

	private DataSource dao = DataSource.getInstance();
	private Connection connection;
	private PreparedStatement preparedStatement;
	private ResultSet resultSet;

	private void close() {
		try {
			if (resultSet != null)
				resultSet.close();
			if (preparedStatement != null)
				preparedStatement.close();
			if (connection != null)
				connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<PlayerVO> playerList() {
		String sql = "SELECT * FROM PLAYER";
		List<PlayerVO> playerList = new ArrayList();
		PlayerVO vo;
		connection = dao.getConnection();
		try {
			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				vo = new PlayerVO();
				vo.setName(resultSet.getString("player_name"));
				vo.setPlayerLV(resultSet.getInt("player_lv"));
				vo.setPokemonName(resultSet.getString("pokemon_name"));
				vo.setPokemonLV(resultSet.getInt("pokemon_lv"));
				playerList.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return playerList;
	}

	@Override
	public int signUp(PlayerVO vo) {
		String sql = "INSERT INTO PLAYER(player_name,pokemon_name,pokemon_type) VALUES(?,?,?)";
		int n = 0;
		connection = dao.getConnection();

		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, vo.getName());
			preparedStatement.setString(2, vo.getPokemonName());
			preparedStatement.setString(3, vo.getPokemonType());
			n = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return n;
	}

//	@Override
//	public int selectPokemon(PlayerVO vo) {
//		String sql = "UPDATE PLAYER SET POKEMON_TYPE = (SELECT  FROM POKEMON WHERE POKEMON_NAME = ?) WHERE PLAYER_NAME =?";
//		int n = 0;
//		connection = dao.getConnection();
//		try {
//			preparedStatement = connection.prepareStatement(sql);
//			preparedStatement.setString(1, vo.getPokemonName());
//			preparedStatement.setString(2, vo.getName());
//			n = preparedStatement.executeUpdate();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return n;
//	}

	@Override
	public PlayerVO signIn(PlayerVO vo) {
		String sql = "SELECT * FROM PLAYER WHERE PLAYER_NAME = ?";

		try {
			connection = dao.getConnection();
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, vo.getName());
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				vo = new PlayerVO();
				vo.setName(resultSet.getString("player_name"));
				vo.setPlayerLV(resultSet.getInt("player_lv"));
				vo.setPokemonName(resultSet.getString("pokemon_name"));
				vo.setPokemonLV(resultSet.getInt("pokemon_lv"));
				vo.setPokemonType(resultSet.getString("pokemon_type"));
				vo.setPokemonATT(resultSet.getInt("pokemon_att"));
				vo.setPokemonDEF(resultSet.getInt("pokemon_def"));
				vo.setPokemonHP(resultSet.getInt("pokemon_hp"));
				vo.setPokemonMaxHP(resultSet.getInt("pokemon_maxhp"));
				vo.setPokemonEXP(resultSet.getInt("pokemon_exp"));
				vo.setPokemonMaxEXP(resultSet.getInt("pokemon_maxexp"));
			}

		} catch (

		SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return vo;
	}

	public String showInfo(PlayerVO user) {
		user.toString2();
		return null;
	}

	public PlayerVO wildPokemon(PlayerVO user) {
		PlayerVO wildPokemon = new PlayerVO();
		String sql = "SELECT * FROM POKEMON WHERE POKEMON_NO = ?";
		String pokemonName = "";
		try {
			connection = dao.getConnection();
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, 16);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {

				wildPokemon = new PlayerVO();
				wildPokemon.setName("야생");
				wildPokemon.setPokemonName(resultSet.getString("pokemon_name"));
				wildPokemon.setPokemonLV(user.getPokemonLV());
				wildPokemon.setPokemonATT(user.getPokemonLV() * 9);
				wildPokemon.setPokemonDEF(user.getPokemonLV() * 9);
				wildPokemon.setPokemonHP(user.getPokemonLV() * 10);
				wildPokemon.setPokemonMaxHP(user.getPokemonLV() * 10);
				wildPokemon.setPokemonEXP(user.getPokemonLV() * 5);
				wildPokemon.setGold(user.getPokemonLV() * 5);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		System.out.println(pokemonName);
		return wildPokemon;
	}

	public int save(PlayerVO user) {
		int n = 0;
		String sql = "UPDATE PLAYER SET PLAYER_LV =?,POKEMON_LV =?,GOLD=?,POKEMON_ATT=?,POKEMON_DEF=?,POKEMON_HP=?,POKEMON_MAXHP=?,POKEMON_EXP=?,POKOMON_MAXEXP=? WHERE PLAYER_NAME = ?";
		connection = dao.getConnection();
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, user.getPlayerLV());
			preparedStatement.setInt(2, user.getPokemonLV());
			preparedStatement.setInt(3, user.getGold());
			preparedStatement.setInt(4, user.getPokemonATT());
			preparedStatement.setInt(5, user.getPokemonDEF());
			preparedStatement.setInt(6, user.getPokemonHP());
			preparedStatement.setInt(7, user.getPokemonMaxHP());
			preparedStatement.setInt(8, user.getPokemonEXP());
			preparedStatement.setInt(9, user.getPokemonMaxEXP());
			preparedStatement.setString(10, user.getName());
			n = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return n;
	}

}
