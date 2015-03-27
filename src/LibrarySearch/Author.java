package LibrarySearch;

public class Author {
    String street_address, city, state, zip, phone, line;
    int index;    
    
    public Author() {
        this.index = 0;
        this.street_address = "";
        this.city = "";
        this.state = "";
        this.zip = "";
        this.phone = "";
    }
    
    
    public Author(int index, String street_address, String city, String state, String zip,
                           String phone) {
        this.index = index;
        this.street_address = street_address;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.phone = phone;
    }       
    
    public String getStreet_address() {
        return street_address;
    }
    
    public int getIndex() {
        return index;
    }
    
    public String getCity() {
        return city;
    }   
    
    public String getState() {
        return state;
    }  

    public String getZip() {
        return zip;
    }   

    public String getPhone() {
        return phone;
    }     

    public void setStreet_address(String author_street_address) {
        street_address = author_street_address;
    }

    public void setIndex(int i) {
        index = i;
    }    
    public void setCity(String author_city) {
        city = author_city;
    }   
    
    public void setState(String author_state) {
        state = author_state;
    }  

    public void setZip(String author_zip) {
        zip = author_zip;
    }   

    public void setPhone(String author_phone) {
        phone = author_phone;
    }
    
    public String toString() {
        return index + " : " + street_address + " : " + city + " : " + state + " : " + zip
                 + " : " + phone;
    }
}
