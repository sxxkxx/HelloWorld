package co.san.newproject.inventory.serviceImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.san.newproject.common.DataSource;
import co.san.newproject.inventory.service.InventoryService;
import co.san.newproject.inventory.service.InventoryVO;
import co.san.newproject.product.service.ProductVO;

public class InventoryServiceImpl implements InventoryService {

	private DataSource dao = DataSource.getInstance();
	private Connection connection;
	private PreparedStatement preparedStatement;
	private ResultSet resultSet;

	private void Close() {
		try {
			if (resultSet != null) {
				resultSet.close();
			}
			if (preparedStatement != null) {
				preparedStatement.close();
			}
			if (connection != null) {
				connection.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// 입고내역 등록
	@Override
	public int inventoryStore(InventoryVO vo) {
		int n = 0;
		String sql = "INSERT INTO INVENTORY(INVENTORY_NUMBER,PRODUCT_NUMBER,INVENTORY_STATUS,INVENTORY_QUANTITY,INVENTORY_DATE) VALUES(?,?,?,?,?)";
		connection = dao.getConnection();
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, vo.getInventoryNumber());
			preparedStatement.setInt(2, vo.getProductNumber());
			preparedStatement.setString(3, "입고");
			preparedStatement.setInt(4, vo.getInventoryQuantity());
			preparedStatement.setDate(5, java.sql.Date.valueOf(vo.getInventoryDate()));
			n = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Close();
		}

		return n;
	}

	// 출고내역 등록
	@Override
	public int inventoryRelease(InventoryVO vo) {
		int n = 0;
		String sql = "INSERT INTO INVENTORY(INVENTORY_NUMBER,PRODUCT_NUMBER,INVENTORY_STATUS,INVENTORY_QUANTITY,INVENTORY_DATE) VALUES(?,?,?,?,?)";
		connection = dao.getConnection();
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, vo.getInventoryNumber());
			preparedStatement.setInt(2, vo.getProductNumber());
			preparedStatement.setString(3, "출고");
			preparedStatement.setInt(4, vo.getInventoryQuantity());
			preparedStatement.setDate(5, java.sql.Date.valueOf(vo.getInventoryDate()));
			n = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Close();
		}

		return n;
	}

	// 입출고 내역 조회
	@Override
	public List<InventoryVO> inventoryHistory() {
		String sql = "SELECT * FROM INVENTORY ORDER BY INVENTORY_NUMBER";
		connection = dao.getConnection();
		InventoryVO vo;
		List<InventoryVO> inventoryHistory = new ArrayList<>();

		try {
			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				vo = new InventoryVO();
				vo.setInventoryNumber(resultSet.getInt("inventory_number"));
				vo.setProductNumber(resultSet.getInt("product_number"));
				vo.setInventoryStatus(resultSet.getString("inventory_status"));
				vo.setInventoryQuantity(resultSet.getInt("inventory_quantity"));
				vo.setInventoryDate(resultSet.getDate("inventory_date").toLocalDate());

				inventoryHistory.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return inventoryHistory;
	}

	// 재고 조회
	@Override
	public List<ProductVO> inventoryInquiry() {
		String sql = "SELECT * FROM PRODUCT ORDER BY PRODUCT_NUMBER";
		List<ProductVO> products = new ArrayList<>();
		ProductVO product;
		connection = dao.getConnection();
		try {
			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				product = new ProductVO();
				product.setProductNumber(resultSet.getInt("product_number"));
				product.setProductQuantity(resultSet.getInt("product_quantity"));
				products.add(product);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return products;
	}

	// 입출고 내역 관리번호를 자동부여
	@Override
	public int getNextInventoryNumber() {
		String sql = "SELECT NVL(MAX(Inventory_NUMBER),0) AS MAX_NUMBER FROM Inventory";
		int result = 0;
		connection = dao.getConnection();
		try {
			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				result = (resultSet.getInt("MAX_NUMBER")) + 1;

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Close();
		}

		return result;
	}

}
