package org.npc.models.commands;

import java.util.UUID;

import org.npc.models.commands.interfaces.ResultCommandInterface;
import org.npc.models.api.Product;
import org.npc.models.repositories.interfaces.ProductRepositoryInterface;

public class ProductQuery implements ResultCommandInterface<Product> {
	
	private UUID productId;
	private ProductRepositoryInterface productRepository;
	
	@Override
	public Product execute() {
		return new Product(
			this.productRepository.get(this.productId)
		);
	}

	//Properties

	public UUID getProductId() {
		return this.productId;
	}
	public ProductQuery setProductId(UUID productId) {
		this.productId = productId;
		return this;
	}
	
	public ProductRepositoryInterface getProductRepository() {
		return this.productRepository;
	}
	public ProductQuery setProductRepository(ProductRepositoryInterface productRepository) {
		this.productRepository = productRepository;
		return this;
	}
	
	public ProductQuery()
	{
		productId = new UUID(0,0);
		productRepository = null;
	}
	
	public ProductQuery(ProductRepositoryInterface pri)
	{
		productId = new UUID(0,0);
		productRepository = pri;
	}
	
	public ProductQuery(UUID pid)
	{
		productId = pid;
		productRepository = null;
	}
	
	public ProductQuery(UUID pid, ProductRepositoryInterface pri)
	{
		productId = pid;
		productRepository = pri;
	}
}