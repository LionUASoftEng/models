package org.npc.models.commands;

import java.util.UUID;
import java.util.stream.Collectors;

import org.npc.models.commands.interfaces.ResultCommandInterface;
import org.npc.models.api.Product;
import org.npc.models.api.ProductListing;
import org.npc.models.repositories.interfaces.ProductRepositoryInterface;

public class ProductsQuery implements ResultCommandInterface<ProductListing> {
	
	private ProductRepositoryInterface productRepository;
	
	@Override
	public ProductListing execute() {
		return (new ProductListing()).
			setProducts(
				this.productRepository.all().stream().map(mp -> (new Product(mp))).collect(Collectors.toList()
			)
		);
	}

	//Properties
	public ProductRepositoryInterface getProductRepository() {
		return this.productRepository;
	}
	public ProductsQuery setProductRepository(ProductRepositoryInterface productRepository) {
		this.productRepository = productRepository;
		return this;
	}
	
	public ProductsQuery()
	{
		productRepository = null;
	}
	public ProductsQuery(ProductRepositoryInterface pri)
	{
		productRepository = pri;
	}
}