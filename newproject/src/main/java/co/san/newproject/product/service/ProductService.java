package co.san.newproject.product.service;

import java.util.List;

public interface ProductService {

	List<ProductVO> productList();

	int productInsert(ProductVO vo);

	int productDelete(ProductVO vo);

	int productUpdate(ProductVO vo);

	int productStore(ProductVO vo);
	
	int warehousingInsert(WarehousingVO vo);

	int productRelease(ProductVO vo);
	
	int warehousingRelease(WarehousingVO vo);

	List<WarehousingVO> warehousingHistory();
	
	int getNextProductNumber();
	
	int getNextWarehousingNumber();
}
