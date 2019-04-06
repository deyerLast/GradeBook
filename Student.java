import java.util.Objects;
public class Student {
    private String firstName;  // First Name
    private String lastName;   // Last Name
    private String email;      // Email Address
    private String id;         // Student ID
    public Object aString;
    public Object aNum;

    /**
     * Student constructor builds Student object
     * @param fName If field empty, constructor reports exception.
     * @param lName If field empty, constructor reports exception.
     * @param email If field empty, constructor reports exception.
     * @param id    If field empty, constructor reports exception.
     * @throws IllegalArgumentException Throw error if something doesn't work.
     */
    public Student(String fName, String lName, String email, String id) throws
            IllegalArgumentException {

        // If fields are empty throw exception
        if(id.isEmpty() || email.isEmpty()|| fName.isEmpty() ||
                lName.isEmpty()) {
            throw new IllegalArgumentException("Error: One or more fields are" +
                    "empty.");
        }
        // If email doesn't contain "@" throw exception
        if(!email.contains("@")){
            throw new IllegalArgumentException("Error: No @ in the email" +
                    " address," + email + ".");
        }

        this.lastName = lName;
        this.firstName = fName;
        this.email = email;
        this.id = id;
    }

    //=========================================================================

    public String getFirstName(){
        return firstName;}

    //=========================================================================


    public String getLastName(){
        return lastName;}

    //=========================================================================

    public String getId(){
        return id;}

    //========================================================================


    public String getEmail(){
        return email;}


    //=======================================================================

    /**
     * @param other  If empty, will not run.
     * @return
     * Checks to see if two different students are the same.
     */

    public boolean equals(Student other) {
        boolean result = false;
        if ((id.equals(other.getId())) && lastName.equals(other.getLastName())
                && firstName.equals(other.getFirstName())
                && email.equals(other.getEmail())) {
            result = true;
        }
        return result;
    }

    //========================================================================

    // The generic equals for comparing objects
    @Override
    public boolean equals(Object obj) {
        // Checks if the object is the same instance
        if (this == obj) {
            return true;
        }
        // Make sure obj is not null-type
        if (obj == null) {
            return false;
        }
        // Makes sure class type is equivalent
        if (getClass() != obj.getClass()) {
            return false;
        }

        // Object is of this type, cast and continue
        final Student other = (Student) obj;

        // Check all other class values for equality
        //CHANGE    CHANGE  CHANGE  CHANGE  CHANGE  CHANGE  CHANGE  CHANGE
        if (!Objects.equals(this.firstName, other.firstName)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.lastName, other.lastName)) {
            return false;
        }

        return true;
    }

    //-----------------------------------------======================----------

    // The generic hash code generation for comparing objects
    //Needed to accuratly evaluate the equals of Objects
    @Override
    public int hashCode() {
        int hash = 3;
        //CHANGE    CHANGE  CHANGE  CHANGE  CHANGE  CHANGE  CHANGE  CHANGE
        hash = 97 * hash + Objects.hashCode(this.id);
        hash = 97 * hash + Objects.hashCode(this.firstName);
        hash = 97 * hash + Objects.hashCode(this.lastName);
        return hash;
    }


    //========================================================================

    /**
     * @return
     * Puts all the Student information into a string to return
     */
    public String toString(){
        String display;
        display = "\nName: " + firstName + " " +
                lastName + "\n  Email: " + email + "\n  Student ID: " + id;
        return display;
    }
}
