package infra.exceptions;

public class CommitException extends RuntimeException{

    public String mensagem;

    public CommitException(String msg){
        super(msg);
    }

    @Override
    public String getMessage() {
        return mensagem;
    }
}
