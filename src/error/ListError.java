package error;

import java.util.InputMismatchException;

public abstract class ListError extends InputMismatchException {

    ListError(String message){
        super(message);
    }
}
