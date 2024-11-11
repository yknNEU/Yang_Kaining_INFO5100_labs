package model;

public class Business {
    
    private MasterOrderList masterOrderList;
    private SupplierDirectory supplierDirectory;

    public Business() {
        masterOrderList = new MasterOrderList();
        supplierDirectory = new SupplierDirectory();
    }

    public MasterOrderList getMasterOrderList() {
        return masterOrderList;
    }

    public SupplierDirectory getSupplierDirectory() {
        return supplierDirectory;
    }

    public void setSupplierDirectory(SupplierDirectory supplierDirectory) {
        this.supplierDirectory = supplierDirectory;
    }

    public void setMasterOrderList(MasterOrderList masterOrderList) {
        this.masterOrderList = masterOrderList;
    }
}
