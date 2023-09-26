public class NoteInvalideException extends Exception{

    NoteInvalideException(){
        super();
    }

    public String toString(){
        return "La note n'est pas valide";
    }
}
