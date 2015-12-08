
package org.npc.models.commands;

import java.util.UUID;

import org.apache.commons.lang3.StringUtils;
import org.npc.models.commands.interfaces.ResultCommandInterface;
import org.npc.models.api.Product;
import org.npc.models.enums.ProductApiRequestStatus;
import org.npc.models.repositories.interfaces.ProductRepositoryInterface;

public class CreateProductCommand implements ResultCommandInterface<Product> {
	
	private Product apiProduct;
	private ProductRepositoryInterface productRepository;
	
	@Override
	public Product execute() {
		if (StringUtils.isBlank(this.apiProduct.getItemLookupCode())) {
			return (new Product()).setApiRequestStatus(ProductApiRequestStatus.INVALID_INPUT);
		}
		
		org.npc.models.Product modelProduct = this.productRepository.byItemLookupCode(this.apiProduct.getItemLookupCode());
		if (modelProduct != null) {
			return (new Product()).setApiRequestStatus(ProductApiRequestStatus.LOOKUP_CODE_ALREADY_EXISTS);
		}
		
		this.apiProduct.setId(UUID.randomUUID());
		modelProduct = new org.npc.models.Product(this.apiProduct);
		modelProduct.save();

		return this.apiProduct;
	}

	//Properties
	public Product getApiProduct() {
		return this.apiProduct;
	}
	public CreateProductCommand setApiProduct(Product apiProduct) {
		this.apiProduct = apiProduct;
		return this;
	}
	
	public ProductRepositoryInterface getProductRepository() {
		return this.productRepository;
	}
	public CreateProductCommand setProductRepository(ProductRepositoryInterface productRepository) {
		this.productRepository = productRepository;
		return this;
	}
}
