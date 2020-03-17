package net.selsela.carRental.data.local;


import net.selsela.carRental.data.model.AddressSaved;

public enum DataHolder {
    INSTANCE;

    private AddressSaved addressSaved;



    public static boolean hasAddress() {

        return INSTANCE.addressSaved != null;
    }


    public static AddressSaved getAddressSaved() {
        return INSTANCE.addressSaved;
    }

    public static void setAddressSaved(AddressSaved addressSaved) {
        INSTANCE.addressSaved = addressSaved;
    }

    public static void clearAddress() {
        INSTANCE.addressSaved = null;
    }


    @Override
    public String toString() {
        return "DataHolder{" +
                "addressSaved=" + addressSaved +
                '}';
    }
}

