package org.npc.models.repositories.interfaces;

import org.npc.dataaccess.repository.BaseRepositoryInterface;
import org.npc.models.Product;

public interface ProductRepositoryInterface extends BaseRepositoryInterface<Product> {
	Product byItemLookupCode(String itemlookupcode);
}