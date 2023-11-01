import java.util.ArrayList;

public class Student {
    private String name; // The students name
    private String number; // The student's number

    // A list of all the student's marks
    // The ith index contains the ith's assignment's mark. between [0-100]
    // -1 means no mark.
    private ArrayList<Integer> marks;

    /**
     * @return The student's name
     */
    public String getName() {
        return name;
    }

    public String getNumber() {
        return number;
    }

    /**
     * @return The array list of the student's marks
     */
    public ArrayList<Integer> getMarks() {
        return marks;
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    /**
     * Sets the idx th assignment mark to mark.
     *
     * @param idx A integer number
     * @param mark An integer number between [-1, 100] (with -1 meaning no mark)
     * @return 0 if it successfully set the mark, -1 if not
     */
    public int setMark(int idx, int mark) {
        if(idx < 0 || idx >= marks.size()) {
            return -1;
        }
        marks.set(idx, mark);
        return 0;
    }

    /**
     * Returns the student's mark for the idx th assignment, and -1 if out of bounds
     *
     * @param idx An integer in [0 - marks.size())
     * @return The student's mark for the idx th assignment
     */
    public int getMark(int idx) {
        // Safeguard for out of bounds on the array.
        if(idx >= marks.size() || idx < 0) {
            return -1;
        }
        return marks.get(idx);
    }

    /**
     * Calculates the average of the student (all assignments are weighted the same)
     * using sum(marks)/number of marks
     *
     * @return The average of the student
     */
    public double average() {
        int tot = 0;
        for (int mark: marks) {
            tot += mark;
        }
        return tot / (double)marks.size();
    }


    public Student(String name, String number, ArrayList<Integer> marks) {
        this.name = name;
        this.number = number;
        this.marks = marks;
    }

}