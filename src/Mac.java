/**
 * Created with IntelliJ IDEA.
 * User: Tomek
 * Date: 6/4/13
 * Time: 5:55 AM
 * To change this template use File | Settings | File Templates.
 */
public class Mac {
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) throws BadMacAddressException {
        if(checkCorectness(address))
        this.address = address;
        else
            throw new BadMacAddressException();
    }

    private boolean checkCorectness(String address) {
        return true; //for now
    }

    private String address;

    @Override
    public int hashCode() {
        return address.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        Mac that = (Mac)obj;
        return this.address.equals(that.address);
    }
}
