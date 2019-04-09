package gov.edu.dao;

import java.util.List;

import gov.edu.model.Supplier;

public interface SupplierDao
	{

		   public boolean addSupplier(Supplier supplier);
		   public boolean deleteSupplier(Supplier supplier);
		   public boolean updateSupplier(Supplier supplier);
		   public List<Supplier> listSuppliers();
		   public Supplier getSupplier(int supplierId);

	}

