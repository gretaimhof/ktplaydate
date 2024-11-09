public class StudyGroupEntry {

    private String name;
    private String className;
    private String contact;

    public StudyGroupEntry(String name, String className, String contact) {
        this.name = name;
        this.className = className;
        this.contact = contact;
    }

    public String getName() {
        return name;
    }

    public String getClassName() {
        return className;
    }

    public String getContact() {
        return contact;
    }

    @Override
    public String toString() {
        return name + " (" + className + ") - " + contact;
    }
}
