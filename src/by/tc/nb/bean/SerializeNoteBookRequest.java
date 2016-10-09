package by.tc.nb.bean;

/**
 * Created by Davud_Murtazin on 10/9/2016.
 */
public class SerializeNoteBookRequest extends Request{
    private String filePath;

    public SerializeNoteBookRequest() {
    }

    public SerializeNoteBookRequest(String filePath) {
        this.filePath = filePath;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }
}
