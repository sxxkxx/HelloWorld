package co.san.newproject.product.serviceImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
		List<ProductVO> products = new ArrayList();

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
			preparedStatement.setInt(1, vo.getProductNumber());
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
		String sql = "";
		connection = dao.getConnection();
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, vo.getProductNumber());
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
	public int productRelease(ProductVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<WarehousingVO> warehousingHistory() {
		// TODO Auto-generated method stub
		return null;
	}

}
