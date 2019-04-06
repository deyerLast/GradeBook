import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class GradeItem {
    private int itemId;                     // Item Id
    private int maxScore;                   // Max score
    private int actualScore;                // Actual size
    private String studentId;               // Student Id
    private String courseId;                // Course ID
    private String itemType;                // Item type
    private String date;                    // Date
    private String[] items = new String[]
            {"HW", "Quiz", "Test", "Final",
                    "Class Work"};          // Array
    // of valid item types
    List<String> list;
    private Object aString;
    private Object aNum;

    /**
     * GradeItem constructor builds GradeItem object
     * @param itemId        If field empty, constructor reports exception.
     * @param studentId     If field empty, constructor reports exception.
     * @param courseId      If field empty, constructor reports exception.
     * @param itemType      If field empty, constructor reports exception.
     * @param date          If field empty, constructor reports exception.
     * @param maxScore      If field empty, not int, not greater than
     *                      actualScore, and not greater than zero.
     * @param actualScore   If field empty, not int, not 0 or greater, not
     *                      less than maxScore
     * @throws IllegalArgumentException Throw error if something doesn't work.
     */


    //-----------------------------------------======================----------
    public GradeItem(int itemId, String studentId, String courseId,
                     String itemType,
                     String date, int maxScore, int actualScore)
            throws IllegalArgumentException {//constructor

        list = Arrays.asList(items);
        if(!list.contains(itemType)){
            throw new IllegalArgumentException("Error: Invalid Item type.");
        }
        if(studentId.isEmpty() || courseId.isEmpty() || date.isEmpty() ||
                itemType.isEmpty()) {
            throw new IllegalArgumentException("Error: StudentId, courseId, " +
                    "or date is empty.");
        }

        //CHANGED CHANGED CHANGED CHANGED CHANGED CHANGED CHANGED CHANGED
        if(maxScore < 0) {
            throw new IllegalArgumentException("Error: Scores incorrect: Max " +
                    "score less than 0.");
        }
        //CHANGED CHANGED CHANGED CHANGED CHANGED CHANGED CHANGED CHANGED
        if(actualScore > maxScore){
            throw new IllegalArgumentException("Error: Scores incorrect: " +
                    "Actual score great than Max score.");
        }
        //CHANGED CHANGED CHANGED CHANGED CHANGED CHANGED CHANGED CHANGED
        if(actualScore < 0){
            throw new IllegalArgumentException("Error: Scores incorrect: " +
                    "Actual score less than 0.");
        }

        this.maxScore = maxScore;
        this.actualScore = actualScore;
        this.itemId = itemId;
        this.studentId = studentId;
        this.courseId = courseId;
        this.itemType = itemType;
        this.date = date;

    }

    //-----------------------------------------======================----------
    // Return item id
    public int getItemId(){
        return itemId; }

    //-----------------------------------------======================---------
    // Return max score
    public int getMaxScore(){
        return maxScore;}

    //-----------------------------------------======================---------
    // Return actual score
    public int getActualScore(){
        return actualScore;}

    //-----------------------------------------======================----------
    // Return Student id
    public String getStudentId(){
        return studentId;}

    //-----------------------------------------======================----------
    // Return course id
    public String getCourseId(){
        return courseId;}

    //-----------------------------------------======================---------
    // Return Item type
    public String getItemType(){
        return itemType;}

    //-----------------------------------------======================---------
    // Returns date
    public String getDate(){
        return date;}

    //-----------------------------------------======================----------

    /**
     * Boolean equals   Checks if two GradeItem objects are the same
     * @param other
     * @return result
     */
    public boolean equals(GradeItem other) {
        boolean result = false;
        if (studentId.equals(other.getStudentId()) &&
                courseId.equals(other.getCourseId()) &&
                itemType.equals(other.getItemType()) &&
                date.equals(other.getDate())) {
            result = true;
        }
        return result;
    }

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
        final GradeItem other = (GradeItem) obj;

        // Check all other class values for equality
        //CHANGE    CHANGE  CHANGE  CHANGE  CHANGE  CHANGE  CHANGE  CHANGE

        if (!Objects.equals(this.getActualScore(), other.getActualScore())) {
            return false;
        }
        if (!Objects.equals(this.getDate(), other.getDate())) {
            return false;
        }
        if (!Objects.equals(this.getItemId(), other.getItemId())) {
            return false;
        }
        if (!Objects.equals(this.getCourseId(), other.getCourseId())) {
            return false;
        }
        if (!Objects.equals(this.getStudentId(), other.getStudentId())) {
            return false;
        }
        if (!Objects.equals(this.getItemType(), other.getItemType())) {
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
        hash = 97 * hash + Objects.hashCode(this.getActualScore());
        hash = 97 * hash + Objects.hashCode(this.getDate());
        hash = 97 * hash + Objects.hashCode(this.getItemId());
        hash = 97 * hash + Objects.hashCode(this.getCourseId());
        hash = 97 * hash + Objects.hashCode(this.getStudentId());
        hash = 97 * hash + Objects.hashCode(this.getItemType());
        return hash;
    }

    //-----------------------------------------======================----------

    /**
     * toString returns a string of all the values held by GradeItem constructor
     * @return result
     *
     */
    public String toString(){
        return "Item: " + itemType + "\n" + getActualScore() + " out of " +
                getMaxScore() + "\nCourse Id: " + getCourseId() + "\nDate: " +
                getDate() + "\nStudent Id: " + getStudentId();
    }
}
