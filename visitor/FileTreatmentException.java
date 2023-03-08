package visitor;

public class FileTreatmentException extends RuntimeException {
    FileTreatmentException() { }
    FileTreatmentException(String message) {
        super(message);
    }
    @Override
    public void printStackTrace() {
        super.printStackTrace();
    }
}
