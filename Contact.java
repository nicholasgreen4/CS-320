public class Contact {

   private final String contactId;
   private String firstName;
   private String lastName;
   private String phone;
   private String address;

   public Contact(String contactId, String firstName, String lastName, String phone, String address) {
       validateContactId(contactId);
       validateName(firstName, "firstName");
       validateName(lastName, "lastName");
       validatePhone(phone);
       validateAddress(address);

       this.contactId = contactId;
       this.firstName = firstName;
       this.lastName = lastName;
       this.phone = phone;
       this.address = address;
   }

   public String getContactId() {
       return contactId;
   }

   public String getFirstName() {
       return firstName;
   }

   public String getLastName() {
       return lastName;
   }

   public String getPhone() {
       return phone;
   }

   public String getAddress() {
       return address;
   }

   private void validateContactId(String contactId) {
       if (contactId == null || contactId.isEmpty() || contactId.length() > 10) {
           throw new IllegalArgumentException("Contact ID must be a non-empty string with a maximum length of 10 characters.");
       }
   }

   private void validateName(String name, String fieldName) {
       if (name == null || name.isEmpty() || name.length() > 10) {
           throw new IllegalArgumentException(fieldName + " must be a non-empty string with a maximum length of 10 characters.");
       }
   }

   private void validatePhone(String phone) {
       if (phone == null || phone.isEmpty() || phone.length() != 10 || !phone.matches("\\d{10}")) {
           throw new IllegalArgumentException("Phone must be a 10-digit numeric string.");
       }
   }

   private void validateAddress(String address) {
       if (address == null || address.isEmpty() || address.length() > 30) {
           throw new IllegalArgumentException("Address must be a non-empty string with a maximum length of 30 characters.");
       }
   }
   
   // Setters
   public void setFirstName(String firstName) {
        validateName(firstName, "firstName");
        this.firstName = firstName;
   }
    
   public void setLastName(String lastName) {
        validateName(lastName, "lastName");
        this.lastName = lastName;
   }

   public void setPhone(String phone) {
        validatePhone(phone);
        this.phone = phone;
   }

   public void setAddress(String address) {
        validateAddress(address);
        this.address = address;
   }
}
