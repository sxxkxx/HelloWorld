package co.san.newproject.product.serviceImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.List;

import co.san.newproject.common.DataSource;
import co.san.newproject.product.service.ProductService;
import co.san.newproject.product.service.ProductVO;
import co.san.newproject.product.service.WarehousingVO;

public class ProductServiceImpl implements ProductService {

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

	@Override
	public List<ProductVO> productList() {
		String sql = "SELECT * FROM PRODUCT ORDER BY PRODUCT_NUMBER";
		List<ProductVO> products = new ArrayList();
		ProductVO product;
		connection = dao.getConnection();
		try {
			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				product = new ProductVO();
				product.setProductNumber(resultSet.getInt("product_number"));
				product.setProductMaker(resultSet.getString("product_maker"));
				product.setProductName(resultSet.getString("product_name"));
				product.setProductPrice(resultSet.getInt("product_price"));
				product.setProductQuantity(resultSet.getInt("product_quantity"));
				products.add(product);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return products;
	}

	@Override
	public int productInsert(ProductVO vo) {
		int n = 0;
		String sql = "INSERT INTO PRODUCT VALUES(?,?,?,?,?)";
		connection = dao.getConnection();
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, vo.getProductNumber());
			preparedStatement.setString(2, vo.getProductMaker());
			preparedStatement.setString(3, vo.getProductName());
			preparedStatement.setInt(4, vo.getProductPrice());
			preparedStatement.setInt(5, vo.getProductQuantity());
			n = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Close();
		}

		return n;
	}

	@Override
	public int productDelete(ProductVO vo) {
		int n = 0;
		String sql = "DELETE FROM PRODUCT WHERE PRODUCT_NUMBER=?";
		connection = dao.getConnection();
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, vo.getProductNumber());
			n = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Close();
		}
		return n;
	}

	@Override
	public int productUpdate(ProductVO vo) {
		int n = 0;
		String sql = "UPDATE PRODUCT SET PRODUCT_PRICE=? WHERE PRODUCT_NUMBER=?";
		connection = dao.getConnection();
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, vo.getProductPrice());
			preparedStatement.setInt(2, vo.getProductNumber());
			n = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Close();
		}
		return n;
	}

	@Override
	public int productStore(ProductVO vo) {
		int n = 0;
		String sql = "UPDATE PRODUCT SET PRODUCT_QUANTITY = PRODUCT_QUANTITY+? WHERE PRODUCT_NUMBER=?";
		connection = dao.getConnection();
		WarehousingVO warehousingvo = new WarehousingVO();
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, vo.getProductQuantity());
			preparedStatement.setInt(2, vo.getProductNumber());

			n = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Close();
		}
		if (n != 0) {
			warehousingvo.setWarehousingNumber(getNextWarehousingNumber());
			warehousingvo.setProductNumber(vo.getProductNumber());
			warehousingvo.setWarehousingQuantity(vo.getProductQuantity());
			warehousingInsert(warehousingvo);
		}
		return n;
	}

	@Override
	public int warehousingInsert(WarehousingVO vo) {
		int n = 0;
		String sql = "INSERT INTO WAREHOUSING(WAREHOUSING_NUMBER,PRODUCT_NUMBER,WAREHOUSING_STATUS,WAREHOUSING_QUANTITY) VALUES(?,?,?,?)";
		connection = dao.getConnection();
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, vo.getWarehousingNumber());
			preparedStatement.setInt(2, vo.getProductNumber());
			preparedStatement.setString(3, "입고");
			preparedStatement.setInt(4, vo.getWarehousingQuantity());
			n = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return n;
	}

	@Override
	public int productRelease(ProductVO vo) {
		int n = 0;
		String sql = "UPDATE PRODUCT SET PRODUCT_QUANTITY = PRODUCT_QUANTITY-? WHERE PRODUCT_NUMBER=?";
		connection = dao.getConnection();
		WarehousingVO warehousingvo = new WarehousingVO();
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, vo.getProductQuantity());
			preparedStatement.setInt(2, vo.getProductNumber());

			n = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Close();
		}
		if (n != 0) {
			warehousingvo.setWarehousingNumber(getNextWarehousingNumber());
			warehousingvo.setProductNumber(vo.getProductNumber());
			warehousingvo.setWarehousingQuantity(vo.getProductQuantity());
			warehousingRelease(warehousingvo);
		}
		return n;
	}
	
	@Override
	public int warehousingRelease(WarehousingVO vo) {
		int n = 0;
		String sql = "INSERT INTO WAREHOUSING(WAREHOUSING_NUMBER,PRODUCT_NUMBER,WAREHOUSING_STATUS,WAREHOUSING_QUANTITY) VALUES(?,?,?,?)";
		connection = dao.getConnection();
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, vo.getWarehousingNumber());
			preparedStatement.setInt(2, vo.getProductNumber());
			preparedStatement.setString(3, "출고");
			preparedStatement.setInt(4, vo.getWarehousingQuantity());
			n = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return n;
	}

	@Override
	public List<WarehousingVO> warehousingHistory() {
		String sql = "SELECT * FROM WAREHOUSING ORDER BY WAREHOUSING_NUMBER";
		connection = dao.getConnection();
		WarehousingVO vo;
		List<WarehousingVO> warehousingHistory = new ArrayList<WarehousingVO>();

		try {
			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				vo = new WarehousingVO();
				vo.setWarehousingNumber(resultSet.getInt("warehousing_number"));
				vo.setProductNumber(resultSet.getInt("product_number"));
				vo.setWarehousingStatus(resultSet.getString("warehousing_status"));
				vo.setWarehousingQuantity(resultSet.getInt("warehousing_quantity"));
				vo.setWarehousingDate(resultSet.getDate("warehousing_date"));
				warehousingHistory.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return warehousingHistory;
	}

	@Override
	public int getNextProductNumber() {
		String sql = "SELECT NVL(MAX(PRODUCT_NUMBER),0) AS NEXT_PRODUCT_NUMBER FROM PRODUCT";
		int result = 0;
		connection = dao.getConnection();
		try {
			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				result = (resultSet.getInt("next_product_number")) + 1;

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;
	}

	@Override
	public int getNextWarehousingNumber() {
		String sql = "SELECT NVL(MAX(WAREHOUSING_NUMBER),0) AS NEXT_WAREHOUSING_NUMBER FROM WAREHOUSING";
		int result = 0;
		connection = dao.getConnection();
		try {
			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				result = (resultSet.getInt("next_warehousing_number")) + 1;

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Close();
		}

		return result;
	}

}
