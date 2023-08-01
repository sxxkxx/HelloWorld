package co.san.newproject.inventory.service;

import java.util.List;

import co.san.newproject.product.service.ProductVO;


public interface InventoryService {
	int inventoryStore(InventoryVO vo);
		
	int inventoryRelease(InventoryVO vo);

	List<InventoryVO> inventoryHistory();
	
	List<ProductVO> inventoryInquiry();
			
	int getNextInventoryNumber();
}
