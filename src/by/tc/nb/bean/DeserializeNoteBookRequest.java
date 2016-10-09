package by.tc.nb.bean;

/**
 * Created by Davud_Murtazin on 10/9/2016.
 */
public class DeserializeNoteBookRequest extends Request {
    private String filePath;

    public DeserializeNoteBookRequest() {
    }

    public DeserializeNoteBookRequest(String filePath) {
        this.filePath = filePath;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }
}
